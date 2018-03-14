package vista.usuarios.control;

import java.util.ArrayList;

import modelo.IRol;
import modelo.IUsuario;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public interface IControlGestionarRoles {
	/**
	 * Recibe una plantilla de Rol y realiza una búsqueda
	 *  filtrando por los campos correspondientes
	 * @param rol - la plantilla de Rol con los datos
	 * @return lista de roles que satisfacen los filtros de búsqueda
	 */
	public ArrayList<IRol> buscarRoles(IRol rol);
	
	/**
	 * Asigna un Rol a un Usuario 
	 * @param usuario - la plantilla de Usuario con su identificador
	 * @param rol - el Rol que se quiere asignar
	 * @return <strong>True</strong> si el Rol se asignó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean asignarRol(IUsuario usuario, IRol rol);
	
	/**
	 * Suprime un Rol de un Usuario
	 * @param usuario - la plantilla de Usuario con su identificador
	 * @param rol - el Rol que se quiere suprimir
	 * @return <strong>True</strong> si el Rol se suprimió con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean suprimirRol(IUsuario usuario, IRol rol);
}
