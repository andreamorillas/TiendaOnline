package LN;

import COMUN.clsConstantes;

public class clsContrase�a 
{

	private boolean retorno=false;

	/**
	 * Constructor sin par�metros.
	 */
	public clsContrase�a()
	{
		
	}
	
	/**
	 * M�todo que comprueba si la contrase�a introducida es correcta.
	 * @param Contrase�a : La contrase�a introducida por el usuario.
	 * @return retorno Devolver� un true si la contrase�a es correcta, esto es, si coincide con su contrase�a. En caso contrario, devolver� un false.
	 * 
	 */
	public boolean LeerContrase�a(String Contrase�a)
	{
		
		if(Contrase�a.equals(clsConstantes.CONTRASENA))
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
