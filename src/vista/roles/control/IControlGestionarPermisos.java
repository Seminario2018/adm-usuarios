package vista.roles.control;

import java.util.ArrayList;

import modelo.IPermiso;
import modelo.IRol;

/**
 * @author Javier Elías Gómez Vicente
 * @version 1.1, 14 de mar. de 2018
 */
public interface IControlGestionarPermisos {
	/**
	 * Recibe una plantilla de Permiso y realiza una búsqueda
	 *  filtrando por los campos correspondientes
	 * @param permiso - la plantilla de Permiso con los datos
	 * @return lista de Permisos que satisfacen los filtros de búsqueda
	 */
	public ArrayList<IPermiso> buscarPermisos(IPermiso permiso);
	
	/**
	 * Asigna un Permiso a un Rol 
	 * @param rol - la plantilla de Rol con su identificador
	 * @param permiso - el permiso que se quiere asignar
	 * @return <strong>True</strong> si el Permiso se asignó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean asignarPermiso(IRol rol, IPermiso permiso);
	
	/**
	 * Suprime un Permiso de un Rol
	 * @param rol - la plantilla de Rol con su identificador
	 * @param permiso - el Permiso que se quiere suprimir
	 * @return <strong>True</strong> si el Permiso se suprimió con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean suprimirPermiso(IRol rol, IPermiso permiso);
}
