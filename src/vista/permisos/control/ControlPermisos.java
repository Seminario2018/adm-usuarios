/**
 * 
 */
package vista.permisos.control;

import java.util.ArrayList;

import controlador.IControlador;
import modelo.permisos.IPermiso;

/**
 * @author Javier Elías Gómez Vicente
 *
 */
public class ControlPermisos implements IControlPermisos {
	
	private IControlador control;
	
	public ControlPermisos(IControlador control) {
		super();
		this.control = control;
	}
	
	/* (non-Javadoc)
	 * @see vista.permisos.control.IControlPermisos#buscarPermiso(modelo.permisos.IPermiso)
	 */
	@Override
	public ArrayList<IPermiso> buscarPermiso(IPermiso permiso) {
		return control.buscarPermiso(permiso);
	}

	/* (non-Javadoc)
	 * @see vista.permisos.control.IControlPermisos#eliminarPermiso(modelo.permisos.IPermiso)
	 */
	@Override
	public boolean eliminarPermiso(IPermiso permiso) {
		return control.eliminarPermiso(permiso);
	}

	/* (non-Javadoc)
	 * @see vista.permisos.control.IControlPermisos#getIPermiso()
	 */
	@Override
	public IPermiso getIPermiso() {
		return control.getIPermiso();
	}

}
