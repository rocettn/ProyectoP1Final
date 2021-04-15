package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


import logico.TarjetaMadre;
import logico.Tienda;
import logico.Venta;
import logico.DiscoDuro;
import logico.MemoriaRam;
import logico.Microprocesador;
import logico.TarjetaMadre;
import logico.Componente;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ListarFactura extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldBuscarFact;
	private JTable table;
	public static DefaultTableModel model;
	public static Object [] fil;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ListarFactura() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarFactura.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setTitle("R&M");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 388);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(204, 204, 204));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(10, 11, 734, 294);
		contentPane.add(panel);

		JLabel labelFactura = new JLabel("Buscar Factura:");
		labelFactura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelFactura.setBounds(55, 21, 122, 22);
		panel.add(labelFactura);

		JLabel labelImagBus = new JLabel("");
		labelImagBus.setIcon(new ImageIcon(ListarFactura.class.getResource("/imagenes/Webp.net-resizeimage-Buscar.png")));
		labelImagBus.setBounds(10, 11, 68, 41);
		panel.add(labelImagBus);

		textFieldBuscarFact = new JTextField();
		textFieldBuscarFact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				  DefaultTableModel mode = (DefaultTableModel)table.getModel();
				  TableRowSorter<DefaultTableModel> tr = new
				  TableRowSorter<DefaultTableModel>(mode); table.setRowSorter(tr);
				  tr.setRowFilter(RowFilter.regexFilter(textFieldBuscarFact.getText().trim()));
				 
			}
		});
		textFieldBuscarFact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldBuscarFact.setColumns(10);
		textFieldBuscarFact.setBounds(157, 23, 184, 20);
		panel.add(textFieldBuscarFact);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 714, 193);
		panel.add(scrollPane);
		
			{
				model = new DefaultTableModel();
				String[] headers = {"Código", "Cliente", "Vendedor", "Monto Total", "Fecha", "Cant. Componente"};
				model.setColumnIdentifiers(headers);
			}

		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			
			}
		});
		buttonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonCancelar.setBounds(655, 315, 89, 23);
		contentPane.add(buttonCancelar);
		llenarTabla();
	}
	
	public static void llenarTabla() {
		model.setRowCount(0);
		fil = new Object[model.getColumnCount()];
		for (Venta f : Tienda.getInstance().getVentasTienda()) {
			fil[0] = f.getIdFactura();
			fil[1] = f.getClienteVenta().getNombre();
			fil[2] = f.getVendedorVenta().getNombre();
			fil[3] = f.getMontoTotal();
			fil[4] = f.getFecha();
			fil[5] = f.getComponentesVenta().size()+f.getCombosVenta().size();
			model.addRow(fil);
		
			
		}
		
	}
}
