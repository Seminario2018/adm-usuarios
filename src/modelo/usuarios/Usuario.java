package modelo.usuarios;

import java.util.ArrayList;

import modelo.permisos.Permiso;
import modelo.roles.Rol;
import persistencia.ManejoDatos;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public class Usuario implements IUsuario {
	
	private ManejoDatos md = new ManejoDatos();
	private String nombre;
	private String descripcion;
	private String email;
	private String password;
	private int estado;
	// ArrayList de [IRol, String] (fechaAsignacion)
	private ArrayList<Object[]> roles = new ArrayList<Object[]>();
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nombre, String descripcion, String email, String password, int estado,
			ArrayList<Object[]> roles) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.email = email;
		this.password = password;
		this.estado = estado;
		this.roles = roles;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public ArrayList<Object[]> getRoles() {
		ArrayList<Object[]> permisos = new ArrayList<Object[]>();
		ArrayList<String> per = md.select("roles r join rolesporusuario ru", "Nombre, Nombre_amigable, descripcion, r.estado, fecha_de_asignacion",
				"ru.Estado = 1 AND ru.rol = r.nombre AND '" + this.getNombre() + "' = ru.usuario");
		for (String s: per) {
			String[] split = s.split(" -- ");
			Object[] o = new Object[2];
			o[0] = new Rol(split[0], split[1],split[2], Integer.parseInt(split[3]),null);
			o[1] = split[4];
			permisos.add(o);
		}
		this.setRoles(permisos);
		return this.roles;

	}
	public void setRoles(ArrayList<Object[]> roles) {
		this.roles = roles;
	}

	@Override
	public IUsuario clone() {
		return new Usuario(nombre, descripcion, email, password, estado, roles);
	}
	
}
