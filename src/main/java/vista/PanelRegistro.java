 package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelRegistro extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public JLabel lblTitulo, lblNombre, lblContrasenia;
	public JTextField textFieldNombre, textFieldContrasenia;
	public JButton btnContinuar, btnNoAcc, btnCancelar;
	
	public PanelRegistro() {
		setLayout(null);
		setBounds(0,0,800,600);
		setBackground(new Color(255, 201, 164));
		
		lblTitulo = new JLabel("INICIO DE SESIÓN");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblTitulo.setBounds(229, 35, 269, 39);
		add(lblTitulo);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(218, 132, 78, 39);
		add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(383, 132, 192, 39);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		btnContinuar = new JButton("CONTINUAR");
		btnContinuar.setBounds(527, 404, 212, 99);
		add(btnContinuar);
		
		btnNoAcc = new JButton("NO TENGO CUENTA");
		btnNoAcc.setBounds(59, 404, 158, 99);
		add(btnNoAcc);
		
		lblContrasenia = new JLabel("Contrase\u00F1a:");
		lblContrasenia.setBounds(218, 238, 65, 39);
		add(lblContrasenia);
		
		textFieldContrasenia = new JTextField();
		textFieldContrasenia.setBounds(385, 238, 190, 39);
		add(textFieldContrasenia);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(276, 404, 192, 99);
		add(btnCancelar);
	}

}
