package modelo.personas;

import java.util.ArrayList;

import modelo.usuarios.IUsuario;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public interface IPersona {
	
	public String getNombre();
	public void setNombre(String nombre);
	public String getApellido();
	public void setApellido(String apellido);
	public String getTipoDoc();
	public void setTipoDoc(String tipoDoc);
	public String getNroDoc();
	public void setNroDoc(String nroDoc);
	public String getCiudad();
	public void setCiudad(String ciudad);
	public String getDireccion();
	public void setDireccion(String direccion);
	public String getTelefono();
	public void setTelefono(String telefono);
	public int getEstado();
	public void setEstado(int estado);
	public String getFechaNacimiento();
	public void setFechaNacimiento(String fechaNacimiento);
	public ArrayList<IUsuario> getUsuarios();
	public void setUsuarios(ArrayList<IUsuario> usuarios);
	
	public IPersona clone();
}
