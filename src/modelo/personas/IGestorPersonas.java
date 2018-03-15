package modelo.personas;

import java.util.ArrayList;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 15 de mar. de 2018
 */
public interface IGestorPersonas {
	/**
	 * Crea una Persona nueva
	 * @param persona - la plantilla de Persona con los datos
	 * @return <strong>True</strong> si la Persona se creó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean agregarPersona(IPersona persona);
	
	/**
	 * Modifica a la Persona que matchea con su identificador,
	 *  sobreescribiendo los datos
	 * @param persona - la plantilla de Persona con los datos
	 * @return <strong>True</strong> si la Persona se modificó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean modificarPersona(IPersona persona);
	
	/**
	 * Elimina a la Persona que matchea con su identificador
	 * @param persona - la plantilla de Persona con los datos
	 * @return <strong>True</strong> si la Persona se eliminó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean eliminarPersona(IPersona persona);

	/**
	 * Recibe una plantilla de Persona y realiza una búsqueda
	 *  filtrando por los campos correspondientes
	 * @param persona - la plantilla de Persona con los datos
	 * @return lista de Personas que satisfacen los filtros de búsqueda
	 */
	public ArrayList<IPersona> buscarPersona(IPersona persona);
	
	/**
	 * @return una plantilla de Persona vacía
	 */
	public IPersona getIPersona();
}
