package DATOS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import COMUN.clsConstantes.enFicDatos;
import DATOS.AppendableObjectOutputStream;
import DATOS.itfDatos;

/**
 * 
 * @author Andrea Morillas y Paula Elósegui
 * Clase que contiene métodos para leer, borrar etc. ficheros. 
 *
 */
public class clsDatos implements itfDatos
{
	
	private final String fic_clientes = ".\\Data\\cliente.dat";
	private final String fic_pantalones = ".\\Data\\pantalones.dat";
	private final String fic_camisetas = ".\\Data\\camisetas.dat";
	private final String fic_compra = ".\\Data\\compras.dat";
	
	
	ObjectOutputStream oos;
	ObjectInputStream ois; 
	AppendableObjectOutputStream aos;
	
	private String setFichero (enFicDatos fichero)
	{
	
		switch(fichero)
		{
			
			case CLIENTES:
			{
				return fic_clientes;
			}
			case PANTALONES:
			{
				return fic_pantalones;
			}	
			case CAMISETAS:
			{
				return fic_camisetas;
			}
			case COMPRA:
			{
				return fic_compra;
			}
			
			
		}
		return "";
	}
	
	public void ComenzarSave(enFicDatos fichero)
	{
		
		
		String ruta=setFichero(fichero);
		File fic;
		
		fic=new File(ruta);
		
		if(fic.exists())
		{
			try {
				aos = new AppendableObjectOutputStream(new FileOutputStream(fic,true));
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			
		}
		else
		{
			
			try
			{
				fic.createNewFile();
				oos = new ObjectOutputStream(new FileOutputStream(fic));
			} catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
//				e.printStackTrace();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		}
		
		
	}
	public void TerminarSave()
	{
		try
		{
			if (oos!=null) oos.close();
			else if(aos!=null)aos.close();
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}  // Se cierra al terminar.
	}
	public void Save(Serializable o)
	{	
		try
		{
			if(oos!=null) 
				oos.writeObject(o);
			else
			{
				if(aos!=null)	
				{
					
					aos.writeObject(o);
				}
			}
			
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("Filenotfound write");
		} 
		catch (IOException e)	
		{
			System.out.println("IOExc write");
		}
	}
	
	public void ComenzarRead(enFicDatos fichero)
	{
		String ruta=setFichero(fichero);
		File fic;
		
		fic=new File(ruta);
		if (fic.exists())
		{
			try
			{
				ois = new ObjectInputStream(new FileInputStream(fic));
			} 
			catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("File not found");
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("El fichero IO");
			}
		}
	}
	
	public void TerminarRead()
	{
		try
		{
			if(ois!=null)ois.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	public ArrayList<Serializable> Read()
	{
		
		ArrayList<Serializable>lista;
		Serializable o=null;
		
		
		lista=new ArrayList<Serializable>();
			try
			{
				
				while ((o = (Serializable)ois.readObject()) != null) 
				{
				       lista.add(o);
				        
				 }
				
				
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				if(o==null) 
				{
	//				System.out.println(e.getMessage());
				}
			}catch (ClassNotFoundException e)
			{
				// TODO Auto-generated catch block
	//			e.printStackTrace();
			}catch (NullPointerException e)
			{
				// TODO Auto-generated catch block
	//			e.printStackTrace();
			}
		
		return lista;
	}
	
	public void ResetFile (enFicDatos fichero) 
	{		
		String ruta =setFichero(fichero);
//		System.out.println(ruta);
		File f=new File(ruta);
		f.delete();	
	}
	
	
}