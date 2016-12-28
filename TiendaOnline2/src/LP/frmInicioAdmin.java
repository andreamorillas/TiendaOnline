package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPasswordField;
/**
 * 
 * @author Paula y Andrea
 * En esta clase, crearemos la ventana d eincio de sesión del administrador.
 */
public class frmInicioAdmin extends JFrame implements ActionListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField contra;


	/**
	 * Constructor donde creamos nuestra ventan, a nuestro gusto.
	 */
	public frmInicioAdmin() 
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipal.class.getResource("/Image/Icono tienda.jpg")));
		setTitle("Inicio sesi\u00F3n como administardor");
		getContentPane().setLayout(null);
		
		JLabel lblIniciarSesin = new JLabel("Iniciar sesi\u00F3n");
		lblIniciarSesin.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblIniciarSesin.setBounds(160, 26, 127, 27);
		getContentPane().add(lblIniciarSesin);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblContrasea.setBounds(42, 116, 102, 17);
		getContentPane().add(lblContrasea);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnEntrar.setBounds(82, 216, 102, 23);
		btnEntrar.addActionListener(this);
		
		btnEntrar.setActionCommand("Entrar");
		getContentPane().add(btnEntrar);
		
		JButton btnSalir = new JButton("Cancelar");
		btnSalir.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnSalir.setBounds(248, 216, 102, 23);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Cancelar");
		getContentPane().add(btnSalir);
		
		contra = new JPasswordField();
		contra.setBounds(218, 116, 157, 20);
		getContentPane().add(contra);
		contra.setColumns(10);
			
	}

	/**
	 * Este metodo, e sun metodo que se crea por defecto al implementar el ActionListener, donde decimos al programa que debe hacer según que boton pulse el usuario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand())
		{
		case "Cancelar":
			this.Principal();
			this.dispose();
			break;
		
		case "Entrar":
			
			if(contra.getText().length()>3)
			{
				
				if(contra.getText().equals("admin"))
				{
					frmAdministrador ad=new frmAdministrador();
					ad.setVisible(true);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(this, "La contraseña introducida no es correcta, vuelva a intentarlo");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "La contraseña debe de tener 4 caracteres");
			}
		}
	}

	/**
	 * En en lcaso de que el usuario pulse el boton cancelar.
	 * Mediante este metodo, se llamara a la clase pricnipal, de manera que vuelva a la ventana incial del programa.
	 */
	private void Principal() 
	{
		// TODO Auto-generated method stub
	
		clsPrincipal principal=new clsPrincipal();
		principal.setVisible(true);
	}
}
