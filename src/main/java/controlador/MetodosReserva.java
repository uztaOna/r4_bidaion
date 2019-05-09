package controlador;

import java.util.Date;
import javax.swing.JOptionPane;
import modelo.TipoHab;
import vista.Ventana;

public class MetodosReserva { 
	
	/*
	 * Registra al usuario si no lo est�
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
		int numEntero = Integer.parseInt(vis.panelReserva.lblCantInd.getText())+1;
		String texto=Integer.toString(numEntero);
		return texto;
	}
	
	public static String sumaBoton2 (Ventana vis) {
		int numEntero = Integer.parseInt(vis.panelReserva.lblCantMatri.getText())+1;
		String texto=Integer.toString(numEntero);
		return texto;
	}
	
	public static String sumaBoton3 (Ventana vis) {
		int numEntero = Integer.parseInt(vis.panelReserva.lblCantDoble.getText())+1;
		String texto=Integer.toString(numEntero);
		return texto;
	}
	
	public static String restaBoton (Ventana vis) {
		int numEntero = Integer.parseInt(vis.panelReserva.lblCantInd.getText())-1;
		String texto=Integer.toString(numEntero);
		return texto;
	}
	
	public static String restaBoton2 (Ventana vis) {
		int numEntero = Integer.parseInt(vis.panelReserva.lblCantMatri.getText())-1;
		String texto=Integer.toString(numEntero);
		return texto;
	}
	
	public static String restaBoton3 (Ventana vis) {
		int numEntero = Integer.parseInt(vis.panelReserva.lblCantDoble.getText())-1;
		String texto=Integer.toString(numEntero);
		return texto;
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
