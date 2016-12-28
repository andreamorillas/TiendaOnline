package LN;

import java.io.Serializable;

import COMUN.clsConstantes;
import COMUN.clsExcepcionParametroIncorrecto;

/**
 * 
 * @author Paula y Andrea
 * 
 * En esta clase encontramos todos los atributos propios que tiene el cliente: nombre, apellido 1, apellido 2,
 * dni (no podrá haber dos usuarios con el mismo DNI) y conraseña. 
 *
 */
public class clsCliente extends clsUsuario implements Serializable, itfProperty, Comparable<clsCliente>
{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private int año;
	private String domicilio;
	private String nickname;
	private String contraseña;
	
	

	public clsCliente(String nombre, String apellido1, String apellido2,
			String dni, String domicilio, String nickname, String contraseña) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.año=año;
		this.domicilio = domicilio;
		this.nickname = nickname;
		this.contraseña = contraseña;
	}

	public clsCliente() {
		// TODO Auto-generated constructor stub
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	@Override
	
	
	public String toString() {
		return "clsCliente [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", dni=" + dni + ", domicilio=" + domicilio + ", contraseña]";
	}

	@Override
	public String getStringProperty(String propiedad) 
	{
		switch(propiedad)
		{
			case clsConstantes.NOMBRE: return this.getNombre();
			case clsConstantes.APELLIDO1 : return this.getApellido1();
			case clsConstantes.APELLIDO2 : return this.getApellido2();
			case clsConstantes.DNI: return this.getDni();
			case clsConstantes.DOMICILIO : return this.getDomicilio();
			case clsConstantes.NICKNAME : return this.getNickname();
			case clsConstantes.CONTRASENA : return this.getContraseña();

			default: throw new clsExcepcionParametroIncorrecto(propiedad);
		}
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result
				+ ((nickname == null) ? 0 : nickname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsCliente other = (clsCliente) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		return true;
	}

	@Override
	public boolean getBooleanProperty(String propiedad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo(clsCliente o) 
	{	
		return dni.compareTo(o.getDni());
	}
	
	
//	public int compareTo(Object e) {
//		// TODO Auto-generated method stub
//		
//		clsCliente a=(clsCliente)e;		
//		return dni.compareTo(a.getDni());
//	}
//	
//	public int compareTo1(Object o) {
//		// TODO Auto-generated method stub
//		
//		clsCliente af=(clsCliente)o;		
//		return nombre.compareTo(af.getDni());
//	}
	
	
	

	
}
