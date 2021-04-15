package visual;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import logico.*;
import java.awt.Toolkit;

public class Componente extends JFrame {

	private JPanel contentPane;
	private final JPanel panelInfGeneral = new JPanel();
	private JTextField textID;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textNoSerie;
	private JTextField textCanMax;
	private JTextField textCanMin;
	private JTextField textCantidadReal;
	private JTextField textPrecioCompra;
	private JTextField textPrecioVenta;
	private JTextField textTipodeConector;
	private JTextField textTipodeMemoriaRAM;
	private JTextField textConexionesDD;
	private JRadioButton rdbtnDiscoDuro;
	private JRadioButton rdbtnMicroprocesador;
	private JRadioButton rdbtnMemoriaRam;
	private JRadioButton rdbTarjetaMadre;
	private JTextField textCantidadMemoria;
	private JTextField textTipoDeMemoria;
	
	private JPanel panelTarjetaMadre;
	private JPanel panelMemoriaRAM;
	private JPanel panelMicroprocesador;
	private JLabel lblTipoConector;
	private JLabel lblVelocidadDe;
	private JTextField textTipoConectorMicro;
	private JTextField textVelocidadProcesamiento;
	private JLabel lblImagMicro;
	private JPanel panelDiscoDuro;
	private JLabel lblTipoConexionDD;
	private JLabel lblCapacidadAlm;
	private JTextField textTipoConexionDD;
	private JTextField textCapacidadAlmace;
	private JLabel lblImagDD;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Componente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Componente.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setTitle("R&M");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 548);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setForeground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		panelInfGeneral.setBackground(UIManager.getColor("Button.background"));
		panelInfGeneral.setForeground(new Color(204, 204, 204));
		panelInfGeneral.setBounds(10, 11, 612, 181);
		contentPane.add(panelInfGeneral);
		panelInfGeneral.setLayout(null);
		panelInfGeneral.setBorder(new TitledBorder(null, "Informaci\u00F3n General de Componentes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblID.setBounds(42, 37, 46, 14);
		panelInfGeneral.add(lblID);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMarca.setBounds(42, 62, 46, 14);
		panelInfGeneral.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModelo.setBounds(42, 87, 46, 14);
		panelInfGeneral.add(lblModelo);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setText("CP - " + Tienda.getInstance().getCodigoCompo());
		textID.setBounds(98, 34, 174, 20);
		panelInfGeneral.add(textID);
		textID.setColumns(10);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBounds(98, 59, 174, 20);
		panelInfGeneral.add(textMarca);
		
		textModelo = new JTextField();
		textModelo.setColumns(10);
		textModelo.setBounds(98, 84, 174, 20);
		panelInfGeneral.add(textModelo);
		
		JLabel lblNoSerie = new JLabel("No. Serie:");
		lblNoSerie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNoSerie.setBounds(42, 112, 97, 14);
		panelInfGeneral.add(lblNoSerie);
		
		JLabel lblCantidadMxima = new JLabel("Cantidad M\u00E1xima:");
		lblCantidadMxima.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantidadMxima.setBounds(292, 40, 97, 14);
		panelInfGeneral.add(lblCantidadMxima);
		
		JLabel lblCantidadMinima = new JLabel("Cantidad Minima:");
		lblCantidadMinima.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantidadMinima.setBounds(292, 65, 97, 14);
		panelInfGeneral.add(lblCantidadMinima);
		
		textNoSerie = new JTextField();
		textNoSerie.setColumns(10);
		textNoSerie.setBounds(98, 109, 174, 20);
		panelInfGeneral.add(textNoSerie);
		
		textCanMax = new JTextField();
		textCanMax.setColumns(10);
		textCanMax.setBounds(399, 37, 174, 20);
		panelInfGeneral.add(textCanMax);
		
		textCanMin = new JTextField();
		textCanMin.setColumns(10);
		textCanMin.setBounds(399, 62, 174, 20);
		panelInfGeneral.add(textCanMin);
		
		JLabel lblCantidadReal = new JLabel("Cantidad Real:");
		lblCantidadReal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantidadReal.setBounds(292, 90, 97, 14);
		panelInfGeneral.add(lblCantidadReal);
		
		JLabel lblPrecioCompra = new JLabel("Precio Compra:");
		lblPrecioCompra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecioCompra.setBounds(292, 115, 97, 14);
		panelInfGeneral.add(lblPrecioCompra);
		
		textCantidadReal = new JTextField();
		textCantidadReal.setColumns(10);
		textCantidadReal.setBounds(399, 87, 174, 20);
		panelInfGeneral.add(textCantidadReal);
		
		textPrecioCompra = new JTextField();
		textPrecioCompra.setColumns(10);
		textPrecioCompra.setBounds(399, 112, 174, 20);
		panelInfGeneral.add(textPrecioCompra);
		
		JLabel lblPrecioVenta = new JLabel("Precio Venta:");
		lblPrecioVenta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecioVenta.setBounds(157, 143, 97, 14);
		panelInfGeneral.add(lblPrecioVenta);
		
		textPrecioVenta = new JTextField();
		textPrecioVenta.setColumns(10);
		textPrecioVenta.setBounds(264, 140, 174, 20);
		panelInfGeneral.add(textPrecioVenta);
		
		JPanel panelTipoComponente = new JPanel();
		panelTipoComponente.setLayout(null);
		panelTipoComponente.setForeground(new Color(204, 204, 204));
		panelTipoComponente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Componentes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTipoComponente.setBackground(SystemColor.menu);
		panelTipoComponente.setBounds(10, 203, 612, 98);
		contentPane.add(panelTipoComponente);
		
		JPanel panelSeleccione = new JPanel();
		panelSeleccione.setLayout(null);
		panelSeleccione.setForeground(new Color(204, 204, 204));
		panelSeleccione.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSeleccione.setBackground(SystemColor.menu);
		panelSeleccione.setBounds(10, 24, 592, 59);
		panelTipoComponente.add(panelSeleccione);
		
		rdbTarjetaMadre = new JRadioButton("Tarjeta Madre");
		rdbTarjetaMadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTarjetaMadre.setVisible(true);
				panelMemoriaRAM.setVisible(false);
				panelMicroprocesador.setVisible(false);
				panelDiscoDuro.setVisible(false);
				rdbtnMemoriaRam.setSelected(false);
				rdbtnMicroprocesador.setSelected(false);
				rdbtnDiscoDuro.setSelected(false);
			}
		});
		rdbTarjetaMadre.setSelected(true);
		rdbTarjetaMadre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbTarjetaMadre.setBounds(49, 23, 109, 23);
		panelSeleccione.add(rdbTarjetaMadre);
		
		rdbtnMemoriaRam = new JRadioButton("Memoria RAM");
		rdbtnMemoriaRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTarjetaMadre.setVisible(false);
				panelMemoriaRAM.setVisible(true);
				panelMicroprocesador.setVisible(false);
				panelDiscoDuro.setVisible(false);
				rdbTarjetaMadre.setSelected(false);
				rdbtnMicroprocesador.setSelected(false);
				rdbtnDiscoDuro.setSelected(false);
			}
		});
		rdbtnMemoriaRam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnMemoriaRam.setBounds(177, 23, 109, 23);
		panelSeleccione.add(rdbtnMemoriaRam);
		
		rdbtnMicroprocesador = new JRadioButton("Microprocesador");
		rdbtnMicroprocesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTarjetaMadre.setVisible(false);
				panelMemoriaRAM.setVisible(false);
				panelMicroprocesador.setVisible(true);
				panelDiscoDuro.setVisible(false);
				rdbTarjetaMadre.setSelected(false);
				rdbtnMemoriaRam.setSelected(false);
				rdbtnDiscoDuro.setSelected(false);
			}
		});
		rdbtnMicroprocesador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnMicroprocesador.setBounds(302, 23, 141, 23);
		panelSeleccione.add(rdbtnMicroprocesador);
		
		rdbtnDiscoDuro = new JRadioButton("Disco Duro");
		rdbtnDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTarjetaMadre.setVisible(false);
				panelMemoriaRAM.setVisible(false);
				panelMicroprocesador.setVisible(false);
				panelDiscoDuro.setVisible(true);
				rdbTarjetaMadre.setSelected(false);
				rdbtnMemoriaRam.setSelected(false);
				rdbtnMicroprocesador.setSelected(false);
			}
		});
		rdbtnDiscoDuro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnDiscoDuro.setBounds(445, 23, 141, 23);
		panelSeleccione.add(rdbtnDiscoDuro);
		
		panelTarjetaMadre = new JPanel();
		panelTarjetaMadre.setLayout(null);
		panelTarjetaMadre.setForeground(new Color(204, 204, 204));
		panelTarjetaMadre.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tarjeta Madre", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTarjetaMadre.setBackground(SystemColor.menu);
		panelTarjetaMadre.setBounds(10, 313, 612, 149);
		contentPane.add(panelTarjetaMadre);
		
		JLabel lblTipoDeConector = new JLabel("Tipo de conector:");
		lblTipoDeConector.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoDeConector.setBounds(42, 43, 110, 14);
		panelTarjetaMadre.add(lblTipoDeConector);
		
		JLabel lblTipoDeMemoria = new JLabel("Tipo de Memoria RAM:");
		lblTipoDeMemoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoDeMemoria.setBounds(42, 68, 136, 14);
		panelTarjetaMadre.add(lblTipoDeMemoria);
		
		JLabel lblListaDeConexiones = new JLabel("Lista de conexiones de Disco Duro:");
		lblListaDeConexiones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblListaDeConexiones.setBounds(42, 93, 203, 14);
		panelTarjetaMadre.add(lblListaDeConexiones);
		
		textTipodeConector = new JTextField();
		textTipodeConector.setColumns(10);
		textTipodeConector.setBounds(147, 41, 322, 20);
		panelTarjetaMadre.add(textTipodeConector);
		
		textTipodeMemoriaRAM = new JTextField();
		textTipodeMemoriaRAM.setColumns(10);
		textTipodeMemoriaRAM.setBounds(172, 66, 297, 20);
		panelTarjetaMadre.add(textTipodeMemoriaRAM);
		
		textConexionesDD = new JTextField();
		textConexionesDD.setColumns(10);
		textConexionesDD.setBounds(240, 91, 229, 20);
		panelTarjetaMadre.add(textConexionesDD);
		
		JLabel lblImagenTarMad = new JLabel("");
		lblImagenTarMad.setIcon(new ImageIcon(Componente.class.getResource("/imagenes/Webp.net-resizeimage-TarMad.png")));
		lblImagenTarMad.setBounds(475, 11, 127, 127);
		panelTarjetaMadre.add(lblImagenTarMad);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logico.Componente compTem = null;
				String idComponente = textID.getText();
				String marcaCompo = textMarca.getText();
				String modeloCompo= textModelo.getText();
				String serie = textNoSerie.getText();
				int cantMaxComp = Integer.parseInt(textCanMax.getText());
				int cantMinComp = Integer.parseInt(textCanMin.getText());
				int cantReal = Integer.parseInt(textCantidadReal.getText());	
				float precioCompraCom = Float.parseFloat(textPrecioCompra.getText());
				float precioVentaCom = Float.parseFloat(textPrecioVenta.getText());

				if(!textMarca.getText().isEmpty() || !textModelo.getText().isEmpty() ) {
				if(rdbTarjetaMadre.isSelected()) {
					compTem = new TarjetaMadre(idComponente, marcaCompo, modeloCompo, precioVentaCom, precioCompraCom, serie, cantMinComp, cantMaxComp, cantReal, textTipodeConector.getText(), textTipodeMemoriaRAM.getText(), textConexionesDD.getText());
					Tienda.getInstance().insertarComponente(compTem);
				}
				
				if(rdbtnMemoriaRam.isSelected()) {
					float cantMemoria = Float.parseFloat(textCantidadMemoria.getText());
					String tipMemoria = textTipoDeMemoria.getText();
					compTem = new MemoriaRam(idComponente, marcaCompo, modeloCompo, precioVentaCom, precioCompraCom, serie, cantMinComp, cantMaxComp, cantReal, cantMemoria, tipMemoria);
					Tienda.getInstance().insertarComponente(compTem);
				}
				
				if(rdbtnMicroprocesador.isSelected()) {
					String tipConector = textTipoConectorMicro.getText();
					float veloProc = Float.parseFloat(textVelocidadProcesamiento.getText());
					compTem = new Microprocesador(idComponente, marcaCompo, modeloCompo, precioVentaCom, precioCompraCom, serie, cantMinComp, cantMaxComp, cantReal, tipConector, veloProc);
					Tienda.getInstance().insertarComponente(compTem);
				}
				
				if(rdbtnDiscoDuro.isSelected()) {
					//float capAlm = Float.parseFloat(textCapacidadAlmace.getText());
					String tipConexion = textTipoConexionDD.getText();
					compTem = new DiscoDuro(idComponente, marcaCompo, modeloCompo, precioVentaCom, precioCompraCom, serie, cantMinComp, cantMaxComp, cantReal, Float.parseFloat(textCapacidadAlmace.getText()), tipConexion);
					Tienda.getInstance().insertarComponente(compTem);
				}
				limpiarCasilla();
				JOptionPane.showMessageDialog(null,"Has agregado correctamente el componente","Información",JOptionPane.INFORMATION_MESSAGE);
			    dispose();
			  }
				
			}
			
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrar.setBounds(366, 473, 123, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(499, 473, 123, 23);
		contentPane.add(btnCancelar);
		
		panelMemoriaRAM = new JPanel();
		panelMemoriaRAM.setVisible(false);
		panelMemoriaRAM.setLayout(null);
		panelMemoriaRAM.setForeground(new Color(204, 204, 204));
		panelMemoriaRAM.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Memoria RAM", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelMemoriaRAM.setBackground(SystemColor.menu);
		panelMemoriaRAM.setBounds(10, 313, 612, 149);
		contentPane.add(panelMemoriaRAM);
		
		JLabel lblCantidadDeMemoria = new JLabel("Cantidad de Memoria:");
		lblCantidadDeMemoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantidadDeMemoria.setBounds(42, 43, 146, 14);
		panelMemoriaRAM.add(lblCantidadDeMemoria);
		
		JLabel lblTipoDeMemoria_1 = new JLabel("Tipo de Memoria:");
		lblTipoDeMemoria_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoDeMemoria_1.setBounds(42, 68, 136, 14);
		panelMemoriaRAM.add(lblTipoDeMemoria_1);
		
		textCantidadMemoria = new JTextField();
		textCantidadMemoria.setColumns(10);
		textCantidadMemoria.setBounds(172, 41, 297, 20);
		panelMemoriaRAM.add(textCantidadMemoria);
		
		textTipoDeMemoria = new JTextField();
		textTipoDeMemoria.setColumns(10);
		textTipoDeMemoria.setBounds(172, 66, 297, 20);
		panelMemoriaRAM.add(textTipoDeMemoria);
		
		JLabel labelImagMemoriaRam = new JLabel("");
		labelImagMemoriaRam.setIcon(new ImageIcon(Componente.class.getResource("/imagenes/Webp.net-resizeimage-MR.png")));
		labelImagMemoriaRam.setBounds(475, 11, 127, 127);
		panelMemoriaRAM.add(labelImagMemoriaRam);
		
		panelMicroprocesador = new JPanel();
		panelMicroprocesador.setVisible(false);
		panelMicroprocesador.setLayout(null);
		panelMicroprocesador.setForeground(new Color(204, 204, 204));
		panelMicroprocesador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Microprocesador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelMicroprocesador.setBackground(SystemColor.menu);
		panelMicroprocesador.setBounds(10, 313, 612, 149);
		contentPane.add(panelMicroprocesador);
		
		lblTipoConector = new JLabel("Tipo de conector:");
		lblTipoConector.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoConector.setBounds(42, 43, 110, 14);
		panelMicroprocesador.add(lblTipoConector);
		
		lblVelocidadDe = new JLabel("Velocidad de procesamiento:");
		lblVelocidadDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVelocidadDe.setBounds(42, 68, 181, 14);
		panelMicroprocesador.add(lblVelocidadDe);
		
		textTipoConectorMicro = new JTextField();
		textTipoConectorMicro.setColumns(10);
		textTipoConectorMicro.setBounds(147, 41, 322, 20);
		panelMicroprocesador.add(textTipoConectorMicro);
		
		textVelocidadProcesamiento = new JTextField();
		textVelocidadProcesamiento.setColumns(10);
		textVelocidadProcesamiento.setBounds(215, 66, 254, 20);
		panelMicroprocesador.add(textVelocidadProcesamiento);
		
		lblImagMicro = new JLabel("");
		lblImagMicro.setIcon(new ImageIcon(Componente.class.getResource("/imagenes/Webp.net-resizeimage-Microprocesador.png")));
		lblImagMicro.setBounds(475, 11, 127, 127);
		panelMicroprocesador.add(lblImagMicro);
		
		panelDiscoDuro = new JPanel();
		panelDiscoDuro.setVisible(false);
		panelDiscoDuro.setLayout(null);
		panelDiscoDuro.setForeground(new Color(204, 204, 204));
		panelDiscoDuro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Disco Duro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDiscoDuro.setBackground(SystemColor.menu);
		panelDiscoDuro.setBounds(10, 313, 612, 149);
		contentPane.add(panelDiscoDuro);
		
		lblTipoConexionDD = new JLabel("Tipo de conexi\u00F3n:");
		lblTipoConexionDD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoConexionDD.setBounds(42, 43, 110, 14);
		panelDiscoDuro.add(lblTipoConexionDD);
		
		lblCapacidadAlm = new JLabel("Capacidad de Almacenamiento:");
		lblCapacidadAlm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCapacidadAlm.setBounds(42, 68, 179, 14);
		panelDiscoDuro.add(lblCapacidadAlm);
		
		textTipoConexionDD = new JTextField();
		textTipoConexionDD.setColumns(10);
		textTipoConexionDD.setBounds(147, 41, 322, 20);
		panelDiscoDuro.add(textTipoConexionDD);
		
		textCapacidadAlmace = new JTextField();
		textCapacidadAlmace.setColumns(10);
		textCapacidadAlmace.setBounds(213, 66, 256, 20);
		panelDiscoDuro.add(textCapacidadAlmace);
		
		lblImagDD = new JLabel("");
		lblImagDD.setIcon(new ImageIcon(Componente.class.getResource("/imagenes/Webp.net-resizeimage-DiscoDuro.png")));
		lblImagDD.setBounds(475, 11, 127, 127);
		panelDiscoDuro.add(lblImagDD);
	}
	
	public void limpiarCasilla() {
		textNoSerie.setText("");
		textTipoConexionDD.setText("");
		textCapacidadAlmace.setText("");
		textVelocidadProcesamiento.setText("");
		textTipoConectorMicro.setText("");
		textTipoDeMemoria.setText("");
		textCantidadMemoria.setText("");
		textConexionesDD.setText("");
		textPrecioVenta.setText("");
		textPrecioCompra.setText("");
		textCanMin.setText("");
		textCanMax.setText("");
		textID.setText("");
		textMarca.setText("");
		textModelo.setText("");
		textCantidadReal.setText("");
		textTipodeMemoriaRAM.setText("");
		
	}
}
