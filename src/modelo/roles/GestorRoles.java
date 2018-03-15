package modelo.roles;

import java.util.ArrayList;

import modelo.permisos.IPermiso;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 15 de mar. de 2018
 */
public class GestorRoles implements IGestorRoles {

	/* (non-Javadoc)
	 * @see modelo.roles.IGestorRoles#agregarRol(modelo.roles.IRol)
	 */
	@Override
	public boolean agregarRol(IRol rol) {
		return false;
	}

	/* (non-Javadoc)
	 * @see modelo.roles.IGestorRoles#modificarRol(modelo.roles.IRol)
	 */
	@Override
	public boolean modificarRol(IRol rol) {
		return false;
	}

	/* (non-Javadoc)
	 * @see modelo.roles.IGestorRoles#eliminarRol(modelo.roles.IRol)
	 */
	@Override
	public boolean eliminarRol(IRol rol) {
		return false;
	}

	/* (non-Javadoc)
	 * @see modelo.roles.IGestorRoles#buscarRoles(modelo.roles.IRol)
	 */
	@Override
	public ArrayList<IRol> buscarRoles(IRol rol) {
		return null;
	}

	/* (non-Javadoc)
	 * @see modelo.roles.IGestorRoles#getIRol()
	 */
	@Override
	public IRol getIRol() {
		return new Rol();
	}

	/* (non-Javadoc)
	 * @see modelo.roles.IGestorRoles#asignarPermiso(modelo.roles.IRol, modelo.permisos.IPermiso)
	 */
	@Override
	public boolean asignarPermiso(IRol rol, IPermiso permiso) {
		return false;
	}

	/* (non-Javadoc)
	 * @see modelo.roles.IGestorRoles#suprimirPermiso(modelo.roles.IRol, modelo.permisos.IPermiso)
	 */
	@Override
	public boolean suprimirPermiso(IRol rol, IPermiso permiso) {
		return false;
	}

}
