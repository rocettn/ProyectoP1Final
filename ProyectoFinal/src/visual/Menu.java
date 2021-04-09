package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	private Dimension din;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Menu frame = new Menu();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("R&M");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 411);
		din = getToolkit().getScreenSize();  
		super.setSize(din.width,din.height-45);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panelBotonSalir = new JPanel();
		panelBotonSalir.setLayout(null);
		panelBotonSalir.setForeground(new Color(204, 204, 204));
		panelBotonSalir.setBackground(SystemColor.menu);
		panelBotonSalir.setBounds(0, 46, 148, 638);
		contentPane.add(panelBotonSalir);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBackground(new Color(192, 192, 192));
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClose.setBounds(29, 604, 89, 23);
		panelBotonSalir.add(btnClose);
		
		
		JPanel panelIconoMenu = new JPanel();
		panelIconoMenu.setLayout(null);
		panelIconoMenu.setForeground(new Color(204, 204, 204));
		panelIconoMenu.setBackground(Color.WHITE);
		panelIconoMenu.setBounds(0, 0, 1350, 44);
		contentPane.add(panelIconoMenu);
		
		JLabel lblMenuIcono = new JLabel("");
		lblMenuIcono.setBounds(10, 11, 50, 29);
		panelIconoMenu.add(lblMenuIcono);
		lblMenuIcono.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Webp.net-resizeimage - menuIcono.png")));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(70, 11, 536, 21);
		panelIconoMenu.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Registros");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registro Empleado");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trabajador tb = new Trabajador();
				tb.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registro Cliente");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteRegistrar c = new ClienteRegistrar();
				c.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registro Proveedores");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Registro Componentes");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Componente c = new Componente();
				c.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Registro Combo");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Venta");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Facturaci\u00F3n");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturar f = new Facturar();
				f.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Lista de Facturas");
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_1 = new JMenu("Reporte");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Lista de Empleados");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaTrabajador lt = new ListaTrabajador();
				lt.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Lista de Cliente");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCliente m = new ListarCliente();
				m.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Lista de componentes");
		mnNewMenu_1.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Lista de combos");
		mnNewMenu_1.add(mntmNewMenuItem_11);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setLayout(null);
		panelLogo.setForeground(new Color(204, 204, 204));
		panelLogo.setBackground(new Color(0, 153, 153));
		panelLogo.setBounds(148, 40, 1202, 644);
		contentPane.add(panelLogo);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/r&M nuevo color.png")));
		lblLogo.setBounds(359, 162, 393, 321);
		panelLogo.add(lblLogo);
	}
}
