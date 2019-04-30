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

public class PanelLogin extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public JLabel lblRegistroUsuario, lblNombre, lblApellido, lblDni, lblSexo, lblContrasenia, lblFechaNacimiento;
	public JTextField textFieldNombre, textFieldApellido, textFieldDNI, textFieldNacimiento, textFieldContrasenia;
	public JButton btnRegistrarme, btnCancelar;
	public JComboBox comboBoxSexo;
	
	public PanelLogin() {
		setLayout(null);
		setBounds(0,0,800,600);
		setBackground(new Color(255, 201, 164));
		
		lblRegistroUsuario = new JLabel("REGISTRO");
		lblRegistroUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblRegistroUsuario.setBounds(229, 35, 269, 39);
		add(lblRegistroUsuario);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(218, 106, 78, 39);
		add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(383, 106, 192, 39);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(218, 170, 78, 39);
		add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(383, 171, 192, 39);
		add(textFieldApellido);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(218, 371, 65, 39);
		add(lblDni);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(385, 371, 190, 39);
		add(textFieldDNI);
		
		lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaNacimiento.setBounds(218, 304, 160, 39);
		add(lblFechaNacimiento);
		
		textFieldNacimiento = new JTextField();
		textFieldNacimiento.setColumns(10);
		textFieldNacimiento.setBounds(383, 304, 192, 39);
		add(textFieldNacimiento);
		
		btnRegistrarme = new JButton("REGISTRARME");
		btnRegistrarme.setBounds(545, 526, 171, 39);
		add(btnRegistrarme);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(90, 526, 134, 39);
		add(btnCancelar);
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(218, 239, 78, 39);
		add(lblSexo);
		
		comboBoxSexo = new JComboBox();
		comboBoxSexo.setBounds(383, 239, 192, 39);
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		add(comboBoxSexo);
		
		lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setBounds(218, 434, 65, 39);
		add(lblContrasenia);
		
		textFieldContrasenia = new JTextField();
		textFieldContrasenia.setBounds(385, 434, 190, 39);
		add(textFieldContrasenia);
	}

}
