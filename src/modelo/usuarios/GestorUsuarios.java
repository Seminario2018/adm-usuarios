package modelo.usuarios;

import java.util.ArrayList;

import modelo.personas.IPersona;
import modelo.roles.IRol;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 15 de mar. de 2018
 */
public class GestorUsuarios implements IGestorUsuarios {

	/* (non-Javadoc)
	 * @see modelo.usuarios.IGestorUsuarios#agregarUsuario(modelo.personas.IPersona, modelo.usuarios.IUsuario)
	 */
	@Override
	public boolean agregarUsuario(IPersona persona, IUsuario usuario) {
		return false;
	}

	/* (non-Javadoc)
	 * @see modelo.usuarios.IGestorUsuarios#modificarUsuario(modelo.usuarios.IUsuario)
	 */
	@Override
	public boolean modificarUsuario(IUsuario usuario) {
		return false;
	}

	/* (non-Javadoc)
	 * @see modelo.usuarios.IGestorUsuarios#eliminarUsuario(modelo.usuarios.IUsuario)
	 */
	@Override
	public boolean eliminarUsuario(IUsuario usuario) {
		return false;
	}

	/* (non-Javadoc)
	 * @see modelo.usuarios.IGestorUsuarios#buscarUsuario(modelo.usuarios.IUsuario, modelo.personas.IPersona)
	 */
	@Override
	public ArrayList<IUsuario> buscarUsuario(IUsuario usuario, IPersona persona) {
		return null;
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
		return false;
	}

	/* (non-Javadoc)
	 * @see modelo.usuarios.IGestorUsuarios#suprimirRol(modelo.usuarios.IUsuario, modelo.roles.IRol)
	 */
	@Override
	public boolean suprimirRol(IUsuario usuario, IRol rol) {
		return false;
	}

}
