package conectorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	public static Connection getConexion() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/banco_platinum";
			String usr = "root";
			String psw = "Root";
			
			con = DriverManager.getConnection(url,usr,psw);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error --> al cargar el Driver");
		
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error --> de Base de Datos");
			
			
		}
		
		return con;
	} 
}
