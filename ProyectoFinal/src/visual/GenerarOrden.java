package visual;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Administrador;
import logico.Componente;
import logico.OrdenCompra;
import logico.Proveedor;
import logico.Tienda;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class GenerarOrden extends JFrame {

	private JPanel contentPane;
	private Componente componenteOrden = null;
	private Proveedor proveedorOrden = null;
	private float totalOrden = 0.0f;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GenerarOrden(Componente comp, Proveedor prov) {
		setTitle("R&M");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GenerarOrden.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		this.componenteOrden = comp;
		this.proveedorOrden = prov;

		JPanel panelInfoCompo = new JPanel();
		panelInfoCompo.setForeground(new Color(0, 0, 0));
		panelInfoCompo.setBorder(new TitledBorder(null, "Informaci\u00F3n de componente a pedir: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfoCompo.setBounds(12, 13, 410, 122);
		contentPane.add(panelInfoCompo);
		panelInfoCompo.setLayout(null);

		JLabel lblIDComp = new JLabel("Id Componente:");
		lblIDComp.setBounds(12, 33, 101, 16);
		panelInfoCompo.add(lblIDComp);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 62, 56, 16);
		panelInfoCompo.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(12, 91, 56, 16);
		panelInfoCompo.add(lblModelo);

		JLabel lblIDComptext = new JLabel("" + componenteOrden.getId());
		lblIDComptext.setBounds(125, 33, 143, 16);
		panelInfoCompo.add(lblIDComptext);

		JLabel labelMarcatext = new JLabel("" + componenteOrden.getMarca());
		labelMarcatext.setBounds(125, 62, 143, 16);
		panelInfoCompo.add(labelMarcatext);

		JLabel laberModelotext = new JLabel("" + componenteOrden.getModelo());
		laberModelotext.setBounds(125, 91, 143, 16);
		panelInfoCompo.add(laberModelotext);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GenerarOrden.class.getResource("/imagenes/Webp.net-resizeimage_ordenCompraComp.jpg")));
		lblNewLabel.setBounds(306, 33, 75, 60);
		panelInfoCompo.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n de proveedor de componente:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 148, 410, 122);
		contentPane.add(panel);

		JLabel lblIDProveedor = new JLabel("Id Proveedor:");
		lblIDProveedor.setBounds(12, 33, 101, 16);
		panel.add(lblIDProveedor);

		JLabel lblNombreProveedor = new JLabel("Nombre:");
		lblNombreProveedor.setBounds(12, 62, 56, 16);
		panel.add(lblNombreProveedor);

		JLabel lblPaidProv = new JLabel("Pa\u00EDs:");
		lblPaidProv.setBounds(12, 91, 56, 16);
		panel.add(lblPaidProv);

		JLabel labelIDProveedortext = new JLabel("" + proveedorOrden.getIdProveedor());
		labelIDProveedortext.setBounds(125, 33, 143, 16);
		panel.add(labelIDProveedortext);

		JLabel labelNombreProveedortext = new JLabel("" + proveedorOrden.getNombreProveedor());
		labelNombreProveedortext.setBounds(125, 62, 143, 16);
		panel.add(labelNombreProveedortext);

		JLabel labelPaistext = new JLabel("" + proveedorOrden.getPais());
		labelPaistext.setBounds(125, 91, 143, 16);
		panel.add(labelPaistext);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(GenerarOrden.class.getResource("/imagenes/Webp.net-resizeimage-pro.png")));
		lblNewLabel_1.setBounds(297, 33, 101, 74);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cantidad de componentes a ordenar:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(12, 283, 410, 98);
		contentPane.add(panel_1);

		JLabel lblCantidadOrdenar = new JLabel("Cantidad:");
		lblCantidadOrdenar.setBounds(12, 33, 101, 16);
		panel_1.add(lblCantidadOrdenar);

		JLabel lblTotalOrden = new JLabel("Total Orden de Compra:");
		lblTotalOrden.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalOrden.setBounds(12, 65, 174, 16);
		panel_1.add(lblTotalOrden);

		JLabel labelTotalOrdentext = new JLabel("" + totalOrden);
		labelTotalOrdentext.setBounds(210, 66, 143, 16);
		panel_1.add(labelTotalOrdentext);

		JSpinner spinnerCantOrdenar = new JSpinner();
		spinnerCantOrdenar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totalOrden = (componenteOrden.getPrecioCompraComponente() * Integer.parseInt(spinnerCantOrdenar.getValue().toString()));

				lblTotalOrden.setText(""+totalOrden);
			}
		});
		spinnerCantOrdenar.setBounds(125, 30, 83, 22);
		panel_1.add(spinnerCantOrdenar);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(GenerarOrden.class.getResource("/imagenes/Webp.net-resizeimage (7).png")));
		lblNewLabel_2.setBounds(313, 13, 72, 72);
		panel_1.add(lblNewLabel_2);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(325, 394, 97, 25);
		contentPane.add(btnCancelar);

		JButton btnOrdenar = new JButton("Ordenar");
		btnOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(totalOrden <= proveedorOrden.getLimCredito()) {
				
				OrdenCompra ordenGenerada = new OrdenCompra(comp, Integer.parseInt(spinnerCantOrdenar.getValue().toString()), prov, totalOrden, (Administrador)Tienda.getInstance().getUsuario(),new Date());
						Tienda.getInstance().insertarOrdenCompra(ordenGenerada);
						//Proveedor.setLimCredito(proveedor.getLimCredito()-total);
						comp.setCantActualComp(comp.getCantActualComp()+Integer.parseInt(spinnerCantOrdenar.getValue().toString()));
						JOptionPane.showMessageDialog(null, "Se creo satisfactoriamente la orden de compra");
						dispose();
						//}else {
						//	JOptionPane.showMessageDialog(null, "La compañia no cuenta con sufienciente Credito con el proveedor: "+proveedor.getNombre());
						//}
						}
			});
				btnOrdenar.setBounds(216, 394, 97, 25);
				contentPane.add(btnOrdenar);
		}
	}
