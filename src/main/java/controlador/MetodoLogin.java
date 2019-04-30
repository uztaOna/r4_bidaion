package controlador;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Cliente;
import modelo.Modelo;
import vista.Ventana;

public class MetodoLogin {
	
	/*
	 * Registra al usuario si no lo está
	 */
	public Cliente registro(Ventana vis, Modelo mod) {
		String nombre = vis.panelLogin.textFieldNombre.getText();
		String apellido = vis.panelLogin.textFieldApellido.getText();
		String dni = vis.panelLogin.textFieldDNI.getText();
		char sexo = cambiarSexoAChar(vis.panelLogin.comboBoxSexo);
		String fechaNac = vis.panelLogin.textFieldNacimiento.getText();
		String contrasenia = vis.panelLogin.textFieldContrasenia.getText();	
		if (nombre.length() > 0 && apellido.length() > 0 && validarDNI(dni) == true && fechaNac.length() > 0 ) {
			return (new Cliente(nombre, apellido, dni, sexo, fechaNac, contrasenia, 99, 9999));
		} else {
			JOptionPane.showMessageDialog(null, "El usuario introducido ya esta registrado, porfavor inicie sesion", "Usuario ya registrado", JOptionPane.INFORMATION_MESSAGE);
		}
		return null;
	}
		
	/*
	 * valida que sea un DNI válido
	 */
	public boolean validarDNI(String DNI) {
		return DNI.matches("^[0-9]{7,8}['T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E|T]$");
	}
	
	/*
	 * Pasa el valor de la comboBox a char dependiendo de si es hombre (V) o mujer (M)
	 */
	public char cambiarSexoAChar(JComboBox ComboBoxSexo) {
		String sexo = ComboBoxSexo.getSelectedItem().toString();
		if (sexo == "Hombre") {
			return 'V';
		} else
			return 'M';
	}
	
	/*
	 * Valida si en el campo solo hay letras
	 */
	public boolean validarSoloLetras(JTextField campoTexto) {
		if (!(campoTexto.getText().matches("^[a-zA-Z]+$"))) {
			JOptionPane.showMessageDialog(null, "Este campo solo admite letras", "Error", JOptionPane.ERROR_MESSAGE);
			campoTexto.setBackground(new Color(240, 128, 128));
			return false;
		} else
			campoTexto.setBackground(new JTextField().getBackground());
		return true;
	}
	
	/*
	 * valida que la contraseña tenga los parámetros válidos
	 */
	public boolean validarContrasenia(char[] password) {
		// Regex para validar contraseña, por orden: Una letra minuscula, una letra
		// mayuscula, un numero y minimo 8 caracteres de longitud

		Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
		String contraString=new String(password);
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
