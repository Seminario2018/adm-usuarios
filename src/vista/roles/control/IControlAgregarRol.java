package vista.roles.control;

import modelo.IRol;

/**
 * @author Javier Elías Gómez Vicente
 * @version 1.1, 14 de mar. de 2018
 */
public interface IControlAgregarRol extends IControlRoles {
	/**
	 * Crea un Rol nuevo
	 * @param rol - la plantilla de Rol con los datos
	 * @return <strong>True</strong> si el Rol se creó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean agregarRol(IRol rol);
}
