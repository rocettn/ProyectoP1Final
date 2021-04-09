package visual;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import logico.Cliente;
import logico.Persona;
import logico.Tienda;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ClienteRegistrar extends JFrame {

	private JPanel contentPane;
	private JTextField textNombreCliente;
	private JTextField textCedulaCliente;
	private JTextField textTelCliente;
	private JTextField textDirecCliente;
	private JTextField textCredito;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private JLabel lblCreditoCliente;
	private JPanel panelLogo;
	private JPanel panelDetalleCred;

	/**
	 * Launch the application.
	 */
	
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Cliente frame = new Cliente();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public ClienteRegistrar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClienteRegistrar.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setTitle("R&M");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 481);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JPanel panelInfoGeneral = new JPanel();
		panelInfoGeneral.setLayout(null);
		panelInfoGeneral.setForeground(new Color(204, 204, 204));
		panelInfoGeneral.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInfoGeneral.setBackground(SystemColor.menu);
		panelInfoGeneral.setBounds(10, 11, 580, 150);
		contentPane.add(panelInfoGeneral);
		
		JLabel lblNombreCliente = new JLabel("Nombre:");
		lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreCliente.setBounds(42, 37, 87, 14);
		panelInfoGeneral.add(lblNombreCliente);
		
		JLabel lblCedulaCliente = new JLabel("C\u00E9dula:");
		lblCedulaCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCedulaCliente.setBounds(42, 62, 87, 14);
		panelInfoGeneral.add(lblCedulaCliente);
		
		JLabel lblTelefon = new JLabel("Tel\u00E9fono:");
		lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefon.setBounds(42, 87, 87, 14);
		panelInfoGeneral.add(lblTelefon);
		
		textNombreCliente = new JTextField();
		textNombreCliente.setColumns(10);
		textNombreCliente.setBounds(131, 34, 290, 20);
		panelInfoGeneral.add(textNombreCliente);
		
		textCedulaCliente = new JTextField();
		textCedulaCliente.setColumns(10);
		textCedulaCliente.setBounds(131, 59, 290, 20);
		panelInfoGeneral.add(textCedulaCliente);
		
		textTelCliente = new JTextField();
		textTelCliente.setColumns(10);
		textTelCliente.setBounds(131, 84, 290, 20);
		panelInfoGeneral.add(textTelCliente);
		
		JLabel lblDirecClien = new JLabel("Direcci\u00F3n:");
		lblDirecClien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDirecClien.setBounds(42, 112, 87, 14);
		panelInfoGeneral.add(lblDirecClien);
		
		textDirecCliente = new JTextField();
		textDirecCliente.setColumns(10);
		textDirecCliente.setBounds(131, 109, 290, 20);
		panelInfoGeneral.add(textDirecCliente);
		
		JLabel lblImagInfCliente = new JLabel("");
		lblImagInfCliente.setIcon(new ImageIcon(ClienteRegistrar.class.getResource("/imagenes/Webp.net-resizeimage-ICliente.png")));
		lblImagInfCliente.setBounds(427, 11, 143, 128);
		panelInfoGeneral.add(lblImagInfCliente);
		
		JPanel panelCredPregun = new JPanel();
		panelCredPregun.setLayout(null);
		panelCredPregun.setForeground(new Color(204, 204, 204));
		panelCredPregun.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u00BFHabilitar cr\u00E9dito?", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCredPregun.setBackground(SystemColor.menu);
		panelCredPregun.setBounds(10, 172, 580, 100);
		contentPane.add(panelCredPregun);
		
		JLabel lblImagenSigno = new JLabel("");
		lblImagenSigno.setIcon(new ImageIcon(ClienteRegistrar.class.getResource("/imagenes/Webp.net-resizeimagePregunta.png")));
		lblImagenSigno.setBounds(485, 11, 85, 78);
		panelCredPregun.add(lblImagenSigno);
		
		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNo.setSelected(false);
				lblCreditoCliente .setVisible(true);
				textCredito.setVisible(true);
				panelLogo.setVisible(false);
				panelDetalleCred.setVisible(true);
			}
		});
		rdbtnSi.setSelected(true);
		rdbtnSi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnSi.setBounds(158, 40, 109, 23);
		panelCredPregun.add(rdbtnSi);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSi.setSelected(false);
				lblCreditoCliente .setVisible(false);
				textCredito.setVisible(false);
				panelLogo.setVisible(true);
				panelDetalleCred.setVisible(false);
			}
		});
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNo.setBounds(312, 40, 109, 23);
		panelCredPregun.add(rdbtnNo);
		
		panelDetalleCred = new JPanel();
		panelDetalleCred.setBounds(10, 283, 580, 116);
		contentPane.add(panelDetalleCred);
		panelDetalleCred.setLayout(null);
		panelDetalleCred.setForeground(new Color(204, 204, 204));
		panelDetalleCred.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalle de Cr\u00E9dito", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDetalleCred.setBackground(SystemColor.menu);
		
		lblCreditoCliente = new JLabel("Cr\u00E9dito Cliente:");
		lblCreditoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCreditoCliente.setBounds(31, 57, 87, 14);
		panelDetalleCred.add(lblCreditoCliente);
		
		textCredito = new JTextField();
		textCredito.setColumns(10);
		textCredito.setBounds(129, 55, 290, 20);
		panelDetalleCred.add(textCredito);
		
		JLabel lblImagCredito = new JLabel("");
		lblImagCredito.setIcon(new ImageIcon(ClienteRegistrar.class.getResource("/imagenes/Webp.net-resizeimage cred.png")));
		lblImagCredito.setBounds(454, 11, 116, 100);
		panelDetalleCred.add(lblImagCredito);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(475, 410, 115, 23);
		contentPane.add(btnCancelar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persona persTem = null;
				String nombreCliente = textNombreCliente.getText();
				String telefono = textTelCliente.getText();
				String cedula = textCedulaCliente.getText();
				String direccion = textDirecCliente.getText();
				//public Cliente(String nombre, String telefono, String cedula, String direccion, 
						//float creditoCliente)
				if(rdbtnSi.isSelected()) {
					float credito = Float.parseFloat(textCredito.getText());
					persTem = new Cliente(nombreCliente, telefono, cedula, direccion, credito);
					Tienda.getInstance().insertarPersona(persTem);
				}else {
					persTem = new Cliente(nombreCliente, telefono, cedula, direccion, 0);
					Tienda.getInstance().insertarPersona(persTem);
					
				}
				JOptionPane.showMessageDialog(null, "Se ha registrado satisfactoriamente el cliente");
				dispose();
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrar.setBounds(350, 410, 115, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnClienteExis = new JButton("Elegir Cliente Existente");
		btnClienteExis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCliente lc = new ListarCliente();
				dispose();
				lc.setVisible(true);
			}
		});
		btnClienteExis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClienteExis.setBounds(165, 410, 175, 23);
		contentPane.add(btnClienteExis);
		
		panelLogo = new JPanel();
		panelLogo.setVisible(false);
		panelLogo.setLayout(null);
		panelLogo.setForeground(new Color(0, 153, 153));
		panelLogo.setBackground(new Color(0, 153, 153));
		panelLogo.setBounds(10, 283, 580, 116);
		contentPane.add(panelLogo);
		
		JLabel labelLogoCliente = new JLabel("");
		labelLogoCliente.setIcon(new ImageIcon(ClienteRegistrar.class.getResource("/imagenes/Webp.net-resizeimage_logoLogIn.png")));
		labelLogoCliente.setBounds(160, 11, 235, 100);
		panelLogo.add(labelLogoCliente);
	}
}
