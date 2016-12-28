package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JTextField;
import javax.swing.JButton;

import COMUN.clsConstantes;
import LN.ExcepcionClienteNoExistente;
import LN.ExcepcionClientesNoGuardados;
import LN.ExcepcionContraseñaIncorrecta;
import LN.ExcepcionIncorrecto;
import LN.clsCliente;
import LN.clsContraseña;
import LN.clsGestorCliente;
/**
 * 
 * @author Paula y Andrea
 * En esta clase, crearemos la ventana d eincio de sesión del cliente.
 */
public class frmInicioCliente extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUsu;
	private String nickname;
	private JPasswordField txtContra;
	/**
	 * Constructor donde creamos nuestra ventan, a nuestro gusto.
	 */
	public frmInicioCliente() 
	{
		setTitle("Inicio de sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		getContentPane().setLayout(null);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipal.class.getResource("/Image/Icono tienda.jpg")));
		
		JLabel lblIniciarSesin = new JLabel("Iniciar sesi\u00F3n");
		lblIniciarSesin.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblIniciarSesin.setBounds(145, 24, 175, 29);
		getContentPane().add(lblIniciarSesin);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNombreDeUsuario.setBounds(60, 84, 150, 14);
		getContentPane().add(lblNombreDeUsuario);
		
		txtUsu = new JTextField();
		txtUsu.setBounds(220, 78, 157, 20);
		getContentPane().add(txtUsu);
		txtUsu.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblContrasea.setBounds(60, 156, 150, 14);
		getContentPane().add(lblContrasea);
		
		txtContra = new JPasswordField();
		txtContra.setColumns(10);
		txtContra.setBounds(220, 150, 157, 20);
		getContentPane().add(txtContra);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnEntrar.setBounds(74, 249, 136, 29);
		btnEntrar.addActionListener(this);
		btnEntrar.setActionCommand("Entrar");
		getContentPane().add(btnEntrar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnRegistrarse.setBounds(257, 249, 136, 29);
		btnRegistrarse.addActionListener(this);
		btnRegistrarse.setActionCommand("Registrarse");
		getContentPane().add(btnRegistrarse);
	}

	
	/**
	 * Este metodo, e sun metodo que se crea por defecto al implementar el ActionListener, donde decimos al programa que debe hacer según que boton pulse el usuario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	
		switch (e.getActionCommand())
		{
		case "Entrar":
			
			try {
				this.comprobar();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			break;
			
		case "Registrarse":
			this.Registro();
			this.dispose();
			break;
		}
	}

	private void comprobar() throws IOException {
		// TODO Auto-generated method stub
		nickname = txtUsu.getText();
		String contraseña = txtContra.getText();
		clsGestorCliente objGestor = new clsGestorCliente();
		
		try
		{
			objGestor.ComprobarContraseña(nickname, contraseña);
			JOptionPane.showMessageDialog(this, "Bienvenido a la tienda online   " + nickname);	

			frmCliente cliente=new frmCliente();
			cliente.setVisible(true);
			this.dispose();
		} catch (ExcepcionClienteNoExistente | ExcepcionContraseñaIncorrecta | ExcepcionClientesNoGuardados e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
	}


	/**
	 * En en lcaso de que el usuario pulse el boton registrar.
	 * Mediante este metodo, se llamara a la clase de registro, donde le nuevo cliente podra registrarse.
	 */
	private void Registro() 
	{
		// TODO Auto-generated method stub
		frmRegistro registro=new frmRegistro();
		registro.setVisible(true);
	}
}
