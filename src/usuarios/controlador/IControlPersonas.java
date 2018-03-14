package usuarios.controlador;

import java.util.ArrayList;

import usuarios.modelo.IPersona;

/**
 * @author Javier Elías Gómez Vicente
 * @version 1.0, 13 de mar. de 2018
 */
public interface IControlPersona {
	/**
	 * Recibe una plantilla de Persona y realiza una busqueda
	 *  filtrando por los campos correspondientes
	 * @param persona - la plantilla de Persona con los datos
	 * @return lista de Personas que satisfacen los filtros de busqueda
	 */
	public ArrayList<IPersona> buscarPersona(IPersona persona);
	
	/**
	 * @return una plantilla de Persona vacía
	 */
	public IPersona getIPersona();
}
