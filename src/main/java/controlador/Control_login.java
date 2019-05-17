package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Cliente;
import modelo.Hotel;
import modelo.Modelo;
import modelo.TipoHab;
import vista.Vista;

public class Control_login implements ActionListener {
		
	 /*
	 * Registra al usuario en la base de datos en el caso que no estuviera
	 */
	
	Vista vista;
	Modelo modelo;
	Cliente cliente;
	
	//Constructor
	public Control_login(Modelo modelo, Vista vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	public void inicializar_eventos_login()
	{
		this.vista.panelLogin.btnCancelar.addActionListener(this);
		this.vista.panelLogin.btnNoAcc.addActionListener(this);
		this.vista.panelLogin.btnLogin.addActionListener(this);
	}

	//Datos provisionales para prueba
		TipoHab cama1=new TipoHab(40, 10,14,16);
		Date miFecha= new Date(115, 6, 2, 15, 30);
	
		Cliente cliente1=new Cliente("Pit", "El Anquila","64651682Q", 'M', miFecha, "QQQQ", 2, 9999999);
		Hotel hotel1=new Hotel("ID DEMO", "HOTEL DEMO", "DEMO CITY", 10, 5, 50);
	//
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vista.panelLogin.btnLogin) {		
			nombreUsuario(vista, cliente1);
			comprobarInicioSesion(vista);
		}
		else if(e.getSource() == this.vista.panelLogin.btnNoAcc) {
			this.vista.setContentPane(vista.panelRegistro);
		}
		else if(e.getSource() == this.vista.panelLogin.btnCancelar) {
			this.vista.setContentPane(vista.panelBienvenida);		
			limpiarLogin(this.vista);
			limpiarRegistro(this.vista);
		}
	}
	
	public static void comprobarInicioSesion(Vista vis) {
		JTextField dni = vis.panelLogin.textFieldNombre;
		char[] contra = vis.panelLogin.textFieldContrasenia.getPassword();
		//if()
	}
		
	public static void limpiarRegistro(Vista vis) {
		vis.panelRegistro.txtNombre.setText("");
		vis.panelRegistro.txtApellido.setText("");
		vis.panelRegistro.txtDni.setText("");
//		vis.panelLogin.dateFnac.setTex("");
		vis.panelRegistro.txtPassword.setText("");
		vis.panelRegistro.txtNombre.setBackground(new JTextField().getBackground());
		vis.panelRegistro.txtApellido.setBackground(new JTextField().getBackground());
	}
	
	public static void limpiarLogin(Vista vis) {
		vis.panelLogin.textFieldNombre.setText("");
		vis.panelLogin.textFieldContrasenia.setText("");
	}
	
	//-----------------------------------------------------------------------------------------------------------
	public Cliente iniciarSesion(Modelo mod, Vista vis) {
		String dniUsuario = vis.panelRegistro.txtDni.getText();
		String contraUsuario = Control_registro.encriptarContra(vis.panelRegistro.txtPassword.getPassword());
		String sql = "select * from cliente where DNI=\"" + dniUsuario + "\"";
		ResultSet rs = mod.conexion.hacerPeticion(sql);
		try {
			if (rs.next()) {
				String contraBase = rs.getString("Password");
				if (contraBase.equals(contraUsuario)) {
					return (new Cliente(rs.getString("DNI"), rs.getString("Nombre"), rs.getString("Apellidos"), rs.getDate("Fnac"), rs.getString("Sexo").toCharArray()[0], rs.getString("Password")));
				} else {
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta", null, JOptionPane.INFORMATION_MESSAGE);
				}
			} else
				JOptionPane.showMessageDialog(null, "Este usuario no esta registrado, por favor introduzca sus datos a la izquierda", null, JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//-----------------------------------------------------------------------------------------------------------
	
	public static void nombreUsuario (Vista vis, Cliente cliente) {		
		vis.panelReserva.lblUsuarioReser.setText(cliente.nombre);
		vis.panelHoteles.lblUsuarioHotel.setText(cliente.nombre);
		
		vis.panelReserva.btnLogin.setText("Log out");
		vis.panelHoteles.btnLogin.setText("Log out");
		
	}
	
	public static void salirUsuario(Vista vis) {
		if(vis.panelReserva.btnLogin.getText()=="Log out") {
			vis.panelReserva.lblUsuarioReser.setText("");
			vis.panelHoteles.lblUsuarioHotel.setText("");
			
			vis.panelReserva.btnLogin.setText("Loguearme");
			vis.panelHoteles.btnLogin.setText("Loguearme");
		}
		else {
			System.out.println("Debes estar en log out");
		}
	}
}