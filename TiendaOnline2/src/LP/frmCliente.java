package LP;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import LN.ExcepcionClientesNoGuardados;
import LN.clsCliente;
import LN.clsGestorCliente;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * 
 * @author Paula y Andrea
 * En esta clase creamos a ventana del menu prinicpal del cliente
 */
public class frmCliente extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	private String NICKNAME;
	
	/**
	 * Es el contructor, el cual pone la ventana en modo visible.
	 * Además, llama al metodo donde se va a crear la ventana.
	 */
	public frmCliente()
	{
	
		this.setVisible(true);
		
		createAndShowGUI();
	
	}
	/**
	 * Con este metodo creamos nuestra ventana
	 */
	public void createAndShowGUI() 
	{
		getContentPane().setLayout(null);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipal.class.getResource("/Image/Icono tienda.jpg")));
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setIcon(new ImageIcon(frmCliente.class.getResource("/Image/persona3.jpg")));
		lblUsuario.setBounds(505, 11, 65, 74);
		getContentPane().add(lblUsuario);
		
		
		JButton btnCompra = new JButton("Compra");
		btnCompra.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnCompra.setBounds(81, 177, 102, 31);
		getContentPane().add(btnCompra);
		btnCompra.addActionListener(this);
		btnCompra.setActionCommand("Compra");
		
		JButton btnDevolucion = new JButton("Devolucion");
		btnDevolucion.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnDevolucion.setBounds(259, 177, 102, 31);
		getContentPane().add(btnDevolucion);
		btnDevolucion.addActionListener(this);
		btnDevolucion.setActionCommand("Devolucion");
		
		JButton btnYo = new JButton("YO");
		btnYo.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnYo.setBounds(505, 80, 65, 21);
		getContentPane().add(btnYo);
		btnYo.addActionListener(this);
		btnYo.setActionCommand("YO");
		
		JButton btnCarrito = new JButton("Carrito");
		btnCarrito.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnCarrito.setBounds(426, 177, 102, 31);
		getContentPane().add(btnCarrito);
		btnCarrito.addActionListener(this);
		btnCarrito.setActionCommand("Carrito");
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnSalir.setBounds(468, 324, 102, 31);
		getContentPane().add(btnSalir);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(frmCliente.class.getResource("/Image/fondo.jpg")));
		lblFondo.setBounds(0, 0, 629, 404);
		getContentPane().add(lblFondo);
		
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 636, 442);
	}
	@Override
	/**
	 * Este metodo, e sun metodo que se crea por defecto al implementar el ActionListener, donde decimos al programa que debe hacer según que boton pulse el usuario.
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand())
		{
		
		case "Compra":
			
			this.Compra();
			this.dispose();
			break;
			
		case "Devolucion":
			
			this.Dev();
			this.dispose();
			break;
			
		case "Carrito":
			
			try {
				this.Carrito();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
			break;
		
		case "Salir":
			
			this.Principal();
			this.dispose();
			break;
		
		case "YO":
			
			try {
				this.Yo();
			} catch (ExcepcionClientesNoGuardados | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
			break;
		}
	}
	/**
	 * El programa accede a este metodo cuanod el usuario selecciona el bonton YO.
	 * Este metodo llama a la ventana donde visualizara su perfil
	 * @throws ExcepcionClientesNoGuardados 
	 * @throws IOException 
	 */
	private void Yo() throws ExcepcionClientesNoGuardados, IOException 
	{
		
		frmVerPerfil menu =new frmVerPerfil();
		menu.setVisible(true);
		
	}
	/**
	 * El programa accede a este metodo cuanod el usuario selecciona el bonton Salir.
	 * Este metodo llama a la ventana prinicpal, de modo que sladra totalmente de la aplicación
	 */
	private void Principal() 
	{
		clsPrincipal menu =new clsPrincipal();
		menu.setVisible(true);
	}
	/**
	 * El programa accede a este metodo cuanod el usuario selecciona el bonton Carrito.
	 * Este metodo llama a la ventana donde podra visualizar sus compras
	 * @throws IOException 
	 */
	private void Carrito() throws IOException 
	{
		
		frmVerCarrito menu=new frmVerCarrito();
		menu.setVisible(true);
	}
	/**
	 * El programa accede a este metodo cuanod el usuario selecciona el bonton Devolucion.
	 * Este metodo llama a la ventana de menu de devoluciones, donde el cliente podra elegir, que prenda quiere devolver.
	 */
	private void Dev() 
	{
		
		frmMenuDev menu =new frmMenuDev();
		menu.setVisible(true);
	}
	/**
	 * El programa accede a este metodo cuanod el usuario selecciona el bonton Compra.
	 * Este metodo llama a la ventana de menu de compras, donde el cliente podra elegir, que prenda quiere comprar.
	 */
	private void Compra() 
	{

		frmMenuCompra menu =new frmMenuCompra();
		menu.setVisible(true);
	}
	
}
