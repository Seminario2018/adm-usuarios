/**
 * 
 */
package usuarios.controlador;

import java.util.ArrayList;

import usuarios.modelo.IPersona;
import usuarios.modelo.IUsuario;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public interface IControlUsuarios {
	/**
	 * Recibe una plantilla de Usuario y Persona y realiza una búsqueda
	 * filtrando por los campos correspondientes
	 * @param usuario - la plantilla de Usuario con los datos
	 * @param persona - la plantilla de Persona con los datos
	 * @return lista de Usuarios que satisfacen los filtros de búsqueda
	 */
	public ArrayList<IUsuario> buscarUsuario(IUsuario usuario, IPersona persona);
	
	/**
	 * @return una plantilla de Usuario vacía 
	 */
	public IUsuario getIUsuario();
	
	/**
	 * @return una plantilla de Persona vacía
	 */
	public IPersona getIPersona();
}
