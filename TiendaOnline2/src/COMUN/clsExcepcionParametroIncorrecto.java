package COMUN;

public class clsExcepcionParametroIncorrecto extends RuntimeException
{
	private String propiedad;
	
	public clsExcepcionParametroIncorrecto(String propiedad1)
	{
		propiedad=propiedad1;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Error en el tipo " + propiedad;
	}

}
