package modelo.Programas;

import java.util.List;

import jdk.nashorn.internal.runtime.ListAdapter;
import modelo.proyectos.Proyecto;
import modelo.usuarios.Usuario;
import sun.util.calendar.BaseCalendar.Date;

public class Programa implements IPrograma {

	private String nombre;
	private Usuario director;
	private Usuario coordinador;
	private String Disposicion;
	private Date fechaInicio;
	private Date fechaFin;
	private List<Proyecto> proyectos;
	public Programa(String nombre, Usuario director, Usuario coordinador, String disposicion, Date fechaInicio,
			Date fechaFin) {
		super();
		this.nombre = nombre;
		this.director = director;
		this.coordinador = coordinador;
		Disposicion = disposicion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
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
	public Usuario getDirector() {
		return director;
	}
	
	@Override
	public void setDirector(Usuario director) {
		this.director = director;
	}
	
	@Override
	public Usuario getCoordinador() {
		return coordinador;
	}
	
	@Override
	public void setCoordinador(Usuario coordinador) {
		this.coordinador = coordinador;
	}
	
	@Override
	public String getDisposicion() {
		return Disposicion;
	}
	
	@Override
	public void setDisposicion(String disposicion) {
		Disposicion = disposicion;
	}
	
	@Override
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	@Override
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	@Override
	public Date getFechaFin() {
		return fechaFin;
	}
	
	
	@Override
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
	
	
	@Override
	public IPrograma clone() {
		return new Programa(nombre,director, coordinador, Disposicion ,fechaInicio, fechaFin);
	}






	@Override
	public List<Proyecto> getProyectos() {
		return proyectos ;
	}






	@Override
	public void setProyecto(Proyecto proyecto) {
		// TODO Auto-generated method stub
		this.proyectos.add(proyecto);
	}
	
	
}
