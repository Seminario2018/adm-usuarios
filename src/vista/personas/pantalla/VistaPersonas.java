package vista.personas.pantalla;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modelo.personas.IPersona;
import modelo.personas.Persona;
import vista.personas.control.ControlPersonas;
import vista.personas.control.IControlPersonas;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 16 de mar. de 2018
 */
public class VistaPersonas extends JFrame {
	
	private IControlPersonas control = new ControlPersonas();
	private ArrayList<IPersona> personas = new ArrayList<IPersona>();
	
	private JComboBox<String> cmbEstado;
	private JComboBox<String> cmbTipoDoc;
	private JTextField txtDireccion;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtNroDoc;
	private JTextField txtTelefono;
	private JTextField txtCiudad;
	private JTable table;
	private JTable header;
	private JButton btnModificar;
	private JButton btnEliminar; 

	
	private void botonBuscar() {
		
		IPersona p = this.control.getIPersona();		
		
		p.setDireccion(txtDireccion.getText());
		p.setCiudad(txtCiudad.getText());
		p.setTelefono(txtTelefono.getText());
		p.setApellido(txtApellido.getText());
		p.setNombre(txtNombre.getText());
		p.setTipoDoc((String) cmbTipoDoc.getSelectedItem());
		p.setNroDoc(txtNroDoc.getText());
		
		switch ((String) cmbEstado.getSelectedItem()) {
		case "Activo":
			p.setEstado(1);
			break;
		default:
			p.setEstado(0);
			break;
		}
		
		this.personas = this.control.buscarPersona(p);
		/*
		IPersona p2 = new Persona("Pepita", "Gonzalez", "DNI", "12",
				"Luján", "Maraboto 823", "471762", 1, "2016-06-29", null);
		personas.add(p2);
		*/
		actualizarTabla();
	}
	
	private void botonAgregar() {
		VistaAgregarPersona vistaAgregar = new VistaAgregarPersona();
		vistaAgregar.setVisible(true);
	}
	
	private void botonModificar() {
		VistaModificarPersona vistaModificar = new VistaModificarPersona(personaSeleccionada());
		vistaModificar.setVisible(true);
	}
	
	private void botonEliminar() {
		if (control.eliminarPersona(personaSeleccionada())) {
			this.personas.remove(personaSeleccionada());
			actualizarTabla();
		}
	}
	
	private void actualizarTabla() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		table.revalidate();
		
		if (personas != null) {
			for (IPersona p : this.personas) {
				String[] row = new String[9];
				row[0] = p.getNombre();
				row[1] = p.getApellido();
				row[2] = p.getTipoDoc();
				row[3] = p.getNroDoc();
				row[4] = p.getCiudad();
				row[5] = p.getDireccion();
				row[6] = p.getTelefono();
				row[7] = p.getFechaNacimiento();
				
				switch (p.getEstado()) {
				case 1:	
					row[8] = "Activo";
					break;
				default:
					row[8] = "Inactivo";
					break;
				}
				
				dtm.addRow(row);
			}
		}
	}
	
	private void habilitarBotones() {
		if (table.getSelectedRow() == -1) {
			btnModificar.setEnabled(false);
        	btnEliminar.setEnabled(false);
        } else {
        	btnModificar.setEnabled(true);
        	btnEliminar.setEnabled(true);
        }
	}
	
	private IPersona personaSeleccionada() {
		IPersona p = null;
		int i = 0;
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		String nroDoc = (String) dtm.getValueAt(table.getSelectedRow(), 3);
		while (i < this.personas.size() && p == null) {
			if (this.personas.get(i).getNroDoc() == nroDoc)
				p = this.personas.get(i);
			i++;
		}
		return p;
	}
	
	public VistaPersonas() {
		setTitle("Administración de Personas");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel busqueda = new JPanel();
		getContentPane().add(busqueda, BorderLayout.NORTH);
		GridBagLayout gbl_busqueda = new GridBagLayout();
		gbl_busqueda.columnWidths = new int[]{39, 97, 25, 28, 0};
		gbl_busqueda.rowHeights = new int[]{20, 0, 23, 0, 0, 0};
		gbl_busqueda.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_busqueda.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		busqueda.setLayout(gbl_busqueda);
		
		JLabel lblDireccin = new JLabel("Dirección");
		GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
		gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccin.anchor = GridBagConstraints.EAST;
		gbc_lblDireccin.gridx = 0;
		gbc_lblDireccin.gridy = 0;
		busqueda.add(lblDireccin, gbc_lblDireccin);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		GridBagConstraints gbc_txtDireccion = new GridBagConstraints();
		gbc_txtDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDireccion.gridx = 1;
		gbc_txtDireccion.gridy = 0;
		busqueda.add(txtDireccion, gbc_txtDireccion);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
		gbc_lblCiudad.anchor = GridBagConstraints.EAST;
		gbc_lblCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudad.gridx = 2;
		gbc_lblCiudad.gridy = 0;
		busqueda.add(lblCiudad, gbc_lblCiudad);
		
		txtCiudad = new JTextField();
		GridBagConstraints gbc_txtCiudad = new GridBagConstraints();
		gbc_txtCiudad.insets = new Insets(0, 0, 5, 0);
		gbc_txtCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCiudad.gridx = 3;
		gbc_txtCiudad.gridy = 0;
		busqueda.add(txtCiudad, gbc_txtCiudad);
		txtCiudad.setColumns(10);
		
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
		
		JLabel lblTelfono = new JLabel("Teléfono");
		GridBagConstraints gbc_lblTelfono = new GridBagConstraints();
		gbc_lblTelfono.anchor = GridBagConstraints.EAST;
		gbc_lblTelfono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelfono.gridx = 2;
		gbc_lblTelfono.gridy = 1;
		busqueda.add(lblTelfono, gbc_lblTelfono);
		
		txtTelefono = new JTextField();
		GridBagConstraints gbc_txtTelefono = new GridBagConstraints();
		gbc_txtTelefono.insets = new Insets(0, 0, 5, 0);
		gbc_txtTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefono.gridx = 3;
		gbc_txtTelefono.gridy = 1;
		busqueda.add(txtTelefono, gbc_txtTelefono);
		txtTelefono.setColumns(10);
		
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
				"Nombre", "Apellido", "Tipo de Documento", "N\u00FAmero de Documento", "Ciudad", "Direcci\u00F3n", "Tel\u00E9fono", "Fecha de Nacimiento", "Estado"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		DefaultTableModel dtm = (DefaultTableModel) header.getModel();
		dtm.addRow(new String[] {
				"Nombre",
				"Apellido",
				"Tipo de Documento",
				"Número de Documento",
				"Ciudad", "Dirección",
				"Teléfono",
				"Fecha de Nacimiento",
				"Estado"
			});
		
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
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Nombre", "Apellido", "Tipo de Documento", "N\u00FAmero de Documento", "Ciudad", "Direcci\u00F3n", "Tel\u00E9fono", "Fecha de Nacimiento", "Estado"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
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
		
	}

}
