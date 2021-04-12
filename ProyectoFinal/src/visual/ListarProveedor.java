package visual;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import logico.Combo;
import logico.Componente;
import logico.Proveedor;
import logico.Tienda;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarProveedor extends JFrame {

	private JPanel contentPane;
	private JTextField textBuscarProveedor;
	private JTable table;
	public static DefaultTableModel modeloTabPro;
	private int sel = -1;
	private int modelFil = -1;
	private Proveedor proveedor  = null; 
	public static Object [] fil; 
	private JButton buttonCompoTrae;


	public ListarProveedor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarProveedor.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 382);
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

		JLabel lblBuscarProveedor = new JLabel("Buscar Proveedor:");
		lblBuscarProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBuscarProveedor.setBounds(55, 21, 122, 22);
		panel.add(lblBuscarProveedor);

		JLabel labelIcoBuscar = new JLabel("");
		labelIcoBuscar.setIcon(new ImageIcon(ListarProveedor.class.getResource("/imagenes/Webp.net-resizeimage-Buscar.png")));
		labelIcoBuscar.setBounds(10, 11, 68, 41);
		panel.add(labelIcoBuscar);

		textBuscarProveedor = new JTextField();
		textBuscarProveedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(textBuscarProveedor.getText().trim()));
			}
		});
		textBuscarProveedor.setColumns(10);
		textBuscarProveedor.setBounds(157, 23, 184, 20);
		panel.add(textBuscarProveedor);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 594, 193);
		panel.add(scrollPane);

		modeloTabPro = new DefaultTableModel();
		String columns [] = {"ID Proveedor","Nombre","País"};
		modeloTabPro.setColumnIdentifiers(columns);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sel = table.getSelectedRow();
				modelFil = table.convertRowIndexToModel(sel);
				if(sel!=-1) {

					buttonCompoTrae.setEnabled(true);
					//btnPagar.setEnabled(true);
					proveedor = Tienda.getInstance().buscarProveedorTienda((String)modeloTabPro.getValueAt(modelFil, 0));

				}else {
					buttonCompoTrae.setEnabled(false);
					//btnPagar.setEnabled(false);

				}
			}
		});

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(modeloTabPro);
		scrollPane.setViewportView(table);

		JButton button = new JButton("Cancelar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(535, 316, 89, 23);
		contentPane.add(button);
		
		buttonCompoTrae = new JButton("Componente que ofrece");
		buttonCompoTrae.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Combo c = new Combo("Componentes que ofrece: "+proveedor.getNombreProveedor(),"compoAux");
				for(Componente a : proveedor.getComponentesSuple()) {
					c.insertarComponenteCombo(a);
				}
				ListarComponente lc = new ListarComponente();
				lc.setVisible(true);
			}
		});
		buttonCompoTrae.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonCompoTrae.setBounds(353, 317, 172, 23);
		contentPane.add(buttonCompoTrae);
		loadTabla();
	}
	

	private void loadTabla() {
		modeloTabPro.setRowCount(0); 
		fil = new Object [modeloTabPro.getColumnCount()];

		for(Proveedor proveed : Tienda.getInstance().getProveedoresTienda()){

			fil[0] = proveed.getIdProveedor();
			fil[1] = proveed.getNombreProveedor();
			fil[2] = proveed.getPais();
			modeloTabPro.addRow(fil);
		}

	}
}
