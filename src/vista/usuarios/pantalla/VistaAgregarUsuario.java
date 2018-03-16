package vista.usuarios.pantalla;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import modelo.personas.IPersona;
import modelo.personas.Persona;
import modelo.usuarios.IUsuario;
import vista.personas.pantalla.VistaAgregarPersona;
import vista.usuarios.control.ControlAgregarUsuario;
import vista.usuarios.control.IControlAgregarUsuario;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public class VistaAgregarUsuario extends JFrame {
	private IControlAgregarUsuario control = new ControlAgregarUsuario();
	private ArrayList<IPersona> personas = new ArrayList<IPersona>();
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNroDoc;
	private JComboBox<String> cmbTipoDoc;
	private JTable table;
	private JTable header;
	private JTextField txtUsuario;
	private JTextField txtPass;
	private JTextField txtEmail;
	private JTextField txtDescr;
	private JButton btnAgregar;

	private void botonAgregar() {
		IUsuario u = control.getIUsuario();
		
		u.setNombre(txtUsuario.getText());
		u.setPassword(txtPass.getText());
		u.setEmail(txtEmail.getText());
		u.setDescripcion(txtDescr.getText());
		
		control.agregarUsuario(personaSeleccionada(), u);
	}
	
	private void botonNueva() {
		VistaAgregarPersona vistaNueva = new VistaAgregarPersona();
		vistaNueva.setVisible(true);
	}
	
	private void botonBuscar() {
		IPersona p = control.getIPersona();
		
		p.setApellido(txtApellido.getText());
		p.setNombre(txtNombre.getText());
		p.setNroDoc(txtNroDoc.getText());
		p.setTipoDoc((String) cmbTipoDoc.getSelectedItem());
		
		//this.personas = this.control.buscarPersona(p);
		
		this.personas.add(new Persona("Pepita", "Corazón", "DNI", "39586150", "Luján", "Maraboto 823", "01140", 1, "1996-06-29", null));
		this.personas.add(new Persona("José", "Suárez", "DNI", "40283120", "Luján", "Lamberti 862", "232350", 1, "1996-06-29", null));
		
		actualizarTabla();
	}
	
	private void actualizarTabla() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		table.revalidate();
		
		if (personas != null) {
			for (IPersona p : this.personas) {
				String[] row = new String[4];
				row[0] = p.getApellido();
				row[1] = p.getNombre();
				row[2] = p.getTipoDoc();
				row[3] = p.getNroDoc();
				dtm.addRow(row);
			}
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
	
	private void habilitarBotones() {
		 if (table.getSelectedRow() == -1) {
			 btnAgregar.setEnabled(false);
	     } else {
	    	 btnAgregar.setEnabled(true);
	     }
	}
	
	public VistaAgregarUsuario() {
		setTitle("Agregar Usuario");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panelPersonas = new JPanel();
		getContentPane().add(panelPersonas, BorderLayout.CENTER);
		GridBagLayout gbl_panelPersonas = new GridBagLayout();
		gbl_panelPersonas.columnWidths = new int[] {0};
		gbl_panelPersonas.rowHeights = new int[] {0, 0, 0};
		gbl_panelPersonas.columnWeights = new double[]{1.0};
		gbl_panelPersonas.rowWeights = new double[]{0.0, 0.0, 1.0};
		panelPersonas.setLayout(gbl_panelPersonas);
		
		JPanel pnlDatosPersonas = new JPanel();
		GridBagConstraints gbc_pnlDatosPersonas = new GridBagConstraints();
		gbc_pnlDatosPersonas.fill = GridBagConstraints.HORIZONTAL;
		gbc_pnlDatosPersonas.insets = new Insets(0, 0, 5, 0);
		gbc_pnlDatosPersonas.gridx = 0;
		gbc_pnlDatosPersonas.gridy = 0;
		panelPersonas.add(pnlDatosPersonas, gbc_pnlDatosPersonas);
		GridBagLayout gbl_pnlDatosPersonas = new GridBagLayout();
		gbl_pnlDatosPersonas.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlDatosPersonas.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlDatosPersonas.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		gbl_pnlDatosPersonas.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlDatosPersonas.setLayout(gbl_pnlDatosPersonas);
		
		JLabel lblDatosDeLa = new JLabel("Datos de la Persona:");
		GridBagConstraints gbc_lblDatosDeLa = new GridBagConstraints();
		gbc_lblDatosDeLa.gridwidth = 4;
		gbc_lblDatosDeLa.insets = new Insets(0, 0, 5, 0);
		gbc_lblDatosDeLa.gridx = 0;
		gbc_lblDatosDeLa.gridy = 0;
		pnlDatosPersonas.add(lblDatosDeLa, gbc_lblDatosDeLa);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 1;
		pnlDatosPersonas.add(lblApellido, gbc_lblApellido);
		
		txtApellido = new JTextField();
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridx = 1;
		gbc_txtApellido.gridy = 1;
		pnlDatosPersonas.add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblTipoDeDocumento = new JLabel("Tipo de Documento");
		GridBagConstraints gbc_lblTipoDeDocumento = new GridBagConstraints();
		gbc_lblTipoDeDocumento.anchor = GridBagConstraints.EAST;
		gbc_lblTipoDeDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDeDocumento.gridx = 2;
		gbc_lblTipoDeDocumento.gridy = 1;
		pnlDatosPersonas.add(lblTipoDeDocumento, gbc_lblTipoDeDocumento);
		
		cmbTipoDoc = new JComboBox();
		cmbTipoDoc.setModel(new DefaultComboBoxModel(new String[] {"DNI"}));
		cmbTipoDoc.setSelectedIndex(0);
		GridBagConstraints gbc_cmbTipoDoc = new GridBagConstraints();
		gbc_cmbTipoDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTipoDoc.insets = new Insets(0, 0, 5, 0);
		gbc_cmbTipoDoc.gridx = 3;
		gbc_cmbTipoDoc.gridy = 1;
		pnlDatosPersonas.add(cmbTipoDoc, gbc_cmbTipoDoc);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 0, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 2;
		pnlDatosPersonas.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 0, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 2;
		pnlDatosPersonas.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNmeroDeDocumento = new JLabel("Número de Documento");
		GridBagConstraints gbc_lblNmeroDeDocumento = new GridBagConstraints();
		gbc_lblNmeroDeDocumento.anchor = GridBagConstraints.EAST;
		gbc_lblNmeroDeDocumento.insets = new Insets(0, 0, 0, 5);
		gbc_lblNmeroDeDocumento.gridx = 2;
		gbc_lblNmeroDeDocumento.gridy = 2;
		pnlDatosPersonas.add(lblNmeroDeDocumento, gbc_lblNmeroDeDocumento);
		
		txtNroDoc = new JTextField();
		GridBagConstraints gbc_txtNrodoc = new GridBagConstraints();
		gbc_txtNrodoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNrodoc.gridx = 3;
		gbc_txtNrodoc.gridy = 2;
		pnlDatosPersonas.add(txtNroDoc, gbc_txtNrodoc);
		txtNroDoc.setColumns(10);
		
		JPanel panelBtnPersona = new JPanel();
		GridBagConstraints gbc_panelBtnPersona = new GridBagConstraints();
		gbc_panelBtnPersona.insets = new Insets(0, 0, 5, 0);
		gbc_panelBtnPersona.anchor = GridBagConstraints.EAST;
		gbc_panelBtnPersona.gridx = 0;
		gbc_panelBtnPersona.gridy = 1;
		panelPersonas.add(panelBtnPersona, gbc_panelBtnPersona);
		panelBtnPersona.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		panelBtnPersona.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNuevaPersona = new JButton("Nueva Persona...");
		btnNuevaPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonNueva();
			}
		});
		panel.add(btnNuevaPersona);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonBuscar();
			}
		});
		panel.add(btnBuscar);
		
		JPanel panelResultados = new JPanel();
		GridBagConstraints gbc_panelResultados = new GridBagConstraints();
		gbc_panelResultados.fill = GridBagConstraints.BOTH;
		gbc_panelResultados.insets = new Insets(0, 0, 5, 0);
		gbc_panelResultados.gridx = 0;
		gbc_panelResultados.gridy = 2;
		panelPersonas.add(panelResultados, gbc_panelResultados);
		panelResultados.setLayout(new BorderLayout(0, 0));
		
		header = new JTable();
		header.setFont(new Font("Tahoma", Font.BOLD, 11));
		header.setBackground(Color.LIGHT_GRAY);
		header.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Apellido", "Nombre", "Tipo de Documento", "Numero de Documento"
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
		head[0] = "Apellido";
		head[1] = "Nombre";
		head[2] = "Tipo de Documento";
		head[3] = "Número de Documento";
		dtm.addRow(head);
		header.setFocusable(false);
		header.setRowSelectionAllowed(false);
		panelResultados.add(header, BorderLayout.NORTH);
		
		table = new JTable();
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
				"Apellido", "Nombre", "Tipo de Documento", "Numero de Documento"
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
		panelResultados.add(table, BorderLayout.CENTER);
		
		JPanel pnlUsuarios = new JPanel();
		getContentPane().add(pnlUsuarios, BorderLayout.SOUTH);
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
		gbl_pnlDatosUsuario.rowHeights = new int[] {0, 0};
		gbl_pnlDatosUsuario.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		gbl_pnlDatosUsuario.rowWeights = new double[]{0.0, 0.0};
		pnlDatosUsuario.setLayout(gbl_pnlDatosUsuario);
		
		JLabel lblUsuario = new JLabel("Usuario");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 0;
		pnlDatosUsuario.add(lblUsuario, gbc_lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 1;
		gbc_txtUsuario.gridy = 0;
		pnlDatosUsuario.add(txtUsuario, gbc_txtUsuario);
		
		JLabel lblPass = new JLabel("Contraseña");
		GridBagConstraints gbc_lblPass = new GridBagConstraints();
		gbc_lblPass.insets = new Insets(0, 0, 5, 5);
		gbc_lblPass.gridx = 2;
		gbc_lblPass.gridy = 0;
		pnlDatosUsuario.add(lblPass, gbc_lblPass);
		
		txtPass = new JTextField();
		GridBagConstraints gbc_txtPass = new GridBagConstraints();
		gbc_txtPass.insets = new Insets(0, 0, 5, 0);
		gbc_txtPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPass.gridx = 3;
		gbc_txtPass.gridy = 0;
		pnlDatosUsuario.add(txtPass, gbc_txtPass);
		txtPass.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 0, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 1;
		pnlDatosUsuario.add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(0, 0, 0, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 1;
		pnlDatosUsuario.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 0, 5);
		gbc_lblDescripcin.gridx = 2;
		gbc_lblDescripcin.gridy = 1;
		pnlDatosUsuario.add(lblDescripcin, gbc_lblDescripcin);
		
		txtDescr = new JTextField();
		GridBagConstraints gbc_txtDescr = new GridBagConstraints();
		gbc_txtDescr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescr.gridx = 3;
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
		
		btnAgregar = new JButton("Agregar Usuario");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAgregar();
			}
		});
		btnAgregar.setEnabled(false);
		pnlBtnUsuario.add(btnAgregar);
		
		JLabel lblDatosUsuario = new JLabel("Datos de Usuario:");
		GridBagConstraints gbc_lblDatosUsuario = new GridBagConstraints();
		gbc_lblDatosUsuario.gridx = 0;
		gbc_lblDatosUsuario.gridy = 0;
		pnlUsuarios.add(lblDatosUsuario, gbc_lblDatosUsuario);
	}

}
