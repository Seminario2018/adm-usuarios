package vista.roles.pantalla;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modelo.permisos.IPermiso;
import modelo.roles.IRol;
import vista.permisos.pantalla.VistaAgregarPermiso;
import vista.roles.control.ControlGestionarPermisos;
import vista.roles.control.IControlGestionarPermisos;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Javier Elías Gómez Vicente
 *
 */
public class VistaGestionarPermisos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlGestionarPermisos control = new ControlGestionarPermisos();
	private IRol rol;
	private ArrayList<IPermiso> permisos = new ArrayList<IPermiso>();
	private JTable headerr;
	private JTable tabler;
	private JTable header;
	private JTable table;
	private JTextField txtNombre;
	private JComboBox<String> cmbEstado;
	private JButton btnAsignar;
	private JButton btnSuprimir;

	private void botonAsignar() {
		if (control.asignarPermiso(this.rol, permisoSeleccionado())) {
			actualizarTablaR();
		}
	}

	private void botonSuprimir() {
		if (control.suprimirPermiso(this.rol, permisoSeleccionado())) {
			actualizarTablaR();
		}
	}
	
	private void botonNuevo() {
		VistaAgregarPermiso vistaPermiso = new VistaAgregarPermiso();
		vistaPermiso.setVisible(true);
	}
	
	private void botonBuscar() {
		IPermiso permiso = this.control.getIPermiso();
		permiso.setNombre(txtNombre.getText());
		switch ((String) cmbEstado.getSelectedItem()) {
		case "Activo":
			permiso.setEstado(1);
			break;
		default:
			permiso.setEstado(0);
			break;
		}

		this.permisos = this.control.buscarPermisos(permiso);
		
		actualizarTablaP();
		actualizarTablaR();
	}
	
	private IPermiso permisoSeleccionado() {
		IPermiso p = null;
		int i = 0;
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		String nombre = (String) dtm.getValueAt(table.getSelectedRow(), 0);
		while (i < this.permisos.size() && p == null) {
			if(this.permisos.get(i).getNombre() == nombre)
				p = this.permisos.get(i);
			i++;
		}
		return p;
	}
	
	private void actualizarTablaP() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		table.revalidate();
		
		if (this.permisos != null) {
			for (IPermiso p : this.permisos) {
				String[] row = new String[3];
				row[0] = p.getNombre();
				row[1] = p.getFuncionalidad();
				row[2] = p.getDescripcion();
				dtm.addRow(row);
			}
		}
	}
	
	private void actualizarTablaR() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		table.revalidate();
		
		if (this.rol != null) {
			ArrayList<Object[]> permisosRol = this.rol.getPermisos();
			int i = 0;
			while (i < permisosRol.size()) {
				IPermiso p = (IPermiso) permisosRol.get(i)[0];
				String[] row = new String[3];
				row[0] = p.getNombre();
				row[1] = p.getFuncionalidad();
				row[2] = p.getDescripcion();
				dtm.addRow(row);
			}
		}
	}
	
	private void habilitarBotones() {
		 if (table.getSelectedRow() == -1) {
			 btnAsignar.setEnabled(false);
			 btnSuprimir.setEnabled(false);
	     } else {
	    	 btnAsignar.setEnabled(true);
	    	 btnSuprimir.setEnabled(true);
	     }
	}
	
	public VistaGestionarPermisos(IRol rol) {
		this.rol = rol;
		setTitle("Gestionar Permisos de Rol");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{0.5, 0.0, 0.5};
		gridBagLayout.rowWeights = new double[]{1.0};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panelRol = new JPanel();
		GridBagConstraints gbc_panelRol = new GridBagConstraints();
		gbc_panelRol.fill = GridBagConstraints.BOTH;
		gbc_panelRol.insets = new Insets(0, 0, 5, 5);
		gbc_panelRol.gridx = 0;
		gbc_panelRol.gridy = 0;
		getContentPane().add(panelRol, gbc_panelRol);
		getContentPane().add(panelRol, gbc_panelRol);
		panelRol.setLayout(new BorderLayout(0, 0));
		panelRol.setLayout(new BorderLayout(0, 0));
		
		headerr = new JTable();
		headerr.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Funcionalidad", "Descripcion"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
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
		headerr.setRowSelectionAllowed(false);
		headerr.setFont(new Font("Tahoma", Font.BOLD, 11));
		headerr.setFocusable(false);
		headerr.setBackground(Color.LIGHT_GRAY);
		panelRol.add(headerr, BorderLayout.NORTH);
		panelRol.add(headerr, BorderLayout.NORTH);
		
		tabler = new JTable();
		tabler.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nombre", "Funcionalidad", "Descripcion"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		panelRol.add(tabler);
		
		JLabel lblPermisosDelRol = new JLabel("Permisos del Rol "+rol.getNombre());
		lblPermisosDelRol.setHorizontalAlignment(SwingConstants.CENTER);
		panelRol.add(lblPermisosDelRol, BorderLayout.SOUTH);
		
		JPanel panelPermiso = new JPanel();
		GridBagConstraints gbc_panelPermiso = new GridBagConstraints();
		gbc_panelPermiso.fill = GridBagConstraints.BOTH;
		gbc_panelPermiso.insets = new Insets(0, 0, 5, 0);
		gbc_panelPermiso.gridx = 2;
		gbc_panelPermiso.gridy = 0;
		getContentPane().add(panelPermiso, gbc_panelPermiso);
		
		getContentPane().add(panelPermiso, gbc_panelPermiso);
		
		header = new JTable();
		header.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Funcionalidad", "Descripcion"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
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
		header.setRowSelectionAllowed(false);
		header.setFont(new Font("Tahoma", Font.BOLD, 11));
		header.setFocusable(false);
		header.setBackground(Color.LIGHT_GRAY);
		
		table = new JTable();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	habilitarBotones();
	        }
	    });
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nombre", "Funcionalidad", "Descripcion"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		panelPermiso.setLayout(new BorderLayout(0, 0));
		panelPermiso.setLayout(new BorderLayout(0, 0));
		
		panelPermiso.add(header, BorderLayout.NORTH);
		panelPermiso.add(table);
		
		JLabel lblPermisosDisponibles = new JLabel("Permisos disponibles");
		lblPermisosDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		panelPermiso.add(lblPermisosDisponibles, BorderLayout.SOUTH);
		
		JPanel panelBotones = new JPanel();
		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.insets = new Insets(0, 0, 0, 5);
		gbc_panelBotones.gridx = 1;
		gbc_panelBotones.gridy = 0;
		getContentPane().add(panelBotones, gbc_panelBotones);
		
		JPanel panel = new JPanel();
		panelBotones.add(panel);
		panel.setLayout(new GridLayout(10, 0, 0, 0));
		
		btnAsignar = new JButton("Asignar");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonAsignar();
			}
		});
		btnAsignar.setEnabled(false);
		panel.add(btnAsignar);
		
		btnSuprimir = new JButton("Suprimir");
		btnSuprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonSuprimir();
			}
		});
		btnSuprimir.setEnabled(false);
		panel.add(btnSuprimir);
		
		JButton btnNuevo = new JButton("Nuevo Permiso...");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonNuevo();
			}
		});
		panel.add(btnNuevo);
		
		JButton btnBuscar = new JButton("Buscar Permiso");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonBuscar();
			}
		});
		panel.add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre del Permiso");
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		panel.add(lblEstado);
		
		cmbEstado = new JComboBox();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
		cmbEstado.setSelectedIndex(0);
		panel.add(cmbEstado);
		
		actualizarTablaR();
	}
}
