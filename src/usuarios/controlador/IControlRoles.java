package usuarios.controlador;

import java.util.ArrayList;

import usuarios.modelo.IUsuario;
import usuarios.modelo.IRol;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public interface IControlRoles {
	/**
	 * Recibe una plantilla de Usuario y devuelve todos los roles
	 *  asignados al mismo
	 * @param usuario - la plantilla de Usuario con los datos
	 * @return lista de roles que corresponden al Usuario
	 */
	public ArrayList<IRol> buscarRoles(IUsuario usuario);
	
	/**
	 * @return lista completa de Roles existentes
	 */
	public ArrayList<IRol> buscarRoles();
	
	/**
	 * Asigna un Rol a un Usuario 
	 * @param usuario - la plantilla de Usuario con su identificador
	 * @param rol - el rol que se quiere asignar
	 * @return <strong>True</strong> si el Rol se asignó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean asignarRol(IUsuario usuario, IRol rol);
}
