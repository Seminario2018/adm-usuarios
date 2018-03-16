package vista.usuarios.pantalla;

import javax.swing.JFrame;

import modelo.usuarios.IUsuario;
import vista.usuarios.control.IControlGestionarRoles;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 16 de mar. de 2018
 */
public class VistaGestionarRoles extends JFrame {
	
	private IControlGestionarRoles control;
	private IUsuario usuario;

	public VistaGestionarRoles(IUsuario usuario) {
		this.usuario = usuario;
		setTitle("Gestionar Roles de Usuario");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
