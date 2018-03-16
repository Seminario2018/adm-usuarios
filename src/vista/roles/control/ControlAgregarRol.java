/**
 * 
 */
package vista.roles.control;

import controlador.IControlador;
import modelo.roles.IRol;

/**
 * @author Javier Elías Gómez Vicente
 *
 */
public class ControlAgregarRol implements IControlAgregarRol {
	
	private IControlador control;
	
	/**
	 * @param control
	 */
	public ControlAgregarRol(IControlador control) {
		super();
		this.control = control;
	}

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlAgregarRol#agregarRol(modelo.roles.IRol)
	 */
	@Override
	public boolean agregarRol(IRol rol) {
		return control.agregarRol(rol);
	}

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlAgregarRol#getIRol()
	 */
	@Override
	public IRol getIRol() {
		return control.getIRol();
	}

}
