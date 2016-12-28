package LN;

public class ExcepcionCodBarrasRepetido extends Exception
{
	private static final long serialVersionUID = 1L;

	private final static String MENSAJE = "Lamentablemente el código de barras elegido, ya esta registrado, vuelva a intentarlo";
	
	
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
