package visual;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.OrdenCompra;
import logico.Tienda;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarOrdenCompra extends JFrame {

	private JPanel contentPane;
	private JTable tableOrdenCompra;
	public static DefaultTableModel model;
	public static Object [] fil;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ListarOrdenCompra() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarOrdenCompra.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setTitle("R&M");
		setBounds(100, 100, 850, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelOrdenCompra = new JPanel();
		panelOrdenCompra.setLayout(null);
		panelOrdenCompra.setForeground(new Color(204, 204, 204));
		panelOrdenCompra.setBackground(SystemColor.menu);
		panelOrdenCompra.setBounds(10, 130, 814, 240);
		contentPane.add(panelOrdenCompra);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 794, 216);
		panelOrdenCompra.add(scrollPane);

		model = new DefaultTableModel();
		String columns[] = {"Id Componente","Total","Proveedor","Administrador","Cantidad Pedida","Fecha"};
		model.setColumnIdentifiers(columns);
		tableOrdenCompra = new JTable();
		tableOrdenCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		tableOrdenCompra.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableOrdenCompra.setModel(model);
		scrollPane.setViewportView(tableOrdenCompra);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loadTabla();
			}
		});
		buttonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonCancelar.setBounds(735, 381, 89, 23);
		contentPane.add(buttonCancelar);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ListarOrdenCompra.class.getResource("/imagenes/MicrosoftTeams-image (3).png")));
		lblNewLabel_1.setBounds(378, 11, 149, 119);
		contentPane.add(lblNewLabel_1);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTabla();
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnActualizar.setBounds(636, 381, 89, 23);
		contentPane.add(btnActualizar);
		setLocationRelativeTo(null);
	}

	private void loadTabla() {
		model.setRowCount(0);
		fil = new Object[model.getColumnCount()];
		for(OrdenCompra c : Tienda.getInstance().getOrdenesComprasTienda()){

			fil[0]=c.getComponenteAPedir().getId();
			fil[1]=c.getTotalOrdenCompra();
			fil[2]=c.getProveedorCompra().getNombreProveedor();
			fil[3]=c.getAdminOrdenCompra().getNombre();
			fil[4] = c.getCantComponente();
			fil[5] = c.getFechaOrdenCompra();
			model.addRow(fil);


		}
	}
}
