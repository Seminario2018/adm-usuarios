/**
 * 
 */
package vista.roles.control;

import javax.swing.JOptionPane;

import controlador.IControlador;
import modelo.roles.IRol;

/**
 * @author Elias
 *
 */
public class ControlModificarRol implements IControlModificarRol {
	
	private IControlador control;
	
	/**
	 * @param control
	 */
	public ControlModificarRol(IControlador control) {
		super();
		this.control = control;
	}

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlModificarRol#modificarRol(modelo.roles.IRol)
	 */
	@Override
	public boolean modificarRol(IRol rol) {
		//return control.modificarRol(rol);
	    String error = "No se pudo modificar el rol por las siguientes razones:\n";
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
            if (control.modificarRol(rol)) {
                JOptionPane.showMessageDialog(null, "El rol se modificó con éxito");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un problema al modificar al rol");
                return false;
            }
        }
	}

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlModificarRol#getIRol()
	 */
	@Override
	public IRol getIRol() {
		return control.getIRol();
	}

}
