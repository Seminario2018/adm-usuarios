package usuarios.controlador;

import java.util.ArrayList;

import usuarios.modelo.IPermiso;
import usuarios.modelo.IRol;

/**
 * @author Javier Elías Gómez Vicente
 * @version 1.0, 13 de mar. de 2018
 */
public interface IControlAsignarPermiso {
	/**
	 * Recibe una plantilla de Rol y devuelve todos los permisos
	 *  asignados al mismo
	 * @param rol - la plantilla de Rol con los datos
	 * @return lista de permisos que corresponden al Rol
	 */
	public ArrayList<IPermiso> buscarPermisos(IRol rol);
	
	/**
	 * @return lista completa de Permisos existentes
	 */
	public ArrayList<IPermiso> buscarPermisos();
	
	/**
	 * Asigna un Permiso a un Rol 
	 * @param rol - la plantilla de Rol con su identificador
	 * @param permiso - el permiso que se quiere asignar
	 * @return <strong>True</strong> si el Rol se asignÃ³ con Ã©xito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean asignarPermiso(IRol rol, IPermiso permiso);
}
