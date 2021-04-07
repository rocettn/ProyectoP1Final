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
				
			}
		});
		textBuscarEmpleado.setBounds(157, 23, 184, 20);
		panel.add(textBuscarEmpleado);
		textBuscarEmpleado.setColumns(10);
		
		JScrollPane scrollPaneTablaEmpleado = new JScrollPane();
		scrollPaneTablaEmpleado.setBounds(10, 63, 594, 193);
		panel.add(scrollPaneTablaEmpleado);
		
		tableEmpleado = new JTable();
		tableEmpleado.addMouseListener(new MouseAdapter() {
	
			
		});

		
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
		

	}
	

}
