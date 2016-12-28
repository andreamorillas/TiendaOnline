package LN;

import java.io.Serializable;

import COMUN.clsConstantes;
import COMUN.clsExcepcionParametroIncorrecto;

/**
 * 
 * @author Paula y Andrea
 *
 * En esta clase encontramos los atributos propios que tiene el pantalon: bolsillos y código de barras (que no
 * podrá haber dos pantalones con el mismo código de barras).
 */
public class clsPantalon extends clsPrenda implements Serializable, itfProperty, Comparable<clsPantalon>
{
	
	private static final long serialVersionUID = 1L;
	
	
	private boolean bolsillos;
	private int codbarrasPant;
	
	
	public clsPantalon(String nombre, double precio, String color, int talla,
			int cantidad, int codbarrasPant, boolean bolsillos) {
		super(nombre, precio, color, talla, cantidad);
		this.bolsillos = bolsillos;
		this.codbarrasPant = codbarrasPant;
	}

	public boolean isBolsillos() {
		return bolsillos;
	}

	public void setBolsillos(boolean bolsillos) {
		this.bolsillos = bolsillos;
	}
	
	public int getCodbarrasPant() {
		return codbarrasPant;
	}

	public void setCodbarrasPant(int codbarrasPant) {
		this.codbarrasPant = codbarrasPant;
	}

	@Override
	public String getStringProperty(String propiedad) 
	{
		switch(propiedad)
		{
		case clsConstantes.NOMBREPANT : return this.getNombre();
		case clsConstantes.COLORPANT : return this.getColor();
		
		default: throw new clsExcepcionParametroIncorrecto(propiedad);
		}
	
	}

	@Override
	public Integer getIntegerProperty(String propiedad) 
	{
		
		switch(propiedad)
		{
			case clsConstantes.TALLAPANT: return this.getTalla();
			case clsConstantes.CODIGODEBARRASPANT : return this.getCodbarrasPant();
			case clsConstantes.CANTIDADPANT: return this.getCantidad();
			
			default: throw new clsExcepcionParametroIncorrecto(propiedad);
		}
		
	}

	@Override
	public Float getFloatProperty(String propiedad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getDoubleProperty(String propiedad) 
	{
		switch(propiedad)
		{
			case clsConstantes.PRECIOPANT: return this.getPrecio();
			
			default: throw new clsExcepcionParametroIncorrecto(propiedad);
		}
	}

	@Override
	public char getCharProperty(String propiedad) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getBooleanProperty(String propiedad) {
		switch(propiedad)
		{
			case clsConstantes.BOLSILLOS: return this.isBolsillos();
			default: throw new clsExcepcionParametroIncorrecto(propiedad);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codbarrasPant;
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
		clsPantalon other = (clsPantalon) obj;
		if (codbarrasPant != other.codbarrasPant)
			return false;
		return true;
	}

	@Override
	public int compareTo(clsPantalon codigo) {
		// TODO Auto-generated method stub
		return codigo.compareTo(codigo);
	}

	
	
}

	

