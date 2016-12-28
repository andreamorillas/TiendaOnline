package LP;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * 
 * @author Paula y Andrea
 * Mediante esta clase, el cliente, podrá elegir, que prenda desea devolver.
 */
public class frmMenuDev extends JFrame implements ActionListener
{
	/**
	 * Constructor, donde ponemos la ventana en modo visible y llamamos al metodo correspondiente para la creación de la ventana.
	 */
	public frmMenuDev()
	{
		this.setVisible(true);
		
		createAndShowGUI();
	}
	/**
	 * Metodo con el que creamos la ventana a nuestro gusto.
	 */
	public void createAndShowGUI() 
	{
		getContentPane().setLayout(null);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipal.class.getResource("/Image/Icono tienda.jpg")));
		
		JButton btnCamiseta = new JButton("Camisetas");
		btnCamiseta.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCamiseta.setBounds(83, 152, 123, 34);
		getContentPane().add(btnCamiseta);
		btnCamiseta.addActionListener(this);
		btnCamiseta.setActionCommand("Camisetas");
		
		JButton btnPantalones = new JButton("Pantalones");
		btnPantalones.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnPantalones.setBounds(305, 152, 123, 34);
		getContentPane().add(btnPantalones);
		btnPantalones.addActionListener(this);
		btnPantalones.setActionCommand("Pantalones");
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAtras.setBounds(413, 277, 123, 34);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand("Atras");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(frmMenuCompra.class.getResource("/Image/fondo.jpg")));
		lblNewLabel.setBounds(0, 0, 553, 336);
		getContentPane().add(lblNewLabel);
		
		setTitle("Devoluciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,200,556,367);
	}
	/**
	 Este metodo, e sun metodo que se crea por defecto al implementar el ActionListener, donde decimos al programa que debe hacer según que boton pulse el usuario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand())
		{
		
		case "Camisetas":
			
			this.Cami();
			this.dispose();
			break;
		
		case "Pantalones":
			
			this.Pant();
			this.dispose();
			break;
			
		case "Atras":
			
			this.Atras();
			this.dispose();
			break;
		}
	}
	/**
	 * Metodo al que se llama cuando el suuario puksa el boton atras.
	 * En este metodo, se hace una llamada a la ventana principal del cliente.
	 */
	private void Atras() 
	{		
		frmCliente menu= new frmCliente();
		menu.setVisible(true);
	}
	/**
	 * Metodo al que se llama cuando el suuario pulsa el boton Pantalones.
	 * En este metodo, se hace una llamada a la ventana de devolucion de un pantalon..
	 */
	private void Pant() 
	{		
		
		frmClienteDevolucionPantalon menu =new frmClienteDevolucionPantalon();
		menu.setVisible(true);
		
	}
	/**
	 * Metodo al que se llama cuando el suuario pulsa el boton camisetas.
	 * En este metodo, se hace una llamada a la ventana de devolucion de una camiseta.
	 */
	private void Cami() 
	{		
		
		frmClienteDevolucionCamiseta menu=new frmClienteDevolucionCamiseta();
		menu.setVisible(true);
	}
	

}
