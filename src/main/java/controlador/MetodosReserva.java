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

import modelo.TipoHab;
import modelo.Cliente;
import modelo.Habitacion;
import modelo.Modelo;
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
		String nombreAloj = cama.getNombreAloj();
		String ubicacion= cama.getUbicacion();
		String cod_Habitacion = cama.getCod_Habitacion();
		String tipoHabitacion= cama.getTipoHabitacion();
		
		if(individual>cama.getIndividual()||matrimonio>cama.getMatrimonio()||doble>cama.getDoble()) {
			JOptionPane.showMessageDialog(null, "Uno de los campos es incorrecto");
			return false;
		}else {
			int NHabitaciones=cama.getNumHabitaciones()-(individual+matrimonio+doble);
			cama.setNumHabitaciones(NHabitaciones);
			System.out.println(individual+matrimonio+doble+nombreAloj+ubicacion+cod_Habitacion+tipoHabitacion);
			cama.setNumHabitaciones(NHabitaciones);
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
	
	public boolean validarFecha(Date fecha) {
		if(!fecha.before(Calendar.getInstance().getTime())) {
			JOptionPane.showMessageDialog(null, "La fecha introducida no es valida","Error en la fecha", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}else return true; 
	}
	
}
