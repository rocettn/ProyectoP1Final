package visual;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import logico.*;

public class Trabajador extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textCedula;
	private JTextField textTelefono;
	private JTextField textDireccion;
	private JTextField textIDVend;
	private JTextField textUsuarioV;
	private JTextField textContraV;
	private JTextField textIdAdminis;
	private JTextField textUsuarioAdm;
	private JTextField textContraAdmin;
	private JPanel panelAdministrador;
	private JPanel panelVendedor;
	private JRadioButton rdbtnVendedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trabajador frame = new Trabajador();
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
	public Trabajador() {
		setTitle("R&M");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JPanel panelInfoGen = new JPanel();
		panelInfoGen.setLayout(null);
		panelInfoGen.setForeground(new Color(204, 204, 204));
		panelInfoGen.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInfoGen.setBackground(SystemColor.menu);
		panelInfoGen.setBounds(10, 11, 580, 150);
		contentPane.add(panelInfoGen);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(42, 37, 87, 14);
		panelInfoGen.add(lblNombre);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCedula.setBounds(42, 62, 87, 14);
		panelInfoGen.add(lblCedula);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefono.setBounds(42, 87, 87, 14);
		panelInfoGen.add(lblTelefono);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(131, 34, 290, 20);
		panelInfoGen.add(textNombre);
		
		textCedula = new JTextField();
		textCedula.setColumns(10);
		textCedula.setBounds(131, 59, 290, 20);
		panelInfoGen.add(textCedula);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(131, 84, 290, 20);
		panelInfoGen.add(textTelefono);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setBounds(42, 112, 87, 14);
		panelInfoGen.add(lblDireccion);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(131, 109, 290, 20);
		panelInfoGen.add(textDireccion);
		
		JLabel lblImagPersData = new JLabel("");
		lblImagPersData.setBounds(456, 11, 114, 128);
		panelInfoGen.add(lblImagPersData);
		lblImagPersData.setIcon(new ImageIcon(Trabajador.class.getResource("/imagenes/Webp.net-resizeimage-PD.jpg")));
		
		JPanel panelTipoEmpleado = new JPanel();
		panelTipoEmpleado.setLayout(null);
		panelTipoEmpleado.setForeground(new Color(204, 204, 204));
		panelTipoEmpleado.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTipoEmpleado.setBackground(SystemColor.menu);
		panelTipoEmpleado.setBounds(10, 168, 580, 99);
		contentPane.add(panelTipoEmpleado);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(443, 11, 114, 128);
		panelTipoEmpleado.add(label_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(new Color(204, 204, 204));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(10, 23, 560, 65);
		panelTipoEmpleado.add(panel_2);
		
		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAdministrador.setVisible(true);
				panelVendedor.setVisible(false);
				rdbtnVendedor.setSelected(false);
			}
		});
		rdbtnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnAdministrador.setBounds(317, 26, 109, 23);
		panel_2.add(rdbtnAdministrador);
		
		rdbtnVendedor = new JRadioButton("Vendedor");
		rdbtnVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAdministrador.setVisible(false);
				panelVendedor.setVisible(true);
				rdbtnAdministrador.setSelected(false);
			}
		});
		rdbtnVendedor.setSelected(true);
		rdbtnVendedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnVendedor.setBounds(148, 26, 109, 23);
		panel_2.add(rdbtnVendedor);
		
		panelVendedor = new JPanel();
		panelVendedor.setLayout(null);
		panelVendedor.setForeground(new Color(204, 204, 204));
		panelVendedor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Vendedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelVendedor.setBackground(SystemColor.menu);
		panelVendedor.setBounds(10, 274, 580, 150);
		contentPane.add(panelVendedor);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(42, 46, 87, 14);
		panelVendedor.add(lblId);
		
		JLabel lblUsuarioVe = new JLabel("Usuario:");
		lblUsuarioVe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuarioVe.setBounds(42, 71, 87, 14);
		panelVendedor.add(lblUsuarioVe);
		
		JLabel lblContraV = new JLabel("Contrase\u00F1a:");
		lblContraV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContraV.setBounds(42, 96, 87, 14);
		panelVendedor.add(lblContraV);
		
		textIDVend = new JTextField();
		textIDVend.setColumns(10);
		textIDVend.setBounds(131, 43, 290, 20);
		panelVendedor.add(textIDVend);
		
		textUsuarioV = new JTextField();
		textUsuarioV.setColumns(10);
		textUsuarioV.setBounds(131, 68, 290, 20);
		panelVendedor.add(textUsuarioV);
		
		textContraV = new JTextField();
		textContraV.setColumns(10);
		textContraV.setBounds(131, 93, 290, 20);
		panelVendedor.add(textContraV);
		
		JLabel lblImagVendedor = new JLabel("");
		lblImagVendedor.setIcon(new ImageIcon(Trabajador.class.getResource("/imagenes/Webp.net-resizeimage - Vendedor.png")));
		lblImagVendedor.setBounds(431, 11, 139, 128);
		panelVendedor.add(lblImagVendedor);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persona auxiliar = null;
				String nombre = textNombre.getText();
				String cedula = textCedula.getText();
				String telefono= textTelefono.getText();
				String direccion = textDireccion.getText();
				if(textNombre.getText().isEmpty() || textCedula.getText().isEmpty() || textTelefono.getText().isEmpty() || textDireccion.getText().isEmpty()) {
				}else {
				if(rdbtnVendedor.isSelected()) {
					String idVend = textIDVend.getText();
					auxiliar = new Vendedor(nombre, cedula, telefono, direccion, idVend, textUsuarioV.getText(), textContraV.getText());
					Tienda.getInstance().insertarPersona(auxiliar);
					//System.out.println("El empleado es: "+Tienda.getInstance().getPersonasTienda().get(0).getNombre()); Prueba
				}
				
				if(rdbtnAdministrador.isSelected()) {
					auxiliar = new Administrador(nombre, cedula, telefono, direccion, textIdAdminis.getText(), textUsuarioAdm.getText(), textContraAdmin.getText());
					Tienda.getInstance().insertarPersona(auxiliar);
				}
				limpiar();
				JOptionPane.showMessageDialog(null, "Ingreso Correcto de Empleado a R&M-Arma tu Equipo", "Información", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregar.setBounds(334, 432, 123, 23);
		contentPane.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(467, 432, 123, 23);
		contentPane.add(btnCancelar);
		
		panelAdministrador = new JPanel();
		panelAdministrador.setVisible(false);
		panelAdministrador.setLayout(null);
		panelAdministrador.setForeground(new Color(204, 204, 204));
		panelAdministrador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Administrador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAdministrador.setBackground(SystemColor.menu);
		panelAdministrador.setBounds(10, 274, 580, 150);
		contentPane.add(panelAdministrador);
		
		JLabel lblIdAdm = new JLabel("ID:");
		lblIdAdm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdAdm.setBounds(42, 46, 87, 14);
		panelAdministrador.add(lblIdAdm);
		
		JLabel lblUserAdm = new JLabel("Usuario:");
		lblUserAdm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUserAdm.setBounds(42, 71, 87, 14);
		panelAdministrador.add(lblUserAdm);
		
		JLabel lblContraAdm = new JLabel("Contrase\u00F1a:");
		lblContraAdm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContraAdm.setBounds(42, 96, 87, 14);
		panelAdministrador.add(lblContraAdm);
		
		textIdAdminis = new JTextField();
		textIdAdminis.setColumns(10);
		textIdAdminis.setBounds(131, 43, 290, 20);
		panelAdministrador.add(textIdAdminis);
		
		textUsuarioAdm = new JTextField();
		textUsuarioAdm.setColumns(10);
		textUsuarioAdm.setBounds(131, 68, 290, 20);
		panelAdministrador.add(textUsuarioAdm);
		
		textContraAdmin = new JTextField();
		textContraAdmin.setColumns(10);
		textContraAdmin.setBounds(131, 93, 290, 20);
		panelAdministrador.add(textContraAdmin);
		
		JLabel lblImagAdmin = new JLabel("");
		lblImagAdmin.setIcon(new ImageIcon(Trabajador.class.getResource("/imagenes/Webp.net-resizeimage-Admin.png")));
		lblImagAdmin.setBounds(431, 11, 139, 128);
		panelAdministrador.add(lblImagAdmin);
	}
	
	public void limpiar () {
		
		textNombre.setText("");
		textCedula.setText("");
		textTelefono.setText("");
		textDireccion.setText("");
		textContraAdmin.setText("");
		textUsuarioAdm.setText("");
		textIDVend.setText("");
		textIdAdminis.setText("");
		textContraV.setText("");
		textUsuarioV.setText("");
		
	}
}
