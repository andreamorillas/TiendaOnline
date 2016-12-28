package LN;

public class ExcepcionRepetido extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	private final static String MENSAJE = "Lamentablemente el nickname elegido, ya esta registrado, vuelva a intentarlo";
	
	
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
