package modelo.roles;

import java.util.ArrayList;

import modelo.permisos.IPermiso;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 15 de mar. de 2018
 */
public interface IGestorRoles {
	/**
	 * Crea un Rol nuevo
	 * @param rol - la plantilla de Rol con los datos
	 * @return <strong>True</strong> si el Rol se creó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean agregarRol(IRol rol);

	/**
	 * Modifica al Rol que matchea con su identificador,
	 *  sobreescribiendo los datos
	 * @param rol - la plantilla de Rol con los datos
	 * @return <strong>True</strong> si el Rol se modificó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean modificarRol(IRol rol);

	/**
	 * Elimina al Rol que matchea con su identificador
	 * @param rol - la plantilla de Rol con los datos
	 * @return <strong>True</strong> si el Rol se eliminó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean eliminarRol(IRol rol);
	
	/**
	 * Recibe una plantilla de Rol y realiza una búsqueda
	 *  filtrando por los campos correspondientes
	 * @param rol - la plantilla de Rol con los datos
	 * @return lista de roles que satisfacen los filtros de búsqueda
	 */
	public ArrayList<IRol> buscarRoles(IRol rol);
	
	/**
	 * @return una plantilla de Rol vacía 
	 */
	public IRol getIRol();
	
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
