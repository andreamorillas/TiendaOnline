package LN;

public class ExcepcionClientesNoGuardados extends Exception
{
	private static final long serialVersionUID = 1L;
	private final static String MENSAJE = "No hay clientes guardados";
	
	
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
