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
				+ "Direccion, Telefono, Estado, Fecha_de_nacimiento",
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
		ArrayList<String> condiciones = new ArrayList<String>();
		String condicion = "";
		if(persona.getEstado() == 1) {
			condicion = "Estado = 1";
		}else {
			condicion = "Estado = 0";
		}
		if (!persona.getApellido().equals("")) {
			condiciones.add("Apellido = '" + persona.getApellido() + "'");
		}
		if (!persona.getNombre().equals("")) {
			condiciones.add("Nombre = '" + persona.getNombre() + "'");
		}
		if (!persona.getTipoDoc().equals("")) {
			condiciones.add("tipo_doc = '" + persona.getTipoDoc() + "'");
		}
		if (!persona.getNroDoc().equals("")) {
			condiciones.add("nro_doc = '" + persona.getNroDoc() + "'");
		}
		for(String s : condiciones) {
			condicion += " AND " + s;
		}
		ArrayList<IPersona> personas = new ArrayList();
		ArrayList<String> per = md.select("personas", "Nombre, Apellido, tipo_Doc, Nro_doc, Ciudad,"
				+ " Direccion, Telefono, Estado, Fecha_de_nacimiento", condicion);
		for (String s: per) {
			String[] split = s.split(" -- ");
			personas.add(new Persona(split[0], split[1], split[2], split[3], split[4], split[5],
					split[6], Integer.parseInt(split[7]), split[8], null));
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
