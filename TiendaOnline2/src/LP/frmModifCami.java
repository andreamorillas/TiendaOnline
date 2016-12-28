package LP;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import COMUN.clsConstantes;
import LN.clsCamiseta;
import LN.clsGestorAdministrador;

import java.awt.Dimension;
import java.awt.Font;
/**
 * 
 * @author Paula y Andrea
 * Mediante esta clase, el admisnitrador podrá modificar los datos de una camiseta.
 */
public class frmModifCami extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtEscote;
	private JCheckBox chckboxEscote;
	
	private JComboBox<String> jcbCamisetas; 
	private JLabel lblCamisetas;
	private clsGestorAdministrador gestor;
	private JButton btnModificar;
	private JTextField txtPrecio;
	private HashSet<clsCamiseta> camisetas;
	private JTextField txtCantidad;

	private JTable table;

	private JScrollPane scrollPane;
	
	/**
	 * Constructor, donde ponemos la ventana en modo visible y llamamos al metodo correspondiente para la creación de la ventana.
	 * Además tambein creamos aqui la ventana a nuestro gusto.
	 */
	public frmModifCami() 
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
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 25, 516, 230);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPrecio.setBounds(29, 312, 46, 14);
		getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(90, 306, 60, 20);
		getContentPane().add(txtPrecio);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnModificar.setBounds(346, 309, 107, 23);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("Modificar");
		
		jcbCamisetas= new JComboBox<String>();
		jcbCamisetas.setBounds(29, 268, 121, 20);
		getContentPane().add(jcbCamisetas);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCantidad.setBounds(182, 312, 60, 14);
		getContentPane().add(lblCantidad);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAtras.setBounds(463, 309, 89, 23);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand("Atras");
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(267, 306, 41, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(frmAltaCamiseta.class.getResource("/Image/administracion.jpg")));
		lblFondo.setBounds(0, 0, 562, 343);
		getContentPane().add(lblFondo);
		
		
		lblCamisetas = new JLabel("Camisetas");
		gestor=new clsGestorAdministrador();
		HashSet<clsCamiseta> listaCamisetas = gestor.verCamisetas();
			
		
		for (clsCamiseta clsCamiseta : listaCamisetas) 
		{
			System.out.println(listaCamisetas);
			int Codigo=clsCamiseta.getIntegerProperty(clsConstantes.CODIGODEBARRASCAMI);
			String nombre=clsCamiseta.getStringProperty(clsConstantes.NOMBRECAMI);
			jcbCamisetas.addItem(Codigo + "--" + nombre);
			
			System.out.println(("Cod. Barras" + Codigo));
		}
		
		setTitle("Modificar camiseta");
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
		
			if( txtPrecio.getText().length()>0 && txtCantidad.getText().length()>0)
			{
										
				camisetas=gestor.verCamisetas();
			
				if (jcbCamisetas.getSelectedItem() != null) 
				{
					String a=(String) jcbCamisetas.getSelectedItem();
					String [] variables = a.split("-");
					int codigo = Integer.parseInt(variables[0]);

					
					for (clsCamiseta aux : camisetas) 
					{
						System.out.println(camisetas);
						
						if (aux.getIntegerProperty(clsConstantes.CODIGODEBARRASCAMI) == codigo) 
						{
							
							Double precio1 =Double.parseDouble(txtPrecio.getText());
							aux.setPrecio(precio1);

														
							int cantidad1=Integer.parseInt(txtCantidad.getText());
							aux.setCantidad(cantidad1);
							
							gestor.modificarCamiseta(camisetas);
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
	private void crearTabla()
	{	
		table=null;
		
		TablaCamisModifModel tab= new TablaCamisModifModel(camisetas);
		
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
	class TablaCamisModifModel extends AbstractTableModel
    {
		private static final long serialVersionUID = 1L;
		
		private String[] columnNames = {"Cod Barras","Nombre","Talla","Color","Precio", "Escote", "Cantidad"};
        Object[][] data;
        /**
         * Constructor del modelo de datos para la JTable de camisetas.
         * @param m Lista de camiseta
         */
		
        public TablaCamisModifModel(HashSet<clsCamiseta> m)
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
