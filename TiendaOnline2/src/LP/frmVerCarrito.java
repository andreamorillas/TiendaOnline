package LP;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import COMUN.clsConstantes;
import LN.ExcepcionClientesNoGuardados;
import LN.ExcepcionNoCompras;
import LN.clsCamiseta;
import LN.clsCliente;
import LN.clsCompra;
import LN.clsGestorAdministrador;
import LN.clsGestorCliente;

import java.awt.ScrollPane;
import java.io.IOException;
import java.util.HashSet;
/**
 * 
 * @author Paula y Andrea
 * Mediante esta ventana, el cliente podrá ver las compras que ha realizado.
 */

public class frmVerCarrito extends JFrame implements ActionListener
{

	
	private JTable table;
	private HashSet<clsCompra> compras;
	private String NICKNAME;
	private JScrollPane scrollPane;
	/**
	 * Constructor, donde ponemos la ventana en modo visible y llamamos al metodo correspondiente para la creación de la ventana.
	 * @throws IOException 
	 * @throws ExcepcionNoCompras 
 	 */
	public frmVerCarrito() throws IOException, ExcepcionNoCompras 
	{
		this.setVisible(true);
		
		CargarDatos();
		createAndShowGUI();
	}
	/**
	 * Metodo donde creamos la ventana a nuestro gusto
	 * @throws IOException 
	 */
	public void createAndShowGUI() throws IOException 
	{
		getContentPane().setLayout(null);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipal.class.getResource("/Image/Icono tienda.jpg")));
		
		createTable();
		
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
		btnAtras.setBounds(413, 277, 123, 34);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand("Atras");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(frmMenuCompra.class.getResource("/Image/fondo.jpg")));
		lblNewLabel.setBounds(0, 0, 553, 336);
		getContentPane().add(lblNewLabel);
		

		
		setTitle("Compra pantalón");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,200,556,367);
	}
	/**
	 *Este metodo, es un metodo que se crea por defecto al implementar el ActionListener, donde decimos al programa que debe hacer según que boton pulse el usuario.
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
	 *Metodo al que se llama cuando el suuario puksa el boton Atras.
	 * En este metodo, se hace una llamada a la ventana principal del cliente.
	 */
	private void Atras() 
	{		
		frmCliente menu= new frmCliente();
		menu.setVisible(true);
	}
	public void RecogerNick(String nickname) throws ExcepcionClientesNoGuardados, IOException
	{
		NICKNAME = nickname;
		clsCliente cliente = new clsCliente();
		clsGestorCliente objGestor=new clsGestorCliente();
		cliente = objGestor.DevolverCliente(NICKNAME);
	}
	
	/**
	 * En este metodo creamos la tabla a nuestro gusto
	 */
	public void createTable()
	{
		table=null;
		
		TablaComprasModel tab= new TablaComprasModel(compras);
		
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
	 * @throws ExcepcionNoCompras 
	 */
	private void CargarDatos() throws IOException, ExcepcionNoCompras 
	{
		clsGestorCliente objGestor=new clsGestorCliente();
	
		compras=objGestor.verCompras();
		
		System.out.println(compras.size());
		
		if(compras.size()==0)
		{
			JOptionPane.showMessageDialog(this, "Aun no hay compras");
			dispose();
		}	
		
	}
	/**
	 * Método que permite refrescar la tabla cada vez que tenga algún cambio.
	 * @throws IOException 
	 * @throws ExcepcionClientesNoGuardados 
	 */
	public void RefrescarTabla() throws IOException, ExcepcionNoCompras
	{
		CargarDatos();
		TablaComprasModel tam=(TablaComprasModel)table.getModel();
		tam.setData(compras);
		tam.fireTableDataChanged();
	}
}
/**
 * 
 * @author Paula y Andrea
 * Clase que creamos con el fin de crear la tabla.
 */
class TablaComprasModel extends AbstractTableModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] columnNames= {"Id Compra", "Cod.Barras"};
	Object [][] data;
	 /**
     * Constructor del modelo de datos para la JTable de clientes.
     * @param m Lista de clientes
     */
	public TablaComprasModel(HashSet<clsCompra>lista)
	{
		super();
		setData(lista);
	}
	/**
     * Método con la misma implementación del constructor para poder hacer un modelo de datos de la JTable de clientes.
     * @param m Lista de clientes
     */
	public void setData(HashSet<clsCompra> compras)
	{
		int filas= compras.size();
		int cont;
		
		data=new Object[filas][];
		cont=0;
		
		for (clsCompra aux : compras) 
		{
			
			Object [] a= 
					
					{
						new Integer(aux.getIntegerProperty(clsConstantes.IDCOMPRA)),
						new Integer(aux.getIntegerProperty(clsConstantes.CODIGOCOMPRA)),

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
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return data[row][col];
	}

//    public Object getValueAt(int row, int col) {
//        return data[row][col];
//    }
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//	public Class getColumnClass(int c) {
//        return getValueAt(0, c).getClass();
//    }
//    public boolean isCellEditable(int row, int col) 
//    {          
//            return false;           
//    }
//    public void setValueAt(Object value, int row, int col) 
//    {
//        
//        data[row][col] = value;
//        fireTableCellUpdated(row, col);
//    }
}
