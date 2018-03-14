package vista.permisos.control;

import java.util.ArrayList;

import modelo.IPermiso;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 14 de mar. de 2018
 */
public interface IControlPermisos {
	/**
	 * Recibe una plantilla de Permiso y realiza una búsqueda
	 *  filtrando por los campos correspondientes
	 * @param permiso - la plantilla de Permiso con los datos
	 * @return lista de Permisos que satisfacen los filtros de búsqueda
	 */
	public ArrayList<IPermiso> buscarPermiso(IPermiso permiso);
	
	/**
	 * Elimina al Permiso que matchea con su identificador
	 * @param permiso - la plantilla de Permiso con los datos
	 * @return <strong>True</strong> si el Permiso se eliminó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean eliminarPermiso(IPermiso permiso);
	
	/**
	 * @return una plantilla de Permiso vacía
	 */
	public IPermiso getIPermiso();
}
