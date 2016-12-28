package LP;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import COMUN.clsConstantes;
import LN.ExcepcionClientesNoGuardados;
import LN.ExcepcionNoCompras;
import LN.clsCamiseta;
import LN.clsCliente;
import LN.clsGestorAdministrador;
import LN.clsGestorCliente;
/**
 * 
 * @author Paula y Andrea
 *En esta clase creamos a ventana de compra de camiseta
 */
public class frmClienteCompraCamiseta extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	static HashSet<clsCamiseta> camisetas;
	private JScrollPane scrollPane;
	private String NICKNAME;
	
	/**
	 * Es el contructor, el cual pone la ventana en modo visible.
	 * Además, llama al metodo donde se va a crear la ventana, asi como al metodo que carga los datos correspondientes para el buen funcionamiento de la aplicaicon.
	 
	 */
	public frmClienteCompraCamiseta() 
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
		
		crearTabla();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipal.class.getResource("/Image/Icono tienda.jpg")));
				
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 25, 516, 230);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnAtras.setBounds(440, 277, 96, 34);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand("Atras");
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnComprar.setActionCommand("Atras");
		btnComprar.setBounds(100, 277, 260, 34);
		contentPane.add(btnComprar);
		btnComprar.addActionListener(this);
		btnComprar.setActionCommand("Comprar");
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(frmAltaCamiseta.class.getResource("/Image/fondo.jpg")));
		lblFondo.setBounds(0, 0, 560, 350);
		getContentPane().add(lblFondo);
		
		setTitle("Compra camiseta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,200,578,382);
}
	/**
	 * Este metodo, es un metodo que se crea por defecto al implementar el ActionListener, donde decimos al programa que debe hacer según que boton pulse el usuario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		switch(e.getActionCommand())
		{
		
		case "Atras":
			
			this.Atras();
			this.dispose();
			break;
			
		case "Comprar":
			
			try {
				this.Comprar();
			} catch (ExcepcionClientesNoGuardados | ExcepcionNoCompras | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
	}
	public void Comprar() throws ExcepcionClientesNoGuardados, ExcepcionNoCompras, IOException
	{
		int codigo;
		int rowCamisetas;
		clsGestorCliente objGestor = new clsGestorCliente();	
		rowCamisetas=table.getSelectedRow();
		if((rowCamisetas!=-1) )
		{
			codigo=(int)table.getValueAt(rowCamisetas, 0);
			System.out.println(codigo);
			clsCliente cliente=new clsCliente();
			objGestor.compraCamiseta(NICKNAME, codigo);
			cliente = objGestor.DevolverCliente(NICKNAME);
			RefrescarTabla();
		
		}
		else
		{
			JOptionPane.showMessageDialog(this, "No olvide seleccionar una camiseta");
		}
		
	}
	public void RecogerNick(String nickname) throws ExcepcionClientesNoGuardados, IOException
	{
		NICKNAME = nickname;
		clsCliente cliente = new clsCliente();
		clsGestorCliente objGestor=new clsGestorCliente();
		cliente = objGestor.DevolverCliente(NICKNAME);
	}
	/**
	 * Método que permite refrescar la tabla cada vez que tenga algún cambio.
	 * @throws IOException 
	 */
	public void RefrescarTabla() 
	{
		CargarDatos();
		TablaCamisModel tam=(TablaCamisModel)table.getModel();
		tam.setData(camisetas);
		tam.fireTableDataChanged();
	}

	
	/**
	 * El programa accede a este metodo cuanod el usuario selecciona el bonton Atras.
	 * Este metodo llama a la ventana de menu de compras, donde podra elgir que prenda comprar
	 */
	private void Atras() 
	{		
		frmMenuCompra menu= new frmMenuCompra();
		menu.setVisible(true);
	}
	/**
	 * En este metodo creamos la tabla a nuestro gusto
	 */
	private void crearTabla()
	{	
		table=null;
		
		TablaCamisModel tab= new TablaCamisModel(camisetas);
		
		table=new JTable(tab);
		table.setPreferredScrollableViewportSize(new Dimension(500,70));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		tab.fireTableDataChanged();
		
	}
	/**
	 * Con este metodo, cargamos los datos procedentes del metodo verCamisetas de gestor, en una lista.
	 * @throws IOException 
	 */
	private  void CargarDatos() 
	{	
		clsGestorAdministrador objGestor = new clsGestorAdministrador();
		
		camisetas=objGestor.verCamisetas();
		
		if(camisetas.size()==0)
		{
			JOptionPane.showMessageDialog(this, "No hay camisetas registradas");
			dispose();
		}
		
	}
}
	/**
	 * 
	 * @author Paula y Andrea
	 * Clase que creamos con el fin de crear la tabla.
	 */
	class TablaCamisModel extends AbstractTableModel
    {
		private static final long serialVersionUID = 1L;
		
		private String[] columnNames = {"Cod Barras","Nombre","Talla","Color","Precio", "Escote", "Cantidad"};
        Object[][] data;
        /**
         * Constructor del modelo de datos para la JTable de camisetas.
         * @param m Lista de camiseta
         */
		
        public TablaCamisModel(HashSet<clsCamiseta> m)
        {      	
        	super();     	
    		setData(m);	
        }
        /**
         * Método con la misma implementación del constructor para poder hacer un modelo de datos de la JTable de Camisetas.
         * @param camisetas Lista de camisetas
         */
        public void setData(HashSet<clsCamiseta> camisetas) 
        {
        	int filas = camisetas.size();
    		int cont;
    		
    		data=new Object[filas][];
    		cont=0;	
    		
    		for (clsCamiseta aux : camisetas)
    		{
    			Object[]a = 
    				{
    				   new Integer(aux.getIntegerProperty(clsConstantes.CODIGODEBARRASCAMI)),
   					   new String(aux.getStringProperty(clsConstantes.NOMBRECAMI)),
   					   new Integer (aux.getIntegerProperty(clsConstantes.TALLACAMI)),
   					   new String(aux.getStringProperty(clsConstantes.COLORCAMI)),
   					   new Double (aux.getDoubleProperty(clsConstantes.PRECIOCAMI)),
   					   new Boolean(aux.getBooleanProperty(clsConstantes.ESCOTE)),
   					   new Integer(aux.getIntegerProperty(clsConstantes.CANTIDADCAMI))
    				   
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

