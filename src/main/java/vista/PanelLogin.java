package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelLogin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	public JLabel lblTitulo, lblNombre, lblContrasenia;
	public JTextField textFieldNombre;
	public JButton btnLogin, btnNoAcc, btnCancelar, btnAtras;
	public JPasswordField textFieldContrasenia;
	
	public PanelLogin() {
		setLayout(null);
		setBounds(0,0,800,600);
		setBackground(new Color(255, 201, 164));
		
		lblTitulo = new JLabel("INICIO DE SESI\u00D3N");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblTitulo.setBounds(241, 64, 269, 58);
		add(lblTitulo);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(222, 188, 78, 39);
		add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(383, 188, 192, 39);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		btnLogin = new JButton("Iniciar Sesi\u00F3n");
		btnLogin.setBounds(307, 346, 192, 99);
		add(btnLogin);
		
		btnNoAcc = new JButton("NO TENGO CUENTA");
		btnNoAcc.setBounds(600, 523, 158, 29);
		add(btnNoAcc);
		
		lblContrasenia = new JLabel("Contrase\u00F1a:");
		lblContrasenia.setBounds(218, 238, 65, 39);
		add(lblContrasenia);
		
		textFieldContrasenia = new JPasswordField();
		textFieldContrasenia.setBounds(383, 238, 190, 39);
		add(textFieldContrasenia);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(32, 523, 100, 29);
		add(btnCancelar);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(32, 483, 100, 29);
		add(btnAtras);
	}
}