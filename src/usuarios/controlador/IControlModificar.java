package usuarios.controlador;

import usuarios.modelo.IUsuario;

/**
 * @author Martín Tomás Juran
 * @version 1.0, 13 de mar. de 2018
 */
public interface IControlModificar {
	/**
	 * Modifica al Usuario que matchea con su identificador,
	 *  sobreescribiendo los datos
	 * @param usuario - la plantilla de Usuario con los datos
	 * @return <strong>True</strong> si el Usuario se modificó con éxito,
	 * <strong>False</strong> en otro caso
	 */
	public boolean modificarUsuario(IUsuario usuario);
}
