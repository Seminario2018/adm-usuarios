package modelo.proyectos;



import java.util.ArrayList;

import Programas.IPrograma;
import modelo.usuarios.IUsuario;
import modelo.usuarios.Usuario;
import persistencia.ManejoDatos;

public class GestorDeProyectos implements IGestorDeProyectos{
	
	ManejoDatos md = new ManejoDatos();

	@Override
	public boolean agregarProyecto(IProyectos proyecto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarProyecto(IProyectos proyecto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarProyecto(IProyectos proyecto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<IProyectos> buscarProyectos(IProyectos proyectos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean asignarIntegrantes(Proyecto proyecto, Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarIntegrante(Proyecto Proyecto, Usuario integrante) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean asignarSubsidio(IProyectos proyecto, subsidio subsidio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarSubsidio(Proyecto Proyecto, subsidio subdidio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarSubsidio(Proyecto Proyecto, subsidio subdidio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean asignarProroga(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	
}
