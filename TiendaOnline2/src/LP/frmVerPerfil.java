package LP;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;

import COMUN.clsConstantes;
import LN.ExcepcionClientesNoGuardados;
import LN.clsCliente;
import LN.clsGestorCliente;

import java.awt.Font;
import java.awt.Color;
import java.io.IOException;
import java.util.HashSet;

import javax.swing.JTextField;
import java.awt.TextArea;
/**
 * 
 * @author Paula y Andrea
 * Mediante esta ventana, el cliente podrá ver sus datos y podrá acceder a modificarlos en el caso de que fuese necesario
 */
public class frmVerPerfil extends JFrame implements ActionListener
{
	private JTextField txtApe1;
	private JTextField txtApe2;
	private JTextField txtDni;
	private JTextField txtDomicilio;
	private JTextField txtNickname;
	private JTextField txtContrasena;
	private clsCliente c;
	private String NICKNAME;
	HashSet<clsCliente>listaClientes;
	private JTextField txtNombre;
	/**
	 * Constructor, donde ponemos la ventana en modo visible y llamamos al metodo correspondiente para la creación de la ventana.
	 * @throws ExcepcionClientesNoGuardados 
	 * @throws IOException 
	 */
	public frmVerPerfil() throws ExcepcionClientesNoGuardados, IOException 
	{
		this.setVisible(true);
		createAndShowGUI();
	}
	/**
	 * Metodo donde creamos la ventana a nuestro gusto
	 * @throws ExcepcionClientesNoGuardados 
	 * @throws IOException 
	 */
	public void createAndShowGUI() throws ExcepcionClientesNoGuardados, IOException
	{
		//Falta imprmir los datos del cliente
		
		getContentPane().setLayout(null);
		
		this.RecogerNick(NICKNAME);
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipal.class.getResource("/Image/Icono tienda.jpg")));
		
		JButton btnModificarDatos = new JButton("Modificar datos");
		btnModificarDatos.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnModificarDatos.setBounds(440, 280, 134, 33);
		getContentPane().add(btnModificarDatos);
		btnModificarDatos.addActionListener(this);
		btnModificarDatos.setActionCommand("Modificar");
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAtras.setBounds(485, 341, 89, 27);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand("Atras");
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNombre.setBounds(30, 79, 79, 33);
		getContentPane().add(lblNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido");
		lblPrimerApellido.setForeground(Color.WHITE);
		lblPrimerApellido.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPrimerApellido.setBounds(30, 123, 134, 33);
		getContentPane().add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setForeground(Color.WHITE);
		lblSegundoApellido.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSegundoApellido.setBounds(30, 171, 134, 33);
		getContentPane().add(lblSegundoApellido);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setForeground(Color.WHITE);
		lblDni.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDni.setBounds(30, 227, 55, 33);
		getContentPane().add(lblDni);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setForeground(Color.WHITE);
		lblDomicilio.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDomicilio.setBounds(30, 280, 134, 33);
		getContentPane().add(lblDomicilio);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setForeground(Color.WHITE);
		lblNickname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNickname.setBounds(328, 79, 103, 33);
		getContentPane().add(lblNickname);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblContrasea.setBounds(328, 134, 103, 33);
		getContentPane().add(lblContrasea);
		
		txtApe1 = new JTextField();
		txtApe1.setColumns(10);
		txtApe1.setBounds(164, 131, 86, 20);
		getContentPane().add(txtApe1);
		
		txtApe2 = new JTextField();
		txtApe2.setColumns(10);
		txtApe2.setBounds(164, 179, 86, 20);
		getContentPane().add(txtApe2);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(164, 235, 86, 20);
		getContentPane().add(txtDni);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(10);
		txtDomicilio.setBounds(164, 287, 86, 20);
		getContentPane().add(txtDomicilio);
		
		txtNickname = new JTextField();
		txtNickname.setColumns(10);
		txtNickname.setBounds(440, 87, 86, 20);
		getContentPane().add(txtNickname);
		
		txtContrasena = new JTextField();
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(440, 142, 86, 20);
		getContentPane().add(txtContrasena);
		
		JButton btnDarDeBaja = new JButton("Dar de baja");
		btnDarDeBaja.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnDarDeBaja.setActionCommand("Baja");
		btnDarDeBaja.setBounds(440, 227, 134, 33);
		getContentPane().add(btnDarDeBaja);
		btnDarDeBaja.addActionListener(this);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(164, 87, 86, 20);
		getContentPane().add(txtNombre);
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(frmCliente.class.getResource("/Image/fondo.jpg")));
		lblFondo.setBounds(0, 0, 620, 403);
		getContentPane().add(lblFondo);
		
		setTitle("Mi Perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 636, 442);
	}
	/**
	 *Este metodo, es un metodo que se crea por defecto al implementar el ActionListener, donde decimos al programa que debe hacer según que boton pulse el usuario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
		
		case "Modificar":
			
			this.Modif();
			this.dispose();
			break;
		
		case "Baja":
			
			this.baja();
			this.dispose();
			break;
		
		case "Atras":
			
			this.Atras();
			this.dispose();
			break;
		}
		
	}
	
	
	public void RecogerNick(String nickname) throws ExcepcionClientesNoGuardados, IOException
	{
		NICKNAME = nickname;
		clsCliente cliente = new clsCliente();
		clsGestorCliente objGestor=new clsGestorCliente();
		cliente = objGestor.DevolverCliente(NICKNAME);
		System.out.println(NICKNAME);
		this.VerDatos(NICKNAME);
	}
	private void VerDatos (String NICKNAME) throws ExcepcionClientesNoGuardados
	{
		clsGestorCliente gestor=new clsGestorCliente();
		listaClientes=gestor.verClientes();
		
		for (clsCliente aux : listaClientes) 
		{
			if(aux.getStringProperty(clsConstantes.NICKNAME).equals(NICKNAME))
			{
				System.out.println(aux.getStringProperty(clsConstantes.NOMBRE));
				txtNombre.setText(aux.getStringProperty(clsConstantes.NOMBRE));
				txtApe1.setText(aux.getStringProperty(clsConstantes.APELLIDO1));
				txtApe2.setText(aux.getStringProperty(clsConstantes.APELLIDO2));
				txtDni.setText(aux.getStringProperty(clsConstantes.DNI));
				txtDomicilio.setText(aux.getStringProperty(clsConstantes.DOMICILIO));
				txtNickname.setText(aux.getStringProperty(clsConstantes.NICKNAME));
				txtContrasena.setText(aux.getStringProperty(clsConstantes.CONTRASENA));
			}
		}
	
	}
	/**
	 * Método que da de baja al cliente con el que se haya accedido
	 */
	public void baja()
	{
//		clsGestorCliente gestor=new clsGestorCliente();
//		dni;
//		gestor.EliminarCliente(dni);
		
	}
	/**
	 *Metodo al que se llama cuando el usuario pulsa el boton Atras.
	 * En este metodo, se hace una llamada a la ventana principal del cliente.
	 */
	private void Atras() 
	{		
		frmCliente menu= new frmCliente();
		menu.setVisible(true);
	}
	/**
	 *Metodo al que se llama cuando el usuario pulsa el boton Modificar.
	 * En este metodo, se hace una llamada a la ventana de modificacion de los datos del cliente.
	 */
	private void Modif() 
	{		
		
		frmClienteModif menu =new frmClienteModif();
		menu.setVisible(true);
		
	}
}
