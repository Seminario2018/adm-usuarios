package modelo.proyectos;


import java.util.ArrayList;
import java.util.List;

import modelo.Programas.Programa;
import modelo.permisos.Permiso;
import modelo.personas.Persona;
import modelo.roles.Rol;
import modelo.usuarios.Usuario;
import persistencia.ManejoDatos;
import sun.util.calendar.BaseCalendar.Date;


public class Proyecto implements IProyectos {
	
	private String nombre;
	private String resumen;
	private Date fechaDePresentacion;
	private Date fechaDeAprovacion;
	private String descripcion;
	private Usuario director;
	private Usuario codirector;
	private Date fechaDeInicio;
	private Date fechaDeFinalizacion;
	private List<subsidio> subsidios; 
	private List<Usuario> integrantes;
	
	
	public Proyecto(String nombre, String resumen, Date fechaDePresentacion, Date fechaDeAprovacion, String descripcion,
			Usuario director, Usuario codirector, Date fechaDeInicio, Date fechaDeFinalizacion) {
		super();
		this.nombre = nombre;
		this.resumen = resumen;
		this.fechaDePresentacion = fechaDePresentacion;
		this.fechaDeAprovacion = fechaDeAprovacion;
		this.descripcion = descripcion;
		this.director = director;
		this.codirector = codirector;
		this.fechaDeInicio = fechaDeInicio;
		this.fechaDeFinalizacion = fechaDeFinalizacion;
	}
	
	
	
	@Override
	public String getNombre() {
		return nombre;
	}
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String getResumen() {
		return resumen;
	}
	@Override
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	@Override
	public Date getFechaDePresentacion() {
		return fechaDePresentacion;
	}
	
	@Override
	public void setFechaDePresentacion(Date fechaDePresentacion) {
		this.fechaDePresentacion = fechaDePresentacion;
	}
	@Override
	public Date getFechaDeAprovacion() {
		return fechaDeAprovacion;
	}
	@Override
	public void setFechaDeAprovacion(Date fecaDeAprovacion) {
		this.fechaDeAprovacion = fecaDeAprovacion;
	}
	@Override
	public String getDescripcion() {
		return descripcion;
	}
	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public Usuario getDirector() {
		return director;
	}
	@Override
	public void setDirector(Usuario director) {
		this.director = director;
	}
	@Override
	public Usuario getCoDirector() {
		return codirector;
	}
	@Override
	public void setCoDirector(Usuario codirector) {
		this.codirector = codirector;
	}
	@Override
	public Date getFechaDeInicio() {
		// TODO Auto-generated method stub
		return fechaDeInicio;
	};
	
	@Override
	public void setFechaDeInicio(Date fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}
	public Date getFechaDeFinalizacion() {
		return fechaDeFinalizacion;
	}
	@Override
	public void setFechaDeFinalizacion(Date fechaDeFinalizacion) {
		this.fechaDeFinalizacion = fechaDeFinalizacion;
	}
	
	
	@Override
	public IProyectos clone() {
		return new Proyecto(nombre, resumen, fechaDeInicio, fechaDeFinalizacion,descripcion , director,codirector, fechaDePresentacion, fechaDeAprovacion);
	}



	@Override
	public List<subsidio> getSubsidios() {
		
		return subsidios;
	}



	@Override
	public void setSubsidios(subsidio subsidios) {
		// TODO Auto-generated method stub
			this.subsidios.add(subsidios);
	}



	
	
}
