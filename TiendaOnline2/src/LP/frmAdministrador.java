package LP;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import LN.ExcepcionClientesNoGuardados;
/**
 * 
 * @author Paula y Andrea
 * En esta clase creamos a ventana del menu prinicpal del administrador
 */
public class frmAdministrador extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Es el contructor, el cual pone la ventana en modo visible.
	 * Además, llama al metodo donde se va a crear la ventana.
	 */

	public frmAdministrador() 
	{
		
		this.setVisible(true);
		
		
		createAndShowGUI();
	}
	/**
	 * Con este metodo creamos nuestra ventana
	 */
	private void createAndShowGUI() 
	{
		// TODO Auto-generated method stub
	
		getContentPane().setLayout(null);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipal.class.getResource("/Image/Icono tienda.jpg")));
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAlta.setBounds(53, 150, 102, 31);
		getContentPane().add(btnAlta);
		btnAlta.addActionListener(this);
		btnAlta.setActionCommand("Alta");
		
		JButton btnModif = new JButton("Modificar");
		btnModif.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnModif.setBounds(229, 150, 102, 31);
		getContentPane().add(btnModif);
		btnModif.addActionListener(this);
		btnModif.setActionCommand("Modificar");
		
		JButton btnLista = new JButton("Lista");
		btnLista.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnLista.setBounds(396, 150, 102, 31);
		getContentPane().add(btnLista);
		btnLista.addActionListener(this);
		btnLista.setActionCommand("Lista");
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnSalir.setBounds(426, 283, 102, 31);
		getContentPane().add(btnSalir);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(frmAdministrador.class.getResource("/Image/administracion.jpg")));
		lblNewLabel.setBounds(0, 0, 535, 328);
		getContentPane().add(lblNewLabel);
		
		
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,200,551,365);
	
	}

	@Override
	/**
	 * Este metodo, e sun metodo que se crea por defecto al implementar el ActionListener, donde decimos al programa que debe hacer según que boton pulse el usuario.
	 */
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand())
		{
			
		case "Alta":
			
			this.menuAlta();
			this.dispose();
			break;
		
		case "Modificar":
			
			this.menuModificar();
			this.dispose();
			break;
			
		case "Lista":
			
			try 
			{
				this.lista();
			} catch (IOException | ExcepcionClientesNoGuardados e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
			break;
			
		case "Salir":
			this.Salir();
			this.dispose();
			break;
		}
	}
	/**
	 * El programa accede a este metodo cuanod el usuario selecciona el bonton salir.
	 * Este metodo llama a la ventana de inicio de la aplicación
	 */
	private void Salir() 
	{
		
		clsPrincipal cp=new clsPrincipal();
		cp.setVisible(true);
	}
	/**
	 * El programa accede a este metodo cuanod el usuario selecciona el bonton lista.
	 * Este metodo llama a la ventana de la lista de clientes
	 * @throws IOException 
	 * @throws ExcepcionClientesNoGuardados 
	 */
	private void lista() throws IOException, ExcepcionClientesNoGuardados 
	{
	
		frmListaClientes menu=new frmListaClientes();
		menu.setVisible(true);
	}
	/**
	 * El programa accede a este metodo cuanod el usuario selecciona el bonton Modificar.
	 * Este metodo llama a la ventana de modificar, donde el usuario debera elegir que clase de prenda desea modificar
	 */
	private void menuModificar() {
		
		frmMenuModif menu=new frmMenuModif();
		menu.setVisible(true);
		
	}
	/**
	 * El programa accede a este metodo cuanod el usuario selecciona el bonton Alta.
	 * Este metodo llama a la ventana de modificar, donde el usuario debera elegir que clase de prenda desea dar de alta
	 */
	private void menuAlta() 
	{		
		frmMenuAlta menu=new frmMenuAlta();
		menu.setVisible(true);
	}
	

}
