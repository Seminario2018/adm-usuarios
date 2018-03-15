package modelo.usuarios;

import java.util.ArrayList;

import modelo.personas.IPersona;
import modelo.roles.IRol;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 15 de mar. de 2018
 */
public interface IGestorUsuarios {
	/**
	 * Crea un Usuario nuevo
	 * @param persona - la plantilla de Persona a la cual se le asignará el Usuario
	 * @param usuario - la plantilla de Usuario con los datos
	 * @return <strong>True</strong> si el Usuario se creó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean agregarUsuario(IPersona persona, IUsuario usuario);

	
	/**
	 * Modifica al Usuario que matchea con su identificador,
	 *  sobreescribiendo los datos
	 * @param usuario - la plantilla de Usuario con los datos
	 * @return <strong>True</strong> si el Usuario se modificó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean modificarUsuario(IUsuario usuario);
	
	/**
	 * Elimina al Usuario que matchea con su identificador
	 * @param usuario - la plantilla de Usuario con los datos
	 * @return <strong>True</strong> si el Usuario se eliminó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean eliminarUsuario(IUsuario usuario);
	
	/**
	 * Recibe una plantilla de Usuario y Persona y realiza una búsqueda
	 *  filtrando por los campos correspondientes
	 * @param usuario - la plantilla de Usuario con los datos
	 * @param persona - la plantilla de Persona con los datos
	 * @return lista de Usuarios que satisfacen los filtros de búsqueda
	 */
	public ArrayList<IUsuario> buscarUsuario(IUsuario usuario, IPersona persona);
	
	/**
	 * @return una plantilla de Usuario vacía 
	 */
	public IUsuario getIUsuario();
	
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
