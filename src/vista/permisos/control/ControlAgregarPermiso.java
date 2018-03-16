/**
 * 
 */
package vista.permisos.control;

import controlador.IControlador;
import modelo.permisos.IPermiso;

/**
 * @author Javier Elías Gómez Vicente
 *
 */
public class ControlAgregarPermiso implements IControlAgregarPermiso {

	private IControlador control;
	
	/**
	 * @param control
	 */
	public ControlAgregarPermiso(IControlador control) {
		super();
		this.control = control;
	}

	/* (non-Javadoc)
	 * @see vista.permisos.control.IControlAgregarPermiso#agregarPermiso(modelo.permisos.IPermiso)
	 */
	@Override
	public boolean agregarPermiso(IPermiso permiso) {
		return control.agregarPermiso(permiso);
	}

	/* (non-Javadoc)
	 * @see vista.permisos.control.IControlAgregarPermiso#getIPermiso()
	 */
	@Override
	public IPermiso getIPermiso() {
		return control.getIPermiso();
	}

}
