/**
 * 
 */
package vista.usuarios.control;

import controlador.IControlador;
import modelo.usuarios.IUsuario;

/**
 * @author Javier Elías Gómez Vicente
 *
 */
public class ControlModificarUsuario implements IControlModificarUsuario {

	IControlador control;
	
	/**
	 * @param control
	 */
	public ControlModificarUsuario(IControlador control) {
		super();
		this.control = control;
	}

	/* (non-Javadoc)
	 * @see vista.usuarios.control.IControlModificarUsuario#modificarUsuario(modelo.usuarios.IUsuario)
	 */
	@Override
	public boolean modificarUsuario(IUsuario usuario) {
		return control.modificarUsuario(usuario);
	}

	/* (non-Javadoc)
	 * @see vista.usuarios.control.IControlModificarUsuario#getIUsuario()
	 */
	@Override
	public IUsuario getIUsuario() {
		return control.getIUsuario();
	}

}
