package vista.personas.pantalla;

import javax.swing.JFrame;

import modelo.personas.IPersona;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 16 de mar. de 2018
 */
public class VistaModificarPersona extends JFrame {

	private IPersona persona;
	
	public VistaModificarPersona(IPersona persona) {
		this.persona = persona;
	}
}
