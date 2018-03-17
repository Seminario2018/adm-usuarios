package vista.roles.pantalla;

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

import modelo.roles.IRol;
import modelo.roles.Rol;
import vista.roles.control.ControlRoles;
import vista.roles.control.IControlRoles;

/**
 * @author Javier Elías Gómez Vicente
 *
 */
public class VistaRoles extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControlRoles control = new ControlRoles();
	private ArrayList<IRol> roles = new ArrayList<IRol>();
	private JComboBox<String> cmbEstado;
	private JTextField txtRol;
	private JTextField txtNAmigable;
	private JTable table;
	private JTable header;
	private JButton btnModificar;
	private JButton btnEliminar; 
	private JButton btnPermisos; 
	
	private void botonBuscar() {
		IRol r = control.getIRol();	
		r.setNombre(txtRol.getText());
		r.setNombreAmigable(txtNAmigable.getText());
		
		switch ((String) cmbEstado.getSelectedItem()) {
		case "Activo":
			r.setEstado(1);
			break;
		default:
			r.setEstado(0);
			break;
		}
		
		this.roles.add(new Rol("SUPER", "Super-Usuario", "Todo lo puede", 1, null));
		this.roles.add(new Rol("ADMIN", "Administrador", "Permisos administrativos", 1, null));
		
		actualizarTabla();
	}
	
	private void actualizarTabla() {
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		table.revalidate();
		
		if (roles != null) {
			for (IRol r : this.roles) {
				String[] row = new String[4];
				row[0] = r.getNombre();
				row[1] = r.getNombreAmigable();
				row[2] = r.getDescripcion();
				switch (r.getEstado()) {
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
		VistaAgregarRol vistaAgregar = new VistaAgregarRol();
		vistaAgregar.setVisible(true);
	}
	
	private void botonModificar() {
		VistaModificarRol vistaModificar =
				new VistaModificarRol(rolSeleccionado());
		vistaModificar.setVisible(true);
	}
	
	private void botonEliminar() {
		control.eliminarRol(rolSeleccionado());
	}
	
	private void botonPermisos() {
		VistaGestionarPermisos vistaPermisos =
				new VistaGestionarPermisos(rolSeleccionado());
		vistaPermisos.setVisible(true);
	}
	
	private IRol rolSeleccionado() {
		IRol r = null;
		int i = 0;
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		String nombre = (String) dtm.getValueAt(table.getSelectedRow(), 0);
		while (i < this.roles.size() && r == null) {
			if (this.roles.get(i).getNombre() == nombre)
				r = this.roles.get(i);
			i++;
		}
		return r;
	}
	
	private void habilitarBotones() {
        if (table.getSelectedRow() == -1) {
        	btnModificar.setEnabled(false);
        	btnEliminar.setEnabled(false);
        	btnPermisos.setEnabled(false);
        } else {
        	btnModificar.setEnabled(true);
        	btnEliminar.setEnabled(true);
        	btnPermisos.setEnabled(true);
        }
	}
	
	public VistaRoles() {
		setTitle("Administración de Roles");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel busqueda = new JPanel();
		getContentPane().add(busqueda, BorderLayout.NORTH);
		GridBagLayout gbl_busqueda = new GridBagLayout();
		gbl_busqueda.columnWidths = new int[]{39, 97, 25, 28, 0};
		gbl_busqueda.rowHeights = new int[]{20, 0, 0, 0};
		gbl_busqueda.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_busqueda.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		busqueda.setLayout(gbl_busqueda);
		
		JLabel lblRol = new JLabel("Rol");
		GridBagConstraints gbc_lblRol = new GridBagConstraints();
		gbc_lblRol.anchor = GridBagConstraints.EAST;
		gbc_lblRol.insets = new Insets(0, 0, 5, 5);
		gbc_lblRol.gridx = 0;
		gbc_lblRol.gridy = 0;
		busqueda.add(lblRol, gbc_lblRol);
		
		txtRol = new JTextField();
		txtRol.setColumns(10);
		GridBagConstraints gbc_txtRol = new GridBagConstraints();
		gbc_txtRol.insets = new Insets(0, 0, 5, 5);
		gbc_txtRol.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRol.gridx = 1;
		gbc_txtRol.gridy = 0;
		busqueda.add(txtRol, gbc_txtRol);
		
		JLabel lblNAmigable = new JLabel("Nombre amigable");
		GridBagConstraints gbc_lblNAmigable = new GridBagConstraints();
		gbc_lblNAmigable.anchor = GridBagConstraints.EAST;
		gbc_lblNAmigable.insets = new Insets(0, 0, 5, 5);
		gbc_lblNAmigable.gridx = 2;
		gbc_lblNAmigable.gridy = 0;
		busqueda.add(lblNAmigable, gbc_lblNAmigable);
		
		txtNAmigable = new JTextField();
		txtNAmigable.setColumns(10);
		GridBagConstraints gbc_txtNAmigable = new GridBagConstraints();
		gbc_txtNAmigable.insets = new Insets(0, 0, 5, 0);
		gbc_txtNAmigable.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNAmigable.gridx = 3;
		gbc_txtNAmigable.gridy = 0;
		busqueda.add(txtNAmigable, gbc_txtNAmigable);
		
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
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonBuscar();
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.EAST;
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 2;
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
				"Rol", "Nombre amigable", "Descripcion", "Estado"
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
		head[0] = "Rol";
		head[1] = "Nombre amigable";
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
		
		btnPermisos = new JButton("Permisos");
		btnPermisos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonPermisos();
			}
		});
		btnPermisos.setEnabled(false);
		panel.add(btnPermisos);
	}

}
