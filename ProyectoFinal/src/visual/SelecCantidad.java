package visual;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Combo;
import logico.Componente;
import logico.Tienda;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SelecCantidad extends JFrame {

	private JPanel contentPane;
	public static Object[] fila = new Object [5];
	private int disponibles = 1;
	private String nombreSelec ="";
	private float precioSelec = 0.0f;
	private float montoTotalSelec = 0.0f;
	private String codigoSelec = "";
	private JLabel labelPrecioComp;
	private JLabel labelMontoTotaltext;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SelecCantidad(String codigoComp, String cadena, float flo ,int ent) {
		setTitle("R&M");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelecCantidad.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setBounds(100, 100, 599, 388);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setForeground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		this.disponibles=ent;
		this.nombreSelec=cadena;
		this.precioSelec=flo;
		this.codigoSelec = codigoComp;

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Indicar cantidad a comprar:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 13, 557, 96);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCantCompra = new JLabel("Cantidad de componentes:");
		lblCantCompra.setBounds(111, 44, 164, 16);
		panel.add(lblCantCompra);
		
		JSpinner spinCantidad = new JSpinner();
		spinCantidad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				montoTotalSelec = (precioSelec*Integer.parseInt(spinCantidad.getValue().toString()));
				labelMontoTotaltext.setText("" + montoTotalSelec);
			}
		});
		spinCantidad.setModel(new SpinnerNumberModel(1, 1, disponibles, 1));
		spinCantidad.setBounds(298, 41, 117, 22);
		panel.add(spinCantidad);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de componente a comprar:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(12, 122, 557, 171);
		contentPane.add(panel_1);

		JLabel lblComponenteID = new JLabel("ID de componente:");
		lblComponenteID.setBounds(12, 34, 164, 16);
		panel_1.add(lblComponenteID);

		JLabel lblComponenteIDtext = new JLabel("" + codigoSelec);
		lblComponenteIDtext.setBounds(188, 34, 197, 16);
		panel_1.add(lblComponenteIDtext);

		JLabel lblPrecioDeComponente = new JLabel("Precio de componente:");
		lblPrecioDeComponente.setBounds(12, 78, 164, 16);
		panel_1.add(lblPrecioDeComponente);

		labelPrecioComp = new JLabel("" + precioSelec);
		labelPrecioComp.setBounds(188, 78, 197, 16);
		panel_1.add(labelPrecioComp);

		JLabel lblMontoTotalComp = new JLabel("Monto Total de componente:");
		lblMontoTotalComp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMontoTotalComp.setBounds(12, 131, 197, 16);
		panel_1.add(lblMontoTotalComp);

		montoTotalSelec = (precioSelec * Integer.parseInt(spinCantidad.getValue().toString()));
		labelMontoTotaltext = new JLabel("");
		labelMontoTotaltext.setBounds(205, 131, 197, 16);
		panel_1.add(labelMontoTotaltext);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SelecCantidad.class.getResource("/imagenes/Webp.net-resizeimage_seleccionar.png")));
		lblNewLabel_2.setBounds(397, 13, 128, 145);
		panel_1.add(lblNewLabel_2);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(472, 306, 97, 25);
		contentPane.add(btnCancelar);

		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if('O'==codigoSelec.charAt(0)) {
					Combo c = Tienda.getInstance().buscarComboTienda(codigoSelec);
					if(Tienda.getInstance().verificarCombo(c)) {
						fila[0]=codigoSelec;
						fila[1]=nombreSelec;
						fila[2]= Integer.parseInt(spinCantidad.getValue().toString());
						fila[3]=precioSelec;
						fila[4]=montoTotalSelec;
						Tienda.getInstance().agregarComboTienda(c);
						dispose();
						Facturar.loadTabla(fila);
					}else {
						JOptionPane.showMessageDialog(null, "No se encuentran las componentes necesarias para el combo."+c.getNombreCombo()
						, "Error", JOptionPane.WARNING_MESSAGE);
						dispose();
						ListarComponente lista = new ListarComponente(null, 0);
						lista.setVisible(true);
					}

				}else {
					Componente c = Tienda.getInstance().buscarComponenteTienda(codigoSelec);
					fila[0]=codigoSelec;
					fila[1]=nombreSelec;
					fila[2]= Integer.parseInt(spinCantidad.getValue().toString());
					fila[3]=precioSelec;
					fila[4]=montoTotalSelec;
					int cantidadDeCompra = Integer.parseInt(spinCantidad.getValue().toString());
					for(int i = 0;i<cantidadDeCompra;i++) {
						Tienda.getInstance().agregarComponenteTienda(c);
					}
					dispose();
					Facturar.loadTabla(fila);
				}
			}
		});
		btnSeleccionar.setBounds(342, 306, 117, 25);
		contentPane.add(btnSeleccionar);
	}
}
