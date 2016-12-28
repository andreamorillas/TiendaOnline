package LN;

public class ExcepcionNoCompras extends Exception
{
private final static String MENSAJE = "No hay Compras";
	
	
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
