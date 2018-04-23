package modelo.proyectos;

import sun.util.calendar.BaseCalendar.Date;

public interface IProrroga {
	
	public String getDisposicion();
	public void setDisposicion(String disposicion);
	public Date getFechaInicio();
	public void setFechaInicio(Date fechaInicio);
	public Date getFechaFin();
	public void setFechaFin(Date fechaFin);
	public IProrroga clone();

}
