package LN;

public class ExcepcionIncorrecto extends Exception {

private final static String MENSAJE = "Los datos introducidos no son corectos, vuelva a intentarlo, por favor";
	
	
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
