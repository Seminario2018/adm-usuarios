package usuarios.controlador;

import usuarios.modelo.IUsuario;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public interface IControlAgregar extends IControlUsuarios {
	/**
	 * Crea un Usuario nuevo
	 * @param usuario - la plantilla de Usuario con los datos
	 * @return <strong>True</strong> si el Usuario se creó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean agregarUsuario(IUsuario usuario);
}
