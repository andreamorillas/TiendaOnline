package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JLabel;
import java.awt.Color;
/**
 * 
 * @author Paula y Andrea
 *
 * Clase donde creamos la ventana de incio de neustra aplicación
 */
public class clsPrincipal extends JFrame implements ActionListener {


	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Mediant este constructor, creamos la ventana de inicio, a nuestro gusto.
	 */
	public clsPrincipal() 
	{
		setTitle("Acceso a la tienda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipal.class.getResource("/Image/Icono tienda.jpg")));
				
		getContentPane().setLayout(null);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCliente.setBounds(51, 150, 137, 39);
		btnCliente.addActionListener(this);
		btnCliente.setActionCommand("Cliente");
		getContentPane().add(btnCliente);
		
		JButton btnAdmin = new JButton("Administrador");
		btnAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAdmin.setBounds(322, 150, 155, 39);
		btnAdmin.addActionListener(this);
		btnAdmin.setActionCommand("Administrador");
		getContentPane().add(btnAdmin);
		
		JLabel lblAcc = new JLabel("Acceso a la tienda");
		lblAcc.setForeground(Color.BLACK);
		lblAcc.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAcc.setBounds(167, 31, 195, 39);
		getContentPane().add(lblAcc);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnSalir.setBounds(417, 277, 89, 23);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		getContentPane().add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(frmMenuCompra.class.getResource("/Image/fondo.jpg")));
		lblNewLabel.setBounds(0, 0, 553, 336);
		getContentPane().add(lblNewLabel);
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,200,556,367);
		
		
	}
	/**
	 * Este metodo, e sun metodo que se crea por defecto al implementar el ActionListener, donde decimos al programa que debe hacer según que boton pulse el usuario.
	 */
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand())
		{
		
		case "Cliente":
		
			this.Cliente();
			this.dispose();
			break;
		
		case "Administrador":
			
			this.Admin();
			this.dispose();
			break;
		
		case "Salir":
			
			this.dispose();
		}
	}
	
	/**
	 * El metodo anterior, llama a este, cuando el usuario pulsa el boton de cliente.
	 * Mediante este metodo, se llama a la ventana de inicio de sesión del cliente.
	 */
	private void Cliente() 
	{
		// TODO Auto-generated method stub
		
		frmInicioCliente inicio=new frmInicioCliente();
		inicio.setVisible(true);
		
	}
	/**
	 * El metodo anterior, llama a este, cuando el usuario pulsa el boton de administrador.
	 * Mediante este metodo, se llama a la ventana de inicio de sesión del administrador.
	 */
	private void Admin() 
	{
		// TODO Auto-generated method stub

		frmInicioAdmin inicio=new frmInicioAdmin();
		inicio.setVisible(true);
	}

}
