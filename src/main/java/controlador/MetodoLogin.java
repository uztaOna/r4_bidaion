package controlador;

import java.awt.Color;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import app_launcher.Launcher_sprint1;
import modelo.Cliente;
import modelo.Modelo;
import vista.Ventana;

public class MetodoLogin {
		
	 /*
	 * Registra al usuario en la base de datos en el caso que no estuviera
	 */
	public static Cliente registro(Ventana vis, Modelo modelo) {
		JTextField dni = vis.panelLogin.txtDni;
		JTextField nombre = vis.panelLogin.txtNombre;
		JTextField apellido = vis.panelLogin.txtApellido;
		Date fechaNac = vis.panelLogin.dateFnac.getDate();
		char sexo = cambiarSexoAChar(vis.panelLogin.boxSexo);
		final char[] contra = vis.panelLogin.txtPassword.getPassword();
		//JTextField contrasenia = vis.panelLogin.txtPassword;
		if (validarSoloLetras(nombre) && validarSoloLetras(apellido) && (nombre.getText().length() > 0) && (apellido.getText().length() > 0) && validarDNI(dni) && validarContrasenia(contra)) {
			if (Launcher_sprint1.modelo.consulta.comprobarDNIenBD(vis.panelLogin.txtDni.getText()) == false) {
				return (new Cliente(nombre.getText(), apellido.getText(), dni.getText(), sexo, fechaNac, encriptarContra(contra), 99, (double)(9999)));
			} else {
				JOptionPane.showMessageDialog(null, "El usuario introducido ya esta registrado, porfavor inicie sesion", "Usuario ya registrado", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		return null;	
	}
	
	public static void comprobarInicioSesion(Ventana vis) {
		JTextField dni = vis.panelRegistro.textFieldNombre;
		char[] contra = vis.panelRegistro.textFieldContrasenia.getPassword();
		//if()
	}
		
	public static void limpiarRegistro(Ventana vis) {
		vis.panelLogin.txtNombre.setText("");
		vis.panelLogin.txtApellido.setText("");
		vis.panelLogin.txtDni.setText("");
//		vis.panelLogin.dateFnac.setTex("");
		vis.panelLogin.txtPassword.setText("");
		vis.panelLogin.txtNombre.setBackground(new JTextField().getBackground());
		vis.panelLogin.txtApellido.setBackground(new JTextField().getBackground());
	}
	
	public static void limpiarLogin(Ventana vis) {
		vis.panelRegistro.textFieldNombre.setText("");
		vis.panelRegistro.textFieldContrasenia.setText("");
	}
	
	/*
	 * valida que sea un DNI válido
	 */
	public static boolean validarDNI(JTextField DNI) {
		return DNI.getText().matches("^[0-9]{7,8}['T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E|T]$");
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
	//-----------------------------------------------------------------------------------------------------------
	public Cliente iniciarSesion(Modelo mod, Ventana vis) {
		String dniUsuario = vis.panelLogin.txtDni.getText();
		String contraUsuario = encriptarContra(vis.panelLogin.txtPassword.getPassword());
		String sql = "select * from cliente where DNI=\"" + dniUsuario + "\"";
		ResultSet rs = mod.conexion.hacerPeticion(sql);
		try {
			if (rs.next()) {
				String contraBase = rs.getString("Password");
				if (contraBase.equals(contraUsuario)) {
					return (new Cliente(rs.getString("DNI"), rs.getString("Nombre"), rs.getString("Apellidos"), rs.getDate("Fnac"), rs.getString("Sexo").toCharArray()[0], rs.getString("Password")));
				} else {
					JOptionPane.showMessageDialog(null, "ContraseÃ±a incorrecta", null, JOptionPane.INFORMATION_MESSAGE);
				}
			} else
				JOptionPane.showMessageDialog(null, "Este usuario no esta registrado, por favor introduzca sus datos a la izquierda", null, JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//-----------------------------------------------------------------------------------------------------------
	
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
	
	public static void nombreUsuario (Ventana vis, Cliente cliente) {		
		vis.panelReserva.lblUsuarioReser.setText(cliente.nombre);
		vis.panelHoteles.lblUsuarioHotel.setText(cliente.nombre);
		
		vis.panelReserva.btnLogReserva.setText("Log out");
		vis.panelHoteles.btnLogin.setText("Log out");
		
	}
	
	public static void salirUsuario(Ventana vis) {
		if(vis.panelReserva.btnLogReserva.getText()=="Log out" || vis.panelHoteles.btnLogHoteles.getText()=="Log out") {
			vis.panelReserva.lblUsuarioReser.setText("");
			vis.panelHoteles.lblUsuarioHotel.setText("");
			
			vis.panelReserva.btnLogReserva.setText("Loguearme");
			vis.panelHoteles.btnLogin.setText("Loguearme");
		}
		else {
			System.out.println("Debes estar en log out");
		}
	}


}