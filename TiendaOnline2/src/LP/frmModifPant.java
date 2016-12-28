package LP;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import COMUN.clsConstantes;
import LN.clsCamiseta;
import LN.clsGestorAdministrador;
import LN.clsPantalon;
/**
 * 
 * @author Paula y Andrea
 * Mediante esta clase, el admisnitrador podrá modificar los datos de un pantalon.
 */
public class frmModifPant extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtEscote;
	private JCheckBox chckboxEscote;

	private JLabel lblPantalones;
	private JComboBox<String> jcbPantalones;
	private clsGestorAdministrador gestor;
	private JButton btnModificar;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtColor;
	private JTextField txtTalla;
	private JTextField txtCodigo;
	private ArrayList<clsPantalon> pantalones;
	
	/**
	 * Constructor, donde ponemos la ventana en modo visible y llamamos al metodo correspondiente para la creación de la ventana.
	 * Además tambein creamos aqui la ventana a nuestro gusto.
	 */
	public frmModifPant() 
	{
		getContentPane().setLayout(null);
				
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipal.class.getResource("/Image/Icono tienda.jpg")));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNombre.setBounds(24, 105, 56, 14);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(131, 102, 115, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPrecio.setBounds(24, 146, 46, 14);
		getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(131, 144, 115, 20);
		getContentPane().add(txtPrecio);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblColor.setBounds(24, 188, 46, 14);
		getContentPane().add(lblColor);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(131, 185, 115, 20);
		getContentPane().add(txtColor);
		
		JLabel lblTalla = new JLabel("Talla");
		lblTalla.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTalla.setBounds(24, 225, 46, 14);
		getContentPane().add(lblTalla);
		
		txtTalla = new JTextField();
		txtTalla.setColumns(10);
		txtTalla.setBounds(131, 222, 115, 20);
		getContentPane().add(txtTalla);
	
		JLabel lblCodigo = new JLabel("Cod.Barras");
		lblCodigo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCodigo.setBounds(278, 107, 85, 14);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(373, 104, 153, 20);
		getContentPane().add(txtCodigo);
	
		JCheckBox chckBolsillos = new JCheckBox("SI");
		chckBolsillos.setBounds(373, 144, 41, 23);
		getContentPane().add(chckBolsillos);
		
		JLabel lblEscote = new JLabel("Bolsillos");
		lblEscote.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEscote.setBounds(278, 148, 85, 14);
		getContentPane().add(lblEscote);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnModificar.setBounds(427, 197, 107, 42);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("Modificar");
		
		jcbPantalones= new JComboBox<String>();
		jcbPantalones.setBounds(46, 36, 200, 20);
		getContentPane().add(jcbPantalones);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAtras.setBounds(445, 266, 89, 23);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand("Atras");
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(frmAltaCamiseta.class.getResource("/Image/administracion.jpg")));
		lblFondo.setBounds(0, 0, 562, 343);
		getContentPane().add(lblFondo);
		
		
		lblPantalones = new JLabel("Pantalones");
		gestor=new clsGestorAdministrador();
		ArrayList<clsPantalon> listaPantalones = gestor.verPantalones();
			
		
		for (clsPantalon clsPantalon : listaPantalones) 
		{
			String Codigo=clsPantalon.getStringProperty(clsConstantes.CODIGODEBARRASCAMI);
			jcbPantalones.addItem("Cod. Barras" + Codigo);
		}
		setTitle("Modificar pantalon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,200,578,382);	
}
	/**
	 *Este metodo, es un metodo que se crea por defecto al implementar el ActionListener, donde decimos al programa que debe hacer según que boton pulse el usuario.
	 *En este caso, el metodo de modificar, donde tenemos que llamar al gestor para que lo realice despues de una serie de comprobaciones
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	switch(e.getActionCommand())
	{
		case "Modificar":
		
			if(txtNombre.getText().length()>0 && txtPrecio.getText().length()>0 && txtColor.getText().length()>0 && txtTalla.getText().length()>0 && txtCodigo.getText().length()>0)
			{
										
				pantalones=gestor.verPantalones();
			
				if (jcbPantalones.getSelectedItem() != null) 
				{
					String a=(String) jcbPantalones.getSelectedItem();
					String [] variables = a.split("-");
					int codigo = Integer.parseInt(variables[0]);

					
					for (clsPantalon clsPantalon : pantalones) 
					{
						if (clsPantalon.getIntegerProperty(clsConstantes.CODIGODEBARRASCAMI) == codigo) 
						{
							
							String nombre1 = txtNombre.getText();
							clsPantalon.setNombre(nombre1);

							
							Double precio1 =Double.parseDouble(txtPrecio.getText());
							clsPantalon.setPrecio(precio1);

							
							String color1 = txtColor.getText();
							clsPantalon.setColor(color1);

							
							int talla1 = Integer.parseInt(txtTalla.getText());
							clsPantalon.setTalla(talla1);
							
							
							int codigo1 = Integer.parseInt(txtCodigo.getText());
							clsPantalon.setCodbarrasPant(codigo1);
							
					//CheckBox de Bolsillos
							

							gestor.modificarPantalon(pantalones);
						}
					}
					
					dispose();
				}
			}
		case "Atras":
			
			this.Atras();
			this.dispose();
			break;
		
		}
	}
	/**
	 *Metodo al que se llama cuando el suuario puksa el boton Atras.
	 * En este metodo, se hace una llamada a la ventana de menu de modificaciones, donde podra elegir que prenda desea modificar.
	 */
	private void Atras() 
	{
		// TODO Auto-generated method stub
	
		frmMenuModif mm=new frmMenuModif();
		mm.setVisible(true);
	}

}
