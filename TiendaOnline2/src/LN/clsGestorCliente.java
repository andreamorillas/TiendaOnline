package LN;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.swing.JOptionPane;

import COMUN.clsConstantes;
import COMUN.clsOrdenarPorNickname;
import COMUN.clsConstantes.enFicDatos;
import DATOS.clsDatos;
import LN.ExcepcionNoCompras;

public class clsGestorCliente 
{
	clsDatos datos = new clsDatos();
	/**
	 * 
	 * @param nombre nombre del cliente
	 * @param ape1 primer apellido del cliente
	 * @param ape2 segundo apellido del cliente
	 * @param dni DNI del cliente
	 * @param domicilio domicilio al cual le llegarán los paquetes al cliente
	 * @param nickname nickname del cliente
	 * @param contrasena contraseña del cliente
	 * @throws ExcepcionRepetido excepción que saltará cuando el DNI del cliente sea repetido. 
	 * Meidante este método guardamos en un fichero todos los datos de un nuevo cliente. 
	 * @throws ExcepcionClientesNoGuardados 
	 * @throws IOException 
	 */
	public void altaCliente(String nombre, String ape1, String ape2, String dni, String domicilio, String nickname, String contrasena) throws ExcepcionRepetido, ExcepcionClientesNoGuardados 
	{
		
		clsCliente cliente = new clsCliente(nombre, ape1, ape2, dni, domicilio, nickname, contrasena);
		HashSet<clsCliente> setClientes=new HashSet<clsCliente>();
		
		setClientes=this.verClientes();
		
		if(!setClientes.add(cliente))
		{
			
			throw new ExcepcionRepetido();
		}
		else
		{
			datos.ComenzarSave(enFicDatos.CLIENTES);
			datos.Save(cliente);
			datos.TerminarSave();
			
		}
			System.out.println(enFicDatos.CLIENTES);
		}
		
	/**
	 * 	
	 * @param listaClientes lista de todos los clientes registrados hasta el momento con la modificación hecha
	 * Mediante este método borraremos todos los datos existentes del fichero CLIENTE y volveremos a introducirlos 
	 * todos con la modificación del cliente elegido por el usuario. 
	 */
	public void modificarCliente(ArrayList<clsCliente> listaClientes)

	{
		datos.ResetFile(enFicDatos.CLIENTES);
		for (clsCliente aux : listaClientes) {
			datos.ComenzarSave(enFicDatos.CLIENTES);
			datos.Save(aux);
			datos.TerminarSave();
	}
	}
	/**
	 * 
	 * @param dni
	 * Mediante este método eliminaremos los datos de un cliente en un fichero
	 * @throws IOException 
	 */
	public void bajaCliente(String dni) throws IOException, ExcepcionClientesNoGuardados

	{
		
		HashSet<clsCliente>listaClientes = new HashSet<clsCliente>();
		
		listaClientes = verClientes();
		
		for (clsCliente aux : listaClientes) 
		{
			if(aux.getStringProperty(clsConstantes.DNI).equals(dni))
			{
				listaClientes.remove(aux);
			}
			
		}
	
		datos.ResetFile(enFicDatos.CLIENTES);
		
		datos.ComenzarSave(enFicDatos.CLIENTES);
		
		for (clsCliente aux : listaClientes) 
		{
			datos.Save(aux);
		}
		
		datos.TerminarSave();
		
		
	}
	/**
	 * 
	 * @param clientes: lista de clientes registrados
	 * @return clienets: devuelve la lista de clientes ordenados por nickname
	 * Mediante este méodo ordenaremos los clientes por DNI, su orden natural (interfaz comparable)
	 */
	public ArrayList<clsCliente> OrdenarClientesDni(

		ArrayList<clsCliente> clientes) {

			Collections.sort(clientes);

			return clientes;
		}
 /**
  * 
  * @param clientes: lista de clientes registrados
  * @return clienets: devuelve la lista de clientes ordenados por nickname
  * Mediante este método ordenaremos los clientes por Nickname (comparator)
  */
	public ArrayList<clsCliente> OrdenarClientesNickname(ArrayList<clsCliente> clientes) {

			Collections.sort(clientes, new clsOrdenarPorNickname());

			return clientes;
		}
/**
 * Método mediante el cual saldrá una lista desordenada de los clientes registrados hasta el momento. 
 * @return listaClientes: devuelve la lista de clientes guardados en el sistema.
 */
	public HashSet<clsCliente> verClientes()  throws ExcepcionClientesNoGuardados
		{
			ArrayList<Serializable>lista = new ArrayList<Serializable>();
			HashSet<clsCliente>listaClientes = new HashSet<clsCliente>();
			
			datos.ComenzarRead(enFicDatos.CLIENTES);
			lista = datos.Read();
			for(Serializable s : lista)
			{
				listaClientes.add((clsCliente)s);
			}
			datos.TerminarRead();
			
			System.out.println(listaClientes);			
			return listaClientes;
			

		}
	
	/**
	 * Metodo de comprar camiseta
	 * @param NICKNAME 
	 * @param id
	 * @throws IOException 
	 * @throws ExcepcionNoCompras 
	 */
	public void compraCamiseta(String NICKNAME, int codigo) throws ExcepcionNoCompras 
	{
		HashSet<clsCamiseta>listaCamisetas=new HashSet<clsCamiseta>();
		clsGestorAdministrador gestor=new clsGestorAdministrador();
		HashSet<clsCliente>listaClientes=new HashSet<clsCliente>();
		HashSet<clsCompra>listaCompras=new HashSet<clsCompra>();
		
		int cantidad=0;
		int idCompra=0;
		int unidad=1;
		
		listaCamisetas=gestor.verCamisetas();
		listaCompras=this.verCompras();
		
		
			for (clsCamiseta aux : listaCamisetas) 
			{
				if(aux.getIntegerProperty(clsConstantes.CODIGODEBARRASCAMI).equals(codigo))
				{
					
					cantidad=aux.getIntegerProperty(clsConstantes.CANTIDADCAMI);
					System.out.println("Lo que habia:"+ cantidad);
					cantidad=cantidad-unidad;
					
					System.out.println("Las que quedan:" +cantidad);
					aux.setCantidad(cantidad);
					
					gestor.modificarCamiseta(listaCamisetas);
					
					idCompra=listaCompras.size();
					idCompra++;
					System.out.println(idCompra);
					
					this.GuardarCompra(NICKNAME,codigo,idCompra);
				}
			}
			
			datos.ResetFile(enFicDatos.CAMISETAS);
			for (clsCamiseta aux : listaCamisetas) 
			{
				listaCamisetas.add((clsCamiseta)aux);
			}		
			
	
				
	}
		
	public void GuardarCompra(String NICKNAME, int codigo,int idCompra) 
	{
		// TODO Auto-generated method stub
		clsCompra compra=new clsCompra(NICKNAME, codigo, idCompra);
		datos.ComenzarSave(enFicDatos.COMPRA);
		datos.Save(compra);
		datos.TerminarSave();
	}
	
	public HashSet<clsCompra> verCompras() throws ExcepcionNoCompras  
	{
		ArrayList<Serializable> lista = new ArrayList<Serializable>();
		HashSet<clsCompra> listaCompras = new HashSet<clsCompra>();
		
		datos.ComenzarRead(enFicDatos.COMPRA);
		lista = datos.Read();
		
		for (Serializable s : lista) 
		{
			listaCompras.add((clsCompra)s);
		}
		
		datos.TerminarRead();
		
		System.out.println(listaCompras);
		return listaCompras;
		
		
	}
	
	public void ComprobarContraseña(String nickname, String contraseña) throws ExcepcionClienteNoExistente, ExcepcionContraseñaIncorrecta, IOException, ExcepcionClientesNoGuardados 
	{
		
		boolean resultado = false;
		String contra = null;
		HashSet<clsCliente>listaClientes = new HashSet<clsCliente>();
		
			listaClientes = this.verClientes();
			
			for(clsCliente aux : listaClientes)
			{
				if(aux.getStringProperty(clsConstantes.NICKNAME).equals(nickname))
				{
					contra = aux.getStringProperty(clsConstantes.CONTRASENA);
					resultado=true;
				}
			}
			
			if(resultado == false)
			{
				throw new ExcepcionClienteNoExistente();
			}
			
			if(contra.equals(contraseña)==false)
			{
				throw new ExcepcionContraseñaIncorrecta();
			}
		
		
	}
	
	public clsCliente DevolverCliente(String NICKNAME) throws ExcepcionClientesNoGuardados, IOException
	{
		clsCliente cliente = new clsCliente();
		HashSet<clsCliente>listaClientes = new HashSet<clsCliente>();
		
		listaClientes = this.verClientes();
		
		for(clsCliente aux : listaClientes)
		{
			if(aux.getStringProperty(clsConstantes.NICKNAME).equals(NICKNAME))
			{
				cliente = aux;
			}
		}
		
		return cliente;
	}
	
}
