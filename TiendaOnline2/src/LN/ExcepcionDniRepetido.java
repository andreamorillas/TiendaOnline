package LN;

public class ExcepcionDniRepetido extends Exception
{
		private static final long serialVersionUID = 1L;
		
		private final static String MENSAJE = "Lamentablemente el dni introducido, ya esta registrado, vuelva a intentarlo";
		
		
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

