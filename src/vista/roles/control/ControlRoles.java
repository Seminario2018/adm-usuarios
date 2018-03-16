/**
 * 
 */
package vista.roles.control;

import java.util.ArrayList;

import controlador.IControlador;
import modelo.roles.IRol;

/**
 * @author Javier Elias Gómez Vicente
 *
 */
public class ControlRoles implements IControlRoles {
	
	IControlador control;
	
	/**
	 * @param control
	 */
	public ControlRoles(IControlador control) {
		super();
		this.control = control;
	}

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlRoles#buscarRoles(modelo.roles.IRol)
	 */
	@Override
	public ArrayList<IRol> buscarRoles(IRol rol) {
		return control.buscarRoles(rol);
	}

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlRoles#eliminarRol(modelo.roles.IRol)
	 */
	@Override
	public boolean eliminarRol(IRol rol) {
		return control.eliminarRol(rol);
	}

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlRoles#getIRol()
	 */
	@Override
	public IRol getIRol() {
		return control.getIRol();
	}

}
