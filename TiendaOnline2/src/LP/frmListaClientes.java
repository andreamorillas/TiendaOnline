package LP;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;





import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import COMUN.clsConstantes;
import LN.ExcepcionClienteNoExistente;
import LN.ExcepcionClientesNoGuardados;
import LN.clsCliente;
import LN.clsGestorAdministrador;
import LN.clsGestorCliente;
import LN.clsPantalon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.awt.Font;
/**
 * 
 * @author Paula y Andrea
 *En esta ventana, el adminsitrador podra ver un listado de los clientes registrados en la tienda
 */
public class frmListaClientes extends JFrame implements ActionListener
{
	
	HashSet<clsCliente> clientes;

	private JTable table;
	private JPanel contentPane;

	
	private HashSet<clsCliente> lista;

	/**
	 * Es el contructor, el cual pone la ventana en modo visible.
	 * Además, llama al metodo donde se va a crear la ventana, así como carga los datos correspondientes para el funicionameinto adecuado de la ventana.
	 * @throws IOException 
	 * @throws ExcepcionClientesNoGuardados 
	 */
	public frmListaClientes() throws IOException, ExcepcionClientesNoGuardados 
	{
		
		this.setVisible(true);
		
		CargarDatos();
		
		createAndShowGUI();
		
	}
	
	/**
	 * Con este metodo creamos nuestra ventana
	 */
	public void createAndShowGUI() 
	{
		
		getContentPane().setLayout(null);
				
		createTable();
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 30, 516, 290);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAceptar.setBounds(10, 344, 526, 50);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(this);
		btnAceptar.setActionCommand("Aceptar");
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(frmAltaCamiseta.class.getResource("/Image/administracion.jpg")));
		lblFondo.setBounds(0, 0, 560, 350);
		getContentPane().add(lblFondo);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(90, 150, 568, 442);
		this.setVisible(true);
	
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
		
		case "Aceptar":
			this.Atras();
			this.dispose();
			break;
		}
		
	}
	/**
	 * El programa accede a este metodo cuanod el usuario selecciona el bonton Aceptar.
	 * Este metodo llama a la ventana principal del administrador
	 */
	private void Atras() 
	{
		// TODO Auto-generated method stub
	
		frmAdministrador ad=new frmAdministrador();
		ad.setVisible(true);
	}

	/**
	 * En este metodo creamos la tabla a nuestro gusto
	 */
	public void createTable()
	{
		table=null;
		
		TablaClientesModel tab= new TablaClientesModel(clientes);
		
		table=new JTable(tab);
		table.setPreferredScrollableViewportSize(new Dimension(500,70));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		tab.fireTableDataChanged();
	}
	/**
	 * Con este metodo, cargamos los datos procedentes del metodo verClientes de gestor, en una lista.
	 * @throws IOException 
	 * @throws ExcepcionClientesNoGuardados 
	 */
	private void CargarDatos() throws IOException, ExcepcionClientesNoGuardados 
	{
		clsGestorCliente objGestor=new clsGestorCliente();
	
		clientes=objGestor.verClientes();
		
		System.out.println(clientes.size());
		
		if(clientes.size()==0)
		{
			JOptionPane.showMessageDialog(this, "Aun no hay clientes registrados");
			dispose();
		}	
		
	}
	/**
	 * Método que permite refrescar la tabla cada vez que tenga algún cambio.
	 * @throws IOException 
	 * @throws ExcepcionClientesNoGuardados 
	 */
	public void RefrescarTabla() throws IOException, ExcepcionClientesNoGuardados 
	{
		CargarDatos();
		TablaClientesModel tam=(TablaClientesModel)table.getModel();
		tam.setData(clientes);
		tam.fireTableDataChanged();
	}
}
/**
 * 
 * @author Paula y Andrea
 * Clase que creamos con el fin de crear la tabla.
 */
class TablaClientesModel extends AbstractTableModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] columnNames= {"Dni", "Nombre", "Apellido 1", "Apellido 2", "Nickname"};
	Object [][] data;
	 /**
     * Constructor del modelo de datos para la JTable de clientes.
     * @param m Lista de clientes
     */
	public TablaClientesModel(HashSet<clsCliente>lista)
	{
		super();
		setData(lista);
	}
	/**
     * Método con la misma implementación del constructor para poder hacer un modelo de datos de la JTable de clientes.
     * @param m Lista de clientes
     */
	public void setData(HashSet<clsCliente>lista)
	{
		int filas= lista.size();
		int cont;
		
		data=new Object[filas][];
		cont=0;
		
		for (clsCliente aux : lista) 
		{
			
			Object [] a= 
					
					{
					
					new String (aux.getStringProperty(clsConstantes.DNI)),
					new String (aux.getStringProperty(clsConstantes.NOMBRE)),
					new String (aux.getStringProperty(clsConstantes.APELLIDO1)),
					new String (aux.getStringProperty(clsConstantes.APELLIDO2)),
					new String (aux.getStringProperty(clsConstantes.NICKNAME)),
					
					};
			
			data[cont]=a;
			cont++;
			
			}		
		}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    public boolean isCellEditable(int row, int col) 
    {          
            return false;           
    }
    public void setValueAt(Object value, int row, int col) 
    {
        
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
	
}
