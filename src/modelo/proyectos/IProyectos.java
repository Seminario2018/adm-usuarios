package modelo.proyectos;

import java.util.List;

import modelo.usuarios.Usuario;
import sun.util.calendar.BaseCalendar.Date;
import modelo.usuarios.Usuario;

public interface IProyectos {
	
	public String getNombre();
	public void setNombre(String nombre);
	public String getResumen();
	public void setResumen(String resumen);
	public Date getFechaDePresentacion();
	public void setFechaDePresentacion(Date fechaDeAprovacion);
	public Date getFechaDeAprovacion();
	public void setFechaDeAprovacion(Date fechaDeAprovacion);
	public String getDescripcion();
	public void setDescripcion(String descripcion);
	public Usuario getDirector();
	public void setDirector(Usuario director);
	public Usuario getCoDirector();
	public void setCoDirector(Usuario subDirector);
	public Date getFechaDeInicio();
	public void setFechaDeInicio(Date fechaDeAprovacion);
	public Date getFechaDeFinalizacion();
	public void setFechaDeFinalizacion(Date fechaDeAprovacion);
	public List<subsidio> getSubsidios();
	public void setSubsidios(subsidio subsidios);

	
	public IProyectos clone();
	
	
	
	

}
