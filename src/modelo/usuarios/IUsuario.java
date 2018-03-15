package modelo.usuarios;

import java.util.ArrayList;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public interface IUsuario {
	
	public String getNombre();
	public void setNombre(String nombre);
	public String getDescripcion();
	public void setDescripcion(String descripcion);
	public String getEmail();
	public void setEmail(String email);
	public String getPassword();
	public void setPassword(String password);
	public int getEstado();
	public void setEstado(int estado);
	public ArrayList<Object[]> getRoles();
	public void setRoles(ArrayList<Object[]> roles);
	
	public IUsuario clone();
}
