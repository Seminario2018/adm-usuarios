/**
 * 
 */
package vista.usuarios.control;

import java.util.ArrayList;

import controlador.Controlador;
import controlador.IControlador;
import modelo.roles.IRol;
import modelo.usuarios.IUsuario;

/**
 * @author Javier E�as G�mez Vicente
 *
 */
public class ControlGestionarRoles implements IControlGestionarRoles {
	
	private IControlador control = new Controlador();
	
	/*
	public ControlGestionarRoles(IControlador control) {
		super();
		this.control = control;
	}
	*/

	/* (non-Javadoc)
	 * @see vista.usuarios.control.IControlGestionarRoles#buscarRoles(modelo.roles.IRol)
	 */
	@Override
	public ArrayList<IRol> buscarRoles(IRol rol) {
		return control.buscarRoles(rol);
	}

	/* (non-Javadoc)
	 * @see vista.usuarios.control.IControlGestionarRoles#asignarRol(modelo.usuarios.IUsuario, modelo.roles.IRol)
	 */
	@Override
	public boolean asignarRol(IUsuario usuario, IRol rol) {
		return control.asignarRol(usuario, rol);
	}

	/* (non-Javadoc)
	 * @see vista.usuarios.control.IControlGestionarRoles#suprimirRol(modelo.usuarios.IUsuario, modelo.roles.IRol)
	 */
	@Override
	public boolean suprimirRol(IUsuario usuario, IRol rol) {
		return control.suprimirRol(usuario, rol);
	}

	/* (non-Javadoc)
	 * @see vista.usuarios.control.IControlGestionarRoles#getIRol()
	 */
	@Override
	public IRol getIRol() {
		return control.getIRol();
	}

}
