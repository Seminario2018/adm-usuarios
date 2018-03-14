package vista.permisos.control;

import modelo.IPermiso;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 14 de mar. de 2018
 */
public interface IControlModificarPermiso {
	/**
	 * Modifica al Permiso que matchea con su identificador,
	 *  sobreescribiendo los datos
	 * @param permiso - la plantilla de Permiso con los datos
	 * @return <strong>True</strong> si el Permiso se modificó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean modificarPermiso(IPermiso permiso);
}
