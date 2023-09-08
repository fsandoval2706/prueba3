package conectorBD;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {
	public static void main(String[] args) {
        Connection conexion = MySQLConexion.getConexion();
        
        if (conexion != null) {
            System.out.println("Conexión a la base de datos exitosa.");
            // Aquí puedes realizar más operaciones con la conexión si lo deseas.
            
            try {
                conexion.close(); // Cierra la conexión cuando hayas terminado de usarla.
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se pudo establecer la conexión a la base de datos.");
        }
    }
}
