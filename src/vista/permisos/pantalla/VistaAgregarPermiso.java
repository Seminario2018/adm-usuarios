package vista.permisos.pantalla;

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
import modelo.permisos.IPermiso;
import vista.permisos.control.ControlAgregarPermiso;
import vista.permisos.control.IControlAgregarPermiso;

public class VistaAgregarPermiso extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlAgregarPermiso control = new ControlAgregarPermiso();
	private JTextField txtPermiso;
	private JTextField txtDescr;
	private JTextField txtFuncionalidad;
	private JButton btnAgregar;

	private void botonAgregar() {
		IPermiso p = control.getIPermiso();
		p.setNombre(txtPermiso.getText());
		p.setFuncionalidad(txtFuncionalidad.getText());
		p.setDescripcion(txtDescr.getText());
		control.agregarPermiso(p);
	}
	
	public VistaAgregarPermiso() {
		setTitle("Agregar Permiso");
		setBounds(100, 100, 450, 328);
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
		gbl_pnlDatosUsuario.rowHeights = new int[] {0, 0, 0, 0, 0};
		gbl_pnlDatosUsuario.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		gbl_pnlDatosUsuario.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		pnlDatosUsuario.setLayout(gbl_pnlDatosUsuario);
		
		JLabel lblPermiso = new JLabel("Permiso");
		GridBagConstraints gbc_lblPermiso = new GridBagConstraints();
		gbc_lblPermiso.insets = new Insets(0, 0, 5, 5);
		gbc_lblPermiso.gridx = 0;
		gbc_lblPermiso.gridy = 0;
		pnlDatosUsuario.add(lblPermiso, gbc_lblPermiso);
		
		txtPermiso = new JTextField();
		txtPermiso.setColumns(10);
		GridBagConstraints gbc_txtPermiso = new GridBagConstraints();
		gbc_txtPermiso.gridwidth = 3;
		gbc_txtPermiso.insets = new Insets(0, 0, 5, 0);
		gbc_txtPermiso.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPermiso.gridx = 1;
		gbc_txtPermiso.gridy = 0;
		pnlDatosUsuario.add(txtPermiso, gbc_txtPermiso);
		
		JLabel lblDescr = new JLabel("Descripción");
		GridBagConstraints gbc_lblDescr = new GridBagConstraints();
		gbc_lblDescr.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescr.gridx = 0;
		gbc_lblDescr.gridy = 1;
		pnlDatosUsuario.add(lblDescr, gbc_lblDescr);
		
		txtDescr = new JTextField();
		GridBagConstraints gbc_txtDescr = new GridBagConstraints();
		gbc_txtDescr.gridheight = 2;
		gbc_txtDescr.gridwidth = 3;
		gbc_txtDescr.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescr.fill = GridBagConstraints.BOTH;
		gbc_txtDescr.gridx = 1;
		gbc_txtDescr.gridy = 1;
		pnlDatosUsuario.add(txtDescr, gbc_txtDescr);
		txtDescr.setColumns(10);
		
		JLabel lblFuncionalidad = new JLabel("Funcionalidad");
		GridBagConstraints gbc_lblFuncionalidad = new GridBagConstraints();
		gbc_lblFuncionalidad.anchor = GridBagConstraints.EAST;
		gbc_lblFuncionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblFuncionalidad.gridx = 0;
		gbc_lblFuncionalidad.gridy = 3;
		pnlDatosUsuario.add(lblFuncionalidad, gbc_lblFuncionalidad);
		
		txtFuncionalidad = new JTextField();
		GridBagConstraints gbc_txtFuncionalidad = new GridBagConstraints();
		gbc_txtFuncionalidad.gridheight = 2;
		gbc_txtFuncionalidad.gridwidth = 3;
		gbc_txtFuncionalidad.fill = GridBagConstraints.BOTH;
		gbc_txtFuncionalidad.gridx = 1;
		gbc_txtFuncionalidad.gridy = 3;
		pnlDatosUsuario.add(txtFuncionalidad, gbc_txtFuncionalidad);
		txtFuncionalidad.setColumns(10);
		
		JPanel pnlBtnUsuario = new JPanel();
		GridBagConstraints gbc_pnlBtnUsuario = new GridBagConstraints();
		gbc_pnlBtnUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_pnlBtnUsuario.anchor = GridBagConstraints.EAST;
		gbc_pnlBtnUsuario.gridx = 0;
		gbc_pnlBtnUsuario.gridy = 2;
		pnlUsuarios.add(pnlBtnUsuario, gbc_pnlBtnUsuario);
		
		btnAgregar = new JButton("Agregar Permiso");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAgregar();
			}
		});
		pnlBtnUsuario.add(btnAgregar);
		
		JLabel lblDatosPermiso = new JLabel("Datos del Permiso:");
		GridBagConstraints gbc_lblDatosPermiso = new GridBagConstraints();
		gbc_lblDatosPermiso.gridx = 0;
		gbc_lblDatosPermiso.gridy = 0;
		pnlUsuarios.add(lblDatosPermiso, gbc_lblDatosPermiso);
	}


}
