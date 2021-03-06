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
import vista.Vista;

public class Control_registro implements ActionListener {

	Vista vista;
	Modelo modelo;
	public static boolean pulsado;
	/**
	 * declaracion de vista,modelo
	 * @param modelo
	 * @param vista
	 */
	public Control_registro(Modelo modelo, Vista vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
	/**
	 * iniciador de eventos
	 */
	public void inicializar_eventos_registro() {
		this.vista.panelRegistro.btnCancelar.addActionListener(this);
		this.vista.panelRegistro.btnRegistrarme.addActionListener(this);
		this.vista.panelRegistro.btnAtras.addActionListener(this);
	}
	/**
	 * accionador del panel
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.vista.panelRegistro.btnRegistrarme) {
			modelo.clienteRegistrado = registro(vista,modelo);
			if(modelo.clienteRegistrado != null) {
				modelo.cbd.insertarUsuarioEnBaseDeDatos(modelo.clienteRegistrado);
				if(vista.panelHoteles.JListHoteles.getSelectedValue() == null || 
						pulsado == false)
					this.vista.setContentPane(vista.panelHoteles);
				else
					this.vista.setContentPane(vista.panelReserva);
			}
			registro(vista,modelo);
		}
		else if(e.getSource() == this.vista.panelRegistro.btnCancelar) {
			this.vista.setContentPane(vista.panelBienvenida);
		}
		else if(e.getSource() == this.vista.panelRegistro.btnAtras) {
			if(vista.panelHoteles.JListHoteles.getSelectedValue() == null || 
					pulsado == false)
				this.vista.setContentPane(vista.panelHoteles);
			else
				this.vista.setContentPane(vista.panelReserva);
		}
		limpiarRegistro(this.vista);
		Control_login.limpiarLogin(this.vista);
	}

	/**
	 * metodo para hacer el registro del usuario
	 * @param vis
	 * @param modelo
	 * @return
	 */
	public static Cliente registro(Vista vis, Modelo modelo) {
		JTextField dni = vis.panelRegistro.txtDni;
		JTextField nombre = vis.panelRegistro.txtNombre;
		JTextField apellido = vis.panelRegistro.txtApellido;
		JTextField numerocuenta = vis.panelRegistro.txtNcuenta;
		
		Date fechaNac = vis.panelRegistro.dateFnac.getDate();
		char sexo = cambiarSexoAChar(vis.panelRegistro.boxSexo);
		final char[] contra = vis.panelRegistro.txtPassword.getPassword();
		//JTextField contrasenia = vis.panelLogin.txtPassword;
		if (validarSoloLetras(nombre) && validarSoloLetras(apellido) && (nombre.getText().length() > 0) && (apellido.getText().length() > 0) && validarDNI(dni) && validarContrasenia(contra)) {
			if (modelo.consulta.comprobarDNIenBD(vis.panelRegistro.txtDni.getText()) == false) {
				return (new Cliente(nombre.getText(), apellido.getText(), dni.getText(), sexo, fechaNac, encriptarContra(contra), Integer.parseInt(numerocuenta.getText()), (double)(9999)));
			} else {
				JOptionPane.showMessageDialog(null, "El usuario introducido ya est� registrado, por favor, inicie sesi�n", "Usuario ya registrado", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		return null;	
	}
	
	/**
	 * metodo para cambiar el sexo
	 * @param ComboBoxSexo
	 * @return
	 */
	public static char cambiarSexoAChar(JComboBox ComboBoxSexo) {
		String sexo = ComboBoxSexo.getSelectedItem().toString();
		if (sexo == "Hombre") {
			return 'V';
		} else
			return 'M';
	}

	/**
	 * metodo para validar solo letras en los campos necesarios
	 * @param campoTexto
	 * @return
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
	 * metodo para validar el DNI
	 * @param DNI
	 * @return
	 */
	public static boolean validarDNI(JTextField DNI) {
		return DNI.getText().matches("^[0-9]{7,8}['T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E|T]$");
	}
	
	/**
	 * Encritacion de la contrase�a
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
	
	/**
	 * metodo para encriptar la contrase�a de tipo string
	 * @param contraUsuario
	 * @return
	 */
	public static String encriptarContraSesion(String contraUsuario) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			String contraEnc = new String(contraUsuario);
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

	/**
	 * valida que la contrase�a tenga los parametros validos
	 * @param contra
	 * @return
	 */
	public static boolean validarContrasenia(char[] contra) {
		// Regex para validar contrase�a, por orden: Una letra minuscula, una letra
		// mayuscula, un numero y minimo 8 caracteres de longitud

		Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
		String contraString=new String(contra);
		Matcher m = p.matcher(contraString);
		System.out.println(contraString);

		if (m.matches()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Introduce una letra min�scula, una may�scula, un n�mero y al menos 8 caracteres", "Contrase�a poco segura", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	/**
	 * metodo para limpiar el panel registro
	 * @param vis
	 */
	public static void limpiarRegistro(Vista vis) {
		vis.panelRegistro.txtNombre.setText("");
		vis.panelRegistro.txtApellido.setText("");
		vis.panelRegistro.txtDni.setText("");
		vis.panelRegistro.txtNcuenta.setText("");
//		vis.panelLogin.dateFnac.setTex("");
		vis.panelRegistro.txtPassword.setText("");
		vis.panelRegistro.txtNombre.setBackground(new JTextField().getBackground());
		vis.panelRegistro.txtApellido.setBackground(new JTextField().getBackground());
	}
	
}
