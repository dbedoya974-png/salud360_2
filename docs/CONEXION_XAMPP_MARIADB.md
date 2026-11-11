# Conectar Salud360 con XAMPP (MariaDB)

## 1. Iniciar el motor de base de datos
1. Abre el panel de control de XAMPP.
2. Pulsa **Start** en el módulo **MySQL**. Apache no es necesario para que Java se conecte, pero puedes iniciarlo si vas a usar phpMyAdmin.
3. Si vas a importar desde phpMyAdmin, inicia también Apache y abre `http://localhost/phpmyadmin`.

## 2. Crear las tablas
1. En phpMyAdmin, abre la pestaña **Importar**.
2. Selecciona `database/salud360.sql` de este proyecto.
3. Pulsa **Importar / Continuar**.
4. Verifica que aparezca la base de datos `salud360` con sus 12 tablas.

El script crea la estructura vacía. No inserta pacientes ni profesionales ficticios.

## 3. Configurar el usuario
La configuración predeterminada corresponde a XAMPP local:
- URL: `jdbc:mariadb://localhost:3306/salud360`
- Usuario: `root`
- Contraseña: vacía

Si tu usuario root tiene contraseña, copia `src/main/resources/db.properties.example` como `src/main/resources/db.properties` y edita `db.password`. Ese archivo está excluido de Git para no publicar credenciales. También puedes definir `SALUD360_DB_URL`, `SALUD360_DB_USER` y `SALUD360_DB_PASSWORD` como variables de entorno.

## 4. Cargar el controlador JDBC
Abre el proyecto desde la carpeta que contiene `pom.xml` en IntelliJ IDEA. Acepta **Load Maven Changes** o pulsa **Reload All Maven Projects**. Maven descargará `mariadb-java-client` declarado en `pom.xml`.

## 5. Ejecutar
Ejecuta `src/main/java/app/Application.java`. La aplicación comprobará la conexión antes de mostrar el menú.

## 6. Orden recomendado para registrar información relacionada
Para respetar las llaves foráneas:
1. Pacientes y especialidades.
2. Profesionales (requieren una especialidad existente).
3. Historias clínicas y citas (requieren paciente; las citas también requieren profesional).
4. Consultas (requieren cita e historia clínica).
5. Diagnósticos, tratamientos y signos vitales (requieren consulta).
6. Alergias y antecedentes médicos (requieren paciente).
7. Medicamentos.

Los identificadores los solicita la aplicación, por lo que deben ser únicos. Las relaciones se validan en MariaDB mediante claves foráneas.

## 7. Persistencia y pruebas
Los repositorios `ArrayList` fueron sustituidos por implementaciones JDBC para los 12 módulos. Los registros quedan guardados en MariaDB y permanecen después de cerrar la aplicación. Para verificarlo, crea un registro desde Salud360, cierra el programa, vuelve a ejecutarlo y consulta el mismo registro.

## Solución de problemas
- **Connection refused**: inicia MySQL desde XAMPP y confirma el puerto 3306.
- **Unknown database 'salud360'**: importa `database/salud360.sql`.
- **Access denied**: revisa usuario y contraseña en `db.properties`.
- **No suitable driver**: recarga Maven para descargar `mariadb-java-client`.
- **Cannot add or update a child row**: registra primero el dato padre (por ejemplo, la especialidad antes del profesional).
