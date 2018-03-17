/**
 * 
 */
package vista.personas.control;

import java.util.ArrayList;

import controlador.Controlador;
import controlador.IControlador;
import modelo.personas.IPersona;

/**
 * @author Javier Elias G�mez Vicente
 *
 */
public class ControlPersonas implements IControlPersonas {

	private IControlador control = new Controlador();
	
	/*
	public ControlPersonas(IControlador control) {
		super();
		this.control = control;
	}
	*/

	/* (non-Javadoc)
	 * @see vista.personas.control.IControlPersonas#buscarPersona(modelo.personas.IPersona)
	 */
	@Override
	public ArrayList<IPersona> buscarPersona(IPersona persona) {
		return control.buscarPersona(persona);
	}

	/* (non-Javadoc)
	 * @see vista.personas.control.IControlPersonas#eliminarPersona(modelo.personas.IPersona)
	 */
	@Override
	public boolean eliminarPersona(IPersona persona) {
		return control.eliminarPersona(persona);
	}

	/* (non-Javadoc)
	 * @see vista.personas.control.IControlPersonas#getIPersona()
	 */
	@Override
	public IPersona getIPersona() {
		return control.getIPersona();
	}

}
