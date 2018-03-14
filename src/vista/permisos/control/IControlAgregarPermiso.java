package vista.permisos.control;

import modelo.IPermiso;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 14 de mar. de 2018
 */
public interface IControlAgregarPermiso {
	/**
	 * Crea un Permiso nuevo
	 * @param permiso - la plantilla de Permiso con los datos
	 * @return <strong>True</strong> si el Permiso se creó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean agregarPermiso(IPermiso permiso);
}
