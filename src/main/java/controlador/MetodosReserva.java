package controlador;

import java.util.Date;
import javax.swing.JOptionPane;
import modelo.TipoHab;
import vista.Ventana;

public class MetodosReserva { 
	
	/*
	 * Registra al usuario si no lo está
	 */
	public static boolean reserva(Ventana vis, TipoHab cama) {
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
	
	public static String sumaBoton (Ventana vis) {
		if(Double.parseDouble(vis.panelReserva.lblInDisp.getText())!=Double.parseDouble(vis.panelReserva.lblCantInd.getText())){
			int numEntero = Integer.parseInt(vis.panelReserva.lblCantInd.getText())+1;
			String texto=Integer.toString(numEntero);
			return texto;
		}
		else return vis.panelReserva.lblCantInd.getText();
	}
	
	public static String sumaBoton2 (Ventana vis) {
		if(Double.parseDouble(vis.panelReserva.lblMatriDisp.getText())!=Double.parseDouble(vis.panelReserva.lblCantMatri.getText())){
			int numEntero = Integer.parseInt(vis.panelReserva.lblCantMatri.getText())+1;
			String texto=Integer.toString(numEntero);
			return texto;
		}
		else return vis.panelReserva.lblCantMatri.getText();
	}
	
	public static String sumaBoton3 (Ventana vis) {
		if(Double.parseDouble(vis.panelReserva.lblDobleDisp.getText())!=Double.parseDouble(vis.panelReserva.lblCantDoble.getText())){
			int numEntero = Integer.parseInt(vis.panelReserva.lblCantDoble.getText())+1;
			String texto=Integer.toString(numEntero);
			return texto;
		}
		else return vis.panelReserva.lblCantDoble.getText();
	}
	
	public static String restaBoton (Ventana vis) {
		if(Double.parseDouble(vis.panelReserva.lblCantInd.getText())>0){
			int numEntero = Integer.parseInt(vis.panelReserva.lblCantInd.getText())-1;
			String texto=Integer.toString(numEntero);
			return texto;
		}
		else return vis.panelReserva.lblCantInd.getText();
	}
	
	public static String restaBoton2 (Ventana vis) {
		if(Double.parseDouble(vis.panelReserva.lblCantMatri.getText())>0){
			int numEntero = Integer.parseInt(vis.panelReserva.lblCantMatri.getText())-1;
			String texto=Integer.toString(numEntero);
			return texto;
		}
		else return vis.panelReserva.lblCantMatri.getText();
	}
	
	public static String restaBoton3 (Ventana vis) {
		if(Double.parseDouble(vis.panelReserva.lblCantDoble.getText())>0){
			int numEntero = Integer.parseInt(vis.panelReserva.lblCantDoble.getText())-1;
			String texto=Integer.toString(numEntero);
			return texto;
		}
		else return vis.panelReserva.lblCantDoble.getText();
	}
	
	public static boolean confirmarEleccion(Ventana vis) {
		if(vis.panelReserva.lblCantInd.getText()=="0" && vis.panelReserva.lblCantMatri.getText()=="0" &&
				vis.panelReserva.lblCantDoble.getText()=="0") {
			return false;
		}else return true;
	}
	
	public static void disponibilidadCamas (Ventana vis, TipoHab cama) {
		vis.panelReserva.lblInDisp.setText(Integer.toString(cama.getIndividual()));
		vis.panelReserva.lblMatriDisp.setText(Integer.toString(cama.getMatrimonio()));
		vis.panelReserva.lblDobleDisp.setText(Integer.toString(cama.getDoble()));
	}

	public static void actualizacionCamas (Ventana vis, TipoHab cama) {
		cama.setIndividual(cama.getIndividual()-Integer.parseInt(vis.panelReserva.lblCantInd.getText()));
		cama.setMatrimonio(cama.getMatrimonio()-Integer.parseInt(vis.panelReserva.lblMatriDisp.getText()));
		cama.setDoble(cama.getDoble()-Integer.parseInt(vis.panelReserva.lblDobleDisp.getText()));
		vis.panelReserva.lblInDisp.setText(Integer.toString(cama.getIndividual()));
		vis.panelReserva.lblMatriDisp.setText(Integer.toString(cama.getMatrimonio()));
		vis.panelReserva.lblDobleDisp.setText(Integer.toString(cama.getDoble()));
	}
	
	public static void limpiarDispReser(Ventana vis) {
		vis.panelReserva.lblCantInd.setText("0");
		vis.panelReserva.lblCantMatri.setText("0");
		vis.panelReserva.lblCantDoble.setText("0");
	}
	
	
	/*Comprueba que la fecha sea anterior a hoy*/
	
	public static void validarFecha(Ventana vista) {
		vista.panelBuscador.dateInicio.setMinSelectableDate(new Date());
	}
	
}
