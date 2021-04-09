package visual;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import logico.Cliente;
import logico.Tienda;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Facturar extends JFrame {

	private JPanel contentPane;
	private JTextField textIdFactura;
	private JTextField textCantidadF;
	private JTable tablaEspComp;
	private JTextField textIDCliente;
	private static Cliente clienteTienda = null;
	private JButton buttonBuscarCliente;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Facturar() {
		setTitle("R&M");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Facturar.class.getResource("/imagenes/MicrosoftTeams-image.png")));
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
		panelInfoGeneral.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General Factura", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInfoGeneral.setBackground(SystemColor.menu);
		panelInfoGeneral.setBounds(203, 11, 572, 109);
		contentPane.add(panelInfoGeneral);
		
		JLabel labelFecha = new JLabel("Fecha:");
		labelFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelFecha.setBounds(41, 22, 87, 14);
		panelInfoGeneral.add(labelFecha);
		
		JLabel lblVendedor = new JLabel("Vendedor:");
		lblVendedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVendedor.setBounds(41, 47, 87, 14);
		panelInfoGeneral.add(lblVendedor);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(41, 72, 87, 14);
		panelInfoGeneral.add(lblId);
		
		textIdFactura = new JTextField();
		textIdFactura.setColumns(10);
		textIdFactura.setBounds(130, 72, 121, 20);
		panelInfoGeneral.add(textIdFactura);
		
		JLabel lblFechaGenerada = new JLabel("");
		lblFechaGenerada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaGenerada.setBounds(130, 23, 149, 14);
		panelInfoGeneral.add(lblFechaGenerada);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHora.setBounds(300, 22, 87, 14);
		panelInfoGeneral.add(lblHora);
		
		JLabel lblHoraGenerada = new JLabel("");
		lblHoraGenerada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHoraGenerada.setBounds(397, 22, 155, 14);
		panelInfoGeneral.add(lblHoraGenerada);
		
		JLabel labelVendedorGe = new JLabel("");
		labelVendedorGe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelVendedorGe.setBounds(130, 48, 263, 14);
		panelInfoGeneral.add(labelVendedorGe);
		
		JButton btnBuscarVendedor = new JButton("Buscar Vendedor");
		btnBuscarVendedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscarVendedor.setBounds(424, 47, 128, 23);
		panelInfoGeneral.add(btnBuscarVendedor);
		
		JPanel panelSeleccionarComponente = new JPanel();
		panelSeleccionarComponente.setLayout(null);
		panelSeleccionarComponente.setForeground(new Color(204, 204, 204));
		panelSeleccionarComponente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccionar Componente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSeleccionarComponente.setBackground(SystemColor.menu);
		panelSeleccionarComponente.setBounds(199, 250, 576, 122);
		contentPane.add(panelSeleccionarComponente);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantidad.setBounds(39, 41, 87, 14);
		panelSeleccionarComponente.add(lblCantidad);
		
		textCantidadF = new JTextField();
		textCantidadF.setColumns(10);
		textCantidadF.setBounds(128, 39, 290, 20);
		panelSeleccionarComponente.add(textCantidadF);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.setBounds(323, 81, 128, 23);
		panelSeleccionarComponente.add(btnEliminar);
		
		JButton buttonAgregarCompo = new JButton("Agregar Componente");
		buttonAgregarCompo.setBounds(123, 81, 176, 23);
		panelSeleccionarComponente.add(buttonAgregarCompo);
		buttonAgregarCompo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblImagFac = new JLabel("");
		lblImagFac.setIcon(new ImageIcon(Facturar.class.getResource("/imagenes/Webp.net-resizeimage_factura1.png")));
		lblImagFac.setBounds(483, 11, 87, 93);
		panelSeleccionarComponente.add(lblImagFac);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(204, 204, 204));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Especificaciones de componentes a comprar:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(199, 377, 576, 155);
		contentPane.add(panel);
		
		JScrollPane scrollPaneEspComp = new JScrollPane();
		scrollPaneEspComp.setBounds(12, 23, 556, 114);
		panel.add(scrollPaneEspComp);
		
		tablaEspComp = new JTable();
		scrollPaneEspComp.setViewportView(tablaEspComp);
		
		JPanel panelCalculoVenta = new JPanel();
		panelCalculoVenta.setLayout(null);
		panelCalculoVenta.setForeground(new Color(204, 204, 204));
		panelCalculoVenta.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "C\u00E1lculo de venta:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCalculoVenta.setBackground(SystemColor.menu);
		panelCalculoVenta.setBounds(199, 538, 576, 116);
		contentPane.add(panelCalculoVenta);
		
		JLabel lblMontoTotal = new JLabel("Monto Total:");
		lblMontoTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMontoTotal.setBounds(35, 26, 87, 14);
		panelCalculoVenta.add(lblMontoTotal);
		
		JLabel lblImpuesto = new JLabel("Impuesto:");
		lblImpuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblImpuesto.setBounds(35, 51, 87, 14);
		panelCalculoVenta.add(lblImpuesto);
		
		JLabel lblTotalVenta = new JLabel("Total Venta:");
		lblTotalVenta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotalVenta.setBounds(35, 76, 87, 14);
		panelCalculoVenta.add(lblTotalVenta);
		
		JLabel labelEscMontoTotal = new JLabel("");
		labelEscMontoTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelEscMontoTotal.setBounds(134, 26, 152, 14);
		panelCalculoVenta.add(labelEscMontoTotal);
		
		JLabel labelEscImpuesto = new JLabel("");
		labelEscImpuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelEscImpuesto.setBounds(134, 51, 152, 14);
		panelCalculoVenta.add(labelEscImpuesto);
		
		JLabel labelEscTotalVenta = new JLabel("");
		labelEscTotalVenta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelEscTotalVenta.setBounds(134, 76, 152, 14);
		panelCalculoVenta.add(labelEscTotalVenta);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Facturar.class.getResource("/imagenes/Webp.net-resizeimage_ToltalVenta1.png")));
		lblNewLabel.setBounds(476, 13, 100, 103);
		panelCalculoVenta.add(lblNewLabel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(678, 657, 97, 25);
		contentPane.add(btnCancelar);
		
		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFacturar.setBounds(569, 657, 97, 25);
		contentPane.add(btnFacturar);
		
		JPanel panelInfoCliente = new JPanel();
		panelInfoCliente.setLayout(null);
		panelInfoCliente.setForeground(new Color(204, 204, 204));
		panelInfoCliente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInfoCliente.setBackground(SystemColor.menu);
		panelInfoCliente.setBounds(203, 123, 576, 122);
		contentPane.add(panelInfoCliente);
		
		JLabel labelIDCliente = new JLabel("ID Cliente:");
		labelIDCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelIDCliente.setBounds(39, 23, 87, 14);
		panelInfoCliente.add(labelIDCliente);
		
		JLabel lblNombre = new JLabel("Cliente:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(39, 48, 87, 14);
		panelInfoCliente.add(lblNombre);
		
		JLabel lblTelCliente = new JLabel("Tel\u00E9fono:");
		lblTelCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelCliente.setBounds(39, 73, 87, 14);
		panelInfoCliente.add(lblTelCliente);
		
		JLabel labelNombreCliente = new JLabel("");
		labelNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelNombreCliente.setBounds(128, 49, 263, 14);
		panelInfoCliente.add(labelNombreCliente);
		
		JLabel labelTelefonoCliente = new JLabel("");
		labelTelefonoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelTelefonoCliente.setBounds(128, 73, 263, 14);
		panelInfoCliente.add(labelTelefonoCliente);
		
		buttonBuscarCliente = new JButton("Buscar Cliente");
		buttonBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteRegistrar cr = new ClienteRegistrar();
				cr.setVisible(true);
				/*
				 * Cliente mClientes; mClientes =
				 * Tienda.getInstance().buscarClienteTienda(textIDCliente.getText());
				 * if(mClientes != null) { buttonBuscarCliente.setVisible(false);
				 * textIDCliente.setEditable(false);
				 * labelNombreCliente.setText(mClientes.getNombre());
				 * labelTelefonoCliente.setText(mClientes.getTelefono());
				 * labelDireccionCliente.setText(mClientes.getDireccion());
				 * 
				 * }
				 * 
				 * else { labelNombreCliente.setEditable(true);
				 * labelTelefonoCliente.setEditable(true);
				 * labelDireccionCliente.setEditable(true);
				 * 
				 * }
				 */
			}
		});
		buttonBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonBuscarCliente.setBounds(422, 73, 128, 23);
		panelInfoCliente.add(buttonBuscarCliente);
		
		textIDCliente = new JTextField();
		textIDCliente.setColumns(10);
		textIDCliente.setBounds(128, 21, 121, 20);
		panelInfoCliente.add(textIDCliente);
		
		JLabel labelDireCl = new JLabel("Direcci\u00F3n:");
		labelDireCl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDireCl.setBounds(39, 98, 87, 14);
		panelInfoCliente.add(labelDireCl);
		
		JLabel labelDireccionCliente = new JLabel("");
		labelDireccionCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDireccionCliente.setBounds(128, 98, 263, 14);
		panelInfoCliente.add(labelDireccionCliente);
	}
	
	public static void loadCliente(Cliente c) {
		
		
		/*
		 * clienteTienda = c; textIDCliente.(c.getText());
		 * labelNombreCliente.setText(c.getNombre());
		 * labelTelefonoCliente.setText(c.getTelefono());
		 * labelDireccionCliente.setText(c.getDireccion()); CreditoClienteTienda(c));
		 * buttonBuscarCliente.setVisible(false);
		 */
		 
		 
		
	}
}
