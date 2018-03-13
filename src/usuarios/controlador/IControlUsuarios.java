/**
 * 
 */
package usuarios.controlador;

import java.util.ArrayList;

import usuarios.modelo.IPersona;
import usuarios.modelo.IUsuario;

/**
 * @author Mart�n Tom�s Juran
 * @version 1.0, 13 de mar. de 2018
 */
public interface IControlUsuarios {
	/**
	 * Recibe una plantilla de Usuario y Persona y realiza una b�squeda
	 * filtrando por los campos correspondientes
	 * @param usuario - la plantilla de Usuario con los datos
	 * @param persona - la plantilla de Persona con los datos
	 * @return lista de Usuarios que satisfacen los filtros de b�squeda
	 */
	public ArrayList<IUsuario> buscarUsuario(IUsuario usuario, IPersona persona);
	
	/**
	 * @return una plantilla de Usuario vac�a 
	 */
	public IUsuario getIUsuario();
	
	/**
	 * @return una plantilla de Persona vac�a
	 */
	public IPersona getIPersona();
}
