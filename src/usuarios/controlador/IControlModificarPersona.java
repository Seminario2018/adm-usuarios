package usuarios.controlador;

import usuarios.modelo.IPersona;

/**
 * @author Javíer Elías Gómez Vicente
 * @version 1.0, 13 de mar. de 2018
 */
public interface IControlModificarPersona {
	/**
	 * Modifica la Persona que matchea con su identificador,
	 *  sobreescribiendo los datos
	 * @param persona - la plantilla de Persona con los datos
	 * @return <strong>True</strong> si la Persona se modifica con exito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean modificarPersona(IPersona persona);
}
