package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JSpinner;
import javax.swing.JButton;

import LN.ExcepcionClientesNoGuardados;
import LN.ExcepcionRepetido;
import LN.clsGestorCliente;
/**
 * 
 * @author Paula y Andrea
 * Mediante esta clase, el neuvo cliente, podrá registrarse.
 */
public class frmRegistro extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApe1;
	private JTextField txtApe2;
	private JTextField txtDni;
	private JTextField txtNickname;
	private JTextField txtContra;
	private JTextField txtDomicilio;
	
	/**
	 * Constructor, donde ponemos la ventana en modo visible y llamamos al metodo correspondiente para la creación de la ventana.
	 * Además tambein creamos aqui la ventana a nuestro gusto.
	 */
	public frmRegistro() 
	{
		setTitle("Registro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmRegistro.class.getResource("/Image/Icono tienda.jpg")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().setLayout(null);
		
		setBounds(100,100,693,300);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblRegistro.setBounds(302, 11, 129, 34);
		getContentPane().add(lblRegistro);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNombre.setBounds(21, 73, 162, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido");
		lblPrimerApellido.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPrimerApellido.setBounds(21, 98, 162, 14);
		getContentPane().add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSegundoApellido.setBounds(21, 123, 162, 19);
		getContentPane().add(lblSegundoApellido);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDni.setBounds(21, 153, 162, 14);
		getContentPane().add(lblDni);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(228, 72, 162, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApe1 = new JTextField();
		txtApe1.setColumns(10);
		txtApe1.setBounds(228, 98, 162, 20);
		getContentPane().add(txtApe1);
		
		txtApe2 = new JTextField();
		txtApe2.setColumns(10);
		txtApe2.setBounds(228, 124, 162, 20);
		getContentPane().add(txtApe2);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(228, 152, 162, 20);
		getContentPane().add(txtDni);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNombreDeUsuario.setBounds(417, 73, 170, 14);
		getContentPane().add(lblNombreDeUsuario);
		
		JLabel lblContrsea = new JLabel("Contrse\u00F1a");
		lblContrsea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblContrsea.setBounds(417, 133, 100, 14);
		getContentPane().add(lblContrsea);
		
		txtNickname = new JTextField();
		txtNickname.setColumns(10);
		txtNickname.setBounds(567, 72, 100, 20);
		getContentPane().add(txtNickname);
		
		txtContra = new JTextField();
		txtContra.setColumns(10);
		txtContra.setBounds(529, 132, 138, 20);
		getContentPane().add(txtContra);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnGuardar.setBounds(416, 198, 111, 23);
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("Guardar");
		getContentPane().add(btnGuardar);
		
		JButton btnSalir = new JButton("Cancelar");
		btnSalir.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnSalir.setBounds(544, 198, 105, 23);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Cancelar");
		getContentPane().add(btnSalir);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(10);
		txtDomicilio.setBounds(228, 183, 162, 20);
		getContentPane().add(txtDomicilio);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDomicilio.setBounds(21, 186, 162, 19);
		getContentPane().add(lblDomicilio);
	}
	/**
	 *Este metodo, es un metodo que se crea por defecto al implementar el ActionListener, donde decimos al programa que debe hacer según que boton pulse el usuario.
	 *En este caso, el metodo de guardar, done tenemos que llamar al gestor para que lo realice despues de una serie de comprobaciones
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand())
		{
		case "Cancelar":
			this.Inicio();
			this.dispose();
			break;
			
		case "Guardar":
			
			if (txtNombre.getText().length()>0 && txtApe1.getText().length()>0 && txtApe2.getText().length()>0 && txtDni.getText().length()==9 && txtDomicilio.getText().length()>0 && txtNickname.getText().length()>0 && txtContra.getText().length()>5) 
			{
				clsGestorCliente objgc = new clsGestorCliente();
				
				try
				{
					
					objgc.altaCliente(txtNombre.getText(), txtApe1.getText(), txtApe2.getText(), txtDni.getText(), txtDomicilio.getText(), txtNickname.getText(), txtContra.getText());
					JOptionPane.showMessageDialog(this, "Bienvenido a la tienda online  " + txtNickname.getText() +" !");
					dispose();
					frmCliente cli=new frmCliente();
					cli.setVisible(true);
					
				} catch (ExcepcionRepetido e1) 
				{
					JOptionPane.showMessageDialog(this, e1.getMessage());
				} catch (ExcepcionClientesNoGuardados e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Te has olvidado de introducir algún dato");
			}
			
			}
	}
	/**
	 *Metodo al que se llama cuando el suuario puksa el boton Cancelar.
	 * En este metodo, se hace una llamada a la ventana de incio de sesión de los clientes.
	 */
	private void Inicio() 
	{
		// TODO Auto-generated method stub
	
		frmInicioCliente inicio = new frmInicioCliente();
		inicio.setVisible(true);
	}
}
