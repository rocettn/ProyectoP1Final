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
import logico.DiscoDuro;
import logico.MemoriaRam;
import logico.Microprocesador;
import logico.TarjetaMadre;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarComponente extends JFrame {

	private JPanel contentPane;
	private JTextField textBuscarCompo;
	private JTable table;
	public static DefaultTableModel model;
	public static Object[] fil;
	private int sel = -1;
	private int modelFil = -1;
	private static Combo load = null;
	private Combo comb = null;
	private JButton btnAgregar;
	private static int modo = -1;


	public ListarComponente(Combo a, int b) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarComponente.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setTitle("R&M");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 397);
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
		panel.setBounds(10, 11, 614, 294);
		contentPane.add(panel);
		this.modo = b;
		this.load = a;
		JLabel lblBuscarComponente = new JLabel("Buscar Componente:");
		lblBuscarComponente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBuscarComponente.setBounds(55, 21, 122, 22);
		panel.add(lblBuscarComponente);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ListarComponente.class.getResource("/imagenes/Webp.net-resizeimage-Buscar.png")));
		label_1.setBounds(10, 11, 68, 41);
		panel.add(label_1);

		textBuscarCompo = new JTextField();
		textBuscarCompo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel mode = (DefaultTableModel)table.getModel();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(mode);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(textBuscarCompo.getText().trim()));
			}
		});
		textBuscarCompo.setColumns(10);
		textBuscarCompo.setBounds(174, 23, 184, 20);
		panel.add(textBuscarCompo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 594, 193);
		panel.add(scrollPane);

		model = new DefaultTableModel();
		String columns[] = {"ID","Tipo","Almacen","Precio","Modelo","Marca", "No. Serie"};
		model.setColumnIdentifiers(columns);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sel = table.getSelectedRow();
				modelFil = table.convertRowIndexToModel(sel);
				if(load == null) {
					if(sel!=-1 && (int)model.getValueAt(modelFil, 2)>0) {
						btnAgregar.setEnabled(true);
						if('O'==((String)model.getValueAt(modelFil, 0)).charAt(0)) {
							//btnInformacinComponente.setEnabled(true);
							comb = Tienda.getInstance().buscarComboTienda((String)model.getValueAt(modelFil, 0));
						//}else {
							//btnInformacinComponente.setEnabled(false);
						//}
					}else {
						//btnInformacinComponente.setEnabled(false);
						btnAgregar.setEnabled(false);
					}
				}else {
					btnAgregar.setEnabled(false);
					//btnInformacinComponente.setEnabled(false);

				}
			}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(model);
		scrollPane.setViewportView(table);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				cargarTablaCompo();
				//loadTable(5);
			}

		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(535, 316, 89, 23);
		contentPane.add(btnCancelar);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setEnabled(false);
		
		/*
		 * if(b == 0) { btnAgregar.setVisible(true); }else {
		 * btnAgregar.setVisible(false); }
		 */
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if('O'==((String)model.getValueAt(modelFil, 0)).charAt(0)) {
					comb = Tienda.getInstance().buscarComboTienda((String)model.getValueAt(modelFil, 0));
					SelecCantidad seleccionCantidad = new SelecCantidad(comb.getCodigoIdentCombo(),
							comb.getNombreCombo(), comb.obtenerPrecioVentaCombo()/* , 1 */);
					dispose();
					System.out.println("SelecCantidad 177");
					seleccionCantidad.setVisible(true);
					
				}else if('C'==((String)model.getValueAt(modelFil, 0)).charAt(0)){
					Componente c = Tienda.getInstance().buscarComponenteTienda((String)model.getValueAt(modelFil, 0));
					SelecCantidad seleccionCantidadComp = new SelecCantidad(c.getId(),
							c.getMarca() + " " + c.getModelo(),
							c.getPrecioVentaComponente()/* ,c.getCantActualComp() */);
					//SelecCantidad seleccionCantidadComp = new SelecCantidad(c.getId(), c.getMarca(),
							//c.getPrecioVentaComponente()/* ,c.getCantActualComp() */);
					dispose();
					seleccionCantidadComp.setVisible(true);
					
				}
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregar.setBounds(426, 315, 97, 25);
		contentPane.add(btnAgregar);
		cargarTablaCompo();
	}

	/*
	 * private void loadTable(int seleccionado) {
	 * 
	 * model.setRowCount(0);
	 * 
	 * fil = new Object[model.getColumnCount()];
	 * 
	 * if(seleccionado == 0) { cargarTablaCompo(); }
	 * 
	 * if(seleccionado == 1) { for (Componente comp :
	 * Tienda.getInstance().getComponentesTienda()) {
	 * 
	 * if(comp instanceof TarjetaMadre) {
	 * 
	 * fil[0] = comp.getNumeroSerie(); fil[1] = "Tarjeta Madre"; fil[2] =
	 * comp.getCantActualComp(); fil[3] = comp.getPrecioVentaComponente(); fil[4] =
	 * comp.getModelo(); fil[5] = comp.getMarca();
	 * 
	 * model.addRow(fil); } } }else if(seleccionado == 2) { for (Componente comp :
	 * Tienda.getInstance().getComponentesTienda()) { if(comp instanceof MemoriaRam)
	 * {
	 * 
	 * fil[0] = comp.getNumeroSerie(); fil[1] = "Memoria RAM"; fil[2] =
	 * comp.getCantActualComp(); fil[3] = comp.getPrecioVentaComponente(); fil[4] =
	 * comp.getModelo(); fil[5] = comp.getMarca();
	 * 
	 * model.addRow(fil);
	 * 
	 * } } } else if(seleccionado == 3) { for (Componente comp :
	 * Tienda.getInstance().getComponentesTienda()) { if(comp instanceof
	 * Microprocesador){ fil[0] = comp.getNumeroSerie(); fil[1] = "Microprocesador";
	 * fil[2] = comp.getCantActualComp(); fil[3] = comp.getPrecioVentaComponente();
	 * fil[4] = comp.getModelo(); fil[5] = comp.getMarca();
	 * 
	 * model.addRow(fil); } } } else if(seleccionado == 4) { for (Componente comp :
	 * Tienda.getInstance().getComponentesTienda()) { if(comp instanceof DiscoDuro)
	 * { fil[0] = comp.getNumeroSerie();
	 * 
	 * fil[1] = "Disco Duro";
	 * 
	 * fil[2] = comp.getCantActualComp(); fil[3] = comp.getPrecioVentaComponente();
	 * fil[4] = comp.getModelo(); fil[5] = comp.getMarca();
	 * 
	 * model.addRow(fil); } } } else if(seleccionado == 5 ) { for(Combo c :
	 * Tienda.getInstance().getCombosTienda()) { fil[0] = c.getCodigoIdentCombo();
	 * fil[1] = "Combo"; fil[2] = 1; fil[3] = c.obtenerPrecioVentaCombo(); fil[4] =
	 * c.getNombreCombo(); fil[5] = "Unbranded"; model.addRow(fil); } } }
	 */


	private void cargarTablaCompo() {
		model.setRowCount(0); 
		fil = new Object [model.getColumnCount()];


		//if(!modo) {
		//if(modo == null) {

			if(load == null) {
				for(Componente componenteTemp : Tienda.getInstance().getComponentesTienda()){
					fil[0] = componenteTemp.getId();
					if(componenteTemp instanceof TarjetaMadre) {
						fil[1] = "Tarjeta Madre";
					}
					if(componenteTemp instanceof MemoriaRam) {
						fil[1] = "Memoria RAM";
					}
					if(componenteTemp instanceof Microprocesador) {
						fil[1] = "Microprocesador";
					}
					if(componenteTemp instanceof DiscoDuro) {
						fil[1] = "Disco Duro";
					}

					fil[2] = componenteTemp.getcantActualComp();
					fil[3] = componenteTemp.getPrecioVentaComponente();
					fil[4] = componenteTemp.getModelo();
					fil[5] = componenteTemp.getMarca();
					fil[6] = componenteTemp.getNumeroSerie();
					model.addRow(fil);
				}
				for(Combo c : Tienda.getInstance().getCombosTienda()) {
					fil[0] = c.getCodigoIdentCombo();
					fil[1] = "Combo";
					fil[2] = 1;
					fil[3] = c.obtenerPrecioVentaCombo();
					fil[4] = c.getNombreCombo();
					fil[5] = "No aplica";
					model.addRow(fil);
				}
			}else {
				for(Componente comp : load.getComponenteCombo()){
					fil[0] = comp.getId();
					if(comp instanceof TarjetaMadre) {
						fil[1] = "Tarjeta Madre";
					}
					if(comp instanceof MemoriaRam) {
						fil[1] = "Memoria RAM";
					}
					if(comp instanceof Microprocesador) {
						fil[1] = "Microprocesador";
					}
					if(comp instanceof DiscoDuro) {
						fil[1] = "Disco Duro";
					}

					fil[2] = comp.getcantActualComp();
					fil[3] = comp.getPrecioVentaComponente();
					fil[4] = comp.getModelo();
					fil[5] = comp.getMarca();
					model.addRow(fil);
				}
			}

			/*
			 * }else { for(Componente componenteTemp : load.getComponenteCombo()){ fil[0] =
			 * componenteTemp.getId(); if(componenteTemp instanceof TarjetaMadre) { fil[1] =
			 * "Tarjeta Madre"; } if(componenteTemp instanceof MemoriaRam) { fil[1] =
			 * "Memoria RAM"; } if(componenteTemp instanceof Microprocesador) { fil[1] =
			 * "Microprocesador"; } if(componenteTemp instanceof DiscoDuro) { fil[1] =
			 * "Disco Duro"; }
			 * 
			 * fil[2] = componenteTemp.getcantActualComp(); fil[3] =
			 * componenteTemp.getPrecioVentaComponente(); fil[4] =
			 * componenteTemp.getModelo(); fil[5] = componenteTemp.getMarca(); fil[6] =
			 * componenteTemp.getNumeroSerie(); model.addRow(fil); } }
			 */
	}
}

