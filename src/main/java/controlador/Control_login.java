package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
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
	public static boolean pulsado;
	
	//Constructor
	public Control_login(Modelo modelo, Vista vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	/**
	 * inicializa evento del PanelLogin
	 */
	public void inicializar_eventos_login()
	{
		this.vista.panelLogin.btnCancelar.addActionListener(this);
		this.vista.panelLogin.btnNoAcc.addActionListener(this);
		this.vista.panelLogin.btnLogin.addActionListener(this);
		this.vista.panelLogin.btnAtras.addActionListener(this);
	}

	//Datos provisionales para prueba
		TipoHab cama1=new TipoHab(40, 10,14,16);
		Date miFecha= new Date(115, 6, 2, 15, 30);
	
		//Cliente cliente1=new Cliente("Pit", "El Anquila","64651682Q", 'M', miFecha, "QQQQ", 2, 9999999);
		Hotel hotel1=new Hotel("ID DEMO", "HOTEL DEMO", "DEMO CITY", 10, 5, 50);
	//
		
	/**
	 * Acciones del panel
	 */
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == vista.panelLogin.btnLogin) {
			modelo.clienteRegistrado = iniciarSesion(modelo, vista);			
			nombreUsuario(this.vista,modelo.clienteRegistrado);
			if(modelo.clienteRegistrado != null || 
					pulsado == false) {
				this.vista.setContentPane(vista.panelHoteles);
//				vista.setContentPane(modelo.);
			}
			else if(modelo.clienteRegistrado != null || 
					pulsado == true)
				this.vista.setContentPane(vista.panelReserva);
			else if(modelo.clienteRegistrado == null)
				System.out.println("Error");
			
			//comprobarInicioSesion(this.vista);

			
			if(vista.panelHoteles.JListHoteles.getSelectedValue() == null || 
					pulsado == false)
				this.vista.setContentPane(vista.panelHoteles);
			else
				this.vista.setContentPane(vista.panelReserva);
			
		}
		else if(e.getSource() == this.vista.panelLogin.btnNoAcc) {
			this.vista.setContentPane(vista.panelRegistro);
		}
		else if(e.getSource() == this.vista.panelLogin.btnAtras) {
			if(vista.panelHoteles.JListHoteles.getSelectedValue() == null || 
					pulsado == false)
				this.vista.setContentPane(vista.panelHoteles);
			else
				this.vista.setContentPane(vista.panelReserva);
		}
		else if(e.getSource() == this.vista.panelLogin.btnCancelar) {
			this.vista.setContentPane(vista.panelBienvenida);
		}		
		limpiarLogin(this.vista);
		Control_registro.limpiarRegistro(this.vista);
	}
	
	public static void comprobarInicioSesion(Vista vis) {
		JTextField dni = vis.panelLogin.textFieldNombre;
		char[] contra = vis.panelLogin.textFieldContrasenia.getPassword();
		//if()
	}
	
	/*
	 * Limpia los valores insertados en el panelLogin
	 */
	public static void limpiarLogin(Vista vis) {
		vis.panelLogin.textFieldNombre.setText("");
		vis.panelLogin.textFieldContrasenia.setText("");
	}
	
	/**
	 * Metodo iniciar sesion
	 * @param mod
	 * @param vis
	 * @return
	 */
	public Cliente iniciarSesion(Modelo mod, Vista vis) {
		Cliente cliente;
		System.out.println("entra sesion");
		String dniUsuario = vis.panelLogin.textFieldNombre.getText();
		char[] contraUsuario = vis.panelLogin.textFieldContrasenia.getPassword();
		
		
		cliente = this.modelo.consulta.getCliente(dniUsuario, contraUsuario);
		System.out.println(cliente.nombre + cliente.apellido);
		return cliente;
	}
	
	//-----------------------------------------------------------------------------------------------------------
	
	/**
	 * Cambia en nombre en el label
	 * @param vis
	 * @param cliente
	 */
	public static void nombreUsuario (Vista vis, Cliente cliente) {		
		vis.panelReserva.lblUsuarioReser.setText(cliente.nombre);
		vis.panelHoteles.lblUsuarioHotel.setText(cliente.nombre);
		
		vis.panelReserva.btnLogin.setText("Log out");
		vis.panelHoteles.btnLogin.setText("Log out");
		
	}
	
	/**
	 * cambia los labels al salir el usuario de su cuenta
	 * @param vis
	 */
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