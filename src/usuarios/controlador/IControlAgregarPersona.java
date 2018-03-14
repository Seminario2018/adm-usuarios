package usuarios.controlador;

import usuarios.modelo.IPersona;

/**
 * @author 	Javier Elías Gómez Vicente
 * @version 1.0, 13 de mar. de 2018
 */
public interface IControlAgregarPersona extends IControlPersona {
	/**
	 * Crea una Persona nueva
	 * @param persona - la plantilla de Persona con los datos
	 * @return <strong>True</strong> si la Persona se crea con exito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean agregarPersona(IPersona persona);
}
