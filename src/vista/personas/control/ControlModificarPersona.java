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
		return control.modificarPersona(persona);
	}

	/* (non-Javadoc)
	 * @see vista.personas.control.IControlModificarPersona#getIPersona()
	 */
	@Override
	public IPersona getIPersona() {
		return control.getIPersona();
	}

}
