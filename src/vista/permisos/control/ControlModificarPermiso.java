/**
 * 
 */
package vista.permisos.control;

import javax.swing.JOptionPane;

import controlador.Controlador;
import controlador.IControlador;
import modelo.permisos.IPermiso;

/**
 * @author Javier El�as G�mez Vicente
 *
 */
public class ControlModificarPermiso implements IControlModificarPermiso {
	
	private IControlador control = new Controlador();
	
	/*
	public ControlModificarPermiso(IControlador control) {
		super();
		this.control = control;
	}
	*/

	/* (non-Javadoc)
	 * @see vista.permisos.control.IControlModificarPermiso#modificarPermiso(modelo.permisos.IPermiso)
	 */
	@Override
	public boolean modificarPermiso(IPermiso permiso) {
	    String error = "No se pudo modificar el permiso por las siguientes razones:\n";
        boolean b = false;
        if (permiso.getNombre().compareTo("") == 0) {
            b = true;
            error += "- Debe ingresar el nombre\n";
        }
        if (permiso.getFuncionalidad().compareTo("") == 0) {
            b = true;
            error += "- Debe ingresar la funcionalidad\n";
        }
        
        if (b) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        } else {
            if (control.modificarPermiso(permiso)) {
                JOptionPane.showMessageDialog(null, "El permiso se modificó con éxito");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un problema al modificar el permiso");
                return false;
            }
        }
	}

	/* (non-Javadoc)
	 * @see vista.permisos.control.IControlModificarPermiso#getIPermiso()
	 */
	@Override
	public IPermiso getIPermiso() {
		return control.getIPermiso();
	}

}
