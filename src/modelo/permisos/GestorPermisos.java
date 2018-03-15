package modelo.permisos;

import java.util.ArrayList;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 15 de mar. de 2018
 */
public class GestorPermisos implements IGestorPermisos {

	/* (non-Javadoc)
	 * @see modelo.permisos.IGestorPermisos#agregarPermiso(modelo.permisos.IPermiso)
	 */
	@Override
	public boolean agregarPermiso(IPermiso permiso) {
		return false;
	}

	/* (non-Javadoc)
	 * @see modelo.permisos.IGestorPermisos#modificarPermiso(modelo.permisos.IPermiso)
	 */
	@Override
	public boolean modificarPermiso(IPermiso permiso) {
		return false;
	}

	/* (non-Javadoc)
	 * @see modelo.permisos.IGestorPermisos#eliminarPermiso(modelo.permisos.IPermiso)
	 */
	@Override
	public boolean eliminarPermiso(IPermiso permiso) {
		return false;
	}

	/* (non-Javadoc)
	 * @see modelo.permisos.IGestorPermisos#buscarPermiso(modelo.permisos.IPermiso)
	 */
	@Override
	public ArrayList<IPermiso> buscarPermiso(IPermiso permiso) {
		return null;
	}

	/* (non-Javadoc)
	 * @see modelo.permisos.IGestorPermisos#getIPermiso()
	 */
	@Override
	public IPermiso getIPermiso() {
		return new Permiso();
	}

}
