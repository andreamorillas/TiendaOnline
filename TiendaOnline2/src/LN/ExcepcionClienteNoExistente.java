package LN;

public class ExcepcionClienteNoExistente extends Exception
{
protected final static String MENSAJE = "No existe ningún cliente registrado con ese nombre de usuario. Intentelo de nuevo";
	
	@Override
	public String getMessage() 
	{
		return MENSAJE;
	}
	@Override
	public String toString() 
	{
		return MENSAJE;
	}
}
