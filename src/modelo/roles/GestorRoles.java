package modelo.roles;

import java.util.ArrayList;
import java.util.Calendar;

import modelo.permisos.IPermiso;
import modelo.permisos.Permiso;
import persistencia.ManejoDatos;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 15 de mar. de 2018
 */
public class GestorRoles implements IGestorRoles {

	private ManejoDatos md = new ManejoDatos();
	
	/* (non-Javadoc)
	 * @see modelo.roles.IGestorRoles#agregarRol(modelo.roles.IRol)
	 */
	@Override
	public boolean agregarRol(IRol rol) {
		md.insertar("roles", "Nombre, Nombre_amigable, Descripcion, Estado", "'"
			+ rol.getNombre() +	"', '" + rol.getNombreAmigable() + "', '" + 
			rol.getDescripcion() + "', 1");
		return md.isEstado();
	}

	/* (non-Javadoc)
	 * @see modelo.roles.IGestorRoles#modificarRol(modelo.roles.IRol)
	 */
	@Override
	public boolean modificarRol(IRol rol) {
		md.update("roles", "Nombre_amigable = '" + rol.getNombreAmigable()
		+ "', Descripcion = " + rol.getDescripcion() + "', Estado = " + rol.getEstado(), "Nombre = " + rol.getNombre());
		return md.isEstado();
	}

	/* (non-Javadoc)
	 * @see modelo.roles.IGestorRoles#eliminarRol(modelo.roles.IRol)
	 */
	@Override
	public boolean eliminarRol(IRol rol) {
		md.update("roles", "Estado = " + 0, "Nombre = " + rol.getNombre());
		return md.isEstado();
	}

	/* (non-Javadoc)
	 * @see modelo.roles.IGestorRoles#buscarRoles(modelo.roles.IRol)
	 */
	@Override
	public ArrayList<IRol> buscarRoles(IRol rol) {
		ArrayList<String> condiciones = new ArrayList<String>();
		String condicion = "";
		if(rol.getEstado() == 1) {
			condicion = "Estado = 1";
		}else {
			condicion = "Estado = 0";
		}
		if (!rol.getNombreAmigable().equals("")) {
			condiciones.add("Nombre_amigable = '" + rol.getNombreAmigable() + "'");
		}
		if (!rol.getNombre().equals("")) {
			condiciones.add("Nombre = '" + rol.getNombre() + "'");
		}
		if (!rol.getDescripcion().equals("")) {
			condiciones.add("descripcion = '" + rol.getDescripcion() + "'");
		}
		for(String s : condiciones) {
			condicion += " AND " + s;
		}
		ArrayList<IRol> roles = new ArrayList<IRol>();
		ArrayList<String> per = md.select("roles", "Nombre, Nombre_amigable, Descripcion, Estado", condicion);
		for (String s: per) {
			String[] split = s.split(" -- ");
			roles.add(new Rol(split[0], split[1], split[2], Integer.parseInt(split[3]), null));
		}
		return roles;
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
		md.insertar("permisosderoles", "Rol, Permiso, fecha_de_asignacion, estado",
				"'" + rol.getNombre() + "', '" + permiso.getNombre()
				+ "', '" + Calendar.DATE + "/" + Calendar.MONTH + "/" + Calendar.YEAR + "', 1");
		return md.isEstado();
	}

	/* (non-Javadoc)
	 * @see modelo.roles.IGestorRoles#suprimirPermiso(modelo.roles.IRol, modelo.permisos.IPermiso)
	 */
	@Override
	public boolean suprimirPermiso(IRol rol, IPermiso permiso) {
		md.update("permisosderoles", "Estado = 0",
				"rol = '" + rol.getNombre() + "' and permiso = '" + permiso.getNombre() + "'");
		return md.isEstado();
	}

}
