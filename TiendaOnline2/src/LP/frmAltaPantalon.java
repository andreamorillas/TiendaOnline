package LP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import LN.ExcepcionCodBarrasRepetido;
import LN.clsGestorAdministrador;
/**
 * 
 * @author Paula y Andrea
 * En esta clase crearemos la ventan correspondiente al alta de un pantalon asi como los metodos correpsondientes para ello.
 */
public class frmAltaPantalon extends JFrame implements ActionListener
{
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtColor;
	private JTextField txtTalla;
	private JTextField txtCodBarras;
	private JLabel lblBolsillos;
	private JLabel lblTalla;
	private JCheckBox chckboxBolsillos;
	private JTextField txtCantidad;
	/**
	 * Es el contructor, el cual pone la ventana en modo visible.
	 * Además, llama al metodo donde se va a crear la ventana.
	 */
	public frmAltaPantalon()
	 {
		getContentPane().setBackground(Color.WHITE);
		this.setVisible(true);
		createAndShowGUI();
	 }
	/**
	 * Con este metodo creamos nuestra ventana
	 */
	private void createAndShowGUI() 
	{
		getContentPane().setLayout(null);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipal.class.getResource("/Image/Icono tienda.jpg")));
		
		txtNombre = new JTextField();
		txtNombre.setBounds(173, 53, 86, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(173, 107, 86, 20);
		getContentPane().add(txtPrecio);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(173, 226, 86, 20);
		getContentPane().add(txtColor);
		
		txtTalla = new JTextField();
		txtTalla.setColumns(10);
		txtTalla.setBounds(173, 178, 86, 20);
		getContentPane().add(txtTalla);
		
		txtCodBarras = new JTextField();
		txtCodBarras.setColumns(10);
		txtCodBarras.setBounds(448, 53, 86, 20);
		getContentPane().add(txtCodBarras);
		
		chckboxBolsillos = new JCheckBox("SI");
		chckboxBolsillos.setBounds(173, 281, 41, 23);
		getContentPane().add(chckboxBolsillos);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnGuardar.setBounds(427, 166, 107, 42);
		getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("Guardar");
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAtras.setBounds(445, 266, 89, 23);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand("Guardar");
		
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblPrecio.setBackground(Color.WHITE);
		lblPrecio.setBounds(53, 110, 59, 31);
		getContentPane().add(lblPrecio);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setForeground(Color.BLACK);
		lblColor.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblColor.setBackground(Color.WHITE);
		lblColor.setBounds(53, 219, 59, 31);
		getContentPane().add(lblColor);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setBounds(53, 46, 86, 31);
		getContentPane().add(lblNombre);
		
		JLabel lblCodigoDeBarras = new JLabel("Codigo de Barras");
		lblCodigoDeBarras.setForeground(Color.BLACK);
		lblCodigoDeBarras.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCodigoDeBarras.setBackground(Color.WHITE);
		lblCodigoDeBarras.setBounds(10, 171, 149, 31);
		getContentPane().add(lblCodigoDeBarras);
		
		lblBolsillos = new JLabel("Bolsillos");
		lblBolsillos.setForeground(Color.BLACK);
		lblBolsillos.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblBolsillos.setBackground(Color.WHITE);
		lblBolsillos.setBounds(53, 275, 86, 31);
		getContentPane().add(lblBolsillos);
		
		lblTalla = new JLabel("Talla");
		lblTalla.setForeground(Color.BLACK);
		lblTalla.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblTalla.setBackground(Color.WHITE);
		lblTalla.setBounds(363, 46, 59, 31);
		getContentPane().add(lblTalla);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(445, 117, 34, 20);
		getContentPane().add(txtCantidad);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(Color.BLACK);
		lblCantidad.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCantidad.setBackground(Color.WHITE);
		lblCantidad.setBounds(363, 110, 59, 31);
		getContentPane().add(lblCantidad);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(frmAltaCamiseta.class.getResource("/Image/administracion.jpg")));
		lblFondo.setBounds(0, 0, 560, 350);
		getContentPane().add(lblFondo);
		
		setTitle("Alta Pantalon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 574, 383);
	}
	/**
	 *Este metodo, e sun metodo que se crea por defecto al implementar el ActionListener, donde decimos al programa que debe hacer según que boton pulse el usuario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		switch( e.getActionCommand())
		{
		case "Guardar":
			
			if(txtNombre.getText().length()>0 && txtPrecio.getText().length()>0 && txtColor.getText().length()>0 && txtTalla.getText().length()>0 && txtCodBarras.getText().length()>0 && txtCantidad.getText().length()>0)
			{
				clsGestorAdministrador objga = new clsGestorAdministrador();
				try
				{
					try 
					{
						objga.altaPantalon(txtNombre.getText(), Double.parseDouble(txtPrecio.getText()), txtColor.getText(), Integer.parseInt(txtTalla.getText()), Integer.parseInt(txtCantidad.getText()), Integer.parseInt(txtCodBarras.getText()), chckboxBolsillos.isSelected());
						dispose();
						
					} catch (ExcepcionCodBarrasRepetido e1) 
					{
						JOptionPane.showMessageDialog(this,e1.getMessage());
					}	
					
				}
				catch (NumberFormatException e2)
				{
					JOptionPane.showMessageDialog(this, "Mete un valor que sea un número en los campos numéricos, por favor.");
				}
			}
			
		case "Atras":
			
			this.Atras();
			this.dispose();
			break;
			
			}
	}
	/**
	 * El programa accede a este metodo cuando el usuario selecciona el bonton atras.
	 * Este metodo llama a la de menu de altas, donde le usuario podra volver a decidir que producto quiere dar de alta.
	 */
	private void Atras() {
		// TODO Auto-generated method stub
		
		frmMenuAlta menu=new frmMenuAlta();
		menu.setVisible(true);
	}
}
