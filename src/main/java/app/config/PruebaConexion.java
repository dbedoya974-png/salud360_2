
package app.config;

public class PruebaConexion {

    public static void main(String[] args) {

        if (DatabaseConnection.testConnection()) {
            System.out.println("CONEXION EXITOSA CON SALUD 360");
        } else {
            System.out.println("ERROR AL CONECTAR CON LA BASE DE DATOS");
        }
    }
}
