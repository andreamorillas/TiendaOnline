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
 * Mediante esta clase, el administrador, podrá elegir, que prenda desea dar de alta.
 */
public class frmMenuAlta extends JFrame implements ActionListener
{
	/**
	 * Constructor, donde ponemos la ventana en modo visible y llamamos al metodo correspondiente para la creación de la ventana.
	 */
	public frmMenuAlta()
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
		btnAtras.setBounds(402, 281, 123, 34);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand("Atras");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(frmMenuAlta.class.getResource("/Image/administracion.jpg")));
		lblNewLabel.setBounds(0, 0, 551, 328);
		getContentPane().add(lblNewLabel);
		
		
		setTitle("Altas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,200,551,365);
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
	 * En este metodo, se hace una llamada a la ventana principal del adminsitrador.
	 */
	private void Atras() 
	{		
		frmAdministrador menu= new frmAdministrador();
		menu.setVisible(true);
	}
	/**
	 * Metodo al que se llama cuando el suuario puksa el boton Pantalones.
	 * En este metodo, se hace una llamada a la ventana de alta de un pantalon..
	 */
	private void Pant() 
	{		
		
		frmAltaPantalon menu =new frmAltaPantalon();
		menu.setVisible(true);
		
	}
	/**
	 * Metodo al que se llama cuando el suuario puksa el boton camisetas.
	 * En este metodo, se hace una llamada a la ventana de alta de un camiseta.
	 */
	private void Cami() 
	{		
		
		frmAltaCamiseta menu =new frmAltaCamiseta();
		menu.setVisible(true);
	}

}
