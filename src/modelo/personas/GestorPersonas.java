package modelo.personas;

import java.util.ArrayList;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 15 de mar. de 2018
 */
public class GestorPersonas implements IGestorPersonas {

	/* (non-Javadoc)
	 * @see modelo.personas.IGestorPersonas#agregarPersona(modelo.personas.IPersona)
	 */
	@Override
	public boolean agregarPersona(IPersona persona) {
		return false;
	}

	/* (non-Javadoc)
	 * @see modelo.personas.IGestorPersonas#modificarPersona(modelo.personas.IPersona)
	 */
	@Override
	public boolean modificarPersona(IPersona persona) {
		return false;
	}

	/* (non-Javadoc)
	 * @see modelo.personas.IGestorPersonas#eliminarPersona(modelo.personas.IPersona)
	 */
	@Override
	public boolean eliminarPersona(IPersona persona) {
		return false;
	}

	/* (non-Javadoc)
	 * @see modelo.personas.IGestorPersonas#buscarPersona(modelo.personas.IPersona)
	 */
	@Override
	public ArrayList<IPersona> buscarPersona(IPersona persona) {
		return null;
	}

	/* (non-Javadoc)
	 * @see modelo.personas.IGestorPersonas#getIPersona()
	 */
	@Override
	public IPersona getIPersona() {
		return new Persona();
	}

}
