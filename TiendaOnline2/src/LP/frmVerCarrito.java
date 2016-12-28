package LP;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import COMUN.clsConstantes;
import LN.ExcepcionClientesNoGuardados;
import LN.clsCamiseta;
import LN.clsCliente;
import LN.clsCompra;
import LN.clsGestorAdministrador;
import LN.clsGestorCliente;

import java.awt.ScrollPane;
import java.io.IOException;
import java.util.HashSet;
/**
 * 
 * @author Paula y Andrea
 * Mediante esta ventana, el cliente podrá ver las compras que ha realizado.
 */

public class frmVerCarrito extends JFrame implements ActionListener
{

	
	/**
	 * Constructor, donde ponemos la ventana en modo visible y llamamos al metodo correspondiente para la creación de la ventana.
	 * @throws IOException 
 	 */
	public frmVerCarrito() throws IOException 
	{
		this.setVisible(true);
		
		createAndShowGUI();
	}
	/**
	 * Metodo donde creamos la ventana a nuestro gusto
	 * @throws IOException 
	 */
	public void createAndShowGUI() throws IOException 
	{
		getContentPane().setLayout(null);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipal.class.getResource("/Image/Icono tienda.jpg")));
		

		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnAtras.setBounds(413, 277, 123, 34);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand("Atras");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(frmMenuCompra.class.getResource("/Image/fondo.jpg")));
		lblNewLabel.setBounds(0, 0, 553, 336);
		getContentPane().add(lblNewLabel);
		

		
		setTitle("Compra pantalón");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,200,556,367);
	}
	/**
	 *Este metodo, es un metodo que se crea por defecto al implementar el ActionListener, donde decimos al programa que debe hacer según que boton pulse el usuario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand())
		{
		
		case "Atras":
			
			this.Atras();
			this.dispose();
			break;
		}
	}
	/**
	 *Metodo al que se llama cuando el suuario puksa el boton Atras.
	 * En este metodo, se hace una llamada a la ventana principal del cliente.
	 */
	private void Atras() 
	{		
		frmCliente menu= new frmCliente();
		menu.setVisible(true);
	}
	

}
