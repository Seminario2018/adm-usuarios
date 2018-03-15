package vista.roles.control;

import modelo.roles.IRol;

/**
 * @author Javier Elías Gómez Vicente
 * @version 1.1, 14 de mar. de 2018
 */
public interface IControlAgregarRol {
	/**
	 * Crea un Rol nuevo
	 * @param rol - la plantilla de Rol con los datos
	 * @return <strong>True</strong> si el Rol se creó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean agregarRol(IRol rol);
	
	/**
	 * @return una plantilla de Rol vacía 
	 */
	public IRol getIRol();
}
