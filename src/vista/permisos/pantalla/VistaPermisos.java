package vista.permisos.pantalla;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modelo.permisos.IPermiso;
import modelo.permisos.Permiso;
import modelo.personas.IPersona;
import modelo.roles.Rol;
import modelo.usuarios.IUsuario;
import modelo.usuarios.Usuario;
import vista.permisos.control.ControlPermisos;
import vista.permisos.control.IControlPermisos;
import vista.usuarios.control.ControlUsuarios;
import vista.usuarios.control.IControlUsuarios;
import vista.usuarios.pantalla.VistaAgregarUsuario;
import vista.usuarios.pantalla.VistaGestionarRoles;
import vista.usuarios.pantalla.VistaModificarUsuario;

/**
 * @author Javier Elías Gómez Vicente
 *
 */
public class VistaPermisos extends JFrame {

	private IControlPermisos control = new ControlPermisos();
	private ArrayList<IPermiso> permisos = new ArrayList<IPermiso>();
	private JComboBox<String> cmbEstado;
	private JTextField txtPermiso;
	private JTextField txtDescripcion;
	private JTextField txtFuncionalidad;
	private JTable table;
	private JTable header;
	private JButton btnModificar;
	private JButton btnEliminar; 
	
	private void botonBuscar() {
		IPermiso p = control.getIPermiso();	
		
		p.setNombre(txtPermiso.getText());
		p.setFuncionalidad(txtFuncionalidad.getText());
		p.setDescripcion(txtDescripcion.getText());
		switch ((String) cmbEstado.getSelectedItem()) {
		case "Activo":
			p.setEstado(1);
			break;
		default:
			p.setEstado(0);
			break;
		}
		
		permisos = this.control.buscarPermiso(p);
		
		habilitarBotones();
		
		actualizarTabla();
	}
	
	private void actualizarTabla() {
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		table.revalidate();
		
		if (permisos != null) {
			for (IPermiso p : this.permisos) {
				String[] row = new String[4];
				row[0] = p.getNombre();
				row[1] = p.getDescripcion();
				row[2] = p.getFuncionalidad();
				switch (p.getEstado()) {
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
		VistaAgregarPermiso vistaAgregar = new VistaAgregarPermiso();
		vistaAgregar.setVisible(true);
	}
	
	private void botonModificar() {
		VistaModificarPermiso vistaModificar =
				new VistaModificarPermiso(permisoSeleccionado());
		vistaModificar.setVisible(true);
	}
	
	private void botonEliminar() {
		control.eliminarPermiso(permisoSeleccionado());
	}
	
	private IPermiso permisoSeleccionado() {
		IPermiso p = null;
		int i = 0;
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		String nombre = (String) dtm.getValueAt(table.getSelectedRow(), 0);
		while (i < this.permisos.size() && p == null) {
			if (this.permisos.get(i).getNombre() == nombre)
				p = this.permisos.get(i);
			i++;
		}
		return p;
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
	
	public VistaPermisos() {
		setTitle("Administración de Permisos");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel busqueda = new JPanel();
		getContentPane().add(busqueda, BorderLayout.NORTH);
		GridBagLayout gbl_busqueda = new GridBagLayout();
		gbl_busqueda.columnWidths = new int[]{39, 97, 25, 28, 0};
		gbl_busqueda.rowHeights = new int[]{20, 0, 23, 0, 0};
		gbl_busqueda.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_busqueda.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		busqueda.setLayout(gbl_busqueda);
		
		JLabel lblPermiso = new JLabel("Permiso");
		GridBagConstraints gbc_lblPermiso = new GridBagConstraints();
		gbc_lblPermiso.anchor = GridBagConstraints.EAST;
		gbc_lblPermiso.insets = new Insets(0, 0, 5, 5);
		gbc_lblPermiso.gridx = 0;
		gbc_lblPermiso.gridy = 0;
		busqueda.add(lblPermiso, gbc_lblPermiso);
		
		txtPermiso = new JTextField();
		txtPermiso.setColumns(10);
		GridBagConstraints gbc_txtPermiso = new GridBagConstraints();
		gbc_txtPermiso.insets = new Insets(0, 0, 5, 5);
		gbc_txtPermiso.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPermiso.gridx = 1;
		gbc_txtPermiso.gridy = 0;
		busqueda.add(txtPermiso, gbc_txtPermiso);
		
		JLabel lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 2;
		gbc_lblEstado.gridy = 0;
		busqueda.add(lblEstado, gbc_lblEstado);
		
		cmbEstado = new JComboBox<String>();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
		cmbEstado.setSelectedIndex(0);
		GridBagConstraints gbc_cmbEstado = new GridBagConstraints();
		gbc_cmbEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbEstado.insets = new Insets(0, 0, 5, 0);
		gbc_cmbEstado.gridx = 3;
		gbc_cmbEstado.gridy = 0;
		busqueda.add(cmbEstado, gbc_cmbEstado);
		
		JLabel lblDescripcion = new JLabel("Descripción");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 1;
		busqueda.add(lblDescripcion, gbc_lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.gridwidth = 3;
		gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescripcion.gridx = 1;
		gbc_txtDescripcion.gridy = 1;
		busqueda.add(txtDescripcion, gbc_txtDescripcion);
		
		JLabel lblFuncionalidad = new JLabel("Funcionalidad");
		GridBagConstraints gbc_lblFuncionalidad = new GridBagConstraints();
		gbc_lblFuncionalidad.anchor = GridBagConstraints.EAST;
		gbc_lblFuncionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblFuncionalidad.gridx = 0;
		gbc_lblFuncionalidad.gridy = 2;
		busqueda.add(lblFuncionalidad, gbc_lblFuncionalidad);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonBuscar();
			}
		});
		
		txtFuncionalidad = new JTextField();
		txtFuncionalidad.setColumns(10);
		GridBagConstraints gbc_txtFuncionalidad = new GridBagConstraints();
		gbc_txtFuncionalidad.gridwidth = 3;
		gbc_txtFuncionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_txtFuncionalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFuncionalidad.gridx = 1;
		gbc_txtFuncionalidad.gridy = 2;
		busqueda.add(txtFuncionalidad, gbc_txtFuncionalidad);
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.EAST;
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 3;
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
				"Permiso", "Descripción", "Funcionalidad", "Estado"
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
		head[0] = "Permiso";
		head[1] = "Descripción";
		head[2] = "Funcionalidad";
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
				"Permiso", "Descripci\u00F3n", "Funcionalidad", "Estado"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
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
	}


}
