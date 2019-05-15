package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Cliente;
import modelo.Modelo;
import vista.Ventana;

public class Control_registro implements ActionListener {

	Ventana vista;
	Modelo modelo;
	Cliente cliente;
	
	public Control_registro(Modelo modelo, Ventana vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	public void inicializar_eventos_registro() {
		this.vista.panelRegistro.btnCancelar.addActionListener(this);
		this.vista.panelRegistro.btnRegistrarme.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.vista.panelRegistro.btnRegistrarme) {
			modelo.clienteRegistrado = registro(vista,modelo);
			if(modelo.clienteRegistrado != null) {
				modelo.cbd.insertarUsuarioEnBaseDeDatos(modelo.clienteRegistrado);
				vista.setContentPane(vista.panelReserva);
			}
			registro(vista,modelo);
		}
		else if(e.getSource() == this.vista.panelRegistro.btnCancelar) {
			this.vista.setContentPane(vista.panelBienvenida);
		}
		
	}

	public static Cliente registro(Ventana vis, Modelo modelo) {
		JTextField dni = vis.panelRegistro.txtDni;
		JTextField nombre = vis.panelRegistro.txtNombre;
		JTextField apellido = vis.panelRegistro.txtApellido;
		Date fechaNac = vis.panelRegistro.dateFnac.getDate();
		char sexo = cambiarSexoAChar(vis.panelRegistro.boxSexo);
		final char[] contra = vis.panelRegistro.txtPassword.getPassword();
		//JTextField contrasenia = vis.panelLogin.txtPassword;
		if (validarSoloLetras(nombre) && validarSoloLetras(apellido) && (nombre.getText().length() > 0) && (apellido.getText().length() > 0) && validarDNI(dni) && validarContrasenia(contra)) {
			if (modelo.consulta.comprobarDNIenBD(vis.panelRegistro.txtDni.getText()) == false) {
				return (new Cliente(nombre.getText(), apellido.getText(), dni.getText(), sexo, fechaNac, encriptarContra(contra), 99, (double)(9999)));
			} else {
				JOptionPane.showMessageDialog(null, "El usuario introducido ya está registrado, por favor, inicie sesión", "Usuario ya registrado", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		return null;	
	}
	
	/*
	 * Pasa el valor de la comboBox a char dependiendo de si es hombre (V) o mujer (M)
	 */
	public static char cambiarSexoAChar(JComboBox ComboBoxSexo) {
		String sexo = ComboBoxSexo.getSelectedItem().toString();
		if (sexo == "Hombre") {
			return 'V';
		} else
			return 'M';
	}

	/*
	 * Valida si en el campo solo hay letras
	 */
	public static boolean validarSoloLetras(JTextField campoTexto) {
		if (!(campoTexto.getText().matches("^[a-zA-Z]+$"))) {
			JOptionPane.showMessageDialog(null, "Este campo solo admite letras", "Error", JOptionPane.ERROR_MESSAGE);
			campoTexto.setBackground(new Color(240, 128, 128));
			return false;
		} else
			campoTexto.setBackground(new JTextField().getBackground());
		return true;
	}

	/*
	 * valida que sea un DNI válido
	 */
	public static boolean validarDNI(JTextField DNI) {
		return DNI.getText().matches("^[0-9]{7,8}['T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E|T]$");
	}
	
	
	/**
	 * Encritacion de la contraseña
	 * @param contrasenia
	 * @return
	 */
	public static String encriptarContra(char[] contrasenia) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			String contraEnc = new String(contrasenia);
			byte[] hashInBytes = md.digest(contraEnc.getBytes(StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder();
			for (byte b : hashInBytes) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * valida que la contraseña tenga los parámetros válidos
	 */
	public static boolean validarContrasenia(char[] contra) {
		// Regex para validar contraseña, por orden: Una letra minuscula, una letra
		// mayuscula, un numero y minimo 8 caracteres de longitud

		Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
		String contraString=new String(contra);
		Matcher m = p.matcher(contraString);
		System.out.println(contraString);

		if (m.matches()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Introduce una letra minúscula, una mayúscula, un número y al menos 8 caracteres", "Contraseña poco segura", JOptionPane.ERROR_MESSAGE);
			return false;
		}

	}
}
