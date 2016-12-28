package LN;
/**
 * 
 * @author Paula y Andrea
 *
 */
public class clsUsuario {
	/**
	 * @param contraseña: la contraseña necesario que tiene tanto los clientes como los admisntradores oara poder acceder a la aplicacion
	 */
	private String contraseña;
	
	public clsUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "clsUsuario [contraseña=" + contraseña;
	}
	
	
	
	
}
