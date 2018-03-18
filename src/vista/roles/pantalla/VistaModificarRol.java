package vista.roles.pantalla;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.roles.IRol;
import modelo.usuarios.IUsuario;
import vista.roles.control.ControlModificarRol;
import vista.roles.control.IControlModificarRol;
import vista.usuarios.control.ControlModificarUsuario;
import vista.usuarios.control.IControlModificarUsuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaModificarRol extends JFrame {

	private IControlModificarRol control = new ControlModificarRol();
	private IRol rol;
	private JTextField txtRol;
	private JTextField txtNAmigable;
	private JTextField txtDescr;
	
	private void llenarCampos() {
		txtRol.setText(this.rol.getNombre());
		txtNAmigable.setText(this.rol.getNombreAmigable());
		txtDescr.setText(this.rol.getDescripcion());
	}
	
	protected void botonGuardar() {
		
		this.rol.setNombre(txtRol.getText());
		this.rol.setNombreAmigable(txtNAmigable.getText());
		this.rol.setDescripcion(txtDescr.getText());
		
		control.modificarRol(this.rol);
	}

	public VistaModificarRol(IRol rol) {
		this.rol = rol;
		setTitle("Modificar Rol");
		setBounds(100, 100, 450, 235);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblDatos = new JLabel("Datos de Rol:");
		GridBagConstraints gbc_lblDatos = new GridBagConstraints();
		gbc_lblDatos.insets = new Insets(0, 0, 5, 0);
		gbc_lblDatos.gridx = 0;
		gbc_lblDatos.gridy = 0;
		panel.add(lblDatos, gbc_lblDatos);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblRol = new JLabel("Rol");
		GridBagConstraints gbc_lblRol = new GridBagConstraints();
		gbc_lblRol.insets = new Insets(0, 0, 5, 5);
		gbc_lblRol.gridx = 0;
		gbc_lblRol.gridy = 0;
		panel_1.add(lblRol, gbc_lblRol);
		
		txtRol = new JTextField();
		txtRol.setColumns(10);
		GridBagConstraints gbc_txtRol = new GridBagConstraints();
		gbc_txtRol.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRol.insets = new Insets(0, 0, 5, 5);
		gbc_txtRol.gridx = 1;
		gbc_txtRol.gridy = 0;
		panel_1.add(txtRol, gbc_txtRol);
		
		JLabel lblNAmigable = new JLabel("Nombre amigable");
		GridBagConstraints gbc_lblNAmigable = new GridBagConstraints();
		gbc_lblNAmigable.insets = new Insets(0, 0, 5, 5);
		gbc_lblNAmigable.gridx = 2;
		gbc_lblNAmigable.gridy = 0;
		panel_1.add(lblNAmigable, gbc_lblNAmigable);
		
		txtNAmigable = new JTextField();
		txtNAmigable.setColumns(10);
		GridBagConstraints gbc_txtNAmigable = new GridBagConstraints();
		gbc_txtNAmigable.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNAmigable.insets = new Insets(0, 0, 5, 0);
		gbc_txtNAmigable.gridx = 3;
		gbc_txtNAmigable.gridy = 0;
		panel_1.add(txtNAmigable, gbc_txtNAmigable);
		
		JLabel label_3 = new JLabel("Descripción");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 1;
		panel_1.add(label_3, gbc_label_3);
		
		txtDescr = new JTextField();
		txtDescr.setColumns(10);
		GridBagConstraints gbc_txtDescr = new GridBagConstraints();
		gbc_txtDescr.gridheight = 3;
		gbc_txtDescr.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescr.gridwidth = 3;
		gbc_txtDescr.fill = GridBagConstraints.BOTH;
		gbc_txtDescr.gridx = 1;
		gbc_txtDescr.gridy = 1;
		panel_1.add(txtDescr, gbc_txtDescr);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.EAST;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		panel.add(panel_2, gbc_panel_2);
		
		JButton btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonGuardar();
			}
		});
		panel_2.add(btnGuardarCambios);
		
		llenarCampos();
		
	}
}
