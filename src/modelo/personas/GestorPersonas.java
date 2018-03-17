package modelo.personas;

import java.util.ArrayList;

import modelo.permisos.IPermiso;
import modelo.permisos.Permiso;
import modelo.usuarios.IUsuario;
import persistencia.ManejoDatos;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 15 de mar. de 2018
 */
public class GestorPersonas implements IGestorPersonas {
	
	ManejoDatos md = new ManejoDatos();

	/* (non-Javadoc)
	 * @see modelo.personas.IGestorPersonas#agregarPersona(modelo.personas.IPersona)
	 */
	@Override
	public boolean agregarPersona(IPersona persona) {
		md.insertar("personas", "Nombre, Apellido, tipo_Doc, Nro_doc, Ciudad,"
				+ "Direccion, Telefono, Estado, Fecha de nacimiento",
				"'" + persona.getNombre() + "', '" + persona.getApellido() + "', '" + persona.getTipoDoc() + "', '"
				+ persona.getNroDoc() + "', '" + persona.getCiudad() + "', '" + persona.getDireccion() + "', '" + 
				persona.getTelefono() + "', 1, '" + persona.getFechaNacimiento() + "'");
		return md.isEstado();
	}

	/* (non-Javadoc)
	 * @see modelo.personas.IGestorPersonas#modificarPersona(modelo.personas.IPersona)
	 */
	@Override
	public boolean modificarPersona(IPersona persona) {
		md.update("personas", "Nombre = '" + persona.getNombre() + "', Apellido = '" + persona.getApellido()
		+ "', Ciudad = '" + persona.getCiudad() + "', Direccion = '" + persona.getDireccion()
		+ "', Telefono = '" + persona.getTelefono() + "', Fecha de nacimiento = '" + persona.getFechaNacimiento() + "'",
		"Nro_doc = '" + persona.getNroDoc() + "'");
		return md.isEstado();
	}

	/* (non-Javadoc)
	 * @see modelo.personas.IGestorPersonas#eliminarPersona(modelo.personas.IPersona)
	 */
	@Override
	public boolean eliminarPersona(IPersona persona) {
		md.update("personas", "Estado = 0", "Nro_doc = '" + persona.getNroDoc() + "'");
		return md.isEstado();
	}

	/* (non-Javadoc)
	 * @see modelo.personas.IGestorPersonas#buscarPersona(modelo.personas.IPersona)
	 */
	@Override
	public ArrayList<IPersona> buscarPersona(IPersona persona) {
		ArrayList<IPersona> personas = new ArrayList();
		ArrayList<String> per = md.select("personas", "*", "Estado = 1");
		for (String s: per) {
			String[] split = s.split(" ");
			personas.add(new Persona(split[0], split[1], split[2], split[3], split[4], split[5],
					split[5], Integer.parseInt(split[6]), split[7], null));
		}
		return personas;
	}

	/* (non-Javadoc)
	 * @see modelo.personas.IGestorPersonas#getIPersona()
	 */
	@Override
	public IPersona getIPersona() {
		return new Persona();
	}

}
