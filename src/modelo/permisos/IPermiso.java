package modelo.permisos;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public interface IPermiso {
	
	public String getNombre();
	public void setNombre(String nombre);
	public String getDescripcion();
	public void setDescripcion(String descripcion);
	public String getFuncionalidad();
	public void setFuncionalidad(String funcionalidad);
	public int getEstado();
	public void setEstado(int estado);
	
	public IPermiso clone();
}
