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
public class ControlModificarPersona implements IControlModificarPersona {
	
	private IControlador control;
	
	/**
	 * @param control
	 */
	public ControlModificarPersona(IControlador control) {
		super();
		this.control = control;
	}

	/* (non-Javadoc)
	 * @see vista.personas.control.IControlModificarPersona#modificarPersona(modelo.personas.IPersona)
	 */
	@Override
	public boolean modificarPersona(IPersona persona) {
		// return control.modificarPersona(persona);
		String error = "No se pudo modificar a la persona por las siguientes razones:\n";
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
            if (control.modificarPersona(persona)) {
                JOptionPane.showMessageDialog(null, "La persona se modificó con éxito");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un problema al modificar a la persona");
                return false;
            }
        }
	    
	}

	/* (non-Javadoc)
	 * @see vista.personas.control.IControlModificarPersona#getIPersona()
	 */
	@Override
	public IPersona getIPersona() {
		return control.getIPersona();
	}

}
