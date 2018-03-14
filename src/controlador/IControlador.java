package controlador;

import java.util.ArrayList;

import modelo.IPermiso;
import modelo.IPersona;
import modelo.IRol;
import modelo.IUsuario;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 14 de mar. de 2018
 */
public interface IControlador {
	/**
	 * Crea un Usuario nuevo
	 * @param usuario - la plantilla de Usuario con los datos
	 * @return <strong>True</strong> si el Usuario se creó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean agregarUsuario(IUsuario usuario);
	
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
	
	/**
	 * Crea una Persona nueva
	 * @param persona - la plantilla de Persona con los datos
	 * @return <strong>True</strong> si la Persona se creó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean agregarPersona(IPersona persona);
	
	/**
	 * Modifica a la Persona que matchea con su identificador,
	 *  sobreescribiendo los datos
	 * @param persona - la plantilla de Persona con los datos
	 * @return <strong>True</strong> si la Persona se modificó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean modificarPersona(IPersona persona);
	
	/**
	 * Elimina a la Persona que matchea con su identificador
	 * @param persona - la plantilla de Persona con los datos
	 * @return <strong>True</strong> si la Persona se eliminó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean eliminarPersona(IPersona persona);

	/**
	 * Recibe una plantilla de Persona y realiza una búsqueda
	 *  filtrando por los campos correspondientes
	 * @param persona - la plantilla de Persona con los datos
	 * @return lista de Personas que satisfacen los filtros de búsqueda
	 */
	public ArrayList<IPersona> buscarPersona(IPersona persona);
	
	/**
	 * @return una plantilla de Persona vacía
	 */
	public IPersona getIPersona();
	
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
