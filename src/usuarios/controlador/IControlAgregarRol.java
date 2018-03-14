package usuarios.controlador;

import usuarios.modelo.IRol;

/**
 * @author Javier Elías Gómez vicente
 * @version 1.0, 13 de mar. de 2018
 */
public interface IControlAgregarRol extends IControlRol {
	/**
	 * Crea un Rol nuevo
	 * @param rol - la plantilla de Rol con los datos
	 * @return <strong>True</strong> si el Rol se crea con exito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean agregarRol(IRol rol);
}
