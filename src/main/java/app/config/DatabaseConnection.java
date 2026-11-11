package app.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Centraliza la conexión con MariaDB/MySQL de XAMPP.
 * Se pueden sobrescribir URL, usuario y contraseña mediante variables de entorno.
 */
public final class DatabaseConnection {
    private static final Properties PROPERTIES = loadProperties();

    private DatabaseConnection() {}

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = DatabaseConnection.class.getClassLoader()
                .getResourceAsStream("db.properties")) {
            if (input != null) properties.load(input);
        } catch (Exception e) {
            throw new IllegalStateException("No fue posible leer db.properties.", e);
        }
        return properties;
    }

    public static Connection getConnection() throws SQLException {
        String url = System.getenv().getOrDefault("SALUD360_DB_URL",
                PROPERTIES.getProperty("db.url",
                        "jdbc:mariadb://localhost:3306/salud360?useUnicode=true&characterEncoding=UTF-8"));
        String user = System.getenv().getOrDefault("SALUD360_DB_USER",
                PROPERTIES.getProperty("db.user", "root"));
        String password = System.getenv().getOrDefault("SALUD360_DB_PASSWORD",
                PROPERTIES.getProperty("db.password", ""));
        return DriverManager.getConnection(url, user, password);
    }

    public static boolean testConnection() {
        try (Connection ignored = getConnection()) {
            return true;
        } catch (SQLException e) {
            System.err.println("No se pudo conectar con MariaDB: " + e.getMessage());
            return false;
        }
    }
}
