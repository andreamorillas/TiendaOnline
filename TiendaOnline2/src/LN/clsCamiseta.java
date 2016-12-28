package LN;

import java.io.Serializable;

import COMUN.clsConstantes;
import COMUN.clsExcepcionParametroIncorrecto;

/**
 * 
 * @author Paula y Andrea
 * 
 * En esta clase encontramos los atributos propios que tiene la camiseta: escote y código de barras 
 * (que será el identificativo de cada camiseta. Es decir, no podrá haber dos camisetas con un mismo código de barras).
 *
 */
public class clsCamiseta extends clsPrenda implements Serializable, itfProperty, Comparable<clsCamiseta>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean escote;
	private int codbarrasCami;
	
	
	public clsCamiseta(String nombre, double precio, String color, int talla,
			int cantidad, int codbarrasCami, boolean escote) {
		super(nombre, precio, color, talla, cantidad);
		this.escote = escote;
		this.codbarrasCami = codbarrasCami;
	}

	public boolean isEscote() {
		return escote;
	}
	
	public void setEscote(boolean escote) {
		this.escote = escote;
	}
	public int getCodbarrasCami() {
		return codbarrasCami;
	}

	public void setCodbarrasCami(int codbarrasCami) {
		this.codbarrasCami = codbarrasCami;
	}

	@Override
	public String toString() {
		return "clsCamiseta [escote=" + escote + ", codbarrasCami=" + codbarrasCami + "]";
	}

	@Override
	public String getStringProperty(String propiedad) 
	{
		switch(propiedad)
		{
			case clsConstantes.NOMBRECAMI : return this.getNombre();
			case clsConstantes.COLORCAMI : return this.getColor();
			
			default: throw new clsExcepcionParametroIncorrecto(propiedad);
		}
		
	}

	public Integer getIntegerProperty(String propiedad) 
	{
		
		switch(propiedad)
		{
			case clsConstantes.TALLACAMI: return this.getTalla();
			case clsConstantes.CODIGODEBARRASCAMI : return this.getCodbarrasCami();
			case clsConstantes.CANTIDADCAMI: return this.getCantidad();
			case clsConstantes.CAMISVENDIDAS: return this.getVendidas();
			
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
			case clsConstantes.PRECIOCAMI: return this.getPrecio();
			
			default: throw new clsExcepcionParametroIncorrecto(propiedad);
		}
	}

	@Override
	public char getCharProperty(String propiedad) {
		// TODO Auto-generated method stub
		throw new clsExcepcionParametroIncorrecto(propiedad);
	}


	@Override
	public boolean getBooleanProperty(String propiedad)
	{
		switch(propiedad)
		{
			case clsConstantes.ESCOTE: return this.isEscote();
			default: throw new clsExcepcionParametroIncorrecto(propiedad);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codbarrasCami;
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
		clsCamiseta other = (clsCamiseta) obj;
		if (codbarrasCami != other.codbarrasCami)
			return false;
		return true;
	}

	@Override
	public int compareTo(clsCamiseta codigo) {
		// TODO Auto-generated method stub
		return codigo.compareTo(codigo);
	}
	
	
	
}
