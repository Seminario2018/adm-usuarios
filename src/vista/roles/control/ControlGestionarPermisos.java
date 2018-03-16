/**
 * 
 */
package vista.roles.control;

import java.util.ArrayList;

import controlador.IControlador;
import modelo.permisos.IPermiso;
import modelo.roles.IRol;

/**
 * @author Javier Eías Gómez Vicente
 *
 */
public class ControlGestionarPermisos implements IControlGestionarPermisos {

	private IControlador control;
	
	/**
	 * @param control
	 */
	public ControlGestionarPermisos(IControlador control) {
		super();
		this.control = control;
	}

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlGestionarPermisos#buscarPermisos(modelo.permisos.IPermiso)
	 */
	@Override
	public ArrayList<IPermiso> buscarPermisos(IPermiso permiso) {
		return control.buscarPermiso(permiso);
	}

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlGestionarPermisos#asignarPermiso(modelo.roles.IRol, modelo.permisos.IPermiso)
	 */
	@Override
	public boolean asignarPermiso(IRol rol, IPermiso permiso) {
		return control.asignarPermiso(rol, permiso);
	}

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlGestionarPermisos#suprimirPermiso(modelo.roles.IRol, modelo.permisos.IPermiso)
	 */
	@Override
	public boolean suprimirPermiso(IRol rol, IPermiso permiso) {
		return control.suprimirPermiso(rol, permiso);
	}

}
