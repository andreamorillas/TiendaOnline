package LN;

import java.io.Serializable;

import COMUN.clsConstantes;

/**
 * 
 * @author Paula y Andrea
 * En esta clase encontramos todos los atributos que tiene el admisnitrador: nombre y contrase�a
 */
public class clsAdministrador extends clsUsuario implements Serializable, itfProperty
{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String contrase�a;

	
	public clsAdministrador(String nombre2, String contrasena) {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	@Override
	public String getStringProperty(String propiedad) {
		// TODO Auto-generated method stub
		switch (propiedad)
		{
		case clsConstantes.NOMBRE : return this.getNombre();
		case clsConstantes.CONTRASENA : return this.getContrase�a();
		}
		return propiedad;
	}

	@Override
	public Integer getIntegerProperty(String propiedad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getFloatProperty(String propiedad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getDoubleProperty(String propiedad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char getCharProperty(String propiedad) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getBooleanProperty(String propiedad) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
