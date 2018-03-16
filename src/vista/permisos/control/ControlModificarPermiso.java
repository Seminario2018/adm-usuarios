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
public class ControlModificarPermiso implements IControlModificarPermiso {
	
	private IControlador control;
	
	/**
	 * @param control
	 */
	public ControlModificarPermiso(IControlador control) {
		super();
		this.control = control;
	}

	/* (non-Javadoc)
	 * @see vista.permisos.control.IControlModificarPermiso#modificarPermiso(modelo.permisos.IPermiso)
	 */
	@Override
	public boolean modificarPermiso(IPermiso permiso) {
		return control.modificarPermiso(permiso);
	}

	/* (non-Javadoc)
	 * @see vista.permisos.control.IControlModificarPermiso#getIPermiso()
	 */
	@Override
	public IPermiso getIPermiso() {
		return control.getIPermiso();
	}

}
