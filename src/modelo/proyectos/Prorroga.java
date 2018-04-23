package modelo.proyectos;

import sun.util.calendar.BaseCalendar.Date;

public class Prorroga implements IProrroga{

	private String disposicion;
	private Date fechaInicio;
	private Date fechaFin;
	public Prorroga(String disposicion, Date fechaInicio, Date fechaFin) {
		super();
		this.disposicion = disposicion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	@Override
	public String getDisposicion() {
		return disposicion;
	}
	
	@Override
	public void setDisposicion(String disposicion) {
		this.disposicion = disposicion;
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
	public IProrroga clone() {
		return new Prorroga(disposicion, fechaInicio, fechaFin);
	}
	
}
