package modelo.usuarios;

import java.util.ArrayList;
import java.util.Calendar;

import modelo.personas.IPersona;
import modelo.roles.IRol;
import modelo.roles.Rol;
import persistencia.ManejoDatos;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 15 de mar. de 2018
 */
public class GestorUsuarios implements IGestorUsuarios {
	
	ManejoDatos md = new ManejoDatos();

	/* (non-Javadoc)
	 * @see modelo.usuarios.IGestorUsuarios#agregarUsuario(modelo.personas.IPersona, modelo.usuarios.IUsuario)
	 */
	@Override
	public boolean agregarUsuario(IPersona persona, IUsuario usuario) {
		md.insertar("usuarios", "Nombre, Descripcion, Email, password, Estado, persona",
				"'" + usuario.getNombre() + "', '" + usuario.getDescripcion() + "', '" + usuario.getEmail() + "', '" 
				+ usuario.getPassword() + "'," + usuario.getEstado() + ", '" + persona.getNroDoc());
		return md.isEstado();
	}

	/* (non-Javadoc)
	 * @see modelo.usuarios.IGestorUsuarios#modificarUsuario(modelo.usuarios.IUsuario)
	 */
	@Override
	public boolean modificarUsuario(IUsuario usuario) {
		md.update("usuarios", "Descripcion = '" + usuario.getDescripcion()
			+ "', Email = '" + usuario.getEmail() + "', Password = '" + usuario.getPassword() + "'",
			"nombre = '" + usuario.getNombre() + "'");
		return md.isEstado();
	}

	/* (non-Javadoc)
	 * @see modelo.usuarios.IGestorUsuarios#eliminarUsuario(modelo.usuarios.IUsuario)
	 */
	@Override
	public boolean eliminarUsuario(IUsuario usuario) {
		md.update("usuarios", "Estado = 0", "nombre = '" + usuario.getNombre() + "'");
		return md.isEstado();
	}

	/* (non-Javadoc)
	 * @see modelo.usuarios.IGestorUsuarios#buscarUsuario(modelo.usuarios.IUsuario, modelo.personas.IPersona)
	 */
	@Override
	public ArrayList<IUsuario> buscarUsuario(IUsuario usuario, IPersona persona) {
		ArrayList<IUsuario> usuarios = new ArrayList<IUsuario>();
		ArrayList<String> per = md.select("roles", "*", "Estado = 1");
		for (String s: per) {
			String[] split = s.split(" ");
			usuarios.add(new Usuario(split[0], split[1], split[2], split[3], Integer.parseInt(split[4]), null));
		}
		return usuarios;
	}

	/* (non-Javadoc)
	 * @see modelo.usuarios.IGestorUsuarios#getIUsuario()
	 */
	@Override
	public IUsuario getIUsuario() {
		return new Usuario();
	}

	/* (non-Javadoc)
	 * @see modelo.usuarios.IGestorUsuarios#asignarRol(modelo.usuarios.IUsuario, modelo.roles.IRol)
	 */
	@Override
	public boolean asignarRol(IUsuario usuario, IRol rol) {
		md.insertar("rolesporusuario", "usuario, rol, fecha_de_asignacion, estado",
				"'" + usuario.getNombre() + "', '" + rol.getNombre()
				+ "', '" + Calendar.DATE + "/" + Calendar.MONTH + "/" + Calendar.YEAR + "', 1");
		return md.isEstado();
	}

	/* (non-Javadoc)
	 * @see modelo.usuarios.IGestorUsuarios#suprimirRol(modelo.usuarios.IUsuario, modelo.roles.IRol)
	 */
	@Override
	public boolean suprimirRol(IUsuario usuario, IRol rol) {
		md.update("rolesporusuario", "Estado = 0",
				"rol = '" + rol.getNombre() + "' and usuario = '" + usuario.getNombre() + "'");
		return md.isEstado();
	}

}
