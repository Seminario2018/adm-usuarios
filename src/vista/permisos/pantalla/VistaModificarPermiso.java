package vista.permisos.pantalla;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.permisos.IPermiso;

import vista.permisos.control.ControlModificarPermiso;
import vista.permisos.control.IControlModificarPermiso;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Javier Elías Gómez Vicente
 *
 */
public class VistaModificarPermiso extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -803399536077288994L;
	private IControlModificarPermiso control = new ControlModificarPermiso();
	private IPermiso permiso;
	private JTextField txtPermiso;
	private JTextField txtDescripcion;
	private JTextField txtFuncionalidad;
	
	private void llenarCampos() {
		txtPermiso.setText(this.permiso.getNombre());;
		txtDescripcion.setText(this.permiso.getDescripcion());
		txtFuncionalidad.setText(this.permiso.getFuncionalidad());
	}
	
	private void botonGuardar() {
		
		this.permiso.setNombre(txtPermiso.getText());
		this.permiso.setDescripcion(txtDescripcion.getText());
		this.permiso.setFuncionalidad(txtFuncionalidad.getText());
		
		control.modificarPermiso(this.permiso);
	}

	public VistaModificarPermiso(IPermiso permiso) {
		this.permiso = permiso;
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
		
		JLabel lblDatos = new JLabel("Datos del Permiso:");
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
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblPermiso = new JLabel("Permiso");
		GridBagConstraints gbc_lblPermiso = new GridBagConstraints();
		gbc_lblPermiso.insets = new Insets(0, 0, 5, 5);
		gbc_lblPermiso.gridx = 0;
		gbc_lblPermiso.gridy = 0;
		panel_1.add(lblPermiso, gbc_lblPermiso);
		
		txtPermiso = new JTextField();
		txtPermiso.setColumns(10);
		GridBagConstraints gbc_txtPermiso = new GridBagConstraints();
		gbc_txtPermiso.gridwidth = 3;
		gbc_txtPermiso.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPermiso.insets = new Insets(0, 0, 5, 0);
		gbc_txtPermiso.gridx = 1;
		gbc_txtPermiso.gridy = 0;
		panel_1.add(txtPermiso, gbc_txtPermiso);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 1;
		panel_1.add(lblDescripcion, gbc_lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.gridheight = 2;
		gbc_txtDescripcion.gridwidth = 3;
		gbc_txtDescripcion.fill = GridBagConstraints.BOTH;
		gbc_txtDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescripcion.gridx = 1;
		gbc_txtDescripcion.gridy = 1;
		panel_1.add(txtDescripcion, gbc_txtDescripcion);
		
		JLabel lblFuncionalidad = new JLabel("Funcionalidad");
		GridBagConstraints gbc_lblFuncionalidad = new GridBagConstraints();
		gbc_lblFuncionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblFuncionalidad.gridx = 0;
		gbc_lblFuncionalidad.gridy = 3;
		panel_1.add(lblFuncionalidad, gbc_lblFuncionalidad);
		
		txtFuncionalidad = new JTextField();
		txtFuncionalidad.setText((String) null);
		txtFuncionalidad.setColumns(10);
		GridBagConstraints gbc_textFuncionalidad = new GridBagConstraints();
		gbc_textFuncionalidad.gridheight = 2;
		gbc_textFuncionalidad.gridwidth = 3;
		gbc_textFuncionalidad.fill = GridBagConstraints.BOTH;
		gbc_textFuncionalidad.gridx = 1;
		gbc_textFuncionalidad.gridy = 3;
		panel_1.add(txtFuncionalidad, gbc_textFuncionalidad);
		
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
