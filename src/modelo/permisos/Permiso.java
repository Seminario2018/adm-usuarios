package modelo.permisos;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public class Permiso implements IPermiso {
	
	private String nombre;
	private String descripcion;
	private String funcionalidad;
	private int estado;
	
	public Permiso() {
		super();
	}
	
	public Permiso(String nombre, String descripcion, String funcionalidad, int estado) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.funcionalidad = funcionalidad;
		this.estado = estado;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFuncionalidad() {
		return funcionalidad;
	}
	public void setFuncionalidad(String funcionalidad) {
		this.funcionalidad = funcionalidad;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public IPermiso clone() {
		return new Permiso(nombre, descripcion, funcionalidad, estado);
	}
}
