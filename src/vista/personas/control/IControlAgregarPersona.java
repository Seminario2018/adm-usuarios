package vista.personas.control;

import modelo.personas.IPersona;

/**
 * @author Javier Elías Gómez Vicente
 * @version 1.2, 14 de mar. de 2018
 */
public interface IControlAgregarPersona {
	/**
	 * Crea una Persona nueva
	 * @param persona - la plantilla de Persona con los datos
	 * @return <strong>True</strong> si la Persona se creó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean agregarPersona(IPersona persona);
	
	/**
	 * @return una plantilla de Persona vacía
	 */
	public IPersona getIPersona();
}
