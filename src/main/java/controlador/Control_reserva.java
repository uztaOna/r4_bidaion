package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Hotel;
import modelo.Modelo;
import modelo.TipoHab;
import vista.Vista;

public class Control_reserva implements ActionListener { 
	
	Vista vista;
	Modelo modelo;
	public static boolean pulsado;
	
	public Control_reserva(Modelo modelo, Vista vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	public void inicializar_eventos_reserva() {
		this.vista.panelReserva.btnLogin.addActionListener(this);
		this.vista.panelReserva.btnRegistro.addActionListener(this);
		this.vista.panelReserva.btnReservar.addActionListener(this);
		this.vista.panelReserva.btnCancelar.addActionListener(this);
		this.vista.panelReserva.btnAtras.addActionListener(this);
		this.vista.panelReserva.btnIndividual.addActionListener(this);
		this.vista.panelReserva.btnMasInd.addActionListener(this);
		this.vista.panelReserva.btnMenosInd.addActionListener(this);
		this.vista.panelReserva.btnMatrimonio.addActionListener(this);
		this.vista.panelReserva.btnMasMatri.addActionListener(this);
		this.vista.panelReserva.btnMenosMatri.addActionListener(this);	
		this.vista.panelReserva.btnDoble.addActionListener(this);
		this.vista.panelReserva.btnMasDoble.addActionListener(this);
		this.vista.panelReserva.btnMenosDoble.addActionListener(this);
	}

	TipoHab cama1=new TipoHab(40, 10,14,16);
//	Date miFecha= new Date(115, 6, 2, 15, 30);
//	Cliente cliente1=new Cliente("Pit", "El Anquila","64651682Q", 'M', miFecha, "QQQQ", 2, 9999999);
	Hotel hotel1=new Hotel("ID DEMO", "HOTEL DEMO", "DEMO CITY", 10, 5, 50);

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vista.panelReserva.btnIndividual || e.getSource() == vista.panelReserva.btnMasInd) {			
			vista.panelReserva.lblCantInd.setText(sumaBoton(vista));
		}
		else if(e.getSource() == vista.panelReserva.btnMatrimonio || e.getSource() == vista.panelReserva.btnMasMatri) {			
			vista.panelReserva.lblCantMatri.setText(sumaBoton2(vista));
		}
		else if(e.getSource() == vista.panelReserva.btnDoble || e.getSource() == vista.panelReserva.btnMasDoble) {			
			vista.panelReserva.lblCantDoble.setText(sumaBoton3(vista));
		}
		else if(e.getSource() == vista.panelReserva.btnMenosInd) {			
			vista.panelReserva.lblCantInd.setText(restaBoton(vista));
		}
		else if(e.getSource() == vista.panelReserva.btnMenosMatri) {			
			vista.panelReserva.lblCantMatri.setText(restaBoton2(vista));
		}
		else if(e.getSource() == vista.panelReserva.btnMenosDoble) {			
			vista.panelReserva.lblCantDoble.setText(restaBoton3(vista));
		}
		else if(e.getSource() == vista.panelReserva.btnReservar) {
			if(vista.panelReserva.btnLogin.getText()=="Log out") {
				if(Reserva(vista, cama1)==true && confirmarEleccion(vista)==true) {
					vista.panelPago.textAPagar.setText(String.valueOf(
							(Control_pago.precio(vista, hotel1)+Control_pago.precioRadios(vista))*Control_buscador.getPernoctaciones(vista)));
					vista.setContentPane(vista.panelPago);
				}else{
					JOptionPane.showMessageDialog(null,"Elija al menos una cama, por favor.","Error",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"Debe logearse primero.","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource() == vista.panelReserva.btnAtras) {
			vista.setContentPane(vista.panelHoteles);			
		}
		else if(e.getSource() == vista.panelReserva.btnCancelar) {
			vista.setContentPane(vista.panelBienvenida);
			limpiarDispReser(this.vista);
		}
		else if( e.getSource() == this.vista.panelReserva.btnLogin) {
			if(this.vista.panelReserva.btnLogin.getText() == "Log out") {				
				Control_login.salirUsuario(this.vista);
			}
			else {
				this.vista.setContentPane(this.vista.panelLogin);
			}
		}
		else if(e.getSource() == this.vista.panelReserva.btnRegistro) {
			this.vista.setContentPane(this.vista.panelRegistro);
		}
	}
		
	/*
	 * Registra al usuario si no lo está
	 */
	public static boolean Reserva(Vista vis, TipoHab cama) {
		int individual=vis.panelReserva.lblCantInd.getComponentCount();
		System.out.println(individual);
		int matrimonio=vis.panelReserva.lblCantMatri.getComponentCount();
		int doble=vis.panelReserva.lblCantDoble.getComponentCount();		
		
		if(individual>cama.getIndividual()||matrimonio>cama.getMatrimonio()||doble>cama.getDoble()) {
			JOptionPane.showMessageDialog(null, "Uno de los campos es incorrecto");
			return false;
		}else {
			int NHabitaciones=cama.getcantHabs()-(individual+matrimonio+doble);
			cama.setcantHabs(NHabitaciones);
			System.out.println(individual+matrimonio+doble);
			cama.setcantHabs(NHabitaciones);
			cama.setDoble(doble);
			cama.setIndividual(individual);
			cama.setMatrimonio(matrimonio);
		}
		return true;
	}
	
	/*
	 * Suma 1 a la cantidad de camas individuales
	 */
	public static String sumaBoton (Vista vis) {
		if(Double.parseDouble(vis.panelReserva.lblInDisp.getText())!=Double.parseDouble(vis.panelReserva.lblCantInd.getText())){
			int numEntero = Integer.parseInt(vis.panelReserva.lblCantInd.getText())+1;
			String texto=Integer.toString(numEntero);
			return texto;
		}
		else return vis.panelReserva.lblCantInd.getText();
	}
	
	/*
	 * Suma 1 a la cantidad de camas de matrimonio
	 */
	public static String sumaBoton2 (Vista vis) {
		if(Double.parseDouble(vis.panelReserva.lblMatriDisp.getText())!=Double.parseDouble(vis.panelReserva.lblCantMatri.getText())){
			int numEntero = Integer.parseInt(vis.panelReserva.lblCantMatri.getText())+1;
			String texto=Integer.toString(numEntero);
			return texto;
		}
		else return vis.panelReserva.lblCantMatri.getText();
	}
	
	/*
	 * Suma 1 a la cantidad de camas dobles
	 */
	public static String sumaBoton3 (Vista vis) {
		if(Double.parseDouble(vis.panelReserva.lblDobleDisp.getText())!=Double.parseDouble(vis.panelReserva.lblCantDoble.getText())){
			int numEntero = Integer.parseInt(vis.panelReserva.lblCantDoble.getText())+1;
			String texto=Integer.toString(numEntero);
			return texto;
		}
		else return vis.panelReserva.lblCantDoble.getText();
	}
	
	/*
	 * Resta 1 a la cantidad de camas individuales
	 */
	public static String restaBoton (Vista vis) {
		if(Double.parseDouble(vis.panelReserva.lblCantInd.getText())>0){
			int numEntero = Integer.parseInt(vis.panelReserva.lblCantInd.getText())-1;
			String texto=Integer.toString(numEntero);
			return texto;
		}
		else return vis.panelReserva.lblCantInd.getText();
	}
	
	/*
	 * Resta 1 a la cantidad de camas de matrimonio
	 */
	public static String restaBoton2 (Vista vis) {
		if(Double.parseDouble(vis.panelReserva.lblCantMatri.getText())>0){
			int numEntero = Integer.parseInt(vis.panelReserva.lblCantMatri.getText())-1;
			String texto=Integer.toString(numEntero);
			return texto;
		}
		else return vis.panelReserva.lblCantMatri.getText();
	}
	
	/*
	 * Resta 1 a la cantidad de camas dobles
	 */
	public static String restaBoton3 (Vista vis) {
		if(Double.parseDouble(vis.panelReserva.lblCantDoble.getText())>0){
			int numEntero = Integer.parseInt(vis.panelReserva.lblCantDoble.getText())-1;
			String texto=Integer.toString(numEntero);
			return texto;
		}
		else return vis.panelReserva.lblCantDoble.getText();
	}
	
	/*
	 * Confirma que hay al menos una cama seleccionada
	 */
	public static boolean confirmarEleccion(Vista vis) {
		if(Integer.parseInt(vis.panelReserva.lblCantInd.getText())<1 && Integer.parseInt(vis.panelReserva.lblCantMatri.getText())<1 &&
				Integer.parseInt(vis.panelReserva.lblCantDoble.getText())<1) {
			return false;
		}else return true;
	}
	
	/*
	 * Muestra la cantidad de camas libres
	 */
	public static void disponibilidadCamas (Vista vis, TipoHab cama) {
		vis.panelReserva.lblInDisp.setText(Integer.toString(cama.getIndividual()));
		vis.panelReserva.lblMatriDisp.setText(Integer.toString(cama.getMatrimonio()));
		vis.panelReserva.lblDobleDisp.setText(Integer.toString(cama.getDoble()));
	}

	/*
	 * Va actualizando la cantidad de las camas
	 */
	public static void actualizacionCamas (Vista vis, TipoHab cama) {
		cama.setIndividual(cama.getIndividual()-Integer.parseInt(vis.panelReserva.lblCantInd.getText()));
		cama.setMatrimonio(cama.getMatrimonio()-Integer.parseInt(vis.panelReserva.lblMatriDisp.getText()));
		cama.setDoble(cama.getDoble()-Integer.parseInt(vis.panelReserva.lblDobleDisp.getText()));
		vis.panelReserva.lblInDisp.setText(Integer.toString(cama.getIndividual()));
		vis.panelReserva.lblMatriDisp.setText(Integer.toString(cama.getMatrimonio()));
		vis.panelReserva.lblDobleDisp.setText(Integer.toString(cama.getDoble()));
	}
	
	/*
	 * Limpia los valores insertados en el panelReserva
	 */
	public static void limpiarDispReser(Vista vis) {
		vis.panelReserva.lblCantInd.setText("0");
		vis.panelReserva.lblCantMatri.setText("0");
		vis.panelReserva.lblCantDoble.setText("0");
	}
}
