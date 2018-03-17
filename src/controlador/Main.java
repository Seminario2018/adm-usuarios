package controlador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;

import vista.permisos.pantalla.VistaPermisos;
import vista.personas.pantalla.VistaPersonas;
import vista.roles.pantalla.VistaRoles;
import vista.usuarios.pantalla.VistaUsuarios;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 16 de mar. de 2018
 */
public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 430, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		
		JLabel lblAdministracinDe = new JLabel("Administración de");
		panel.add(lblAdministracinDe);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnPersonas = new JButton("Personas");
		btnPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VistaPersonas vistaPersonas = new VistaPersonas();
				vistaPersonas.setVisible(true);
			}
		});
		panel_1.add(btnPersonas);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaUsuarios vistaUsuarios = new VistaUsuarios();
				vistaUsuarios.setVisible(true);
			}
		});
		panel_1.add(btnUsuarios);
		
		JButton btnRoles = new JButton("Roles");
		btnRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaRoles vistaRoles = new VistaRoles();
				vistaRoles.setVisible(true);
			}
		});
		panel_1.add(btnRoles);
		
		JButton btnPermisos = new JButton("Permisos");
		btnPermisos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaPermisos vistaPermisos = new VistaPermisos();
				vistaPermisos.setVisible(true);
			}
		});
		panel_1.add(btnPermisos);
	}

}
