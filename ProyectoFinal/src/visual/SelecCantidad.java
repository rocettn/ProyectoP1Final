package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class SelecCantidad extends JFrame {

	private JPanel contentPane;
	private JTextField textCantCompra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelecCantidad frame = new SelecCantidad();
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
	public SelecCantidad() {
		setTitle("R&M");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelecCantidad.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setForeground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Indicar cantidad a comprar:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 13, 557, 96);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCantCompra = new JLabel("Cantidad de componentes:");
		lblCantCompra.setBounds(111, 44, 164, 16);
		panel.add(lblCantCompra);
		
		textCantCompra = new JTextField();
		textCantCompra.setBounds(313, 41, 116, 22);
		panel.add(textCantCompra);
		textCantCompra.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de componente a comprar:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(12, 122, 557, 217);
		contentPane.add(panel_1);
		
		JLabel lblComponenteID = new JLabel("ID de componente:");
		lblComponenteID.setBounds(12, 34, 164, 16);
		panel_1.add(lblComponenteID);
		
		JLabel lblComponenteIDtext = new JLabel("");
		lblComponenteIDtext.setBounds(188, 34, 197, 16);
		panel_1.add(lblComponenteIDtext);
		
		JLabel lblMarcaDeComponente = new JLabel("Marca de componente:");
		lblMarcaDeComponente.setBounds(12, 73, 164, 16);
		panel_1.add(lblMarcaDeComponente);
		
		JLabel labelMarcaComp = new JLabel("");
		labelMarcaComp.setBounds(188, 73, 197, 16);
		panel_1.add(labelMarcaComp);
		
		JLabel lblTipoDeComponente = new JLabel("Tipo de componente:");
		lblTipoDeComponente.setBounds(12, 112, 164, 16);
		panel_1.add(lblTipoDeComponente);
		
		JLabel labelTipoComp = new JLabel("");
		labelTipoComp.setBounds(188, 112, 197, 16);
		panel_1.add(labelTipoComp);
		
		JLabel lblPrecioDeComponente = new JLabel("Precio de componente:");
		lblPrecioDeComponente.setBounds(12, 151, 164, 16);
		panel_1.add(lblPrecioDeComponente);
		
		JLabel labelPrecioComp = new JLabel("");
		labelPrecioComp.setBounds(188, 151, 197, 16);
		panel_1.add(labelPrecioComp);
		
		JLabel lblMontoTotalComp = new JLabel("Monto Total de componente:");
		lblMontoTotalComp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMontoTotalComp.setBounds(12, 191, 197, 16);
		panel_1.add(lblMontoTotalComp);
		
		JLabel labelMontoTotaltext = new JLabel("");
		labelMontoTotaltext.setBounds(213, 191, 197, 16);
		panel_1.add(labelMontoTotaltext);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SelecCantidad.class.getResource("/imagenes/Webp.net-resizeimage_seleccionar.png")));
		lblNewLabel_2.setBounds(356, 34, 138, 157);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(472, 352, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Seleccionar");
		btnNewButton_1.setBounds(343, 352, 117, 25);
		contentPane.add(btnNewButton_1);
	}
}
