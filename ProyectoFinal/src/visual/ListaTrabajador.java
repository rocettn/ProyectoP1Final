package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import logico.*;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ListaTrabajador extends JFrame {

	private JPanel contentPane;
	private JTextField textBuscarEmpleado;
	private JTable tableEmpleado;
	public static DefaultTableModel model;
	private int modelfila = -1;
	private Vendedor vend = null;
	private Administrador adm = null;
	private JButton btnVenta;
	public static Object[] row;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaTrabajador frame = new ListaTrabajador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListaTrabajador() {
		setTitle("R&M");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 391);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(204, 204, 204));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(10, 11, 614, 294);
		contentPane.add(panel);
		
		JLabel lblBuscarEmpleado = new JLabel("Buscar Empleado:");
		lblBuscarEmpleado.setBounds(55, 21, 122, 22);
		panel.add(lblBuscarEmpleado);
		lblBuscarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblImagenBuscar = new JLabel("");
		lblImagenBuscar.setBounds(10, 11, 68, 41);
		panel.add(lblImagenBuscar);
		lblImagenBuscar.setIcon(new ImageIcon(ListaTrabajador.class.getResource("/imagenes/Webp.net-resizeimage-Buscar.png")));
		
		textBuscarEmpleado = new JTextField();
		textBuscarEmpleado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel mode = (DefaultTableModel)table.getModel();
				TableRowSorter<DefaultTableModel> m = new TableRowSorter<DefaultTableModel>(mode);
				table.setRowSorter(m);
				m.setRowFilter(RowFilter.regexFilter(textBuscarEmpleado.getText().trim()));
			}
		});
		textBuscarEmpleado.setBounds(157, 23, 184, 20);
		panel.add(textBuscarEmpleado);
		textBuscarEmpleado.setColumns(10);
		
		JScrollPane scrollPaneTablaEmpleado = new JScrollPane();
		scrollPaneTablaEmpleado.setBounds(10, 63, 594, 193);
		panel.add(scrollPaneTablaEmpleado);
		
		
		model = new DefaultTableModel();
		String[] columns = {"Cedula","Tipo","Nombre","Telefono","Direccion"}; 
		model.setColumnIdentifiers(columns);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int sel = tableEmpleado.getSelectedRow();
				 modelfila = tableEmpleado.convertRowIndexToModel(sel);
				if(sel!=-1 ){
					
					if(model.getValueAt(modelfila, 1).toString().equalsIgnoreCase("Vendedor")) {
						btnVenta.setEnabled(true);
						
						vend = Tienda.getInstance().buscarVendedorTienda((String)model.getValueAt(modelfila, 0));
					}else {
						btnVenta.setEnabled(false);
						adm = Tienda.getInstance().buscarAdiministradorTienda((String)model.getValueAt(modelfila, 0));
					}
					
				}else{	
					btnVenta.setEnabled(false);
					}
				
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(model);
		scrollPaneTablaEmpleado.setViewportView(table);
		


		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(535, 316, 89, 23);
		contentPane.add(btnCancelar);
		
		
		btnVenta = new JButton("Venta");
		btnVenta.setEnabled(false);
		btnVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ListadoFacturas a = new ListadoFacturas(aux);
				//a.setVisible(true);
			}
		});
		btnVenta.setBounds(436, 316, 89, 23);
		contentPane.add(btnVenta);
		loadTabla();

	}
	
	private void loadTabla() {
		//Persona m = new Vendedor("a", "a", "b", "c", "c","c", "c");
		//Tienda.getInstance().insertarPersona(m);
		model.setRowCount(0);
		//System.out.println("klk");
		row = new Object [model.getColumnCount()];
		for(Persona t : Tienda.getInstance().getPersonasTienda()) {
			if((t instanceof Vendedor) || (t instanceof Administrador)) {
				row[0]=t.getCedula();
				if(t instanceof Vendedor) {
					row[1]="Vendedor";
    
					
				}else {
					row[1]="Administrador";
				}
				row[2]=t.getNombre();
				row[3]=t.getTelefono();
				row[4]=t.getDireccion();
				model.addRow(row);
			}
		}
		
	}
}
