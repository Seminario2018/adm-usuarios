package vista.roles.pantalla;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import modelo.roles.IRol;
import vista.roles.control.ControlAgregarRol;
import vista.roles.control.IControlAgregarRol;


/**
 * @author Javier Elías Gómez Vicente
 *
 */
public class VistaAgregarRol extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlAgregarRol control = new ControlAgregarRol();
	private JTextField txtRol;
	private JTextField txtNAmigable;
	private JTextField txtDescr;
	private JButton btnAgregar;

	private void botonAgregar() {
		IRol r = control.getIRol();
		
		r.setNombre(txtRol.getText());
		r.setNombreAmigable(txtNAmigable.getText());
		r.setDescripcion(txtDescr.getText());
		
		control.agregarRol(r);
	}
	
	public VistaAgregarRol() {
		setTitle("Agregar Rol");
		setBounds(100, 100, 450, 226);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel pnlUsuarios = new JPanel();
		getContentPane().add(pnlUsuarios, BorderLayout.CENTER);
		GridBagLayout gbl_pnlUsuarios = new GridBagLayout();
		gbl_pnlUsuarios.columnWidths = new int[] {0};
		gbl_pnlUsuarios.rowHeights = new int[] {0, 0, 0};
		gbl_pnlUsuarios.columnWeights = new double[]{1.0};
		gbl_pnlUsuarios.rowWeights = new double[]{0.0, 0.0, 0.0};
		pnlUsuarios.setLayout(gbl_pnlUsuarios);
		
		JPanel pnlDatosUsuario = new JPanel();
		GridBagConstraints gbc_pnlDatosUsuario = new GridBagConstraints();
		gbc_pnlDatosUsuario.fill = GridBagConstraints.BOTH;
		gbc_pnlDatosUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_pnlDatosUsuario.gridx = 0;
		gbc_pnlDatosUsuario.gridy = 1;
		pnlUsuarios.add(pnlDatosUsuario, gbc_pnlDatosUsuario);
		GridBagLayout gbl_pnlDatosUsuario = new GridBagLayout();
		gbl_pnlDatosUsuario.columnWidths = new int[] {0, 0, 0, 0};
		gbl_pnlDatosUsuario.rowHeights = new int[] {0, 0, 0, 0};
		gbl_pnlDatosUsuario.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		gbl_pnlDatosUsuario.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		pnlDatosUsuario.setLayout(gbl_pnlDatosUsuario);
		
		JLabel lblRol = new JLabel("Rol");
		GridBagConstraints gbc_lblRol = new GridBagConstraints();
		gbc_lblRol.insets = new Insets(0, 0, 5, 5);
		gbc_lblRol.gridx = 0;
		gbc_lblRol.gridy = 0;
		pnlDatosUsuario.add(lblRol, gbc_lblRol);
		
		txtRol = new JTextField();
		txtRol.setColumns(10);
		GridBagConstraints gbc_txtRol = new GridBagConstraints();
		gbc_txtRol.insets = new Insets(0, 0, 5, 5);
		gbc_txtRol.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRol.gridx = 1;
		gbc_txtRol.gridy = 0;
		pnlDatosUsuario.add(txtRol, gbc_txtRol);
		
		JLabel lblNAmigable = new JLabel("Nombre amigable");
		GridBagConstraints gbc_lblNAmigable = new GridBagConstraints();
		gbc_lblNAmigable.insets = new Insets(0, 0, 5, 5);
		gbc_lblNAmigable.gridx = 2;
		gbc_lblNAmigable.gridy = 0;
		pnlDatosUsuario.add(lblNAmigable, gbc_lblNAmigable);
		
		txtNAmigable = new JTextField();
		GridBagConstraints gbc_txtNAmigable = new GridBagConstraints();
		gbc_txtNAmigable.insets = new Insets(0, 0, 5, 0);
		gbc_txtNAmigable.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNAmigable.gridx = 3;
		gbc_txtNAmigable.gridy = 0;
		pnlDatosUsuario.add(txtNAmigable, gbc_txtNAmigable);
		txtNAmigable.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 0;
		gbc_lblDescripcin.gridy = 1;
		pnlDatosUsuario.add(lblDescripcin, gbc_lblDescripcin);
		
		txtDescr = new JTextField();
		GridBagConstraints gbc_txtDescr = new GridBagConstraints();
		gbc_txtDescr.gridheight = 3;
		gbc_txtDescr.gridwidth = 3;
		gbc_txtDescr.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescr.fill = GridBagConstraints.BOTH;
		gbc_txtDescr.gridx = 1;
		gbc_txtDescr.gridy = 1;
		pnlDatosUsuario.add(txtDescr, gbc_txtDescr);
		txtDescr.setColumns(10);
		
		JPanel pnlBtnUsuario = new JPanel();
		GridBagConstraints gbc_pnlBtnUsuario = new GridBagConstraints();
		gbc_pnlBtnUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_pnlBtnUsuario.anchor = GridBagConstraints.EAST;
		gbc_pnlBtnUsuario.gridx = 0;
		gbc_pnlBtnUsuario.gridy = 2;
		pnlUsuarios.add(pnlBtnUsuario, gbc_pnlBtnUsuario);
		
		btnAgregar = new JButton("Agregar Rol");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAgregar();
			}
		});
		btnAgregar.setEnabled(false);
		pnlBtnUsuario.add(btnAgregar);
		
		JLabel lblDatosRol = new JLabel("Datos de Rol:");
		GridBagConstraints gbc_lblDatosRol = new GridBagConstraints();
		gbc_lblDatosRol.gridx = 0;
		gbc_lblDatosRol.gridy = 0;
		pnlUsuarios.add(lblDatosRol, gbc_lblDatosRol);
	}


}
