/**
 * 
 */
package vista.roles.control;

import javax.swing.JOptionPane;

import controlador.IControlador;
import modelo.roles.IRol;

/**
 * @author Javier Elías Gómez Vicente
 *
 */
public class ControlAgregarRol implements IControlAgregarRol {
	
	private IControlador control;
	
	/**
	 * @param control
	 */
	/*public ControlAgregarRol(IControlador control) {
		super();
		this.control = control;
	}*/

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlAgregarRol#agregarRol(modelo.roles.IRol)
	 */
	@Override
	public boolean agregarRol(IRol rol) {
		// return ;
	    String error = "No se pudo agregar al usuario por las siguientes razones:\n";
        boolean hubo_error = false;
        if (rol.getNombre().compareTo("") == 0) {
            hubo_error = true;
            error += "- Debe ingresar el nombre\n";
        }
        if (rol.getNombreAmigable().compareTo("") == 0) {
            hubo_error = true;
            error += "- Debe ingresar el nombre amigable\n";
        }
        
        if (hubo_error) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        } else {
            if (control.agregarRol(rol)) {
                JOptionPane.showMessageDialog(null, "El rol se agregó con éxito");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un problema al agregar al rol");
                return false;
            }
        }
	}

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlAgregarRol#getIRol()
	 */
	@Override
	public IRol getIRol() {
		return control.getIRol();
	}

}
