package LP;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import COMUN.clsConstantes;
import DATOS.itfDatos;
import LN.clsGestorAdministrador;
import LN.clsPantalon;
/**
 * 
 * @author Paula y Andrea
 *En esta clase creamos a ventana de compra de pantalon
 */

public class frmClienteCompraPantalon extends JFrame implements ActionListener
{

	static HashSet<clsPantalon> pantalones;
	static JTable table;
	
	private JScrollPane scrollPant;
	/**
	 * Es el constructor, el cual pone la ventana en modo visible.
	 * Además, llama al metodo donde se va a crear la ventana.
	 */
	public frmClienteCompraPantalon()
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
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipal.class.getResource("/Image/Icono tienda.jpg")));
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPant = new JScrollPane();
		scrollPant.setBounds(20, 25, 516, 230);
		contentPane.add(scrollPant);

		scrollPant.setViewportView(table);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnAtras.setBounds(413, 277, 123, 34);
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(frmMenuCompra.class.getResource("/Image/fondo.jpg")));
		lblNewLabel.setBounds(0, 0, 553, 336);
		getContentPane().add(lblNewLabel);
		
		setTitle("Compra pantalón");
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
		
		case "Comprar":
			frmHilo hilo=new frmHilo();
			hilo.setVisible(true);
			break;
		
		}
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
	public void createTable()
	{
		table=null;
		
		TablaPantModel tab= new TablaPantModel(pantalones);
		
		table=new JTable(tab);
		table.setPreferredScrollableViewportSize(new Dimension(500,70));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		tab.fireTableDataChanged();
	}
	/**
	 * Con este metodo, cargamos los datos procedentes del metodo verPantalones de gestor, en una lista.
	 */
	private void CargarDatos()
	{
		clsGestorAdministrador objGestor=new clsGestorAdministrador();
	
		pantalones=objGestor.verPantalones();
		
		if(pantalones.size()==0)
		{
			JOptionPane.showMessageDialog(this, "No hay pantalones registrados");
			dispose();
		}
	}
	
}
/**
 * 
 * @author Paula y Andrea
 * Clase que creamos con el fin de crear la tabla.
 */
class TablaPantModel extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	
	private String[] columnNames= {"Cod. Barras", "Nombre", "Talla", "Color", "Precio", "Bolsillos", "Cantidad"};
	Object [][] data;
	/**
     * Constructor del modelo de datos para la JTable de pantalones.
     * @param m Lista de pantalones
     */
	public TablaPantModel(HashSet<clsPantalon> pantalones)
	{
		super();
		setData(pantalones);
	}
	/**
     * Método con la misma implementación del constructor para poder hacer un modelo de datos de la JTable de Pantalones.
     * @param m Lista de pantalones
     */
	public void setData(HashSet<clsPantalon> pantalones)
	{
		int filas= pantalones.size();
		int cont;
		
		data=new Object[filas][];
		cont=0;
		
		for (clsPantalon clsPantalon : pantalones) 
		{
			
			Object [] a= 
					{				
					new Integer (clsPantalon.getIntegerProperty(clsConstantes.CODIGODEBARRASPANT)),
					new String (clsPantalon.getStringProperty(clsConstantes.NOMBREPANT)),
					new Integer (clsPantalon.getIntegerProperty(clsConstantes.TALLAPANT)),
					new String (clsPantalon.getStringProperty(clsConstantes.COLORPANT)),
					new Double (clsPantalon.getDoubleProperty(clsConstantes.PRECIOPANT)),
					new Boolean (clsPantalon.getBooleanProperty(clsConstantes.BOLSILLOS)),
					new Integer (clsPantalon.getIntegerProperty(clsConstantes.CANTIDADPANT))
					
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

