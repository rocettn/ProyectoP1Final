package visual;



import java.awt.BorderLayout;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



import logico.*;



import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class LogIn extends JFrame {



	private JPanel contentPane;
	private JTextField textoUsuario;
	private JPasswordField textoPassword;
	private JLabel lblmensajePass;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				File f = new File("r&m.dat");
				FileInputStream fileIn;
				FileOutputStream fileOut;
				ObjectInputStream objectIn;
				ObjectOutputStream objectOut;
				try {
					fileIn = new FileInputStream(f);
					objectIn = new ObjectInputStream(fileIn);
					Tienda.tienda=(Tienda)objectIn.readObject();
					fileIn.close();
					objectIn.close();
				}catch(FileNotFoundException e) {
					try {
						fileOut = new FileOutputStream(f);
						objectOut = new ObjectOutputStream(fileOut);
						Persona a = new Administrador("Admin", "0", "1", "2", "Admin", "1234", "3");
						Tienda.getInstance().insertarPersona(a);
						objectOut.writeObject(Tienda.getInstance());
						fileOut.close();
						objectOut.close();

					}catch(FileNotFoundException ex) {

					}catch(IOException ex) {

					}

				}catch(IOException e) {

				}catch(ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Ocurrió un error. Reinicie el programa.");
				}
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 543);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(207, 217, 300, 40);
		contentPane.add(panel);
		panel.setLayout(null);

		textoUsuario = new JTextField();
		textoUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textoUsuario.getText().equalsIgnoreCase("Usuario")) {
					textoUsuario.setText("");
				}else {
					textoUsuario.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textoUsuario.getText().equalsIgnoreCase("")) {
					textoUsuario.setText("Usuario");
				}
			}
		});
		textoUsuario.setBorder(null);
		textoUsuario.setText("Usuario");
		textoUsuario.setBounds(12, 9, 236, 22);
		panel.add(textoUsuario);
		textoUsuario.setColumns(10);

		JLabel lblImagenUsuario = new JLabel("");
		lblImagenUsuario.setIcon(new ImageIcon(LogIn.class.getResource("/imagenes/Webp.net-resizeimage.png")));
		lblImagenUsuario.setBounds(260, 0, 40, 40);
		panel.add(lblImagenUsuario);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(207, 285, 300, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textoPassword = new JPasswordField();
		textoPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textoPassword.getText().equalsIgnoreCase("Contraseña")) {
					textoPassword.setEchoChar('●');
					textoPassword.setText("") ;
				}else {
					textoPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textoPassword.getText().equalsIgnoreCase("")) {
					textoPassword.setText("Contraseña");
					textoPassword.setEchoChar((char)0);
				}
			}
		});
		textoPassword.setEchoChar((char)0);
		textoPassword.setBorder(null);
		textoPassword.setText("Contrase\u00F1a");
		textoPassword.setBounds(12, 9, 240, 22);
		panel_1.add(textoPassword);

		JLabel lblImagenPassword = new JLabel("");
		lblImagenPassword.setIcon(new ImageIcon(LogIn.class.getResource("/imagenes/Webp.net-resizeimage2.png")));
		lblImagenPassword.setBounds(264, 0, 36, 40);
		panel_1.add(lblImagenPassword);

		JLabel lblCerrarX = new JLabel("X");
		lblCerrarX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrarX.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				lblCerrarX.setForeground(Color.WHITE);
			}

		});
		lblCerrarX.setForeground(new Color(240, 255, 240));
		lblCerrarX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblCerrarX.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarX.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCerrarX.setBounds(675, 13, 41, 16);
		contentPane.add(lblCerrarX);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(LogIn.class.getResource("/imagenes/Webp.net-resizeimage_logoLogIn.png")));
		lblLogo.setBounds(207, 13, 300, 191);
		contentPane.add(lblLogo);

		//JLabel lblmensajePass = new JLabel(""); 
		//lblmensajePass.setBounds(207, 338, 300, 25); 
		//contentPane.add(lblmensajePass); 
		//setLocationRelativeTo(null);

		JButton botonIngresar = new JButton("Ingresar");
		botonIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Tienda.getInstance().inicioDeSesionEnLogin(textoUsuario.getText(),textoPassword.getText())) {

					Menu frame = new Menu(); 
					dispose(); 
					frame.setVisible(true);

				}else if(textoUsuario.getText().equalsIgnoreCase("Usuario") ||
						textoUsuario.getText().equalsIgnoreCase("") ||
						textoPassword.getText().equalsIgnoreCase("") ||
						textoPassword.getText().equalsIgnoreCase("Contraseña")){
					lblmensajePass.setText("Falta informacion. Favor de completar.");
				}else{ 
					lblmensajePass.setText("Usuario o contraseña incorrecta. Intentar de nuevo.");
				} 
			}
		});
		/*
		 * botonIngresar.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) {
		 * if(Tienda.getInstance().inicioDeSesionEnLogin(textoUsuario.getText(),
		 * textoPassword.getText())) {
		 * 
		 * Menu frame = new Menu(); dispose(); frame.setVisible(true);
		 * 
		 * }else if(textoUsuario.getText().equalsIgnoreCase("Usuario") ||
		 * textoUsuario.getText().equalsIgnoreCase("") ||
		 * textoPassword.getText().equalsIgnoreCase("") ||
		 * textoPassword.getText().equalsIgnoreCase("Contraseña")){
		 * lblmensajePass.setText("Falta informacion. Favor de completar."); }else{
		 * lblmensajePass.setText("Usuario o contrasena incorrecta. Intentar de nuevo."
		 * ); } } });
		 */
		botonIngresar.setForeground(SystemColor.controlDkShadow);
		botonIngresar.setFont(new Font("Tahoma", Font.BOLD, 17));
		botonIngresar.setBounds(288, 429, 148, 40);
		contentPane.add(botonIngresar);
		
		lblmensajePass = new JLabel("");
		lblmensajePass.setBounds(193, 336, 328, 14);
		contentPane.add(lblmensajePass);


		/*
		 * //JLabel lblmensajePass = new JLabel(""); lblmensajePass.setBounds(207, 338,
		 * 300, 25); contentPane.add(lblmensajePass); setLocationRelativeTo(null);
		 */

	}
}