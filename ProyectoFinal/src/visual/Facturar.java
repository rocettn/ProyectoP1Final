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

public class Facturar extends JFrame {

	private JPanel contentPane;
	private JTextField textIdFactura;
	private JTextField textCantidadF;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		panelLogo.setBounds(10, 11, 177, 580);
		contentPane.add(panelLogo);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setIcon(new ImageIcon(Facturar.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		lblIconLogo.setBounds(10, 11, 157, 159);
		panelLogo.add(lblIconLogo);
		
		JPanel panelInfoGeneral = new JPanel();
		panelInfoGeneral.setLayout(null);
		panelInfoGeneral.setForeground(new Color(204, 204, 204));
		panelInfoGeneral.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInfoGeneral.setBackground(SystemColor.menu);
		panelInfoGeneral.setBounds(195, 11, 580, 150);
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
		panelSeleccionarComponente.setBounds(197, 172, 580, 115);
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
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(195, 298, 580, 150);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Nombre:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(42, 37, 87, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("C\u00E9dula:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(42, 62, 87, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Tel\u00E9fono:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(42, 87, 87, 14);
		panel.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(131, 34, 290, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(131, 59, 290, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(131, 84, 290, 20);
		panel.add(textField_2);
		
		JLabel label_3 = new JLabel("Direcci\u00F3n:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(42, 112, 87, 14);
		panel.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(131, 109, 290, 20);
		panel.add(textField_3);
	}
}
