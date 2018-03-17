package controlador;

import java.util.ArrayList;

import modelo.permisos.GestorPermisos;
import modelo.permisos.IGestorPermisos;
import modelo.permisos.IPermiso;
import modelo.personas.GestorPersonas;
import modelo.personas.IGestorPersonas;
import modelo.personas.IPersona;
import modelo.roles.GestorRoles;
import modelo.roles.IGestorRoles;
import modelo.roles.IRol;
import modelo.usuarios.GestorUsuarios;
import modelo.usuarios.IGestorUsuarios;
import modelo.usuarios.IUsuario;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 15 de mar. de 2018
 */
public class Controlador implements IControlador {

//	private IGestorUsuarios gestorUsuarios = new GestorUsuarios();
	private IGestorPersonas gestorPersonas = new GestorPersonas();
	private IGestorRoles gestorRoles = new GestorRoles();
	private IGestorPermisos gestorPermisos = new GestorPermisos();

	/*
	public Controlador(
			IGestorUsuarios gestorUsuarios,
			IGestorPersonas gestorPersonas,
			IGestorRoles gestorRoles,
			IGestorPermisos gestorPermisos) {
		super();
		this.gestorUsuarios = gestorUsuarios;
		this.gestorPersonas = gestorPersonas;
		this.gestorRoles = gestorRoles;
		this.gestorPermisos = gestorPermisos;
	}
	*/

	/* (non-Javadoc)
	 * @see controlador.IControlador#agregarUsuario(modelo.IUsuario)
	 */
	@Override
	public boolean agregarUsuario(IPersona persona, IUsuario usuario) {
		return gestorUsuarios.agregarUsuario(persona, usuario);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#modificarUsuario(modelo.IUsuario)
	 */
	@Override
	public boolean modificarUsuario(IUsuario usuario) {
		return gestorUsuarios.modificarUsuario(usuario);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#eliminarUsuario(modelo.IUsuario)
	 */
	@Override
	public boolean eliminarUsuario(IUsuario usuario) {
		return gestorUsuarios.eliminarUsuario(usuario);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#buscarUsuario(modelo.IUsuario, modelo.IPersona)
	 */
	@Override
	public ArrayList<IUsuario> buscarUsuario(IUsuario usuario, IPersona persona) {
		return gestorUsuarios.buscarUsuario(usuario, persona);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#getIUsuario()
	 */
	@Override
	public IUsuario getIUsuario() {
		return gestorUsuarios.getIUsuario();
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#asignarRol(modelo.IUsuario, modelo.IRol)
	 */
	@Override
	public boolean asignarRol(IUsuario usuario, IRol rol) {
		return gestorUsuarios.asignarRol(usuario, rol);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#suprimirRol(modelo.IUsuario, modelo.IRol)
	 */
	@Override
	public boolean suprimirRol(IUsuario usuario, IRol rol) {
		return gestorUsuarios.suprimirRol(usuario, rol);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#agregarRol(modelo.IRol)
	 */
	@Override
	public boolean agregarRol(IRol rol) {
		return gestorRoles.agregarRol(rol);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#modificarRol(modelo.IRol)
	 */
	@Override
	public boolean modificarRol(IRol rol) {
		return gestorRoles.modificarRol(rol);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#eliminarRol(modelo.IRol)
	 */
	@Override
	public boolean eliminarRol(IRol rol) {
		return gestorRoles.eliminarRol(rol);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#buscarRoles(modelo.IRol)
	 */
	@Override
	public ArrayList<IRol> buscarRoles(IRol rol) {
		return gestorRoles.buscarRoles(rol);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#getIRol()
	 */
	@Override
	public IRol getIRol() {
		return gestorRoles.getIRol();
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#asignarPermiso(modelo.IRol, modelo.IPermiso)
	 */
	@Override
	public boolean asignarPermiso(IRol rol, IPermiso permiso) {
		return gestorRoles.asignarPermiso(rol, permiso);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#suprimirPermiso(modelo.IRol, modelo.IPermiso)
	 */
	@Override
	public boolean suprimirPermiso(IRol rol, IPermiso permiso) {
		return gestorRoles.suprimirPermiso(rol, permiso);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#agregarPersona(modelo.IPersona)
	 */
	@Override
	public boolean agregarPersona(IPersona persona) {
		return gestorPersonas.agregarPersona(persona);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#modificarPersona(modelo.IPersona)
	 */
	@Override
	public boolean modificarPersona(IPersona persona) {
		return gestorPersonas.modificarPersona(persona);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#eliminarPersona(modelo.IPersona)
	 */
	@Override
	public boolean eliminarPersona(IPersona persona) {
		return gestorPersonas.eliminarPersona(persona);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#buscarPersona(modelo.IPersona)
	 */
	@Override
	public ArrayList<IPersona> buscarPersona(IPersona persona) {
		return gestorPersonas.buscarPersona(persona);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#getIPersona()
	 */
	@Override
	public IPersona getIPersona() {
		return gestorPersonas.getIPersona();
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#agregarPermiso(modelo.IPermiso)
	 */
	@Override
	public boolean agregarPermiso(IPermiso permiso) {
		return gestorPermisos.agregarPermiso(permiso);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#modificarPermiso(modelo.IPermiso)
	 */
	@Override
	public boolean modificarPermiso(IPermiso permiso) {
		return gestorPermisos.modificarPermiso(permiso);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#eliminarPermiso(modelo.IPermiso)
	 */
	@Override
	public boolean eliminarPermiso(IPermiso permiso) {
		return gestorPermisos.eliminarPermiso(permiso);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#buscarPermiso(modelo.IPermiso)
	 */
	@Override
	public ArrayList<IPermiso> buscarPermiso(IPermiso permiso) {
		return gestorPermisos.buscarPermiso(permiso);
	}

	/* (non-Javadoc)
	 * @see controlador.IControlador#getIPermiso()
	 */
	@Override
	public IPermiso getIPermiso() {
		return gestorPermisos.getIPermiso();
	}

}
