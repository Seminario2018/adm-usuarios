/**
 * 
 */
package vista.permisos.control;

import javax.swing.JOptionPane;

import controlador.IControlador;
import modelo.permisos.IPermiso;
import modelo.roles.IRol;

/**
 * @author Javier El�as G�mez Vicente
 *
 */
public class ControlAgregarPermiso implements IControlAgregarPermiso {

	private IControlador control;
	
	/**
	 * @param control
	 */
	/*public ControlAgregarPermiso(IControlador control) {
		super();
		this.control = control;
	}*/

	/* (non-Javadoc)
	 * @see vista.permisos.control.IControlAgregarPermiso#agregarPermiso(modelo.permisos.IPermiso)
	 */
	@Override
	public boolean agregarPermiso(IPermiso permiso) {
	    String error = "No se pudo agregar el permiso por las siguientes razones:\n";
        boolean hubo_error = false;
        if (permiso.getNombre().compareTo("") == 0) {
            hubo_error = true;
            error += "- Debe ingresar el nombre\n";
        }
        if (permiso.getFuncionalidad().compareTo("") == 0) {
            hubo_error = true;
            error += "- Debe ingresar la funcionalidad\n";
        }
        
        if (hubo_error) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        } else {
            if (control.agregarPermiso(permiso)) {
                JOptionPane.showMessageDialog(null, "El permiso se agregó con éxito");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un problema al agregar al usuario");
                return false;
            }
        }
	}

	/* (non-Javadoc)
	 * @see vista.permisos.control.IControlAgregarPermiso#getIPermiso()
	 */
	@Override
	public IPermiso getIPermiso() {
		return control.getIPermiso();
	}

	@Override
	public IRol getIRol() {
		return control.getIRol();
	}

}
