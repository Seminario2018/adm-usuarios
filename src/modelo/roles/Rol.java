package modelo.roles;

import java.util.ArrayList;

import modelo.permisos.Permiso;
import persistencia.ManejoDatos;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public class Rol implements IRol {
	
	private ManejoDatos md = new ManejoDatos();
	private String nombre;
	private String nombreAmigable;
	private String descripcion;
	private int estado;
	// ArrayList de [IPermiso, String] (fechaAsignacion)
	private ArrayList<Object[]> permisos = new ArrayList<Object[]>();
	
	public Rol() {
		super();
	}
	
	public Rol(String nombre, String nombreAmigable, String descripcion, int estado, ArrayList<Object[]> permisos) {
		super();
		this.nombre = nombre;
		this.nombreAmigable = nombreAmigable;
		this.descripcion = descripcion;
		this.estado = estado;
		this.permisos = permisos;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreAmigable() {
		return nombreAmigable;
	}
	public void setNombreAmigable(String nombreAmigable) {
		this.nombreAmigable = nombreAmigable;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public ArrayList<Object[]> getPermisos() {
		ArrayList<Object[]> permisos = new ArrayList<Object[]>();
		ArrayList<String> per = md.select("permisos p join permisosderoles pr join roles r", "permisos.* "
				+ "pr.fecha_de_asignacion","Estado = 1 AND r.Nombre = pr.rol AND p.nombre = pr.permiso");
		for (String s: per) {
			String[] split = s.split(" ");
			Object[] o = new Object[2];
			o[0] = new Permiso(split[0], split[1],split[2], Integer.parseInt(split[3]));
			o[1] = split[4];
			permisos.add(o);
		}
		this.setPermisos(permisos);
		return this.permisos;
	}
	public void setPermisos(ArrayList<Object[]> permisos) {
		this.permisos = permisos;
	}
	
	@Override
	public IRol clone() {
		return new Rol(nombre, nombreAmigable, descripcion, estado, permisos);
	}
	
}
