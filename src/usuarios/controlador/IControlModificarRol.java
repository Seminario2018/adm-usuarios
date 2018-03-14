package usuarios.controlador;

import usuarios.modelo.IRol;

/**
 * @author Javier Elías Gómez Vicente
 * @version 1.0, 13 de mar. de 2018
 */
public interface IControlModificarRol {
	/**
	 * Modifica al Rol que matchea con su identificador,
	 *  sobreescribiendo los datos
	 * @param rol - la plantilla de Rol con los datos
	 * @return <strong>True</strong> si el Rol se modifica con exito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean modificarRol(IRol rol);
}
