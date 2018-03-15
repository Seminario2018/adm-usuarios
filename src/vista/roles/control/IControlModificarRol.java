package vista.roles.control;

import modelo.roles.IRol;

/**
 * @author Javier Elías Gómez Vicente
 * @version 1.1, 14 de mar. de 2018
 */
public interface IControlModificarRol {
	/**
	 * Modifica al Rol que matchea con su identificador,
	 *  sobreescribiendo los datos
	 * @param rol - la plantilla de Rol con los datos
	 * @return <strong>True</strong> si el Rol se modificó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean modificarRol(IRol rol);
	
	/**
	 * @return una plantilla de Rol vacía 
	 */
	public IRol getIRol();
}