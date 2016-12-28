package LN;

import java.io.Serializable;

/**
 * 
 * @author Paula y Andrea
 * 
 * En esta clase encontramos todos los atributos que tienen todas las prendas
 */
public class clsPrenda implements Serializable
{
	/**
	 * @param nombre: nombre de la prenda
	 * @param precio: precio de la prenda
	 * @param color: color de la prenda
	 * @paraam talla: talla de la prenda
	 */
	private String nombre;
	private double precio;
	private String color;
	private int talla;
	private int cantidad;
	private int vendidas;

	

	
	public clsPrenda(String nombre, double precio, String color, int talla,
			int cantidad) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.color = color;
		this.talla = talla;
		this.cantidad = cantidad;
	}

	public int getVendidas() {
		return vendidas;
	}

	public void setVendidas(int vendidas) {
		this.vendidas = vendidas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getTalla() {
		return talla;
	}

	public void setTalla(int talla) {
		this.talla = talla;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Nombre"+nombre + ", precio=" + precio + ", color=" + color + ", talla=" + talla ;
	}
	
	
	
	

}
