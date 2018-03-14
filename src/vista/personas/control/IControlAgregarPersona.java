package vista.personas.control;

import modelo.IPersona;

/**
 * @author Javier Elías Gómez Vicente
 * @version 1.1, 14 de mar. de 2018
 */
public interface IControlAgregarPersona extends IControlPersonas {
	/**
	 * Crea una Persona nueva
	 * @param persona - la plantilla de Persona con los datos
	 * @return <strong>True</strong> si la Persona se creó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean agregarPersona(IPersona persona);
}
