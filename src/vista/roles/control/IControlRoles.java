package vista.roles.control;

import java.util.ArrayList;

import modelo.roles.IRol;

/**
 * @author Javier Eías Gómez Vicente
 * @version 1.1, 14 de mar. de 2018
 */
public interface IControlRoles {
	/**
	 * Recibe una plantilla de Rol y realiza una búsqueda
	 *  filtrando por los campos correspondientes
	 * @param rol - la plantilla de Rol con los datos
	 * @return lista de roles que satisfacen los filtros de búsqueda
	 */
	public ArrayList<IRol> buscarRoles(IRol rol);
	
	/**
	 * Elimina al Rol que matchea con su identificador
	 * @param rol - la plantilla de Rol con los datos
	 * @return <strong>True</strong> si el Rol se eliminó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean eliminarRol(IRol rol);
	
	/**
	 * @return una plantilla de Rol vacía 
	 */
	public IRol getIRol();
}
