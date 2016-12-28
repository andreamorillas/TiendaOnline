package LP;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import LN.clsCamiseta;
import LN.clsCliente;
import LN.clsGestorAdministrador;









import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
/**
 * 
 * @author Paula y Andrea
 *En esta clase creamos a ventana de devolucion de camiseta
 */
public class frmClienteDevolucionCamiseta extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	HashSet<clsCamiseta> camisetas;
	private JTable table;
	
	/**
	 * Es el contructor, el cual pone la ventana en modo visible.
	 * Además, llama al metodo donde se va a crear la ventana.
	 */
	public frmClienteDevolucionCamiseta()
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
		createTable();
		
		getContentPane().setLayout(null);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipal.class.getResource("/Image/Icono tienda.jpg")));
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 25, 516, 230);
		contentPane.add(scrollPane);
	
		scrollPane.setViewportView(table);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnAtras.setBounds(413, 277, 123, 34);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand("Atras");
		
		JButton btnDev = new JButton("Devolver");
		btnDev.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnDev.setActionCommand("Atras");
		btnDev.setBounds(100, 277, 260, 34);
		contentPane.add(btnDev);
		btnDev.addActionListener(this);
		btnDev.setActionCommand("Devolver");
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(frmCliente.class.getResource("/Image/fondo.jpg")));
		lblFondo.setBounds(0, 0, 629, 404);
		getContentPane().add(lblFondo);
		
		setTitle("Devolución camiseta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,200,556,367);
	}
	
	/**
	 * Este metodo, e sun metodo que se crea por defecto al implementar el ActionListener, donde decimos al programa que debe hacer según que boton pulse el usuario.
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
		}
	}
	/**
	 * El programa accede a este metodo cuanod el usuario selecciona el bonton Atras.
	 * Este metodo llama a la ventana de menu de devoluciones, donde podra elgir que prenda devolver
	 */
	private void Atras() 
	{		
		frmMenuDev menu= new frmMenuDev();
		menu.setVisible(true);
	}
	/**
	 * Con este metodo, cargamos los datos procedentes del metodo verCamisetas de gestor, en una lista.
	 */
	private void CargarDatos() {
		// TODO Auto-generated method stub
		clsGestorAdministrador objGestor = new clsGestorAdministrador();
			camisetas= objGestor.verCamisetas();
			System.out.println(camisetas);
			if(camisetas.size()==0)
			{
				JOptionPane.showMessageDialog(this, "No hay camisetas registradas");
				dispose();
			}
		
	}
	/**
	 * Con este metodo creamos nuestra ventana
	 */
	public void createTable()
	{
		table=null;
		TablaDevCami tabla=new TablaDevCami(camisetas);
		
		table = new JTable(tabla);
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		table.setRowSelectionAllowed(true);
		tabla.fireTableDataChanged();
		
		
		table.setVisible(true);
	}
}
	/**
	 * 
	 * @author Paula y Andrea
	 * Clase que creamos con el fin de crear la tabla.
	 */
	class TablaDevCami extends AbstractTableModel
	{

		private static final long serialVersionUID = 1L;
		private String[] columNames = {"Cod.Barras", "Nombre", "Talla", "Color", "Precio", "Bolsillos", "Cantidad"} ;
		Object [][] data;
		 /**
         * Constructor del modelo de datos para la JTable de camisetas.
         * @param camisetas Lista de camiseta
         */
		public TablaDevCami(HashSet<clsCamiseta> camisetas)
		{
			super();
			setData(camisetas);
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
    				   new Integer (aux.getIntegerProperty(clsConstantes.CANTIDADCAMI))
    				   
    				};
    			
    			data[cont]=a;
    			cont++;
    		}
		}

		@Override
		public int getColumnCount() 
		{
			return columNames.length;
		}

		@Override
		public int getRowCount()
		{
			return data.length;
		}
		
		public String getColumnName(int col)
		{
	        return columNames[col];
	    }

	    public Object getValueAt(int row, int col)
	    {
	        return data[row][col];
	    }
		
		public Class getColumnClass(int c)
	    {
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

