package LN;
/**
 * 
 * @author Paula y Andrea
 *
 */
public class clsUsuario {
	/**
	 * @param contrase�a: la contrase�a necesario que tiene tanto los clientes como los admisntradores oara poder acceder a la aplicacion
	 */
	private String contrase�a;
	
	public clsUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getContrase�a() {
		return contrase�a;
	}


	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	@Override
	public String toString() {
		return "clsUsuario [contrase�a=" + contrase�a;
	}
	
	
	
	
}
