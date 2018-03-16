package vista.usuarios.control;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.Controlador;
import controlador.IControlador;
import modelo.personas.IPersona;
import modelo.usuarios.IUsuario;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 15 de mar. de 2018
 */
public class ControlUsuarios implements IControlUsuarios {

	private IControlador control = new Controlador();
	/*
	public ControlUsuarios(IControlador control) {
		super();
		this.control = control;
	}
	*/

	/* (non-Javadoc)
	 * @see vista.usuarios.control.IControlUsuarios#buscarUsuario(modelo.IUsuario, modelo.IPersona)
	 */
	@Override
	public ArrayList<IUsuario> buscarUsuario(IUsuario usuario, IPersona persona) {
		return control.buscarUsuario(usuario, persona);
	}

	/* (non-Javadoc)
	 * @see vista.usuarios.control.IControlUsuarios#eliminarUsuario(modelo.IUsuario)
	 */
	@Override
	public boolean eliminarUsuario(IUsuario usuario) {
		if (control.eliminarUsuario(usuario)) {
			JOptionPane.showMessageDialog(null, "El usuario se eliminó con éxito");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Hubo un problema al eliminar al usuario");
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see vista.usuarios.control.IControlUsuarios#getIUsuario()
	 */
	@Override
	public IUsuario getIUsuario() {
		return control.getIUsuario();
	}

	/* (non-Javadoc)
	 * @see vista.usuarios.control.IControlUsuarios#getIPersona()
	 */
	@Override
	public IPersona getIPersona() {
		return control.getIPersona();
	}

}
