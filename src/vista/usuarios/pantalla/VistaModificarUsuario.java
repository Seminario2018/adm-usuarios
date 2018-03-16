package vista.usuarios.pantalla;

import javax.swing.JFrame;

import modelo.usuarios.IUsuario;
import vista.usuarios.control.ControlModificarUsuario;
import vista.usuarios.control.IControlModificarUsuario;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public class VistaModificarUsuario extends JFrame {

	private IControlModificarUsuario control = new ControlModificarUsuario();
	private IUsuario usuario;
	private JTextField txtUsuario;
	private JTextField txtPass;
	private JTextField txtEmail;
	private JTextField txtDescr;
	
	private void llenarCampos() {
		txtUsuario.setText(this.usuario.getNombre());;
		txtPass.setText(this.usuario.getPassword());
		txtEmail.setText(this.usuario.getEmail());
		txtDescr.setText(this.usuario.getDescripcion());
	}
	
	private void botonGuardar() {
		
		this.usuario.setNombre(txtUsuario.getText());
		this.usuario.setPassword(txtPass.getText());
		this.usuario.setEmail(txtEmail.getText());
		this.usuario.setDescripcion(txtDescr.getText());
		
		control.modificarUsuario(this.usuario);
	}

	public VistaModificarUsuario(IUsuario usuario) {
		this.usuario = usuario;
		setTitle("Modificar Usuario");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label_4 = new JLabel("Datos de Usuario:");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 0;
		panel.add(label_4, gbc_label_4);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel label = new JLabel("Usuario");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_1.add(label, gbc_label);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.gridx = 1;
		gbc_txtUsuario.gridy = 0;
		panel_1.add(txtUsuario, gbc_txtUsuario);
		
		JLabel label_1 = new JLabel("Contraseña");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 0;
		panel_1.add(label_1, gbc_label_1);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		GridBagConstraints gbc_txtPass = new GridBagConstraints();
		gbc_txtPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPass.insets = new Insets(0, 0, 5, 0);
		gbc_txtPass.gridx = 3;
		gbc_txtPass.gridy = 0;
		panel_1.add(txtPass, gbc_txtPass);
		
		JLabel label_2 = new JLabel("Email");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		panel_1.add(label_2, gbc_label_2);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.insets = new Insets(0, 0, 0, 5);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 1;
		panel_1.add(txtEmail, gbc_txtEmail);
		
		JLabel label_3 = new JLabel("Descripción");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 2;
		gbc_label_3.gridy = 1;
		panel_1.add(label_3, gbc_label_3);
		
		txtDescr = new JTextField();
		txtDescr.setColumns(10);
		GridBagConstraints gbc_txtDescr = new GridBagConstraints();
		gbc_txtDescr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescr.gridx = 3;
		gbc_txtDescr.gridy = 1;
		panel_1.add(txtDescr, gbc_txtDescr);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.EAST;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		panel.add(panel_2, gbc_panel_2);
		
		JButton btnGuardarCambios = new JButton("Guardar cambios");
		panel_2.add(btnGuardarCambios);
		
		llenarCampos();
	}
}
