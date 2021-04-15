package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Componente;
import logico.DiscoDuro;
import logico.MemoriaRam;
import logico.Microprocesador;
import logico.OrdenCompra;
import logico.Proveedor;
import logico.TarjetaMadre;
import logico.Tienda;

public class ListarGenerarOrden extends JFrame {

	private JPanel contentPane;
	public static DefaultTableModel model;
	public static Object[] fil;
	private JTable tablaListarGeOrden;
	private Componente componenteAPedir = null;
	private Proveedor proveedorAPedir = null;
	private int seleccionado = -1;
	private int modelfil = -1;
	private JButton btnElegir;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ListarGenerarOrden() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarOrdenCompra.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setTitle("R&M");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelOrdenCompra = new JPanel();
		panelOrdenCompra.setLayout(null);
		panelOrdenCompra.setForeground(new Color(204, 204, 204));
		panelOrdenCompra.setBackground(SystemColor.menu);
		panelOrdenCompra.setBounds(10, 130, 692, 240);
		contentPane.add(panelOrdenCompra);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 668, 216);
		panelOrdenCompra.add(scrollPane);

		model = new DefaultTableModel();
		String columns[] = {"Tipo","Cant.Mínima","Cant. Real","Cant. Máxima","Id componente","Modelo","Marca"};
		model.setColumnIdentifiers(columns);
		tablaListarGeOrden = new JTable();
		tablaListarGeOrden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionado = tablaListarGeOrden.getSelectedRow();
				modelfil = tablaListarGeOrden.convertRowIndexToModel(seleccionado);
					if(seleccionado!=-1 ) {
						
						btnElegir.setEnabled(true);
						componenteAPedir = Tienda.getInstance().buscarComponenteTienda(model.getValueAt(seleccionado, 4).toString());
					}else {
						btnElegir.setEnabled(false);
					}
			}
		});
		tablaListarGeOrden.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaListarGeOrden.setModel(model);
		scrollPane.setViewportView(tablaListarGeOrden);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loadTabla();
			}
		});
		buttonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonCancelar.setBounds(613, 381, 89, 23);
		contentPane.add(buttonCancelar);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ListarOrdenCompra.class.getResource("/imagenes/MicrosoftTeams-image (3).png")));
		lblNewLabel_1.setBounds(301, 0, 149, 119);
		contentPane.add(lblNewLabel_1);
		
		btnElegir = new JButton("Elegir");
		btnElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proveedorAPedir  = Tienda.getInstance().buscarProveedorDeComponente(componenteAPedir.getId());
				if(proveedorAPedir !=null) {
				GenerarOrden a = new GenerarOrden (componenteAPedir,proveedorAPedir);
				dispose();
				a.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "No se encuentra proveedor que supla dicha componente.", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
			}
			}
		});
		btnElegir.setBounds(504, 380, 97, 25);
		contentPane.add(btnElegir);
		setLocationRelativeTo(null);
	}

	private void loadTabla() {
		model.setRowCount(0);
		fil = new Object[model.getColumnCount()];
		for(Componente comp : Tienda.getInstance().getComponentesTienda()){
			if(comp.chequeoCantMinComp()) {
				
				if(comp instanceof TarjetaMadre) {
					fil[0] = "Tarjeta Madre";
				}
				if(comp instanceof MemoriaRam) {
					fil[0] = "Memoria RAM";
				}
				if(comp instanceof Microprocesador) {
					fil[0] = "Microprocesador";
				}
				if(comp instanceof DiscoDuro) {
					fil[0] = "Disco Duro";
				}
			fil[1] = comp.getCantMinimaComp();
			fil[2] = comp.getCantActualComp();
			fil[3] = comp.getCantMaximaComp();
			fil[4] = comp.getId();
			fil[5] = comp.getModelo();
			fil[6] = comp.getMarca();
			model.addRow(fil);
		}
		
	}
	}
	}

