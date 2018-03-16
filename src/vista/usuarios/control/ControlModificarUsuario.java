/**
 * 
 */
package vista.usuarios.control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import controlador.Controlador;
import controlador.IControlador;
import modelo.usuarios.IUsuario;

/**
 * @author Javier El�as G�mez Vicente
 *
 */
public class ControlModificarUsuario implements IControlModificarUsuario {

	private IControlador control = new Controlador();
	
	/*
	public ControlModificarUsuario(IControlador control) {
		super();
		this.control = control;
	}
	*/

	/* (non-Javadoc)
	 * @see vista.usuarios.control.IControlModificarUsuario#modificarUsuario(modelo.usuarios.IUsuario)
	 */
	@Override
	public boolean modificarUsuario(IUsuario usuario) {
		String error = "No se pudo modificar el usuario por las siguientes razones:\n";
		boolean hubo_error = false;
		if (usuario.getNombre().compareTo("") == 0) {
		    hubo_error = true;
			error += "- Debe ingresar el nombre\n";
		}
		if (esEmailValido(usuario.getEmail())) {
		    hubo_error = true;
			error += "- El email no es válido\n";
		}
		if (usuario.getPassword().compareTo("") == 0) {
		    hubo_error = true;
			error += "- Debe ingresar la contraseña\n";
		}
		
		if (hubo_error) {
			JOptionPane.showMessageDialog(null, error);
			return false;
		} else {
			if (control.modificarUsuario(usuario)) {
				JOptionPane.showMessageDialog(null, "El usuario se modificó con éxito");
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Hubo un problema al agregar al usuario");
				return false;
			}
		}
	};
	
	private boolean esEmailValido(String email) {
	    // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
	}

	/* (non-Javadoc)
	 * @see vista.usuarios.control.IControlModificarUsuario#getIUsuario()
	 */
	@Override
	public IUsuario getIUsuario() {
		return control.getIUsuario();
	}

}
