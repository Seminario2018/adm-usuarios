/**
 * 
 */
package usuarios.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTable;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 12 de mar. de 2018
 */
public class VentanaUsuarios extends JPanel {
	private JTextField txtUsuario;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtNroDoc;
	private JTable table;
	public VentanaUsuarios() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel busqueda = new JPanel();
		add(busqueda, BorderLayout.NORTH);
		GridBagLayout gbl_busqueda = new GridBagLayout();
		gbl_busqueda.columnWidths = new int[]{39, 97, 25, 28, 0};
		gbl_busqueda.rowHeights = new int[]{20, 20, 0, 23, 0, 0, 0};
		gbl_busqueda.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_busqueda.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		busqueda.setLayout(gbl_busqueda);
		
		JLabel lblAdm = new JLabel("Administraci\u00F3n de usuarios");
		GridBagConstraints gbc_lblAdm = new GridBagConstraints();
		gbc_lblAdm.insets = new Insets(0, 0, 5, 0);
		gbc_lblAdm.gridx = 3;
		gbc_lblAdm.gridy = 0;
		busqueda.add(lblAdm, gbc_lblAdm);
		
		JLabel lblUsuario = new JLabel("Usuario");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 1;
		busqueda.add(lblUsuario, gbc_lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 1;
		gbc_txtUsuario.gridy = 1;
		busqueda.add(txtUsuario, gbc_txtUsuario);
		
		JLabel lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 2;
		busqueda.add(lblEstado, gbc_lblEstado);
		
		JComboBox cmbEstado = new JComboBox();
		GridBagConstraints gbc_cmbEstado = new GridBagConstraints();
		gbc_cmbEstado.anchor = GridBagConstraints.WEST;
		gbc_cmbEstado.insets = new Insets(0, 0, 5, 5);
		gbc_cmbEstado.gridx = 1;
		gbc_cmbEstado.gridy = 2;
		busqueda.add(cmbEstado, gbc_cmbEstado);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 3;
		busqueda.add(lblApellido, gbc_lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridx = 1;
		gbc_txtApellido.gridy = 3;
		busqueda.add(txtApellido, gbc_txtApellido);
		
		JLabel lblTipoDoc = new JLabel("Tipo de Documento");
		GridBagConstraints gbc_lblTipoDoc = new GridBagConstraints();
		gbc_lblTipoDoc.anchor = GridBagConstraints.EAST;
		gbc_lblTipoDoc.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDoc.gridx = 2;
		gbc_lblTipoDoc.gridy = 3;
		busqueda.add(lblTipoDoc, gbc_lblTipoDoc);
		
		JComboBox cmbTipoDoc = new JComboBox();
		GridBagConstraints gbc_cmbTipoDoc = new GridBagConstraints();
		gbc_cmbTipoDoc.anchor = GridBagConstraints.WEST;
		gbc_cmbTipoDoc.insets = new Insets(0, 0, 5, 0);
		gbc_cmbTipoDoc.gridx = 3;
		gbc_cmbTipoDoc.gridy = 3;
		busqueda.add(cmbTipoDoc, gbc_cmbTipoDoc);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 4;
		busqueda.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 4;
		busqueda.add(txtNombre, gbc_txtNombre);
		
		JLabel lblNroDoc = new JLabel("N\u00FAmero de Documento");
		GridBagConstraints gbc_lblNroDoc = new GridBagConstraints();
		gbc_lblNroDoc.anchor = GridBagConstraints.EAST;
		gbc_lblNroDoc.insets = new Insets(0, 0, 5, 5);
		gbc_lblNroDoc.gridx = 2;
		gbc_lblNroDoc.gridy = 4;
		busqueda.add(lblNroDoc, gbc_lblNroDoc);
		
		txtNroDoc = new JTextField();
		txtNroDoc.setColumns(10);
		GridBagConstraints gbc_txtNroDoc = new GridBagConstraints();
		gbc_txtNroDoc.insets = new Insets(0, 0, 5, 0);
		gbc_txtNroDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNroDoc.gridx = 3;
		gbc_txtNroDoc.gridy = 4;
		busqueda.add(txtNroDoc, gbc_txtNroDoc);
		
		JButton btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.EAST;
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 5;
		busqueda.add(btnBuscar, gbc_btnBuscar);
		
		JPanel resultado = new JPanel();
		add(resultado, BorderLayout.CENTER);
		resultado.setLayout(new GridLayout(1, 0, 0, 0));
		
		table = new JTable();
		resultado.add(table);
		
		JPanel botones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) botones.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		add(botones, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		botones.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnAgregar = new JButton("Agregar");
		panel.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		panel.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		panel.add(btnEliminar);
		
		JButton btnRoles = new JButton("Roles");
		panel.add(btnRoles);
	}

}
