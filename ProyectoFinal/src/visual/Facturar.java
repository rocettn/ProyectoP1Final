package visual;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Combo;
import logico.Componente;
import logico.Persona;
import logico.Venta;
import logico.Tienda;
import logico.Vendedor;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

public class Facturar extends JFrame {

	private JPanel contentPane;
	private JTextField textIdFactura;
	private static JTable tablaEspComp;
	private static JTextField textCedulaCliente;
	private static JLabel labelDireccionCliente;
	private static JLabel labelNombreCliente;
	private static JLabel labelTelefonoCliente;
	private static Cliente clienteTienda = null;
	private static JButton buttonBuscarCliente;
	private int seleccionado = -1;
	private static JLabel lblFechaGenerada;
	public static JLabel lblHora;
	private static JLabel lblHoraGenerada;
	private static Combo comb = null;
	private static ArrayList<Combo> combo = new ArrayList<Combo>();
	private static ArrayList<Componente> mComponente = new ArrayList<Componente>();
	private static Componente compon = null;
	private static int cant = 0;
	private JTextField textIdVendedor;
	private JLabel labelVendedorGe;
	private static JLabel labelNombreCliente_1;
	private static JLabel labelTelefonoCliente_1;
	private static JLabel labelDireccionCliente_1;
	private static float montoTotal = 0;
	public static DefaultTableModel model;
	public static Object[] fil = new Object[5];
	private static Venta aux = null;
	private JButton buttonFacturarACredito;
	private JButton btnFacturar;
	private JLabel lblMontoTotal;
	private static JLabel labelEscMontoTotal;
	private static JLabel labelEscImpuesto;
	private static JLabel labelEscTotalVenta;

	public Facturar(Venta v) {
		this.aux = v;
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {
				if (aux == null) {
					for (int i = 0; i < model.getRowCount(); i++) {
						if ('O' == ((String) model.getValueAt(i, 0)).charAt(0)) {
							Combo c = Tienda.getInstance().buscarComboTienda((String) model.getValueAt(i, 0));
							Tienda.getInstance().restarComponenteCombo(c);
							
						} else {
							Componente c = Tienda.getInstance().buscarComponenteTienda((String) model.getValueAt(i, 0));
							Tienda.getInstance().restarCantidadComponente(c, (int) model.getValueAt(i, 2));

						}
					}
				}
				clear();
				clienteTienda = null;
				dispose();
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}
		});
		setTitle("R&M");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Facturar.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 732);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JPanel panelLogo = new JPanel();
		panelLogo.setLayout(null);
		panelLogo.setForeground(new Color(204, 204, 204));
		panelLogo.setBackground(new Color(0, 153, 153));
		panelLogo.setBounds(10, 11, 183, 671);
		contentPane.add(panelLogo);

		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setIcon(new ImageIcon(Facturar.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		lblIconLogo.setBounds(12, 13, 157, 159);
		panelLogo.add(lblIconLogo);

		JPanel panelInfoGeneral = new JPanel();
		panelInfoGeneral.setLayout(null);
		panelInfoGeneral.setForeground(new Color(204, 204, 204));
		panelInfoGeneral.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Informaci\u00F3n General Factura", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInfoGeneral.setBackground(SystemColor.menu);
		panelInfoGeneral.setBounds(203, 11, 572, 109);
		contentPane.add(panelInfoGeneral);

		JLabel labelFecha = new JLabel("Fecha:");
		labelFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelFecha.setBounds(41, 22, 87, 14);
		panelInfoGeneral.add(labelFecha);

		JLabel lblIDVendedor = new JLabel("C\u00E9dula Vendedor:");
		lblIDVendedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIDVendedor.setBounds(41, 47, 110, 14);
		panelInfoGeneral.add(lblIDVendedor);

		JLabel lblId = new JLabel("ID Factura:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(41, 72, 87, 14);
		panelInfoGeneral.add(lblId);

		textIdFactura = new JTextField();
		textIdFactura.setEditable(false);
		textIdFactura.setText("R&M - " + Tienda.getInstance().getCodigoFactura());
		textIdFactura.setColumns(10);
		textIdFactura.setBounds(151, 69, 128, 20);
		panelInfoGeneral.add(textIdFactura);

		lblFechaGenerada = new JLabel("");
		Calendar inicio = new GregorianCalendar();
		inicio.setTime(new Date());
		lblFechaGenerada.setText("" + inicio.get(Calendar.DAY_OF_MONTH) + "-" + (1 + (inicio.get(Calendar.MONTH))) + "-"
				+ inicio.get(Calendar.YEAR));
		lblFechaGenerada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaGenerada.setBounds(130, 23, 149, 14);
		panelInfoGeneral.add(lblFechaGenerada);

		lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHora.setBounds(300, 22, 87, 14);
		panelInfoGeneral.add(lblHora);

		lblHoraGenerada = new JLabel("");
		Calendar time = new GregorianCalendar();
		inicio.setTime(new Date());
		lblHoraGenerada.setText("" + time.get(Calendar.HOUR_OF_DAY) + ":" + (1 + (inicio.get(Calendar.MINUTE))) + ":"
				+ inicio.get(Calendar.SECOND));
		lblHoraGenerada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHoraGenerada.setBounds(397, 22, 155, 14);
		panelInfoGeneral.add(lblHoraGenerada);

		JButton btnBuscarVendedor = new JButton("Buscar Vendedor");
		btnBuscarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Vendedor mVendedor;
				mVendedor = Tienda.getInstance().buscarVendedorTienda(textIdVendedor.getText());
				if (mVendedor != null) {
					btnBuscarVendedor.setVisible(false);
					textIdVendedor.setEditable(false);
					labelVendedorGe.setText(mVendedor.getNombre());
					labelVendedorGe.setVisible(true);
				}

				else {

					textIdVendedor.setEditable(true);
				}

			}
		});
		btnBuscarVendedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscarVendedor.setBounds(421, 72, 131, 23);
		panelInfoGeneral.add(btnBuscarVendedor);

		textIdVendedor = new JTextField();
		textIdVendedor.setColumns(10);
		textIdVendedor.setBounds(151, 44, 128, 20);
		panelInfoGeneral.add(textIdVendedor);

		JLabel lblVendedor = new JLabel("Vendedor:");
		lblVendedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVendedor.setBounds(300, 47, 67, 14);
		panelInfoGeneral.add(lblVendedor);

		labelVendedorGe = new JLabel("");
		labelVendedorGe.setBounds(381, 47, 171, 14);
		panelInfoGeneral.add(labelVendedorGe);
		labelVendedorGe.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JPanel panelSeleccionarComponente = new JPanel();
		panelSeleccionarComponente.setLayout(null);
		panelSeleccionarComponente.setForeground(new Color(204, 204, 204));
		panelSeleccionarComponente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Seleccionar Componente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSeleccionarComponente.setBackground(SystemColor.menu);
		panelSeleccionarComponente.setBounds(199, 250, 576, 122);
		contentPane.add(panelSeleccionarComponente);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comb != null) {
					combo.remove(comb);
					comb = null;
				} else {
					mComponente.remove(compon);
					Tienda.getInstance().restarCantidadComponente(compon, cant);
					compon = null;
				}
				model.removeRow(seleccionado);
				btnEliminar.setEnabled(false);
				loadTotal();
				seleccionado = -1;
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.setBounds(322, 49, 112, 23);
		panelSeleccionarComponente.add(btnEliminar);

		JButton buttonAgregarCompo = new JButton("Agregar Componente");
		buttonAgregarCompo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarComponente lc = new ListarComponente(null, 5);
				lc.setVisible(true);
			}
		});
		buttonAgregarCompo.setBounds(65, 49, 176, 23);
		panelSeleccionarComponente.add(buttonAgregarCompo);
		buttonAgregarCompo.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblImagFac = new JLabel("");
		lblImagFac.setIcon(new ImageIcon(Facturar.class.getResource("/imagenes/Webp.net-resizeimage_factura1.png")));
		lblImagFac.setBounds(483, 11, 87, 93);
		panelSeleccionarComponente.add(lblImagFac);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(204, 204, 204));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Especificaciones de componentes a comprar:", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(199, 377, 576, 155);
		contentPane.add(panel);

		JScrollPane scrollPaneEspComp = new JScrollPane();
		scrollPaneEspComp.setBounds(12, 23, 556, 114);
		panel.add(scrollPaneEspComp);

		model = new DefaultTableModel();
		String[] columns = { "ID Componente", "Nombre del Artículo", "Cantidad", "Precio" };
		model.setColumnIdentifiers(columns);
		tablaEspComp = new JTable();
		if (aux != null) {
			tablaEspComp.setRowSelectionAllowed(false);
		} else {
			tablaEspComp.setRowSelectionAllowed(true);
		}
		tablaEspComp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionado = tablaEspComp.getSelectedRow();
				int modelrow = tablaEspComp.convertRowIndexToModel(seleccionado);
				if (seleccionado != -1) {
					if ('O' == ((String) model.getValueAt(modelrow, 0)).charAt(0)) {
						btnEliminar.setEnabled(true);

						compon = null;
						comb = Tienda.getInstance().buscarComboTienda((String) model.getValueAt(modelrow, 0));
						cant = (int) model.getValueAt(modelrow, 2);
					} else {
						btnEliminar.setEnabled(true);

						compon = Tienda.getInstance().buscarComponenteTienda((String) model.getValueAt(modelrow, 0));

						cant = (int) model.getValueAt(seleccionado, 2);
						comb = null;
					}

				} else {
					btnEliminar.setEnabled(false);

				}
			}
		});
		tablaEspComp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaEspComp.setModel(model);
		scrollPaneEspComp.setViewportView(tablaEspComp);

		JPanel panelCalculoVenta = new JPanel();
		panelCalculoVenta.setLayout(null);
		panelCalculoVenta.setForeground(new Color(204, 204, 204));
		panelCalculoVenta.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"C\u00E1lculo de venta:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCalculoVenta.setBackground(SystemColor.menu);
		panelCalculoVenta.setBounds(199, 538, 576, 116);
		contentPane.add(panelCalculoVenta);

		lblMontoTotal = new JLabel("Monto Total:");
		lblMontoTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMontoTotal.setBounds(35, 26, 87, 14);
		panelCalculoVenta.add(lblMontoTotal);

		JLabel lblImpuesto = new JLabel("Impuesto (ITBIS 18%):");
		lblImpuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblImpuesto.setBounds(35, 51, 138, 14);
		panelCalculoVenta.add(lblImpuesto);

		JLabel lblTotalVenta = new JLabel("Total Venta:");
		lblTotalVenta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotalVenta.setBounds(35, 76, 87, 14);
		panelCalculoVenta.add(lblTotalVenta);

		labelEscMontoTotal = new JLabel("");
		labelEscMontoTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelEscMontoTotal.setBounds(171, 26, 115, 14);
		panelCalculoVenta.add(labelEscMontoTotal);

		labelEscImpuesto = new JLabel("");
		labelEscImpuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelEscImpuesto.setBounds(171, 51, 115, 14);
		panelCalculoVenta.add(labelEscImpuesto);

		labelEscTotalVenta = new JLabel("");
		labelEscTotalVenta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelEscTotalVenta.setBounds(171, 76, 115, 14);
		panelCalculoVenta.add(labelEscTotalVenta);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
		.setIcon(new ImageIcon(Facturar.class.getResource("/imagenes/Webp.net-resizeimage_ToltalVenta1.png")));
		lblNewLabel.setBounds(476, 13, 100, 103);
		panelCalculoVenta.add(lblNewLabel);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < model.getRowCount(); i++) {
					if ('O' == ((String) model.getValueAt(i, 0)).charAt(0)) {
						Combo c = Tienda.getInstance().buscarComboTienda((String) model.getValueAt(i, 0));
						Tienda.getInstance().restarComponenteCombo(c);
					} else {
						Componente c = Tienda.getInstance().buscarComponenteTienda((String) model.getValueAt(i, 0));
						Tienda.getInstance().restarCantidadComponente(c, (int) model.getValueAt(i, 2));

					}
				}
				clienteTienda = null;
				dispose();
				cargarFactura();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(678, 657, 97, 25);
		contentPane.add(btnCancelar);

		btnFacturar = new JButton("Facturar");
		btnFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Aceptar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea realizar la factura?");

				if (clienteTienda != null && Aceptar == JOptionPane.OK_OPTION) {
					float facturar = Float.parseFloat(JOptionPane.showInputDialog("Indique monto de pago: "));
					if (facturar >= (montoTotal + (montoTotal * 0.18f))) {
						int end = labelVendedorGe.getText().toString().indexOf("|");
						Vendedor v = Tienda.getInstance()
								.buscarVendedorTienda(textIdVendedor.getText().toString()/* .substring(0, end) */);
						Venta f = new Venta(clienteTienda, v, "R&M - " + Tienda.getInstance().getCodigoFactura(),
								montoTotal + (montoTotal * 0.18f), model.getRowCount());

						for (int i = 0; i < model.getRowCount(); i++) {
							fil[0] = model.getValueAt(i, 0).toString();
							fil[1] = model.getValueAt(i, 1).toString();
							fil[2] = Integer.parseInt(model.getValueAt(i, 2).toString());
							fil[3] = Float.parseFloat(model.getValueAt(i, 3).toString());

							f.insertarFilas(i, fil);

						}

						for (Combo c : combo) {
							f.insertarCombos(c);

						}
						for (Componente c : mComponente) {
							f.insertarComponente(c);

						}

						try {
							crearFactura(f);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						Tienda.getInstance().insertarFactura(f);
						Tienda.getInstance().setBalanceTotalAc(
								Tienda.getInstance().getBalanceTotalAc() + f.calcularSumaBeneficio());
						JOptionPane.showMessageDialog(null,
								"Su devuelta será: " + (facturar - (montoTotal + (montoTotal * 0.18f))));
						btnFacturar.setEnabled(false);

						clear();
					} else {
						JOptionPane.showMessageDialog(null,
								"La cantidad dada es menor al monto total, debe ser mayor a: "
										+ (montoTotal + (montoTotal * 0.18f)));
						btnFacturar.setEnabled(true);
					}
				}
			}

		});
		btnFacturar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFacturar.setBounds(569, 657, 97, 25);
		contentPane.add(btnFacturar);

		JPanel panelInfoCliente = new JPanel();
		panelInfoCliente.setLayout(null);
		panelInfoCliente.setForeground(new Color(204, 204, 204));
		panelInfoCliente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Informaci\u00F3n General Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInfoCliente.setBackground(SystemColor.menu);
		panelInfoCliente.setBounds(203, 123, 576, 122);
		contentPane.add(panelInfoCliente);

		JLabel labelCedulaCl = new JLabel("C\u00E9dula Cliente:");
		labelCedulaCl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelCedulaCl.setBounds(39, 23, 87, 14);
		panelInfoCliente.add(labelCedulaCl);

		JLabel lblNombre = new JLabel("Cliente:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(39, 48, 87, 14);
		panelInfoCliente.add(lblNombre);

		JLabel lblTelCliente = new JLabel("Tel\u00E9fono:");
		lblTelCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelCliente.setBounds(39, 73, 87, 14);
		panelInfoCliente.add(lblTelCliente);

		labelNombreCliente_1 = new JLabel("");
		labelNombreCliente_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelNombreCliente_1.setBounds(151, 49, 240, 14);
		panelInfoCliente.add(labelNombreCliente_1);

		labelTelefonoCliente_1 = new JLabel("");
		labelTelefonoCliente_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelTelefonoCliente_1.setBounds(151, 73, 240, 14);
		panelInfoCliente.add(labelTelefonoCliente_1);

		buttonBuscarCliente = new JButton("Buscar Cliente");
		buttonBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteRegistrar cr = new ClienteRegistrar();
				cr.setVisible(true);
			}
		});
		buttonBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonBuscarCliente.setBounds(422, 73, 128, 23);
		panelInfoCliente.add(buttonBuscarCliente);

		textCedulaCliente = new JTextField();
		textCedulaCliente.setColumns(10);
		textCedulaCliente.setBounds(152, 20, 128, 20);
		panelInfoCliente.add(textCedulaCliente);

		JLabel labelDireCl = new JLabel("Direcci\u00F3n:");
		labelDireCl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDireCl.setBounds(39, 98, 87, 14);
		panelInfoCliente.add(labelDireCl);

		labelDireccionCliente_1 = new JLabel("");
		labelDireccionCliente_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDireccionCliente_1.setBounds(151, 98, 240, 14);
		panelInfoCliente.add(labelDireccionCliente_1);

		buttonFacturarACredito = new JButton("Facturar a Cr\u00E9dito");
		buttonFacturarACredito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int Aceptar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea realizar la factura?");

				if (clienteTienda != null && Aceptar == JOptionPane.OK_OPTION) {
					
					float facturar = clienteTienda.getCreditoCliente();//Float.parseFloat(JOptionPane.showInputDialog("Indique monto de pago: "));
					if (facturar >= (montoTotal + (montoTotal * 0.18f))) {
						int end = labelVendedorGe.getText().toString().indexOf("|");
						Vendedor v = Tienda.getInstance()
								.buscarVendedorTienda(textIdVendedor.getText().toString()/* .substring(0, end) */);
						
						Venta f = new Venta(clienteTienda, v, "R&M - " + Tienda.getInstance().getCodigoFactura(),
								montoTotal + (montoTotal * 0.18f), model.getRowCount());

						for (int i = 0; i < model.getRowCount(); i++) {
							fil[0] = model.getValueAt(i, 0).toString();
							fil[1] = model.getValueAt(i, 1).toString();
							fil[2] = Integer.parseInt(model.getValueAt(i, 2).toString());
							fil[3] = Float.parseFloat(model.getValueAt(i, 3).toString());

							f.insertarFilas(i, fil);

						}

						for (Combo c : combo) {
							f.insertarCombos(c);

						}
						for (Componente c : mComponente) {
							f.insertarComponente(c);

						}

						try {
							crearFactura(f);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						Tienda.getInstance().insertarFactura(f);
						JOptionPane.showMessageDialog(null, "El credito restante para el cliente es de: "+(facturar-(montoTotal+(montoTotal*0.18f))));
						buttonFacturarACredito.setEnabled(false);

						clear();
					} else {
						JOptionPane.showMessageDialog(null, "Su credito disponible no es suficiente para pagar el total de: "+(montoTotal+(montoTotal*0.18f)));
						buttonFacturarACredito.setEnabled(true);
					}
				}


			}
		});
		buttonFacturarACredito.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonFacturarACredito.setBounds(420, 657, 139, 25);
		contentPane.add(buttonFacturarACredito);
	}

	public static void loadCliente(Cliente c) {
		clienteTienda = c;
		textCedulaCliente.setText(c.getCedula());
		textCedulaCliente.setEditable(false);
		labelNombreCliente_1.setText(c.getNombre());
		labelTelefonoCliente_1.setText(c.getTelefono());
		labelDireccionCliente_1.setText(c.getDireccion());
		buttonBuscarCliente.setVisible(false);

	}

	private static void loadTotal() {
		montoTotal = 0;
		for (int i = 0; i < tablaEspComp.getRowCount(); i++) {
			montoTotal += ((int)model.getValueAt(i, 2)*(float) model.getValueAt(i, 3));
		}
		DecimalFormat formato1 = new DecimalFormat("#.00");
		labelEscMontoTotal.setText("" + formato1.format(montoTotal));
		labelEscImpuesto.setText("" + formato1.format((montoTotal * 0.18f)));
		labelEscTotalVenta.setText("" + formato1.format((montoTotal + (montoTotal * 0.18f))));

	}

	public static void loadTabla(Object[] fila) {

		if ('O' == fila[0].toString().charAt(0)) {
			for (int i = 0; i < (int) fila[2]; i++) {
				Combo c = Tienda.getInstance().buscarComboTienda(fila[0].toString());
				combo.add(c);
			}

		} else {
			for (int i = 0; i < (int) fila[2]; i++) {
				Componente c = Tienda.getInstance().buscarComponenteTienda(fila[0].toString());
				mComponente.add(c);
			}
		}

		model.addRow(fila);
		loadTotal();
	}

	private void crearFactura(Venta f) throws IOException {

		DecimalFormat formato1 = new DecimalFormat("#.00");
		Calendar inicio = new GregorianCalendar();
		Calendar time = new GregorianCalendar();
		inicio.setTime(f.getFecha());
		try {
			File carpeta = new File("factura");
			if(!carpeta.isDirectory()) {
				carpeta.mkdir();
			}

			File fichero = new File("factura", "Factura R&M - "+Tienda.getInstance().getCodigoFactura()+".txt");
			//File fichero = new File("factura", "Factura-.txt");
			FileOutputStream fos = new FileOutputStream(fichero);

			BufferedWriter informacion = new BufferedWriter(new OutputStreamWriter(fos));
			informacion.write("-------------------------------------------------R&M--------------------------------------------------------");
			informacion.newLine();
			informacion.write("--------------------------------------Santiago de los Caballeros--------------------------------------------");
			informacion.newLine();
			informacion.newLine();
			informacion.write(String.format("%-65s %-65s",("Fecha: "+inicio.get(Calendar.DAY_OF_MONTH)+"-"+(1+(inicio.get(Calendar.MONTH)))+"-"+inicio.get(Calendar.YEAR)), "Hora: " +time.get(Calendar.HOUR_OF_DAY)+":"+(1+(inicio.get(Calendar.MINUTE)))+":"+inicio.get(Calendar.SECOND)));
			informacion.newLine();
			informacion.newLine();
			informacion.write("ID Factura:" + String.format(f.getIdFactura()));
			informacion.newLine();
			informacion.newLine();
			informacion.write("------------------------------------------DATOS GENERALES---------------------------------------------------");
			informacion.newLine();
			informacion.write(String.format("%-65s %-65s",("Cliente: "+f.getClienteVenta().getNombre()), "Vendedor: "+f.getVendedorVenta().getNombre()));
			informacion.newLine();
			informacion.write(String.format("Cedula: "+f.getClienteVenta().getCedula()));
			informacion.newLine();
			informacion.write(String.format("Telefono: "+f.getClienteVenta().getTelefono()));
			informacion.newLine();
			informacion.write(String.format("Direccion: "+f.getClienteVenta().getDireccion()));
			informacion.newLine();
			informacion.write("-----------------------------------------DETALLES DE COMPRA------------------------------------------------");
			informacion.newLine();
			informacion.write(String.format("%-20s %-30s %-30s %-20s","Codigo","Nombre del Articulo", "Cantidad", "Precio"));
			informacion.newLine();
			for(int i = 0;i<model.getRowCount();i++) {
				String codigo = (String)model.getValueAt(i, 0); 
				String nombre =(String)model.getValueAt(i, 1); 
				int cantidad = (int)model.getValueAt(i, 2); 
				float precio = (float)model.getValueAt(i, 3);
				if(nombre.length()<=20) {
					informacion.write(String.format("%-20s %-30s %-30s %-20s",codigo,nombre,cantidad,precio));
					informacion.newLine();
				}else {
					informacion.write(String.format("%-20s %-20s %-20s %-20s",codigo, nombre.substring(0, 20),cantidad,precio));
					informacion.newLine();
				}
			}
			informacion.write("------------------------------------------DETALLES DE FACTURA-------------------------------------------------");
			informacion.newLine();
			informacion.write("Monto Total: " + labelEscMontoTotal.getText().toString()/*formato1.format((f.getMontoTotal() /1.18f ))*/);
			informacion.newLine();
			informacion.write("ITBIS 18%: " + labelEscImpuesto.getText().toString()/*formato1.format((f.getMontoTotal()/1.18f)*0.18)*/);
			informacion.newLine();
			informacion.write("Total: " + labelEscTotalVenta.getText().toString()/*formato1.format(f.getMontoTotal())*/);
			informacion.newLine();
			informacion.newLine();
			informacion.newLine();
			informacion.close();
			fos.close();
		}catch (IOException e) {
			JOptionPane.showMessageDialog(null, "La carpeta de Facturas no está creada, verifique que esté creada");
		}

	}

	private void cargarFactura() {
		if (aux != null) {
			buttonBuscarCliente.setVisible(false);
			labelVendedorGe.setVisible(false);
			buttonFacturarACredito.setVisible(false);
			btnFacturar.setVisible(false);
			textCedulaCliente.setText("Cedula: " + aux.getClienteVenta().getCedula());
			labelNombreCliente_1.setText("Nombre: " + aux.getClienteVenta().getNombre());
			labelTelefonoCliente_1.setText("Telefono: " + aux.getClienteVenta().getTelefono());
			labelDireccionCliente_1.setText("Direccion: " + aux.getClienteVenta().getDireccion());
			labelVendedorGe.setText("Vendedor: " + aux.getVendedorVenta().getNombre());
			textIdFactura.setText("Factura #" + aux.getIdFactura().subSequence(2, aux.getIdFactura().length()));
			Calendar inicio = new GregorianCalendar();
			inicio.setTime(aux.getFecha());
			lblFechaGenerada.setText("" + inicio.get(Calendar.DAY_OF_MONTH) + "-" + (1 + (inicio.get(Calendar.MONTH)))
					+ "-" + inicio.get(Calendar.YEAR));
			lblHoraGenerada.setText("" + inicio.get(Calendar.HOUR_OF_DAY) + ":" + (1 + (inicio.get(Calendar.MINUTE)))
					+ ":" + inicio.get(Calendar.SECOND));
			model.setRowCount(0);
			Object[][] filas = aux.getFilas();
			for (int i = 0; i < aux.getCantidadElegida(); i++) {
				int j = 0;
				for (j = 0; j < 5; j++) {
					fil[j] = filas[i][j];
				}

				model.addRow(fil);
			}
			DecimalFormat formato1 = new DecimalFormat("#.00");
			labelEscMontoTotal.setText("Monto Total: " + formato1.format(aux.getMontoTotal() / 1.18f));
			labelEscImpuesto.setText("ITBIS (18%): " + formato1.format((aux.getMontoTotal() / 1.18f) * 0.18f));
			labelEscTotalVenta.setText("Total: " + formato1.format(aux.getMontoTotal()));
		}
	}
	
	private void clear() {
		buttonBuscarCliente.setVisible(true);
		textCedulaCliente.setText("");
		labelNombreCliente_1.setText("");
		labelTelefonoCliente_1.setText("");
		labelDireccionCliente_1.setText("");
		textIdVendedor.setText("");
		labelVendedorGe.setText("");
		model.setRowCount(0);
		clienteTienda = null;
		combo.clear();
		buttonFacturarACredito.setEnabled(false);
		btnFacturar.setEnabled(false);
		mComponente.clear();//
		compon=null;
		comb=null;
		textIdFactura.setText("R&M - "+Tienda.getInstance().getCodigoFactura());	
		Calendar inicio=new GregorianCalendar();
		inicio.setTime(new Date());
		lblFechaGenerada.setText(""+inicio.get(Calendar.DAY_OF_MONTH)+"-"+(1+(inicio.get(Calendar.MONTH)))+"-"+inicio.get(Calendar.YEAR));
		lblHoraGenerada.setText("" + inicio.get(Calendar.HOUR_OF_DAY) + ":" + (1 + (inicio.get(Calendar.MINUTE))) + ":"+ inicio.get(Calendar.SECOND));
		labelEscMontoTotal.setText("0");
		labelEscImpuesto.setText("0");
		labelEscTotalVenta.setText("0");
		
	}	
}
