/**
 * 
 */
package vista.roles.control;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.Controlador;
import controlador.IControlador;
import modelo.roles.IRol;

/**
 * @author Javier Elias G�mez Vicente
 *
 */
public class ControlRoles implements IControlRoles {
	
	IControlador control = new Controlador();
	
	/*
	public ControlRoles(IControlador control) {
		super();
		this.control = control;
	}
	*/

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlRoles#buscarRoles(modelo.roles.IRol)
	 */
	@Override
	public ArrayList<IRol> buscarRoles(IRol rol) {
		return control.buscarRoles(rol);
	}

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlRoles#eliminarRol(modelo.roles.IRol)
	 */
	@Override
	public boolean eliminarRol(IRol rol) {
		if (control.eliminarRol(rol)) {
            JOptionPane.showMessageDialog(null, "El rol se eliminó con exito");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un problema al eliminar el rol");
            return false;
        }
	}

	/* (non-Javadoc)
	 * @see vista.roles.control.IControlRoles#getIRol()
	 */
	@Override
	public IRol getIRol() {
		return control.getIRol();
	}

}
