package COMUN;

import java.util.Comparator;

import LN.clsCliente;
/**
 * 
 * @author Andrea Morillas y Paula Elósegui
 * En esta clase ordenamos todos los clientes registrados hasta el momento por su Nickname mediante el comparator. 
 *
 */
public class clsOrdenarPorNickname implements Comparator<clsCliente>
{
	public int compare(clsCliente one, clsCliente two)
	{
		return one.getNickname().compareTo(two.getNickname());
	}
}
