package vista.usuarios.control;

import java.util.ArrayList;

import modelo.personas.IPersona;
import modelo.usuarios.IUsuario;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public interface IControlAgregarUsuario {
	/**
	 * Crea un Usuario nuevo
	 * @param persona - la plantilla de Persona a la cual se le asignará el Usuario
	 * @param usuario - la plantilla de Usuario con los datos
	 * @return <strong>True</strong> si el Usuario se creó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean agregarUsuario(IPersona persona, IUsuario usuario);
	
	/**
	 * Recibe una plantilla de Persona y realiza una búsqueda
	 *  filtrando por los campos correspondientes
	 * @param persona - la plantilla de Persona con los datos
	 * @return lista de Personas que satisfacen los filtros de búsqueda
	 */
	public ArrayList<IPersona> buscarPersona(IPersona persona);
	
	/**
	 * @return una plantilla de Usuario vacía 
	 */
	public IUsuario getIUsuario();
	
	/**
	 * @return una plantilla de Persona vacía
	 */
	public IPersona getIPersona();
}
