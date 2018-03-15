package modelo.permisos;

import java.util.ArrayList;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 15 de mar. de 2018
 */
public interface IGestorPermisos {
	/**
	 * Crea un Permiso nuevo
	 * @param permiso - la plantilla de Permiso con los datos
	 * @return <strong>True</strong> si el Permiso se creó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean agregarPermiso(IPermiso permiso);
	
	/**
	 * Modifica al Permiso que matchea con su identificador,
	 *  sobreescribiendo los datos
	 * @param permiso - la plantilla de Permiso con los datos
	 * @return <strong>True</strong> si el Permiso se modificó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean modificarPermiso(IPermiso permiso);
	
	/**
	 * Elimina al Permiso que matchea con su identificador
	 * @param permiso - la plantilla de Permiso con los datos
	 * @return <strong>True</strong> si el Permiso se eliminó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean eliminarPermiso(IPermiso permiso);
	
	/**
	 * Recibe una plantilla de Permiso y realiza una búsqueda
	 *  filtrando por los campos correspondientes
	 * @param permiso - la plantilla de Permiso con los datos
	 * @return lista de Permisos que satisfacen los filtros de búsqueda
	 */
	public ArrayList<IPermiso> buscarPermiso(IPermiso permiso);
	
	/**
	 * @return una plantilla de Permiso vacía
	 */
	public IPermiso getIPermiso();
}
