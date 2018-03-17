package persistencia;

import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ManejoDatos {
	private Conexion con;
	private boolean estado = true;
	
	public boolean isEstado() {
		return estado;
	}

	public ManejoDatos(){
		con = new Conexion();
	}
	
	public String insertar(String tabla, String campos, String valores) {
		estado = true;
		String s = "Se inserto la fila correctamente";
		Connection c = con.conectar();
		String query = "insert into " + tabla + " (" + campos + ") values (" + valores + ")";	
		try {
			Statement st = c.createStatement();
			st.executeQuery(query);
		}
		catch(Exception e){
			estado = false;
			s = "Error al insertar la fila"; 
		}finally {
			con.desconectar();
		}
		return s;
		
	}
	
	public ArrayList<String> select(String tabla, String campos){
		estado = true;
		ArrayList<String> res = new ArrayList<>();
		ArrayList<String> fields = parsear(campos);
		Connection c = con.conectar();
		try {
			Statement st = c.createStatement();
			ResultSet resultSet = st.executeQuery("select " + campos + " from " + tabla);
			while (resultSet.next())
			{
				String res1 = "";
				if (campos.equals("*")){
					res1 += resultSet.getString("ID");
					res1 += "\n";
				}else{
					for (String s : fields){
						res1 += resultSet.getString(s) + " ";
					}
					res.add(res1);					 
				}
				 
			}
		} catch (SQLException e) {
			estado = false;
			e.printStackTrace();
		}finally {
			c = null;
			con.desconectar();
		}
		return res;
	}
	
	public ArrayList<String> select(String tabla, String campos, String condicion){
		estado = true;
		ArrayList<String> res = new ArrayList<>();
		ArrayList<String> fields = parsear(campos);
		Connection c = con.conectar();
		try {
			Statement st = c.createStatement();
			ResultSet resultSet = st.executeQuery("select " + campos + " from " + tabla + " where " + condicion);
			while (resultSet.next())
			{
				String res1 = "";
				if (campos.equals("*")){
					res1 += resultSet.getString("ID");
					res1 += "\n";
				}else{
					for (String s : fields){
						res1 += resultSet.getString(s) + " ";
					}
					res.add(res1);					 
				}
				 
			}
		} catch (SQLException e) {
			estado = false;
			e.printStackTrace();
		}
		return res;
	}
	
	
	public ArrayList<String> parsear(String s){
		 ArrayList<String> campos = new ArrayList<String>();
		 while  (!s.equals("")){
			 int i = s.indexOf(" ");
			 int j = s.indexOf(" ", i +1);
			 campos.add(s.substring(i + 1, j));
			 s = s.substring(j + 1);
		 }
		 return campos;
	 }
	
	public String update(String tabla,String campos) {
		String s = "Se actualizo correctamente la tabla";
		Connection c = con.conectar();
		String query = "update " + tabla + " on " + campos;	
		try {
			Statement st = c.createStatement();
			st.executeQuery(query);
		}
		catch(Exception e){
			estado = true;
			s = "Error al insertar la fila"; 
		}finally {
			con.desconectar();
		}
		return s;

	}
	
	public String update(String tabla,String campos, String condicion) {
		String s = "Se actualizo correctamente la tabla";
		Connection c = con.conectar();
		String query = "update " + tabla + " on " + campos + " Where " + condicion;	
		try {
			Statement st = c.createStatement();
			st.executeQuery(query);
		}
		catch(Exception e){
			estado = true;
			s = "Error al insertar la fila"; 
		}finally {
			con.desconectar();
		}
		return s;

	}
	
}
