package usuarios.controlador;

import java.util.ArrayList;

import usuarios.modelo.IRol;


/**
 * @author Javier Eías Gómez Vicente
 * @version 1.0, 13 de mar. de 2018
 */
public interface IControlRol {
	/**
	 * Recibe una plantilla de Rol y realiza una busqueda
	 *  filtrando por los campos correspondientes
	 * @param rol - la plantilla de Rol con los datos
	 * @return lista de Roles que satisfacen los filtros de busqueda
	 */
	public ArrayList<IRol> buscarRol(IRol rol);
	
	/**
	 * @return una plantilla de Rol vacía 
	 */
	public IRol getIRol();
}
