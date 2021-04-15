package visual;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import logico.Tienda;
import java.awt.Color;
import java.awt.Font;

public class GraficaVComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public GraficaVComponente() {
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setTitle("R&M");
		setBackground(UIManager.getColor("Button.focus"));
		setForeground(UIManager.getColor("Button.focus"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(GraficaVComponente.class.getResource("/imagenes/MicrosoftTeams-image.png")));
		setModal(true);
		setBounds(100, 100, 802, 493);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 153, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		ChartPanel panel = Barras3d();
		getContentPane().add(panel);
		
	}
	
	private ChartPanel Barras3d() {

		String A = "Tarjeta Madre";
		String B = "Memoria RAM";
		String C = "Microprocesador";
		String D = "Disco Duro";

		String vel = "Ventas";

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(Tienda.getInstance().getTajetaMadreT(), A, vel);
		dataset.addValue(Tienda.getInstance().getMemoriaRamT(), B, vel);
		dataset.addValue(Tienda.getInstance().getMicroT(), C, vel);
		dataset.addValue(Tienda.getInstance().getDiscoDuroT(), D, vel);

		JFreeChart barChart = ChartFactory.createBarChart3D(
				"Gráfica de Componente Vendidos", 
				"Tipo de componente", 
				"Componente Vendido", 
				dataset,
				PlotOrientation.VERTICAL, 
				true, 
				true, 
				false);
		 ChartPanel panel = new ChartPanel(barChart);
	        panel.setForeground(UIManager.getColor("Button.focus"));
	        panel.setBackground(UIManager.getColor("Button.focus"));
	        panel.setLayout(null);
	        return panel;
	}

}
