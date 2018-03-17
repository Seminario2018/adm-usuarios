package vista.usuarios.pantalla;

import javax.swing.JFrame;

import modelo.roles.IRol;
import modelo.usuarios.IUsuario;
import vista.roles.pantalla.VistaAgregarRol;
import vista.usuarios.control.ControlGestionarRoles;
import vista.usuarios.control.IControlGestionarRoles;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 16 de mar. de 2018
 */
public class VistaGestionarRoles extends JFrame {
	
	private IControlGestionarRoles control = new ControlGestionarRoles();
	private IUsuario usuario;
	private ArrayList<IRol> roles = new ArrayList<IRol>();
	private JTable headeru;
	private JTable tableu;
	private JTable header;
	private JTable table;
	private JTextField txtNombre;
	private JTextField txtNombreAmigable;
	private JComboBox<String> cmbEstado;
	private JButton btnAsignar;
	private JButton btnSuprimir;

	private void botonAsignar() {
		if (control.asignarRol(this.usuario, rolSeleccionado())) {
			actualizarTablaU();
		}
	}
	
	private void botonSuprimir() {
		if (control.suprimirRol(this.usuario, rolSeleccionado())) {
			actualizarTablaU();
		}
	}
	
	private void botonNuevo() {
		VistaAgregarRol vistaRol = new VistaAgregarRol();
		vistaRol.setVisible(true);
	}
	
	private void botonBuscar() {
		IRol rol = this.control.getIRol();
		rol.setNombre(txtNombre.getText());
		rol.setNombreAmigable(txtNombreAmigable.getText());
		switch ((String) cmbEstado.getSelectedItem()) {
		case "Activo":
			rol.setEstado(1);
			break;
		default:
			rol.setEstado(0);
			break;
		}
		
		this.roles = this.control.buscarRoles(rol);
		
		actualizarTablaR();
		actualizarTablaU();
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
	
	private void actualizarTablaR() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		table.revalidate();
		
		if (this.roles != null) {
			for (IRol r : this.roles) {
				String[] row = new String[3];
				row[0] = r.getNombre();
				row[1] = r.getNombreAmigable();
				switch (r.getEstado()) {
				case 1:
					row[2] = "Activo";
					break;
				default:
					row[2] = "Inactivo";
					break;
				}
				dtm.addRow(row);
			}
		}
	}
	
	private void actualizarTablaU() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		table.revalidate();
		
		if (this.usuario != null) {
			ArrayList<Object[]> rolesUsuario = this.usuario.getRoles(); 
			int i = 0;
			while (i < rolesUsuario.size()) {
				IRol r = (IRol) rolesUsuario.get(i)[0];
				String[] row = new String[3];
				row[0] = r.getNombre();
				row[1] = r.getNombreAmigable();
				switch (r.getEstado()) {
				case 1:
					row[2] = "Activo";
					break;
				default:
					row[2] = "Inactivo";
					break;
				}
				dtm.addRow(row);
				i++;
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
	
	/**
	 * @param rol - el Rol que se busca
	 * @return El índice del Rol en el arreglo de Roles del Usuario,
	 * o -1 si no existe
	 *//*
	private int indexRol(IRol rol) {
		ArrayList<Object[]> rolesUsuario = this.usuario.getRoles(); 
		int i = rolesUsuario.size() - 1;
		while (i >= 0) {
			IRol r = (IRol) rolesUsuario.get(i)[0];
			if (r.getNombre().compareTo(rol.getNombre()) == 0)
				break;
			i--;
		}
		return i;
	} */
	
	public VistaGestionarRoles(IUsuario usuario) {
		this.usuario = usuario;
		setTitle("Gestionar Roles de Usuario");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{0.5, 0.0, 0.5};
		gridBagLayout.rowWeights = new double[]{1.0};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panelUsuario = new JPanel();
		GridBagConstraints gbc_panelUsuario = new GridBagConstraints();
		gbc_panelUsuario.fill = GridBagConstraints.BOTH;
		gbc_panelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_panelUsuario.gridx = 0;
		gbc_panelUsuario.gridy = 0;
		getContentPane().add(panelUsuario, gbc_panelUsuario);
		getContentPane().add(panelUsuario, gbc_panelUsuario);
		panelUsuario.setLayout(new BorderLayout(0, 0));
		panelUsuario.setLayout(new BorderLayout(0, 0));
		
		headeru = new JTable();
		headeru.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Nombre amigable", "Descripcion"
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
		headeru.setRowSelectionAllowed(false);
		headeru.setFont(new Font("Tahoma", Font.BOLD, 11));
		headeru.setFocusable(false);
		headeru.setBackground(Color.LIGHT_GRAY);
		panelUsuario.add(headeru, BorderLayout.NORTH);
		panelUsuario.add(headeru, BorderLayout.NORTH);
		
		tableu = new JTable();
		tableu.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nombre", "Nombre amigable", "Descripcion"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		panelUsuario.add(tableu);
		
		JLabel lblRolesDelUsuario = new JLabel("Roles del Usuario " + this.usuario.getNombre());
		lblRolesDelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelUsuario.add(lblRolesDelUsuario, BorderLayout.SOUTH);
		
		JPanel panelRol = new JPanel();
		GridBagConstraints gbc_panelRoles = new GridBagConstraints();
		gbc_panelRoles.fill = GridBagConstraints.BOTH;
		gbc_panelRoles.insets = new Insets(0, 0, 5, 0);
		gbc_panelRoles.gridx = 2;
		gbc_panelRoles.gridy = 0;
		getContentPane().add(panelRol, gbc_panelRoles);
		
		getContentPane().add(panelRol, gbc_panelRoles);
		
		header = new JTable();
		header.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Nombre amigable", "Descripcion"
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
				"Nombre", "Nombre amigable", "Descripcion"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		panelRol.setLayout(new BorderLayout(0, 0));
		panelRol.setLayout(new BorderLayout(0, 0));
		
		panelRol.add(header, BorderLayout.NORTH);
		panelRol.add(table);
		
		JLabel lblRolesDisponibles = new JLabel("Roles disponibles");
		lblRolesDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		panelRol.add(lblRolesDisponibles, BorderLayout.SOUTH);
		
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
		
		JButton btnNuevo = new JButton("Nuevo Rol...");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonNuevo();
			}
		});
		panel.add(btnNuevo);
		
		JButton btnBuscar = new JButton("Buscar Rol");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonBuscar();
			}
		});
		panel.add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre del Rol");
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombreAmigable = new JLabel("Nombre Amigable");
		panel.add(lblNombreAmigable);
		
		txtNombreAmigable = new JTextField();
		panel.add(txtNombreAmigable);
		txtNombreAmigable.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		panel.add(lblEstado);
		
		cmbEstado = new JComboBox();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
		cmbEstado.setSelectedIndex(0);
		panel.add(cmbEstado);
		
		actualizarTablaU();
	}
}
