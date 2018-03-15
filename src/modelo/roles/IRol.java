package modelo.roles;

import java.util.ArrayList;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public interface IRol {
	
	public String getNombre();
	public void setNombre(String nombre);
	public String getNombreAmigable();
	public void setNombreAmigable(String nombreAmigable);
	public String getDescripcion();
	public void setDescripcion(String descripcion);
	public int getEstado();
	public void setEstado(int estado);
	public ArrayList<Object[]> getPermisos();
	public void setPermisos(ArrayList<Object[]> permisos);
	
	public IRol clone();
}
