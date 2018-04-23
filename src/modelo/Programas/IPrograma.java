package modelo.Programas;

import java.util.List;

import modelo.proyectos.Proyecto;
import modelo.usuarios.Usuario;
import sun.util.calendar.BaseCalendar.Date;

public interface IPrograma {
	
	public String getNombre();
	public void setNombre(String nombre);
	public Usuario getDirector();
	public void setDirector(Usuario usuario);
	public Usuario getCoordinador();
	public void setCoordinador(Usuario usuario);
	public String getDisposicion();
	public void setDisposicion(String disposicion);
	public Date getFechaInicio();
	public void setFechaInicio(Date fechaInicio);
	public Date getFechaFin();
	public void setFechaFin(Date fechaFin);
	public List<Proyecto> getProyectos();
	public void setProyecto(Proyecto proyecto);
	
	
	public IPrograma clone();


}
