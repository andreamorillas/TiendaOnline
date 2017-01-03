package LN;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import COMUN.clsConstantes;
import COMUN.clsConstantes.enFicDatos;
import DATOS.clsDatos;
import DATOS.itfDatos;

public class clsGestorAdministrador {

	itfDatos datos = new clsDatos();
	private boolean retorno;

	/**
	 * Medidante este m�todo guardamos en un fichero todos los datos de una nueva camiseta. 
	 * @param nombre nombre de la camiseta
	 * @param precio precio de la camiseta
	 * @param color color de la camiseta
	 * @param talla talla de la camiseta, siendo �sta entre un intervalo de la talla 32 a la 46
	 * @param codBarras c�digo de barras de la camiseta, que ser� el identificativo de cada una, por eso no podr� haber ning�n c�digo de barras repetido
	 * @param escote boolean que indicar� si la camiseta tiene escote o no. 
	 * @param cnatidad de camisetas que vamos a registrar
	 * @throws ExcepcionCodBarrasRepetido salta esta excepcion cuando al introducir un codigo de barras este ya lo tiene otra camiseta. 
	 */
	public void altaCamiseta(String nombre, double precio, String color,int talla, int cantidad, int codBarras, boolean escote) throws ExcepcionCodBarrasRepetido, IOException
	{

		clsCamiseta camiseta = new clsCamiseta(nombre, precio, color, talla, cantidad,codBarras, escote);

		HashSet<clsCamiseta> setCamisetas = new HashSet<clsCamiseta>();
		setCamisetas=this.verCamisetas();
		

		if(!setCamisetas.add(camiseta))
		{
			
			throw new ExcepcionCodBarrasRepetido();
		}
		else
		{
			datos.ComenzarSave(enFicDatos.CAMISETAS);
			datos.Save(camiseta);
			datos.TerminarSave();
			
			System.out.println(camiseta);
		}
	
		
	}
/**
 * Meidante este m�todo guardamos en un fichero todos los datos de un nuevo pantal�n. 
 * @param nombre nombre del pantal�n
 * @param precio precio del pantal�n
 * @param color color del pantal�n
 * @param talla talla del panta�n
 * @param codBarras c�digo  de barras del pantal�n, que ser� el identificativo de cada uno. 
 * @param bolsillo boolean que indicar� si el pantal�n tiene bolsillos o no.
 * @param cantiad cantidad de pantalones que vamos a registrar
 * @throws ExcepcionCodBarrasRepetido salta esta excepcion cuando al introducir un codigo de barras este ya lo tiene otro pantalon.
 */
	public void altaPantalon(String nombre, double precio, String color, int talla,int cantidad, int codBarras, boolean bolsillo) throws ExcepcionCodBarrasRepetido
	{

		clsPantalon pantalon = new clsPantalon(nombre, precio, color, talla, cantidad,  codBarras, bolsillo);

		HashSet<clsPantalon> setPantalon = new HashSet<clsPantalon>();
		setPantalon=this.verPantalones();

		if(!setPantalon.add(pantalon))
		{
			
			throw new ExcepcionCodBarrasRepetido();
		}
		else
		{
			datos.ComenzarSave(enFicDatos.PANTALONES);
			datos.Save(pantalon);
			datos.TerminarSave();
		}
	
	}

/**
 * Mediante este m�todo borraremos todos los datos existentes del fichero CAMISETAS y volveremos a introducirlas 
 * todas con la modificaci�n de la camiseta elegida por el usuario. 
 * @param camisetas lista de todas las camisetas registradas hasta el momento con la modificaci�n hecha. 
 */
	public void modificarCamiseta(HashSet<clsCamiseta> camisetas) 
	{

		datos.ResetFile(enFicDatos.CAMISETAS);
		
		for (clsCamiseta aux : camisetas) 
		{
			datos.ComenzarSave(enFicDatos.CAMISETAS);
			datos.Save(aux);
			datos.TerminarSave();
		}
	}
/**
 * Mediante este m�todo borraremos todos los datos existentes del fichero PANTALONES y volveremos a introducirlos 
 * todos con la modificaci�n del pantal�n elegido por el usuario. 
 * @param pantalones lista de todos los pantalones registrados hasta el momento con la modificaci�n hecha. 
 */
	public void modificarPantalon(HashSet<clsPantalon> pantalones) 
	{

		datos.ResetFile(enFicDatos.PANTALONES);
		for (clsPantalon aux : pantalones) 
		{
			datos.ComenzarSave(enFicDatos.PANTALONES);
			datos.Save(aux);
			datos.TerminarSave();
		}
	}

/**
 * M�todo mediante el cual saldr� una lista de camisetas desordenadas registradas hasta el momento. 
 * @return listaCamisetas: devulve una lista con las camisetas registradas en el sistema
 */
	public HashSet<clsCamiseta>verCamisetas()
	{
		ArrayList<Serializable> lista = new ArrayList<Serializable>();
		HashSet<clsCamiseta> listaCamisetas = new HashSet<clsCamiseta>();
		
		try
		{
			datos.ComenzarRead(enFicDatos.CAMISETAS);
			lista = datos.Read();
			
			for (Serializable s : lista) 
			{
				listaCamisetas.add((clsCamiseta)s);
				System.out.println(listaCamisetas);
			}
	
		}
		catch (IOException e) 
		{ 
			datos.TerminarRead();
		}
		
		return listaCamisetas;
	}
/**
 * M�todo mediante el cual saldr� una lista de pantalones desordenados registraods hasta el momento. 
 * @return listaPantalones: devuelve una lista con los pantalones guardados en el fichero.
 */
	public HashSet<clsPantalon> verPantalones() 
	{
		ArrayList<Serializable> lista = new ArrayList<Serializable>();
		HashSet<clsPantalon> listaPantalones = new HashSet<clsPantalon>();
		
		System.out.println(enFicDatos.PANTALONES);
		try
		{
			datos.ComenzarRead(enFicDatos.PANTALONES);
			lista = datos.Read();
			
			for (Serializable s : lista) 
			{
				listaPantalones.add((clsPantalon)s);
			}
	
		}
		catch (IOException e) 
		{
			datos.TerminarRead();
		}
		
		return listaPantalones;
	}

	

	
}
