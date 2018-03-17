package modelo.permisos;

import java.util.ArrayList;

import persistencia.ManejoDatos;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 15 de mar. de 2018
 */
public class GestorPermisos implements IGestorPermisos {

	ManejoDatos md = new ManejoDatos();
	
	/* (non-Javadoc)
	 * @see modelo.permisos.IGestorPermisos#agregarPermiso(modelo.permisos.IPermiso)
	 */
	@Override
	public boolean agregarPermiso(IPermiso permiso) {
		md.insertar("permisos","Nombre, Funcionalidad, Estado, Descripcion", "'" + permiso.getNombre() + "', '" 
				+ permiso.getFuncionalidad()  + "', 0, '" + permiso.getDescripcion() + "'");
		return md.isEstado();
	}

	/* (non-Javadoc)
	 * @see modelo.permisos.IGestorPermisos#modificarPermiso(modelo.permisos.IPermiso)
	 */
	@Override
	public boolean modificarPermiso(IPermiso permiso) {
		md.update("permisos", "Funcionalidad = '" + permiso.getFuncionalidad() 
		+ ", Descripcion = '" + permiso.getDescripcion() + "' ", "Nombre = " + permiso.getNombre());
		return false;
	}

	/* (non-Javadoc)
	 * @see modelo.permisos.IGestorPermisos#eliminarPermiso(modelo.permisos.IPermiso)
	 */
	@Override
	public boolean eliminarPermiso(IPermiso permiso) {
		md.update("Permisos", "Estado = " + 0, "Nombre = " + permiso.getNombre());
		return md.isEstado();
	}

	/* (non-Javadoc)
	 * @see modelo.permisos.IGestorPermisos#buscarPermiso(modelo.permisos.IPermiso)
	 */
	@Override
	public ArrayList<IPermiso> buscarPermiso(IPermiso permiso) {
		ArrayList<IPermiso> permisos = new ArrayList();
		ArrayList<String> per = md.select("permisos", "*", "Estado = 1");
		for (String s: per) {
			String[] split = s.split(" ");
			permisos.add(new Permiso(split[0], split[1], split[2], Integer.parseInt(split[3])));
		}
		return permisos;
	}

	/* (non-Javadoc)
	 * @see modelo.permisos.IGestorPermisos#getIPermiso()
	 */
	@Override
	public IPermiso getIPermiso() {
		return new Permiso();
	}

}
