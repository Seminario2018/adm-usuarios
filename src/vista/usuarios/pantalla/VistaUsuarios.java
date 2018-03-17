package vista.usuarios.pantalla;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import modelo.personas.IPersona;
import modelo.roles.Rol;
import modelo.usuarios.IUsuario;
import modelo.usuarios.Usuario;
import vista.usuarios.control.ControlUsuarios;
import vista.usuarios.control.IControlUsuarios;

import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 12 de mar. de 2018
 */
public class VistaUsuarios extends JFrame {
	
	private IControlUsuarios control = new ControlUsuarios();
	private ArrayList<IUsuario> usuarios = new ArrayList<IUsuario>();
	
	private JComboBox<String> cmbTipoDoc;
	private JComboBox<String> cmbEstado;
	private JTextField txtUsuario;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtNroDoc;
	private JTable table;
	private JTable header;
	private JButton btnModificar;
	private JButton btnEliminar; 
	private JButton btnRoles; 
	
	private void botonBuscar() {
		IUsuario u = control.getIUsuario();
		IPersona p = control.getIPersona();		
		
		p.setApellido(txtApellido.getText());
		p.setNombre(txtNombre.getText());
		p.setTipoDoc((String) cmbTipoDoc.getSelectedItem());
		p.setNroDoc(txtNroDoc.getText());
		
		u.setNombre(txtUsuario.getText());
		switch ((String) cmbEstado.getSelectedItem()) {
		case "Activo":
			u.setEstado(1);
			break;
		default:
			u.setEstado(0);
			break;
		}
		
		this.usuarios = control.buscarUsuario(u, p);
		/*
		ArrayList<Object[]> rolesU = new ArrayList<Object[]>();
		Object[] rolU = new Object[2];
		rolU[0] = new Rol("SUPER", "Super-Usuario", "Todo lo puede", 1, null);
		rolesU.add(rolU);
		this.usuarios.add(new Usuario("Pepita", "Coqueta", "pepita@gmail.com", "pepita10", 1, rolesU));
		this.usuarios.add(new Usuario("José", "El loco", "joseloko@hotmail.com", "josecito", 0, null));
		*/
		actualizarTabla();
	}
	
	private void actualizarTabla() {
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		table.revalidate();
		
		if (usuarios != null) {
			for (IUsuario u : this.usuarios) {
				String[] row = new String[4];
				row[0] = u.getNombre();
				row[1] = u.getEmail();
				row[2] = u.getDescripcion();
				switch (u.getEstado()) {
				case 1:
					row[3] = "Activo";
					break;
				default:
					row[3] = "Inactivo";
					break;
				}
				dtm.addRow(row);
			}
		}
	}
	
	private void botonAgregar() {
		VistaAgregarUsuario vistaAgregar = new VistaAgregarUsuario();
		vistaAgregar.setVisible(true);
	}
	
	private void botonModificar() {
		VistaModificarUsuario vistaModificar =
				new VistaModificarUsuario(usuarioSeleccionado());
		vistaModificar.setVisible(true);
	}
	
	private void botonEliminar() {
		if (control.eliminarUsuario(usuarioSeleccionado())) {
			this.usuarios.remove(usuarioSeleccionado());
			actualizarTabla();
		}
	}
	
	private void botonRoles() {
		VistaGestionarRoles vistaRoles =
				new VistaGestionarRoles(usuarioSeleccionado());
		vistaRoles.setVisible(true);
	}
	
	private IUsuario usuarioSeleccionado() {
		IUsuario u = null;
		int i = 0;
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		String nombre = (String) dtm.getValueAt(table.getSelectedRow(), 0);
		while (i < this.usuarios.size() && u == null) {
			if (this.usuarios.get(i).getNombre() == nombre)
				u = this.usuarios.get(i);
			i++;
		}
		return u;
	}
	
	private void habilitarBotones() {
        if (table.getSelectedRow() == -1) {
        	btnModificar.setEnabled(false);
        	btnEliminar.setEnabled(false);
        	btnRoles.setEnabled(false);
        } else {
        	btnModificar.setEnabled(true);
        	btnEliminar.setEnabled(true);
        	btnRoles.setEnabled(true);
        }
	}
	
	public VistaUsuarios() {
		setTitle("Administración de Usuarios");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel busqueda = new JPanel();
		getContentPane().add(busqueda, BorderLayout.NORTH);
		GridBagLayout gbl_busqueda = new GridBagLayout();
		gbl_busqueda.columnWidths = new int[]{39, 97, 25, 28, 0};
		gbl_busqueda.rowHeights = new int[]{20, 0, 23, 0, 0, 0};
		gbl_busqueda.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_busqueda.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		busqueda.setLayout(gbl_busqueda);
		
		JLabel lblUsuario = new JLabel("Usuario");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 0;
		busqueda.add(lblUsuario, gbc_lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 1;
		gbc_txtUsuario.gridy = 0;
		busqueda.add(txtUsuario, gbc_txtUsuario);
		
		JLabel lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 1;
		busqueda.add(lblEstado, gbc_lblEstado);
		
		cmbEstado = new JComboBox<String>();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
		cmbEstado.setSelectedIndex(0);
		GridBagConstraints gbc_cmbEstado = new GridBagConstraints();
		gbc_cmbEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbEstado.insets = new Insets(0, 0, 5, 5);
		gbc_cmbEstado.gridx = 1;
		gbc_cmbEstado.gridy = 1;
		busqueda.add(cmbEstado, gbc_cmbEstado);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 2;
		busqueda.add(lblApellido, gbc_lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridx = 1;
		gbc_txtApellido.gridy = 2;
		busqueda.add(txtApellido, gbc_txtApellido);
		
		JLabel lblTipoDoc = new JLabel("Tipo de Documento");
		GridBagConstraints gbc_lblTipoDoc = new GridBagConstraints();
		gbc_lblTipoDoc.anchor = GridBagConstraints.EAST;
		gbc_lblTipoDoc.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDoc.gridx = 2;
		gbc_lblTipoDoc.gridy = 2;
		busqueda.add(lblTipoDoc, gbc_lblTipoDoc);
		
		cmbTipoDoc = new JComboBox<String>();
		cmbTipoDoc.setModel(new DefaultComboBoxModel(new String[] {"DNI"}));
		cmbTipoDoc.setSelectedIndex(0);
		GridBagConstraints gbc_cmbTipoDoc = new GridBagConstraints();
		gbc_cmbTipoDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTipoDoc.insets = new Insets(0, 0, 5, 0);
		gbc_cmbTipoDoc.gridx = 3;
		gbc_cmbTipoDoc.gridy = 2;
		busqueda.add(cmbTipoDoc, gbc_cmbTipoDoc);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 3;
		busqueda.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 3;
		busqueda.add(txtNombre, gbc_txtNombre);
		
		JLabel lblNroDoc = new JLabel("N\u00FAmero de Documento");
		GridBagConstraints gbc_lblNroDoc = new GridBagConstraints();
		gbc_lblNroDoc.anchor = GridBagConstraints.EAST;
		gbc_lblNroDoc.insets = new Insets(0, 0, 5, 5);
		gbc_lblNroDoc.gridx = 2;
		gbc_lblNroDoc.gridy = 3;
		busqueda.add(lblNroDoc, gbc_lblNroDoc);
		
		txtNroDoc = new JTextField();
		txtNroDoc.setColumns(10);
		GridBagConstraints gbc_txtNroDoc = new GridBagConstraints();
		gbc_txtNroDoc.insets = new Insets(0, 0, 5, 0);
		gbc_txtNroDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNroDoc.gridx = 3;
		gbc_txtNroDoc.gridy = 3;
		busqueda.add(txtNroDoc, gbc_txtNroDoc);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonBuscar();
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.EAST;
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 4;
		busqueda.add(btnBuscar, gbc_btnBuscar);
		
		JPanel resultado = new JPanel();
		getContentPane().add(resultado, BorderLayout.CENTER);
		
		header = new JTable();
		header.setFont(new Font("Tahoma", Font.BOLD, 11));
		header.setBackground(Color.LIGHT_GRAY);
		header.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Usuario", "Email", "Descripcion", "Estado"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		DefaultTableModel dtm = (DefaultTableModel) header.getModel();
		String[] head = new String[4];
		head[0] = "Usuario";
		head[1] = "Email";
		head[2] = "Descripción";
		head[3] = "Estado";
		dtm.addRow(head);
		
		resultado.setLayout(new BorderLayout(0, 0));
		header.setFocusable(false);
		header.setRowSelectionAllowed(false);
		resultado.add(header, BorderLayout.NORTH);
		
		table = new JTable();
		resultado.add(table, BorderLayout.CENTER);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	habilitarBotones();
	        }
	    });
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Usuario", "Email", "Descripcion", "Estado"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setFillsViewportHeight(true);
		
		JPanel botones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) botones.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		getContentPane().add(botones, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		botones.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonAgregar();
			}
		});
		panel.add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonModificar();
			}
		});
		panel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonEliminar();
			}
		});
		btnEliminar.setEnabled(false);
		panel.add(btnEliminar);
		
		btnRoles = new JButton("Roles");
		btnRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonRoles();
			}
		});
		btnRoles.setEnabled(false);
		panel.add(btnRoles);
	}

}
