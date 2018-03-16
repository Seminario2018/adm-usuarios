/**
 * 
 */
package vista.roles.control;

import controlador.IControlador;
import modelo.roles.IRol;

/**
 * @author Elias
 *
 */
public class ControlModificarRol implements IControlModificarRol {
	
	private IControlador control;
	
	/**
	 * @param control
	 */
	public ControlModificarRol(IControlador control) {
		super();
		this.control = control;
	}

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlModificarRol#modificarRol(modelo.roles.IRol)
	 */
	@Override
	public boolean modificarRol(IRol rol) {
		return control.modificarRol(rol);
	}

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlModificarRol#getIRol()
	 */
	@Override
	public IRol getIRol() {
		return control.getIRol();
	}

}
