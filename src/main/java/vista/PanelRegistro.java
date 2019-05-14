package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

public class PanelRegistro extends JPanel {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	public JLabel lblTitulo, lblNombre, lblApellido, lblDni, lblSexo, lblPassword, lblFnac;
	public JTextField txtNombre, txtApellido, txtDni;
	public JButton btnRegistrarme, btnCancelar;
	public JComboBox boxSexo;
	public JDateChooser dateFnac;
	public JPasswordField txtPassword;
	
	public PanelRegistro() {
		setLayout(null);
		setBounds(0,0,800,600);
		setBackground(new Color(255, 201, 164));
		
		lblTitulo = new JLabel("ALTA NUEVA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblTitulo.setBounds(229, 35, 269, 39);
		add(lblTitulo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(218, 106, 78, 39);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(383, 106, 192, 39);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(218, 170, 78, 39);
		add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(383, 171, 192, 39);
		add(txtApellido);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(218, 371, 65, 39);
		add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(385, 371, 190, 39);
		add(txtDni);
		
		lblFnac = new JLabel("Fecha de nacimiento");
		lblFnac.setBounds(218, 304, 160, 39);
		add(lblFnac);
		
		dateFnac = new JDateChooser();
		dateFnac.setBounds(383, 304, 192, 39);
		add(dateFnac);
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(218, 239, 78, 39);
		add(lblSexo);
		
		boxSexo = new JComboBox();
		boxSexo.setBounds(383, 239, 192, 39);
		boxSexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		add(boxSexo);
		
		lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setBounds(218, 434, 65, 39);
		add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(385, 434, 190, 39);
		add(txtPassword);
		
		btnRegistrarme = new JButton("REGISTRARME");
		btnRegistrarme.setBounds(545, 526, 171, 39);
		add(btnRegistrarme);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(90, 526, 134, 39);
		add(btnCancelar);
		
	}
}
