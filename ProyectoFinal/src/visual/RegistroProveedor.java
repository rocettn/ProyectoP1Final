package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Componente;
import logico.MemoriaRam;
import logico.TarjetaMadre;
import logico.Microprocesador;
import logico.DiscoDuro;
import logico.Proveedor;
import logico.Tienda;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RegistroProveedor extends JFrame {

	private JPanel contentPane;
	private JTextField textIdProveedor;
	private JTextField textNombreProveedor;
	private JTextField textPaisProveedor;
	private JTable tableDisponible;
	private JTable tableAgregado;
	private int contador = 0;
	private JButton btnRegistrar;
	private JButton btnAnadir;
	private JButton btnRemover;
	private JComboBox comboBox;
	private static ArrayList<Componente>disp = new ArrayList<Componente>();
	private Componente m = null;
	private static ArrayList<Componente>agr = new ArrayList<Componente>();
	public static DefaultTableModel modelDisp;
	public static DefaultTableModel modelAgr;
	public static Object[] fil;

	public RegistroProveedor() {
		setTitle("R&M");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroProveedor.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 583);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panelInformacionGeneral = new JPanel();
		panelInformacionGeneral.setLayout(null);
		panelInformacionGeneral.setForeground(new Color(204, 204, 204));
		panelInformacionGeneral.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInformacionGeneral.setBackground(SystemColor.menu);
		panelInformacionGeneral.setBounds(10, 11, 580, 124);
		contentPane.add(panelInformacionGeneral);

		JLabel labelIdProveedor = new JLabel("ID Proveedor:");
		labelIdProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelIdProveedor.setBounds(42, 37, 87, 14);
		panelInformacionGeneral.add(labelIdProveedor);

		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelNombre.setBounds(42, 62, 87, 14);
		panelInformacionGeneral.add(labelNombre);

		JLabel lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPas.setBounds(42, 87, 87, 14);
		panelInformacionGeneral.add(lblPas);

		textIdProveedor = new JTextField();
		textIdProveedor.setColumns(10);
		textIdProveedor.setBounds(131, 34, 290, 20);
		panelInformacionGeneral.add(textIdProveedor);

		textNombreProveedor = new JTextField();
		textNombreProveedor.setColumns(10);
		textNombreProveedor.setBounds(131, 59, 290, 20);
		panelInformacionGeneral.add(textNombreProveedor);

		textPaisProveedor = new JTextField();
		textPaisProveedor.setColumns(10);
		textPaisProveedor.setBounds(131, 84, 290, 20);
		panelInformacionGeneral.add(textPaisProveedor);

		JLabel labelImagProv = new JLabel("");
		labelImagProv.setIcon(new ImageIcon(RegistroProveedor.class.getResource("/imagenes/Webp.net-resizeimage-pro.png")));
		labelImagProv.setBounds(451, 11, 119, 107);
		panelInformacionGeneral.add(labelImagProv);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTablaDisp();
				loadTablaAgr();
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Todo>", "Tarjeta Madre", "Memoria RAM", "Microprocesador", "Disco Duro"}));
		comboBox.setBounds(227, 143, 192, 20);
		contentPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("Seleccione Componente deseado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 146, 206, 14);
		contentPane.add(lblNewLabel);

		JPanel panelCompoDisponible = new JPanel();
		panelCompoDisponible.setLayout(null);
		panelCompoDisponible.setForeground(new Color(204, 204, 204));
		panelCompoDisponible.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Componente Disponible", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCompoDisponible.setBackground(SystemColor.menu);
		panelCompoDisponible.setBounds(10, 174, 580, 144);
		contentPane.add(panelCompoDisponible);

		JScrollPane scrollPaneDispo = new JScrollPane();
		scrollPaneDispo.setBounds(10, 22, 559, 111);
		panelCompoDisponible.add(scrollPaneDispo);

		modelDisp = new DefaultTableModel();
		String []columns = {"Codigo", "Tipo", "Marca", "Modelo"};
		modelDisp.setColumnIdentifiers(columns);
		tableDisponible = new JTable();
		tableDisponible.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableAgregado.clearSelection();
				int sel = tableDisponible.getSelectedRow();
				int modelrow = tableDisponible.convertRowIndexToModel(sel);
				if(sel != -1){
					btnAnadir.setEnabled(true);
					btnRemover.setEnabled(false);

					m = disp.get(sel);
				}else{
					btnAnadir.setEnabled(false);
					btnRemover.setEnabled(false);
					m = null;
				}
			}
		});
		tableDisponible.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDisponible.setModel(modelDisp);
		scrollPaneDispo.setViewportView(tableDisponible);

		btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador++;
				disp.remove(m);
				agr.add(m);
				loadTablaDisp();
				loadTablaAgr();
				btnAnadir.setEnabled(false);
				m = null;
				if(contador > 0) {
					btnRegistrar.setEnabled(true);
				}else {
					btnRegistrar.setEnabled(false);
				}
			}
		});
		btnAnadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnadir.setIcon(new ImageIcon(RegistroProveedor.class.getResource("/imagenes/Webp.net-resizeimageAbajo.png")));
		btnAnadir.setBounds(160, 324, 132, 28);
		contentPane.add(btnAnadir);

		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador--;
				disp.remove(m);
				agr.add(m);
				loadTablaDisp();
				loadTablaAgr();
				m = null;
				if(contador > 0) {
					btnRegistrar.setEnabled(true);
				}else {
					btnRegistrar.setEnabled(false);
				}
			}
		});
		btnRemover.setIcon(new ImageIcon(RegistroProveedor.class.getResource("/imagenes/Webp.net-resizeimageFlachaHaciaArriba.png")));
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRemover.setBounds(333, 324, 132, 28);
		contentPane.add(btnRemover);

		JPanel panelCompoAgregado = new JPanel();
		panelCompoAgregado.setLayout(null);
		panelCompoAgregado.setForeground(new Color(204, 204, 204));
		panelCompoAgregado.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Componente Agregado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCompoAgregado.setBackground(SystemColor.menu);
		panelCompoAgregado.setBounds(10, 358, 580, 144);
		contentPane.add(panelCompoAgregado);

		JScrollPane scrollPaneAgregado = new JScrollPane();
		scrollPaneAgregado.setBounds(10, 22, 559, 111);
		panelCompoAgregado.add(scrollPaneAgregado);

		modelAgr = new DefaultTableModel();
		String []columns2 = {"Codigo","Tipo","Marca","Modelo"};
		modelAgr.setColumnIdentifiers(columns2);
		tableAgregado = new JTable();
		tableAgregado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableDisponible.clearSelection();
				int sel = tableAgregado.getSelectedRow();
				int modelrow = tableAgregado.convertRowIndexToModel(sel);
				if(sel!=-1){
					btnAnadir.setEnabled(false);
					btnRemover.setEnabled(true);

					m = agr.get(sel);
				}else{
					btnAnadir.setEnabled(false);
					btnRemover.setEnabled(false);
					m = null;
				}
			}
		});
		tableAgregado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAgregado.setModel(modelAgr);
		scrollPaneAgregado.setViewportView(tableAgregado);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disp.removeAll(disp);
				dispose();
				loadTablaDisp();
				loadTablaAgr();
			}

		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(491, 513, 99, 23);
		contentPane.add(btnCancelar);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proveedor prov = new Proveedor(textIdProveedor.getText(), textNombreProveedor.getText(), textPaisProveedor.getText());
				Tienda.getInstance().insertarProveedor(prov);
				for(Componente com : agr) {
					prov.insertarcomponentes(com);
				}
				JOptionPane.showMessageDialog(null, "Se ha añadido satisfactoriamente el proveedor");
				limpiar();
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrar.setBounds(382, 513, 99, 23);
		contentPane.add(btnRegistrar);
	}
	private void limpiar() {
		textIdProveedor.setText("Pr-"+Tienda.getInstance().getCodigoProveedores());
		textNombreProveedor.setText("");
		textPaisProveedor.setText("");
		modelDisp.setRowCount(0);
		modelAgr.setRowCount(0);
		disp.removeAll(disp);
		for(Componente c : Tienda.getInstance().getComponentesTienda()) {
			disp.add(c);
		}
		agr.removeAll(agr);

		loadTablaDisp();
		loadTablaAgr();
	}

	private void loadTablaDisp() {
		switch(comboBox.getSelectedIndex()) {
		case 0:
			modelDisp.setRowCount(0);
			fil = new Object[modelDisp.getColumnCount()];
			for(Componente c: disp) {
				fil[0]=c.getNumeroSerie();
				if(c instanceof TarjetaMadre) {
					fil[1]="Tarjeta Madre";
				}
				if(c instanceof MemoriaRam) {
					fil[1]="Memoria RAM";
				}
				if(c instanceof Microprocesador) {
					fil[1]="Microprocesador";
				}
				if(c instanceof DiscoDuro) {
					fil[1]="Disco Duro";
				}
				fil[2]=c.getMarca();
				fil[3]=c.getModelo();
				modelDisp.addRow(fil);
			}
			break;
		case 1:
			modelDisp.setRowCount(0);
			fil = new Object[modelDisp.getColumnCount()];
			for(Componente c: disp) {
				if(c instanceof TarjetaMadre) {
					fil[0]=c.getNumeroSerie();
					fil[1]="TarjetaMadre";
					fil[2]=c.getMarca();
					fil[3]=c.getModelo();
					modelDisp.addRow(fil);
				}
			}
			break;
		case 2:
			modelDisp.setRowCount(0);
			fil = new Object[modelDisp.getColumnCount()];
			for(Componente c: disp) {
				if(c instanceof MemoriaRam) {
					fil[0]=c.getNumeroSerie();
					fil[1]="Memoria RAM";
					fil[2]=c.getMarca();
					fil[3]=c.getModelo();
					modelDisp.addRow(fil);
				}
			}
			break;
		case 3:
			modelDisp.setRowCount(0);
			fil = new Object[modelDisp.getColumnCount()];
			for(Componente c: disp) {
				if(c instanceof Microprocesador) {
					fil[0]=c.getNumeroSerie();
					fil[1]="Microprocesador";
					fil[2]=c.getMarca();
					fil[3]=c.getModelo();
					modelDisp.addRow(fil);
				}
			}
			break;
		case 4:
			modelDisp.setRowCount(0);
			fil = new Object[modelDisp.getColumnCount()];
			for(Componente c: disp) {
				if(c instanceof DiscoDuro) {
					fil[0]=c.getNumeroSerie();
					fil[1]="Disco Duro";
					fil[2]=c.getMarca();
					fil[3]=c.getModelo();
					modelDisp.addRow(fil);
				}
			}
			break;
		}

	}

	private void loadTablaAgr() {
		switch(comboBox.getSelectedIndex()) {
		case 0:
			modelAgr.setRowCount(0);
			fil = new Object[modelAgr.getColumnCount()];
			for(Componente c: agr) {
				fil[0]=c.getNumeroSerie();
				if(c instanceof TarjetaMadre) {
					fil[1]="Tarjeta Madre";
				}
				if(c instanceof MemoriaRam) {
					fil[1]="Memoria RAM";
				}
				if(c instanceof Microprocesador) {
					fil[1]="Microprocesador";
				}
				if(c instanceof DiscoDuro) {
					fil[1]="Disco Duro";
				}
				fil[2]=c.getMarca();
				fil[3]=c.getModelo();
				modelAgr.addRow(fil);
			}
			break;
		case 1:
			modelAgr.setRowCount(0);
			fil = new Object[modelAgr.getColumnCount()];
			for(Componente c: agr) {
				if(c instanceof TarjetaMadre) {
					fil[0]=c.getNumeroSerie();
					fil[1]="Tarjeta Madre";
					fil[2]=c.getMarca();
					fil[3]=c.getModelo();
					modelAgr.addRow(fil);
				}
			}
			break;
		case 2:
			modelAgr.setRowCount(0);
			fil = new Object[modelAgr.getColumnCount()];
			for(Componente c: agr) {
				if(c instanceof MemoriaRam) {
					fil[0]=c.getNumeroSerie();
					fil[1]="Memoria RAM";
					fil[2]=c.getMarca();
					fil[3]=c.getModelo();
					modelAgr.addRow(fil);
				}
			}
			break;
		case 3:
			modelAgr.setRowCount(0);
			fil = new Object[modelAgr.getColumnCount()];
			for(Componente c: agr) {
				if(c instanceof Microprocesador) {
					fil[0]=c.getNumeroSerie();
					fil[1]="Microprocesador";
					fil[2]=c.getMarca();
					fil[3]=c.getModelo();
					modelAgr.addRow(fil);
				}
			}
			break;
		case 4:
			modelAgr.setRowCount(0);
			fil = new Object[modelAgr.getColumnCount()];
			for(Componente c: agr) {
				if(c instanceof DiscoDuro) {
					fil[0]=c.getNumeroSerie();
					fil[1]="Disco Duro";
					fil[2]=c.getMarca();
					fil[3]=c.getModelo();
					modelAgr.addRow(fil);
				}
			}
			break;
		}

	}

}
