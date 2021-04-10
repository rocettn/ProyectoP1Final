package visual;

import java.awt.BorderLayout;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import logico.Tienda;
import logico.Cliente;
import logico.Venta;
import logico.Persona;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ListarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textBuscarCliente;
	private JTable table;
	public static DefaultTableModel modelCliente;
	private int modelf = -1;
	private static Cliente auxiliar = null;
	private JButton btnPagarDeuda;
	public static Object[] filaCliente;
	private JButton btnElegir;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ListarCliente() {
		setTitle("R&M");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarCliente.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 389);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(204, 204, 204));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(10, 11, 662, 294);
		contentPane.add(panel);
		
		JLabel lblBuscarCliente = new JLabel("Buscar Cliente:");
		lblBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBuscarCliente.setBounds(55, 21, 122, 22);
		panel.add(lblBuscarCliente);
		
		JLabel lblImagCli = new JLabel("");
		lblImagCli.setIcon(new ImageIcon(ListarCliente.class.getResource("/imagenes/Webp.net-resizeimage-Buscar.png")));
		lblImagCli.setBounds(10, 11, 68, 41);
		panel.add(lblImagCli);
		
		textBuscarCliente = new JTextField();
		textBuscarCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel mode = (DefaultTableModel)table.getModel();
				TableRowSorter<DefaultTableModel> m = new TableRowSorter<DefaultTableModel>(mode);
				table.setRowSorter(m);
				m.setRowFilter(RowFilter.regexFilter(textBuscarCliente.getText().trim()));
			}
		});
		textBuscarCliente.setColumns(10);
		textBuscarCliente.setBounds(157, 23, 184, 20);
		panel.add(textBuscarCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 642, 193);
		panel.add(scrollPane);
		
		modelCliente = new DefaultTableModel();
		String[] columns = {"Cedula","Nombre","Telefono","Direccion", "Crédito Pendiente"}; 
		modelCliente.setColumnIdentifiers(columns);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccionado = table.getSelectedRow();
				int modelrow = table.convertRowIndexToModel(seleccionado);
				//if(modelf==0) {
				if(modelrow!=-1){
					btnElegir.setEnabled(true);
					btnPagarDeuda.setEnabled(true);
					System.out.println(modelrow);
					auxiliar = Tienda.getInstance().buscarClienteTienda((String)modelCliente.getValueAt(modelrow, 0));
					
					
				}else{	
					btnElegir.setEnabled(false);
					btnPagarDeuda.setEnabled(false);
					}
				}/*else 
					btnElegir.setEnabled(false);
					btnPagarDeuda.setEnabled(true);
				}*/
				
			//}
		});
				
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(modelCliente);			
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(535, 316, 89, 23);
		contentPane.add(button);
		
		btnPagarDeuda = new JButton("Pagar Deuda del Cliente");
		btnPagarDeuda.setEnabled(false);
		if(modelf==0) {
			btnPagarDeuda.setVisible(false);
		
		}else {
			btnPagarDeuda.setVisible(true);
			
		}
		btnPagarDeuda = new JButton("Pagar");
		btnPagarDeuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Desea realizar el pago de su Crédito?");
				if(opcion==JOptionPane.OK_OPTION) {
					Tienda.getInstance().PagarDeudaCliente(auxiliar);
					JOptionPane.showMessageDialog(null, "Pago realizado satisfactoriamente");
					loadTabla();
				}else {
					loadTabla();
				}
			}
		});
		btnPagarDeuda.setBounds(436, 316, 89, 23);
		contentPane.add(btnPagarDeuda);
		
		btnElegir = new JButton("Elegir");
		btnElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturar.loadCliente(auxiliar);
				dispose();
			}
		});
		btnElegir.setBounds(337, 316, 89, 23);
		contentPane.add(btnElegir);
		loadTabla();
	}
	

	private void loadTabla() {
		modelCliente.setRowCount(0);
		filaCliente = new Object[modelCliente.getColumnCount()];
		for(Persona p : Tienda.getInstance().getPersonasTienda()){
			if(p instanceof Cliente) {
			Cliente c = (Cliente) p;	
			filaCliente[0] = c.getCedula();
			filaCliente[1] = c.getNombre();
			filaCliente[2] = c.getTelefono();
			filaCliente[3] = c.getDireccion();
			filaCliente[4] = Tienda.getInstance().CreditoClienteTienda(c);
			modelCliente.addRow(filaCliente);
		}
		
	}
	}
}
