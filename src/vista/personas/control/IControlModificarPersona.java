package vista.personas.control;

import modelo.personas.IPersona;

/**
 * @author Javier Elías Gómez Vicente
 * @version 1.1, 14 de mar. de 2018
 */
public interface IControlModificarPersona {
	/**
	 * Modifica a la Persona que matchea con su identificador,
	 *  sobreescribiendo los datos
	 * @param persona - la plantilla de Persona con los datos
	 * @return <strong>True</strong> si la Persona se modificó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean modificarPersona(IPersona persona);
	
	/**
	 * @return una plantilla de Persona vacía
	 */
	public IPersona getIPersona();
}
