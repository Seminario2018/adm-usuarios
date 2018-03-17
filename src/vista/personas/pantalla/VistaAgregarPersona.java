package vista.personas.pantalla;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.personas.Persona;
import vista.personas.control.ControlAgregarPersona;
import vista.personas.control.IControlAgregarPersona;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 16 de mar. de 2018
 */
public class VistaAgregarPersona extends JFrame {
	
	private IControlAgregarPersona control = new ControlAgregarPersona();
	
	private JComboBox<String> cmbTipoDoc;
	private JTextField txtDireccion;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtNroDoc;
	private JTextField txtTelefono;
	private JTextField txtCiudad;
	
	private void botonAgregar() {
		control.agregarPersona(new Persona("Pepita", "Gonzalez", "DNI", "12",
				"Luján", "Maraboto 823", "471762", 1, "2016-06-29", null));
	}
	
	public VistaAgregarPersona() {
		setTitle("Agregar Usuario");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel datos = new JPanel();
		getContentPane().add(datos, BorderLayout.CENTER);
		GridBagLayout gbl_datos = new GridBagLayout();
		gbl_datos.columnWidths = new int[]{39, 97, 25, 28, 0};
		gbl_datos.rowHeights = new int[]{20, 0, 23, 0, 0, 0};
		gbl_datos.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_datos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		datos.setLayout(gbl_datos);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		datos.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 0;
		datos.add(txtNombre, gbc_txtNombre);
		
		JLabel lblTipoDoc = new JLabel("Tipo de Documento");
		GridBagConstraints gbc_lblTipoDoc = new GridBagConstraints();
		gbc_lblTipoDoc.anchor = GridBagConstraints.EAST;
		gbc_lblTipoDoc.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDoc.gridx = 2;
		gbc_lblTipoDoc.gridy = 0;
		datos.add(lblTipoDoc, gbc_lblTipoDoc);
		
		cmbTipoDoc = new JComboBox<String>();
		cmbTipoDoc.setModel(new DefaultComboBoxModel(new String[] {"DNI"}));
		cmbTipoDoc.setSelectedIndex(0);
		GridBagConstraints gbc_cmbTipoDoc = new GridBagConstraints();
		gbc_cmbTipoDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTipoDoc.insets = new Insets(0, 0, 5, 0);
		gbc_cmbTipoDoc.gridx = 3;
		gbc_cmbTipoDoc.gridy = 0;
		datos.add(cmbTipoDoc, gbc_cmbTipoDoc);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 1;
		datos.add(lblApellido, gbc_lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridx = 1;
		gbc_txtApellido.gridy = 1;
		datos.add(txtApellido, gbc_txtApellido);
		
		JLabel lblNroDoc = new JLabel("N\u00FAmero de Documento");
		GridBagConstraints gbc_lblNroDoc = new GridBagConstraints();
		gbc_lblNroDoc.anchor = GridBagConstraints.EAST;
		gbc_lblNroDoc.insets = new Insets(0, 0, 5, 5);
		gbc_lblNroDoc.gridx = 2;
		gbc_lblNroDoc.gridy = 1;
		datos.add(lblNroDoc, gbc_lblNroDoc);
		
		txtNroDoc = new JTextField();
		txtNroDoc.setColumns(10);
		GridBagConstraints gbc_txtNroDoc = new GridBagConstraints();
		gbc_txtNroDoc.insets = new Insets(0, 0, 5, 0);
		gbc_txtNroDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNroDoc.gridx = 3;
		gbc_txtNroDoc.gridy = 1;
		datos.add(txtNroDoc, gbc_txtNroDoc);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
		gbc_lblCiudad.anchor = GridBagConstraints.EAST;
		gbc_lblCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudad.gridx = 0;
		gbc_lblCiudad.gridy = 2;
		datos.add(lblCiudad, gbc_lblCiudad);
		
		txtCiudad = new JTextField();
		GridBagConstraints gbc_txtCiudad = new GridBagConstraints();
		gbc_txtCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_txtCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCiudad.gridx = 1;
		gbc_txtCiudad.gridy = 2;
		datos.add(txtCiudad, gbc_txtCiudad);
		txtCiudad.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Dirección");
		GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
		gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccin.anchor = GridBagConstraints.EAST;
		gbc_lblDireccin.gridx = 2;
		gbc_lblDireccin.gridy = 2;
		datos.add(lblDireccin, gbc_lblDireccin);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		GridBagConstraints gbc_txtDireccion = new GridBagConstraints();
		gbc_txtDireccion.insets = new Insets(0, 0, 5, 0);
		gbc_txtDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDireccion.gridx = 3;
		gbc_txtDireccion.gridy = 2;
		datos.add(txtDireccion, gbc_txtDireccion);
		
		JLabel lblTelfono = new JLabel("Teléfono");
		GridBagConstraints gbc_lblTelfono = new GridBagConstraints();
		gbc_lblTelfono.anchor = GridBagConstraints.EAST;
		gbc_lblTelfono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelfono.gridx = 0;
		gbc_lblTelfono.gridy = 3;
		datos.add(lblTelfono, gbc_lblTelfono);
		
		txtTelefono = new JTextField();
		GridBagConstraints gbc_txtTelefono = new GridBagConstraints();
		gbc_txtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefono.gridx = 1;
		gbc_txtTelefono.gridy = 3;
		datos.add(txtTelefono, gbc_txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
		gbc_lblFechaDeNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeNacimiento.gridx = 2;
		gbc_lblFechaDeNacimiento.gridy = 3;
		datos.add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 3;
		datos.add(panel, gbc_panel);
		
		JComboBox cmbYear = new JComboBox();
		String[] years = new String[100];
		for (int i = 0; i < 100; i++) {
			years[i] = Integer.toString(i + 1918);
		}
		cmbYear.setModel(new DefaultComboBoxModel(years));
		cmbYear.setSelectedIndex(0);
		panel.add(cmbYear);
		
		JLabel label = new JLabel("/");
		panel.add(label);
		
		JComboBox cmbMon = new JComboBox();
		String[] months = new String[12];
		for (int i = 0; i < 12; i++) {
			months[i] = Integer.toString(i+1);
		}
		cmbMon.setModel(new DefaultComboBoxModel(months));
		cmbMon.setSelectedIndex(0);
		panel.add(cmbMon);
		
		JLabel label_1 = new JLabel("/");
		panel.add(label_1);
		
		JComboBox cmbDay = new JComboBox();
		String[] days = new String[31];
		for (int i = 0; i < 31; i++) {
			days[i] = Integer.toString(i+1);
		}
		cmbMon.setModel(new DefaultComboBoxModel(days));
		cmbDay.setSelectedIndex(0);
		panel.add(cmbDay);
		
		JPanel panelBoton = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBoton.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		getContentPane().add(panelBoton, BorderLayout.SOUTH);
		
		JButton btnAgregar = new JButton("Agregar Persona");
		panelBoton.add(btnAgregar);
		
		JLabel lblIngrese = new JLabel("Datos de la Persona:");
		lblIngrese.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblIngrese, BorderLayout.NORTH);
	}

}
