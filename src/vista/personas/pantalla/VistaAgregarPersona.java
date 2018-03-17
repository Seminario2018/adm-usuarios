package vista.personas.pantalla;

import javax.swing.JFrame;

import modelo.personas.Persona;
import vista.personas.control.ControlAgregarPersona;
import vista.personas.control.IControlAgregarPersona;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 16 de mar. de 2018
 */
public class VistaAgregarPersona extends JFrame {
	
	private IControlAgregarPersona control = new ControlAgregarPersona();
	
	public VistaAgregarPersona() {
		control.agregarPersona(new Persona("Pepita", "Gonzalez", "DNI", "39586",
				"Luján", "Maraboto 823", "471762", 1, "2016-06-29", null));
	}

}
