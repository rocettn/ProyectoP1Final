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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Facturar extends JFrame {

	private JPanel contentPane;
	private JTextField textIdFactura;
	private JTextField textCantidadF;
	private JTable tablaEspComp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facturar frame = new Facturar();
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
	public Facturar() {
		setTitle("R&M");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Facturar.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 641);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setLayout(null);
		panelLogo.setForeground(new Color(204, 204, 204));
		panelLogo.setBackground(new Color(0, 153, 153));
		panelLogo.setBounds(10, 11, 183, 580);
		contentPane.add(panelLogo);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setIcon(new ImageIcon(Facturar.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		lblIconLogo.setBounds(12, 13, 157, 159);
		panelLogo.add(lblIconLogo);
		
		JPanel panelInfoGeneral = new JPanel();
		panelInfoGeneral.setLayout(null);
		panelInfoGeneral.setForeground(new Color(204, 204, 204));
		panelInfoGeneral.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInfoGeneral.setBackground(SystemColor.menu);
		panelInfoGeneral.setBounds(199, 11, 576, 150);
		contentPane.add(panelInfoGeneral);
		
		JLabel labelFecha = new JLabel("Fecha:");
		labelFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelFecha.setBounds(42, 37, 87, 14);
		panelInfoGeneral.add(labelFecha);
		
		JLabel lblVendedor = new JLabel("Vendedor:");
		lblVendedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVendedor.setBounds(42, 62, 87, 14);
		panelInfoGeneral.add(lblVendedor);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCliente.setBounds(42, 87, 87, 14);
		panelInfoGeneral.add(lblCliente);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(42, 112, 87, 14);
		panelInfoGeneral.add(lblId);
		
		textIdFactura = new JTextField();
		textIdFactura.setColumns(10);
		textIdFactura.setBounds(131, 109, 121, 20);
		panelInfoGeneral.add(textIdFactura);
		
		JLabel lblFechaGenerada = new JLabel("");
		lblFechaGenerada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaGenerada.setBounds(131, 38, 149, 14);
		panelInfoGeneral.add(lblFechaGenerada);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHora.setBounds(301, 37, 87, 14);
		panelInfoGeneral.add(lblHora);
		
		JLabel lblHoraGenerada = new JLabel("");
		lblHoraGenerada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHoraGenerada.setBounds(398, 37, 155, 14);
		panelInfoGeneral.add(lblHoraGenerada);
		
		JLabel labelVendedorGe = new JLabel("");
		labelVendedorGe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelVendedorGe.setBounds(131, 63, 263, 14);
		panelInfoGeneral.add(labelVendedorGe);
		
		JLabel labelClienteGen = new JLabel("");
		labelClienteGen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelClienteGen.setBounds(131, 87, 263, 14);
		panelInfoGeneral.add(labelClienteGen);
		
		JButton btnBuscarVendedor = new JButton("Buscar Vendedor");
		btnBuscarVendedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscarVendedor.setBounds(425, 62, 128, 23);
		panelInfoGeneral.add(btnBuscarVendedor);
		
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscarCliente.setBounds(425, 87, 128, 23);
		panelInfoGeneral.add(btnBuscarCliente);
		
		JPanel panelSeleccionarComponente = new JPanel();
		panelSeleccionarComponente.setLayout(null);
		panelSeleccionarComponente.setForeground(new Color(204, 204, 204));
		panelSeleccionarComponente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccionar Componente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSeleccionarComponente.setBackground(SystemColor.menu);
		panelSeleccionarComponente.setBounds(199, 162, 576, 116);
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
		panel.setBounds(199, 281, 576, 150);
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
		panelCalculoVenta.setBounds(199, 432, 576, 116);
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
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(674, 561, 97, 25);
		contentPane.add(btnCancelar);
		
		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFacturar.setBounds(565, 561, 97, 25);
		contentPane.add(btnFacturar);
	}
}
