package vista.personas.control;

import java.util.ArrayList;

import modelo.personas.IPersona;

/**
 * @author Javier Elías Gómez Vicente
 * @version 1.1, 14 de mar. de 2018
 */
public interface IControlPersonas {
	/**
	 * Recibe una plantilla de Persona y realiza una búsqueda
	 *  filtrando por los campos correspondientes
	 * @param persona - la plantilla de Persona con los datos
	 * @return lista de Personas que satisfacen los filtros de búsqueda
	 */
	public ArrayList<IPersona> buscarPersona(IPersona persona);
	
	/**
	 * Elimina a la Persona que matchea con su identificador
	 * @param persona - la plantilla de Persona con los datos
	 * @return <strong>True</strong> si la Persona se eliminó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean eliminarPersona(IPersona persona);
	
	/**
	 * @return una plantilla de Persona vacía
	 */
	public IPersona getIPersona();
}
