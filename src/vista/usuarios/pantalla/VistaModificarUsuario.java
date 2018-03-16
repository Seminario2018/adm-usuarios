package vista.usuarios.pantalla;

import javax.swing.JFrame;

import modelo.usuarios.IUsuario;
import vista.usuarios.control.IControlModificarUsuario;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public class VistaModificarUsuario extends JFrame {

	private IControlModificarUsuario control;
	private IUsuario usuario;

	public VistaModificarUsuario(IUsuario usuario) {
		this.usuario = usuario;
		setTitle("Modificar Usuario");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
