package LN;

import COMUN.clsConstantes;

public class clsContraseña 
{

	private boolean retorno=false;

	/**
	 * Constructor sin parámetros.
	 */
	public clsContraseña()
	{
		
	}
	
	/**
	 * Método que comprueba si la contraseña introducida es correcta.
	 * @param Contraseña : La contraseña introducida por el usuario.
	 * @return retorno Devolverá un true si la contraseña es correcta, esto es, si coincide con su contraseña. En caso contrario, devolverá un false.
	 * 
	 */
	public boolean LeerContraseña(String Contraseña)
	{
		
		if(Contraseña.equals(clsConstantes.CONTRASENA))
		{
			retorno=true;
		}
		else
		{
			retorno=false;
		}
		return retorno;
	}

	public boolean isRetorno() {
		return retorno;
	}

	public void setRetorno(boolean retorno) {
		this.retorno = retorno;
	}
	
}
