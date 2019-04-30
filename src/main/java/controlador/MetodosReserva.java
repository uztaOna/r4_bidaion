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

import modelo.Cama;
import modelo.Cliente;
import modelo.Habitacion;
import modelo.Modelo;
import vista.Ventana;

public class MetodosReserva {
	
	/*
	 * Registra al usuario si no lo está
	 */
	public static boolean reserva(Ventana vis, Modelo mod, Cama cama) {
		int individual=vis.panelReserva.indspinn.getComponentCount();
		System.out.println(individual);
		int matrimonio=vis.panelReserva.matrispinn.getComponentCount();
		int doble=vis.panelReserva.doblespinn.getComponentCount();
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

}
