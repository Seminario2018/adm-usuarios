package modelo.personas;

import java.util.ArrayList;

import modelo.usuarios.IUsuario;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public class Persona implements IPersona {
	
	private String nombre;
	private String apellido;
	private String tipoDoc;
	private String nroDoc;
	private String ciudad;
	private String direccion;
	private String telefono;
	private int estado;
	private String fechaNacimiento;
	
	private ArrayList<IUsuario> usuarios = new ArrayList<IUsuario>();
	
	public Persona() {
		super();
	}
	
	public Persona(String nombre, String apellido, String tipoDoc, String nroDoc, String ciudad, String direccion,
			String telefono, int estado, String fechaNacimiento, ArrayList<IUsuario> usuarios) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDoc = tipoDoc;
		this.nroDoc = nroDoc;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.telefono = telefono;
		this.estado = estado;
		this.fechaNacimiento = fechaNacimiento;
		this.usuarios = usuarios;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getNroDoc() {
		return nroDoc;
	}
	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public ArrayList<IUsuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList<IUsuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public IPersona clone() {
		return new Persona(nombre, apellido, tipoDoc, nroDoc, ciudad, direccion,
				telefono, estado, fechaNacimiento, usuarios);
	}
}
