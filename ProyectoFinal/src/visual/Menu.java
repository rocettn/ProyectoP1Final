package visual;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import logico.Tienda;

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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.FlowLayout;

public class Menu extends JFrame {

	private JPanel contentPane;
	private Dimension din;



	public Menu() {
			
			this.addWindowListener(new WindowListener() {

				 @Override
				public void windowOpened(WindowEvent e) {
					 
					 
				}

				 @Override
				public void windowClosing(WindowEvent e) {
				try {
				File f = new File("r&m.dat");
				FileOutputStream fileOut = new FileOutputStream(f);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
				objectOut.writeObject(Tienda.getInstance());
				objectOut.close();
				
				} catch (Exception ex) {
				ex.printStackTrace();
				}

				}
				 
				 @Override
				public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				}

				 @Override
				public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				}

				 @Override
				public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				}

				 @Override
				public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				}

				 @Override
				public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				}
				});

		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setTitle("R&M");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 411);
		//din = getToolkit().getScreenSize();  
		super.setSize(1366,768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panelBotonSalir = new JPanel();
		panelBotonSalir.setLayout(null);
		panelBotonSalir.setForeground(new Color(204, 204, 204));
		panelBotonSalir.setBackground(new Color(0, 153, 153));
		panelBotonSalir.setBounds(0, 46, 280, 672);
		contentPane.add(panelBotonSalir);
		
		JLabel lblLogoMenu = new JLabel("");
		lblLogoMenu.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Webp.net-resizeimage_logoLogIn.png")));
		lblLogoMenu.setBounds(0, 259, 249, 179);
		panelBotonSalir.add(lblLogoMenu);
		
		
		JPanel panelIconoMenu = new JPanel();
		panelIconoMenu.setLayout(null);
		panelIconoMenu.setForeground(new Color(204, 204, 204));
		panelIconoMenu.setBackground(Color.WHITE);
		panelIconoMenu.setBounds(0, 0, 1350, 44);
		contentPane.add(panelIconoMenu);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(70, 11, 536, 21);
		panelIconoMenu.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Registros");
		mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registro Empleado");
		mntmNewMenuItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trabajador tb = new Trabajador();
				tb.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registro Cliente");
		mntmNewMenuItem_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteRegistrar c = new ClienteRegistrar();
				c.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registro Proveedores");
		mntmNewMenuItem_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroProveedor rp = new RegistroProveedor();
				rp.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Registro Componentes");
		mntmNewMenuItem_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Componente c = new Componente();
				c.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Registro Combo");
		mntmNewMenuItem_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCombo rc = new RegistrarCombo();
				rc.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Generar Orden Compra");
		mntmNewMenuItem_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarGenerarOrden go = new ListarGenerarOrden();
				go.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_2 = new JMenu("Venta");
		mnNewMenu_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Facturar");
		mntmNewMenuItem_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturar f = new Facturar(null);
				f.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Lista de Facturas");
		mntmNewMenuItem_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarFactura lf = new ListarFactura();
				lf.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_1 = new JMenu("Reporte");
		mnNewMenu_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Lista de Empleados");
		mntmNewMenuItem_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaTrabajador lt = new ListaTrabajador();
				lt.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Lista de Cliente");
		mntmNewMenuItem_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCliente m = new ListarCliente();
				m.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Lista de componentes");
		mntmNewMenuItem_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarComponente lc = new ListarComponente(null, 0);
				lc.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_9);
		
		JMenuItem mntmListaDeProveedores = new JMenuItem("Lista de proveedores");
		mntmListaDeProveedores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmListaDeProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProveedor lp = new ListarProveedor();
				lp.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmListaDeProveedores);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Lista de Orden de Compra");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarOrdenCompra loc = new ListarOrdenCompra();
				loc.setVisible(true);
			}
		});
		mntmNewMenuItem_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_10);
		
		JLabel lblMenu = new JLabel("");
		lblMenu.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/Webp.net-resizeimage - menuIcono.png")));
		lblMenu.setBounds(10, 0, 46, 44);
		panelIconoMenu.add(lblMenu);
		
		JPanel panelGraficos = new JPanel();
		panelGraficos.setLayout(null);
		panelGraficos.setForeground(new Color(204, 204, 204));
		panelGraficos.setBackground(UIManager.getColor("Button.background"));
		panelGraficos.setBounds(278, 40, 1072, 678);
		contentPane.add(panelGraficos);
		
		JPanel graficaGanancia = new JPanel();
		graficaGanancia.setBounds(10, 11, 493, 299);
		panelGraficos.add(graficaGanancia);
		graficaGanancia.setLayout(null);
		
		JPanel panelCantidadComponete = new JPanel();
		panelCantidadComponete.setBounds(569, 11, 493, 299);
		panelGraficos.add(panelCantidadComponete);
		panelCantidadComponete.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 368, 493, 299);
		panelGraficos.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(569, 368, 493, 299);
		panelGraficos.add(panel_1);
		panel_1.setLayout(null);
	}
}
