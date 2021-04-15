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

import logico.Combo;
import logico.Componente;
import logico.DiscoDuro;
import logico.MemoriaRam;
import logico.Microprocesador;
import logico.TarjetaMadre;
import logico.Tienda;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RegistrarCombo extends JFrame {

	private JPanel contentPane;
	private JTextField textIdCombo;
	private JTextField textNombreCombo;
	private JTextField textPorcentajeDescuento;
	public static DefaultTableModel model;
	public static Object[] fil;
	private JTable tableDisponible;
	private JButton buttonAnadir;
	private JButton buttonRemove;
	private JButton btnRegistrar;
	private Componente cm = null;
	private JTable tableAgregado;
	public static DefaultTableModel model1;
	private ArrayList<Componente>comboAgregado = new ArrayList<Componente>();
	private int contadorC = 0;
	private int contadorCo = 0;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public RegistrarCombo() {
		setTitle("R&M");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarCombo.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JPanel panelInfGen = new JPanel();
		panelInfGen.setLayout(null);
		panelInfGen.setForeground(new Color(204, 204, 204));
		panelInfGen.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInfGen.setBackground(SystemColor.menu);
		panelInfGen.setBounds(10, 11, 580, 124);
		contentPane.add(panelInfGen);
	
		JLabel lblIdCombo = new JLabel("ID Combo:");
		lblIdCombo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdCombo.setBounds(42, 37, 87, 14);
		panelInfGen.add(lblIdCombo);

		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelNombre.setBounds(42, 62, 87, 14);
		panelInfGen.add(labelNombre);

		JLabel labelPorcientoDesc = new JLabel("Descuento %:");
		labelPorcientoDesc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelPorcientoDesc.setBounds(42, 87, 87, 14);
		panelInfGen.add(labelPorcientoDesc);

		textIdCombo = new JTextField();
		textIdCombo.setEditable(false);
		textIdCombo.setText("O - " + Tienda.getInstance().getCodigoCombo());
		textIdCombo.setEditable(false);
		textIdCombo.setColumns(10);
		textIdCombo.setBounds(131, 34, 290, 20);
		panelInfGen.add(textIdCombo);

		textNombreCombo = new JTextField();
		textNombreCombo.setColumns(10);
		textNombreCombo.setBounds(131, 59, 290, 20);
		panelInfGen.add(textNombreCombo);

		textPorcentajeDescuento = new JTextField("20");
		textPorcentajeDescuento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		textPorcentajeDescuento.setColumns(10);
		textPorcentajeDescuento.setBounds(131, 84, 290, 20);
		panelInfGen.add(textPorcentajeDescuento);

		JLabel label_ImagComb = new JLabel("");
		label_ImagComb.setIcon(new ImageIcon(RegistrarCombo.class.getResource("/imagenes/Webp.net-resizeimage_oferta.png")));
		label_ImagComb.setBounds(461, 11, 109, 107);
		panelInfGen.add(label_ImagComb);

		JLabel lblSeleccioneComponente = new JLabel("Seleccione Componente:");
		lblSeleccioneComponente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSeleccioneComponente.setBounds(10, 149, 206, 14);
		contentPane.add(lblSeleccioneComponente);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Todo>", "Tarjeta Madre", "Memoria RAM", "Microprocesador", "Disco Duro"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(comboBox.getSelectedIndex());
			}

			private void loadTable(int seleccionado) {

				model.setRowCount(0);
				fil = new Object[model.getColumnCount()];
				if(seleccionado == 0) {
					cargarTabla();
				}
				if(seleccionado == 1) {
					for (Componente comp : Tienda.getInstance().getComponentesTienda()) {

						if(comp instanceof TarjetaMadre) {

							fil[0] = comp.getNumeroSerie();	
							fil[1] = comp.getMarca();
							fil[2] = comp.getModelo();
							fil[3] = comp.getPrecioVentaComponente();
							model.addRow(fil);
						}
					}
				}else if(seleccionado == 2) {
					for (Componente comp : Tienda.getInstance().getComponentesTienda()) {
						if(comp instanceof MemoriaRam) {

							fil[0] = comp.getNumeroSerie();	
							fil[1] = comp.getMarca();
							fil[2] = comp.getModelo();
							fil[3] = comp.getPrecioVentaComponente();
							model.addRow(fil);

						}
					}
				}
				else if(seleccionado == 3) {
					for (Componente comp : Tienda.getInstance().getComponentesTienda()) {
						if(comp instanceof Microprocesador){
							fil[0] = comp.getNumeroSerie();	
							fil[1] = comp.getMarca();
							fil[2] = comp.getModelo();
							fil[3] = comp.getPrecioVentaComponente();
							model.addRow(fil);
						}
					}
				}
				else if(seleccionado == 4) {
					for (Componente comp : Tienda.getInstance().getComponentesTienda()) {
						if(comp instanceof DiscoDuro) {

							fil[0] = comp.getNumeroSerie();	
							fil[1] = comp.getMarca();
							fil[2] = comp.getModelo();
							fil[3] = comp.getPrecioVentaComponente();
							model.addRow(fil);
						}
					}
				}

			}
		});

		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(195, 146, 224, 20);
		contentPane.add(comboBox);

		JPanel panelDispo = new JPanel();
		panelDispo.setLayout(null);
		panelDispo.setForeground(new Color(204, 204, 204));
		panelDispo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Componente Disponible", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDispo.setBackground(SystemColor.menu);
		panelDispo.setBounds(10, 174, 580, 144);
		contentPane.add(panelDispo);

		JScrollPane scrollPaneDisp = new JScrollPane();
		scrollPaneDisp.setBounds(10, 22, 559, 111);
		panelDispo.add(scrollPaneDisp);

		model = new DefaultTableModel();
		String columns[] = {"Id Componente","Marca","Modelo","Precio"};
		model.setColumnIdentifiers(columns);
		tableDisponible = new JTable();
		tableDisponible.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDisponible.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableAgregado.clearSelection();
				int seleccion = tableDisponible.getSelectedRow();
				int modelrow = tableDisponible.convertRowIndexToModel(seleccion);
				if(seleccion!=-1){
					buttonAnadir.setEnabled(true);
					buttonRemove.setEnabled(false);

					cm = Tienda.getInstance().buscarComponenteTienda((String)model.getValueAt(modelrow, 0));
					if(cm==null) {
						
					}
				}else{
					buttonAnadir.setEnabled(false);
					buttonRemove.setEnabled(false);
					cm = null;
				}
			}
		});

		tableDisponible.setModel(model);
		scrollPaneDisp.setViewportView(tableDisponible);

		buttonAnadir = new JButton("A\u00F1adir");
		buttonAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contadorC++;
				comboAgregado.add(cm);
				loadTablaAnadido();
				buttonAnadir.setEnabled(false);
				if(contadorC>=2) {
					btnRegistrar.setEnabled(true);
				}else {
					btnRegistrar.setEnabled(false);
				}
				cm = null;

			}
		});
		buttonAnadir.setIcon(new ImageIcon(RegistrarCombo.class.getResource("/imagenes/Webp.net-resizeimageAbajo.png")));
		buttonAnadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonAnadir.setBounds(159, 329, 132, 28);
		contentPane.add(buttonAnadir);

		buttonRemove = new JButton("Remover");
		buttonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contadorC--;
				comboAgregado.remove(cm);
				loadTablaAnadido();

				buttonRemove.setEnabled(false);
				if(contadorC>=2) {
					btnRegistrar.setEnabled(true);
				}else {
					btnRegistrar.setEnabled(false);
				}
				cm = null;
			}
		});
		buttonRemove.setIcon(new ImageIcon(RegistrarCombo.class.getResource("/imagenes/Webp.net-resizeimageFlachaHaciaArriba.png")));
		buttonRemove.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonRemove.setBounds(332, 329, 132, 28);
		contentPane.add(buttonRemove);

		JPanel panelAgregar = new JPanel();
		panelAgregar.setLayout(null);
		panelAgregar.setForeground(new Color(204, 204, 204));
		panelAgregar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Componente Agregado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAgregar.setBackground(SystemColor.menu);
		panelAgregar.setBounds(10, 368, 580, 144);
		contentPane.add(panelAgregar);

		JScrollPane scrollPaneAgre = new JScrollPane();
		scrollPaneAgre.setBounds(10, 22, 559, 111);
		panelAgregar.add(scrollPaneAgre);

		model1 = new DefaultTableModel();
		String []columns2 = {"Id Componente","Marca","Modelo","Precio"};
		model1.setColumnIdentifiers(columns2);
		tableAgregado = new JTable();
		tableAgregado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableDisponible.clearSelection();
				int seleccion = tableAgregado.getSelectedRow();
				int modelrow = tableAgregado.convertRowIndexToModel(seleccion);
				if(seleccion!=-1){
					
					buttonAnadir.setEnabled(false);
					buttonRemove.setEnabled(true);

					cm = Tienda.getInstance().buscarComponenteTienda((String)model1.getValueAt(modelrow, 0));
				}else{
					buttonAnadir.setEnabled(false);
					buttonRemove.setEnabled(false);
					cm = null;
				}
			}
		});
		
		tableAgregado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAgregado.setModel(model1);
		scrollPaneAgre.setViewportView(tableAgregado);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textNombreCombo.getText().isEmpty()) {
					Combo aux  =  new Combo(textNombreCombo.getText(), textIdCombo.getText());

					for(Componente c : comboAgregado) {
						aux.insertarComponenteCombo(c);
					}
					Tienda.getInstance().insertarCombo(aux);
					clear();
					btnRegistrar.setEnabled(false);
					contadorCo  =0;
					JOptionPane.showMessageDialog(null, "Se ha registrado satisfactoriamente el combo.");
					dispose();

				}else {
					JOptionPane.showMessageDialog(null, "Debo colocar obligatoriamente nombre de combo","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrar.setBounds(382, 523, 99, 23);
		contentPane.add(btnRegistrar);

		JButton button_3 = new JButton("Cancelar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				dispose();
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_3.setBounds(491, 523, 99, 23);
		contentPane.add(button_3);


		if(contadorCo==0) {
			cargarTabla();
		}
		contadorCo++;
	}

	private void cargarTabla() {
		model.setRowCount(0); 
		fil = new Object [model.getColumnCount()];

		for(Componente comp : Tienda.getInstance().getComponentesTienda()){
			fil[0] = comp.getId();
			fil[1] = comp.getMarca();
			fil[2] = comp.getModelo();
			fil[3] = comp.getPrecioVentaComponente();

			model.addRow(fil);

		}
	}
	private void loadTablaAnadido() {
		model1.setRowCount(0);
		fil = new Object[model1.getColumnCount()];
		for(Componente comp: comboAgregado) {
			fil[0] = comp.getId();
			fil[1] = comp.getMarca();
			fil[2] = comp.getModelo();
			fil[3] = comp.getPrecioVentaComponente();
			model1.addRow(fil);
		}

	}
	
	private void clear() {
		textNombreCombo.setText("");
		textPorcentajeDescuento.setText("");
		comboAgregado.removeAll(comboAgregado);
		
		model1.setRowCount(0);
		cargarTabla();
	}
}
