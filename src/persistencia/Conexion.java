package persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexion {
	
	private Connection conn;
	private String driver;
	private String user;
	private String pass;
	private String url;
	
	
	public Conexion() {
		conn = null;
		driver = "com.mysql.jdbc.Driver";
		user = "root";
		pass = "ljm123ljm";
		url = "jdbc:mysql://localhost:3306/adm-usuario";		
	}
	
	public Connection conectar() {
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void desconectar() {
		conn = null;
	}
}
