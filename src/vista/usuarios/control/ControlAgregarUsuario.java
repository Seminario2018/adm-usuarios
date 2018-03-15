package vista.usuarios.control;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.IControlador;
import modelo.personas.IPersona;
import modelo.usuarios.IUsuario;
import vista.usuarios.pantalla.VistaAgregarUsuario;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 15 de mar. de 2018
 */
public class ControlAgregarUsuario implements IControlAgregarUsuario {

	private IControlador control;
	private VistaAgregarUsuario vista;
	
	public ControlAgregarUsuario(IControlador control, VistaAgregarUsuario vista) {
		super();
		this.control = control;
		this.vista = vista;
	}

	/* (non-Javadoc)
	 * @see vista.usuarios.control.IControlAgregarUsuario#agregarUsuario(modelo.IPersona, modelo.IUsuario)
	 */
	@Override
	public boolean agregarUsuario(IPersona persona, IUsuario usuario) {
		String error = "No se pudo agregar al usuario por las siguientes razones:\n";
		boolean b = true;
		if (usuario.getNombre() == null) {
			b = false;
			error += "- Debe ingresar el nombre\n";
		}
		if (usuario.getEmail() == null) {
			b = false;
			error += "- Debe ingresar el email\n";
		}
		if (usuario.getPassword() == null) {
			b = false;
			error += "- Debe ingresar la contraseña\n";
		}
		
		if (!b) {
			JOptionPane.showMessageDialog(null, error);
			return false;
		} else {
			if (control.agregarUsuario(persona, usuario)) {
				JOptionPane.showMessageDialog(null, "El usuario se agregó con éxito");
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Hubo un problema al agregar al usuario");
				return false;
			}
		}
	}

	/* (non-Javadoc)
	 * @see vista.usuarios.control.IControlAgregarUsuario#buscarPersona(modelo.IPersona)
	 */
	@Override
	public ArrayList<IPersona> buscarPersona(IPersona persona) {
		return control.buscarPersona(persona);
	}

	/* (non-Javadoc)
	 * @see vista.usuarios.control.IControlAgregarUsuario#getIUsuario()
	 */
	@Override
	public IUsuario getIUsuario() {
		return control.getIUsuario();
	}

	/* (non-Javadoc)
	 * @see vista.usuarios.control.IControlAgregarUsuario#getIPersona()
	 */
	@Override
	public IPersona getIPersona() {
		return control.getIPersona();
	}

}
