/**
 * 
 */
package vista.personas.control;

import controlador.IControlador;
import modelo.personas.IPersona;

/**
 * @author Javier Elías Gómez Vicente
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
		return control.agregarPersona(persona);
	}

	/* (non-Javadoc)
	 * @see vista.personas.control.IControlAgregarPersona#getIPersona()
	 */
	@Override
	public IPersona getIPersona() {
		return control.getIPersona();
	}

}
