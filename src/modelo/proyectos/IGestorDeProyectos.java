package modelo.proyectos;

import java.util.ArrayList;

import Programas.IPrograma;
import Programas.Programa;
import modelo.personas.IPersona;
import modelo.usuarios.IUsuario;
import modelo.usuarios.Usuario;

public interface IGestorDeProyectos {
	
	
	// agregar proyectos
	public boolean agregarProyecto(IProyectos proyecto);

	
	public boolean modificarProyecto(IProyectos proyecto);
	
	
	public boolean eliminarProyecto(IProyectos proyecto);
	
	
	public ArrayList<IProyectos> buscarProyectos(IProyectos proyectos);
	
	
	
	public boolean asignarIntegrantes(Proyecto proyecto, Usuario usuario );

	public boolean eliminarIntegrante(Proyecto Proyecto, Usuario integrante);

	
	public boolean asignarSubsidio(IProyectos proyecto, subsidio subsidio);
	
	public boolean eliminarSubsidio(Proyecto Proyecto, subsidio subdidio);
	
	
	public boolean modificarSubsidio(Proyecto Proyecto, subsidio subdidio);
	
	
	
	
	public boolean asignarProroga(Proyecto proyecto);
	

	
}
