/**
 * 
 */
package vista.personas.control;

import javax.swing.JOptionPane;

import controlador.IControlador;
import modelo.personas.IPersona;

/**
 * @author Javier El�as G�mez Vicente
 *
 */
public class ControlAgregarPersona implements IControlAgregarPersona {

	private IControlador control;
	
	
	/**
	 * @param control
	 */
	public ControlAgregarPersona(IControlador control) {
		super();
		this.control = control;
	}

	/* (non-Javadoc)
	 * @see vista.personas.control.IControlAgregarPersona#agregarPersona(modelo.personas.IPersona)
	 */
	@Override
	public boolean agregarPersona(IPersona persona) {
		// return control.agregarPersona(persona);
	    String error = "No se pudo agregar a la persona por las siguientes razones:\n";
        boolean b = true;
        if (persona.getNombre().compareTo("") == 0) {
            b = false;
            error += "- Debe ingresar el nombre\n";
        }
        if (persona.getApellido().compareTo("") == 0) {
            b = false;
            error += "- Debe ingresar el apellido\n";
        }
        if (persona.getTipoDoc().compareTo("") == 0) {
            b = false;
            error += "- Debe ingresar el tipo de documento\n";
        }
        if (persona.getNroDoc().compareTo("") == 0) {
            b = false;
            error += "- Debe ingresar el número de documento\n";
        }
        if (persona.getCiudad().compareTo("") == 0) {
            b = false;
            error += "- Debe ingresar la ciudad\n";
        }
        if (persona.getDireccion().compareTo("") == 0) {
            b = false;
            error += "- Debe ingresar la dirección\n";
        }
        if (persona.getTelefono().compareTo("") == 0) {
            b = false;
            error += "- Debe ingresar el teléfono\n";
        }
        if (persona.getFechaNacimiento().compareTo("") == 0) {
            b = false;
            error += "- Debe ingresar la fecha de nacimiento\n";
        }
        
        if (!b) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        } else {
            if (control.agregarPersona(persona)) {
                JOptionPane.showMessageDialog(null, "La persona se agregó con éxito");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un problema al agregar a la persona");
                return false;
            }
        }
	}

	/* (non-Javadoc)
	 * @see vista.personas.control.IControlAgregarPersona#getIPersona()
	 */
	@Override
	public IPersona getIPersona() {
		return control.getIPersona();
	}

}
