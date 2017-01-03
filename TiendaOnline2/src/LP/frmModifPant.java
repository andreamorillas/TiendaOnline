package LP;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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
import LN.clsPantalon;
/**
 * 
 * @author Paula y Andrea
 * Mediante esta clase, el admisnitrador podrá modificar los datos de un pantalon.
 */
public class frmModifPant extends JFrame implements ActionListener
{

	private JLabel lblPantalones;
	private JComboBox<String> jcbPantalones;
	private clsGestorAdministrador gestor;
	private JButton btnModificar;
	
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private HashSet<clsPantalon> pantalones;
	private JScrollPane scrollPane;
	
	private JTable table;
	
	
	/**
	 * Constructor, donde ponemos la ventana en modo visible y llamamos al metodo correspondiente para la creación de la ventana.
	 * Además tambein creamos aqui la ventana a nuestro gusto.
	 */
	public frmModifPant() 
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
		
		jcbPantalones= new JComboBox<String>();
		jcbPantalones.setBounds(29, 268, 121, 20);
		getContentPane().add(jcbPantalones);
		
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
		
		
		lblPantalones = new JLabel("PAntalones");
		gestor=new clsGestorAdministrador();
		HashSet<clsPantalon> listaPantalones = gestor.verPantalones();
			
		
		for (clsPantalon clsPantalon : listaPantalones) 
		{
			System.out.println(listaPantalones);
			int Codigo=clsPantalon.getIntegerProperty(clsConstantes.CODIGODEBARRASPANT);
			String nombre=clsPantalon.getStringProperty(clsConstantes.NOMBREPANT);
			jcbPantalones.addItem(Codigo + "--" + nombre);
			
			System.out.println(("Cod. Barras" + Codigo));
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
		
			if( txtPrecio.getText().length()>0 && txtCantidad.getText().length()>0)
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
													
							Double precio1 =Double.parseDouble(txtPrecio.getText());
							clsPantalon.setPrecio(precio1);

							int cantidad1=Integer.parseInt(txtCantidad.getText());
							clsPantalon.setCantidad(cantidad1);
							

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
	
	private void crearTabla()
	{	
		table=null;
		
		TablaPantModifModel tab= new TablaPantModifModel(pantalones);
		
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
		
		pantalones=objGestor.verPantalones();
		
		if(pantalones.size()==0)
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
	class TablaPantModifModel extends AbstractTableModel
    {
		private static final long serialVersionUID = 1L;
		
		private String[] columnNames = {"Cod Barras","Nombre","Talla","Color","Precio", "Escote", "Cantidad"};
        Object[][] data;
        /**
         * Constructor del modelo de datos para la JTable de camisetas.
         * @param m Lista de camiseta
         */
		
        public TablaPantModifModel(HashSet<clsPantalon> m)
        {      	
        	super();     	
    		setData(m);	
        }
        /**
         * Método con la misma implementación del constructor para poder hacer un modelo de datos de la JTable de Camisetas.
         * @param camisetas Lista de camisetas
         */
        public void setData(HashSet<clsPantalon> pantalones) 
        {
        	int filas = pantalones.size();
    		int cont;
    		
    		data=new Object[filas][];
    		cont=0;	
    		
    		for (clsPantalon aux : pantalones)
    		{
    			Object[]a = 
    				{
    				   new Integer(aux.getStringProperty(clsConstantes.CODIGODEBARRASPANT)),
   					   new String(aux.getStringProperty(clsConstantes.NOMBREPANT)),
   					   new Integer (aux.getIntegerProperty(clsConstantes.TALLAPANT)),
   					   new String(aux.getStringProperty(clsConstantes.COLORPANT)),
   					   new Double (aux.getDoubleProperty(clsConstantes.PRECIOPANT)),
   					   new Boolean(aux.getBooleanProperty(clsConstantes.BOLSILLOS)),
   					   new Integer(aux.getIntegerProperty(clsConstantes.CANTIDADPANT))
    				   
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
