package vista.permisos.control;

import modelo.permisos.IPermiso;

/**
 * @author Martín Tomás Juran
 * @version 1.1, 15 de mar. de 2018
 */
public interface IControlAgregarPermiso {
	/**
	 * Crea un Permiso nuevo
	 * @param permiso - la plantilla de Permiso con los datos
	 * @return <strong>True</strong> si el Permiso se creó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean agregarPermiso(IPermiso permiso);
	
	/**
	 * @return una plantilla de Permiso vacía
	 */
	public IPermiso getIPermiso();
}
