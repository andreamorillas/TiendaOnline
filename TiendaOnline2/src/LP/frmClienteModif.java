package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JComboBox;
/**
 * 
 * @author Paula y Andrea
 *En esta clase creamos a ventana de compra de camiseta
 */
public class frmClienteModif extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtNombre;
	private JTextField txtApe1;
	private JTextField txtApe2;
	private JTextField txtDni;
	private JTextField txtDomicilio;
	private JTextField txtNickname;
	private JTextField txtContrasena;
	
	/**
	 * Es el contructor, el cual pone la ventana en modo visible.
	 * Además, llama al metodo donde se va a crear la ventana.
	 */
	public frmClienteModif()
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
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNombre.setBounds(23, 142, 60, 14);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(146, 140, 106, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApe1 = new JLabel("Primer apellido");
		lblApe1.setForeground(Color.WHITE);
		lblApe1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblApe1.setBounds(23, 173, 113, 14);
		getContentPane().add(lblApe1);
		
		txtApe1 = new JTextField();
		txtApe1.setBounds(146, 171, 106, 20);
		getContentPane().add(txtApe1);
		txtApe1.setColumns(10);
		
		txtApe2 = new JTextField();
		txtApe2.setColumns(10);
		txtApe2.setBounds(146, 202, 106, 20);
		getContentPane().add(txtApe2);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(146, 233, 106, 20);
		getContentPane().add(txtDni);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(10);
		txtDomicilio.setBounds(146, 266, 106, 20);
		getContentPane().add(txtDomicilio);
		
		JLabel lblApe2 = new JLabel("Segundo apellido");
		lblApe2.setForeground(Color.WHITE);
		lblApe2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblApe2.setBounds(23, 204, 111, 14);
		getContentPane().add(lblApe2);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setForeground(Color.WHITE);
		lblDni.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDni.setBounds(23, 235, 76, 14);
		getContentPane().add(lblDni);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setForeground(Color.WHITE);
		lblDomicilio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDomicilio.setBounds(23, 269, 76, 14);
		getContentPane().add(lblDomicilio);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setForeground(Color.WHITE);
		lblNickname.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNickname.setBounds(280, 61, 76, 14);
		getContentPane().add(lblNickname);
		
		JLabel lblContrasena = new JLabel("Contrasena");
		lblContrasena.setForeground(Color.WHITE);
		lblContrasena.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblContrasena.setBounds(280, 93, 76, 14);
		getContentPane().add(lblContrasena);
		
		txtNickname = new JTextField();
		txtNickname.setColumns(10);
		txtNickname.setBounds(385, 59, 124, 20);
		getContentPane().add(txtNickname);
		
		txtContrasena = new JTextField();
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(385, 90, 124, 20);
		getContentPane().add(txtContrasena);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnGuardar.setBounds(400, 208, 89, 23);
		getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("Guardar");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCancelar.setBounds(400, 265, 89, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("Cancelar");
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(frmAltaCamiseta.class.getResource("/Image/fondo.jpg")));
		lblFondo.setBounds(0, 0, 560, 350);
		getContentPane().add(lblFondo);
		
		setTitle("Modificar datos del cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 574, 383);
	}
	/**
	 * Este metodo, e sun metodo que se crea por defecto al implementar el ActionListener, donde decimos al programa que debe hacer según que boton pulse el usuario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand())
		{
		case "Cancelar":
			
			this.Atras();
			this.dispose();
			break;
		}
	}
	/**
	 * El programa accede a este metodo cuanod el usuario selecciona el bonton Atras.
	 * Este metodo llama a la ventana del menu principal del cliente
	 */
	private void Atras() 
	{
		// TODO Auto-generated method stub
		
		frmCliente fc=new frmCliente();
		fc.setVisible(true);
	}
}
