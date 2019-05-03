package controlador;

import javax.swing.JOptionPane;
import modelo.Cama;
import modelo.Hotel;
import modelo.Modelo;
import vista.Ventana;

public class MetodosReserva {
	
	/*
	 * Registra al usuario si no lo está
	 */
	public static void infoRva() {
		// 1 Leer JList seleccionado
		String nombreHotel = (String)Launcher_sprint1.vista.panelHoteles.jlistHoteles.getSelectedValue();
		
		// 2 Ir a BBDD y sacar datos de hotel pasandole NOMBRE
		Hotel hotel = Launcher_sprint1.modelo.consulta.getDatosHotel(nombreHotel);
		
		// 3 Cambiar labels de pan hoteles con datos de bbdd
		Launcher_sprint1.vista.panelReserva.lblHotelSelec.setText(hotel.getNombreAloj());
	}
	
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
