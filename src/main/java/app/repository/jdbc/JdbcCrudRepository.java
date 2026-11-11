package app.repository.jdbc;

import app.config.DatabaseConnection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación JDBC reutilizable para las operaciones CRUD.
 * Cada repositorio concreto define la entidad, tabla y campo identificador.
 */
public class JdbcCrudRepository<T> {
    private final Class<T> entityClass;
    private final String table;
    private final String idField;
    private final List<Field> fields;

    public JdbcCrudRepository(Class<T> entityClass, String table, String idField) {
        this.entityClass = entityClass;
        this.table = table;
        this.idField = idField;
        this.fields = new ArrayList<>();
        for (Field field : entityClass.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                fields.add(field);
            }
        }
    }

    public T create(T entity) {
        String columns = joinColumns(fields, true);
        String placeholders = String.join(", ", java.util.Collections.nCopies(fields.size(), "?"));
        String sql = "INSERT INTO " + table + " (" + columns + ") VALUES (" + placeholders + ")";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            bindEntity(statement, entity, fields, 1);
            statement.executeUpdate();
            return entity;
        } catch (SQLException | IllegalAccessException e) {
            throw persistenceError("crear", e);
        }
    }

    public List<T> selectAll() {
        List<T> result = new ArrayList<>();
        String sql = "SELECT " + joinColumns(fields, true) + " FROM " + table
                + " ORDER BY " + toColumn(idField);
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rows = statement.executeQuery()) {
            while (rows.next()) result.add(mapRow(rows));
            return result;
        } catch (SQLException | ReflectiveOperationException e) {
            throw persistenceError("consultar", e);
        }
    }

    public T findById(int id) {
        String sql = "SELECT " + joinColumns(fields, true) + " FROM " + table
                + " WHERE " + toColumn(idField) + " = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet rows = statement.executeQuery()) {
                return rows.next() ? mapRow(rows) : null;
            }
        } catch (SQLException | ReflectiveOperationException e) {
            throw persistenceError("buscar", e);
        }
    }

    public boolean update(T entity) {
        List<Field> mutableFields = fields.stream()
                .filter(field -> !field.getName().equals(idField)).toList();
        StringBuilder assignments = new StringBuilder();
        for (int i = 0; i < mutableFields.size(); i++) {
            if (i > 0) assignments.append(", ");
            assignments.append(toColumn(mutableFields.get(i).getName())).append(" = ?");
        }
        String sql = "UPDATE " + table + " SET " + assignments + " WHERE " + toColumn(idField) + " = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            int next = bindEntity(statement, entity, mutableFields, 1);
            Field id = findField(idField);
            statement.setObject(next, id.get(entity));
            return statement.executeUpdate() > 0;
        } catch (SQLException | IllegalAccessException e) {
            throw persistenceError("actualizar", e);
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM " + table + " WHERE " + toColumn(idField) + " = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw persistenceError("eliminar", e);
        }
    }

    private int bindEntity(PreparedStatement statement, T entity, List<Field> selected, int start)
            throws SQLException, IllegalAccessException {
        int index = start;
        for (Field field : selected) {
            Object value = field.get(entity);
            if (value instanceof Enum<?>) {
                value = ((Enum<?>) value).name();
            } else if (value instanceof String text && text.isBlank()) {
                value = null;
            } else if (value instanceof String text && isDateField(field.getName())) {
                value = java.sql.Date.valueOf(text);
            } else if (value instanceof String text && field.getName().equals("hora")) {
                value = java.sql.Time.valueOf(text.length() == 5 ? text + ":00" : text);
            }
            statement.setObject(index++, value);
        }
        return index;
    }

    private T mapRow(ResultSet row) throws SQLException, ReflectiveOperationException {
        Constructor<T> constructor = entityClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        T entity = constructor.newInstance();
        for (Field field : fields) {
            Object value = row.getObject(toColumn(field.getName()));
            if (value == null) continue;
            Class<?> type = field.getType();
            if (type.isEnum()) {
                @SuppressWarnings({"rawtypes", "unchecked"})
                Object enumValue = Enum.valueOf((Class<? extends Enum>) type, value.toString());
                field.set(entity, enumValue);
            } else if (type == int.class || type == Integer.class) {
                field.set(entity, ((Number) value).intValue());
            } else if (type == double.class || type == Double.class) {
                field.set(entity, ((Number) value).doubleValue());
            } else if (type == long.class || type == Long.class) {
                field.set(entity, ((Number) value).longValue());
            } else if (type == String.class && value instanceof java.sql.Date) {
                field.set(entity, value.toString());
            } else if (type == String.class && value instanceof java.sql.Time) {
                field.set(entity, value.toString());
            } else {
                field.set(entity, value);
            }
        }
        return entity;
    }

    private Field findField(String name) {
        return fields.stream().filter(field -> field.getName().equals(name)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Campo identificador inexistente: " + name));
    }

    private String joinColumns(List<Field> selected, boolean ignored) {
        return selected.stream().map(field -> toColumn(field.getName()))
                .collect(java.util.stream.Collectors.joining(", "));
    }

    private boolean isDateField(String name) {
        return name.equals("fecha") || name.equals("fechaNacimiento")
                || name.equals("fechaApertura") || name.equals("fechaInicio")
                || name.equals("fechaFin");
    }

    private String toColumn(String camelCase) {
        return camelCase.replaceAll("([a-z0-9])([A-Z])", "$1_$2").toLowerCase();
    }

    private IllegalStateException persistenceError(String action, Exception cause) {
        String detail = cause.getMessage() == null ? cause.getClass().getSimpleName() : cause.getMessage();
        return new IllegalStateException("Error al " + action + " en la tabla " + table
                + ". Verifique que MariaDB esté iniciado y que la base salud360 esté creada. Detalle: " + detail, cause);
    }
}
