package test_modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Habitacion;

public class test_habitacion {
	private String id = "ID1";
	private String nombreAloj = "Alojamiento1";
	private String ubicacion = "Bilbao";
	private int numHabitaciones = 2;
	private String cod_Habitacion="A0048";
	private String tipoHabitacion= "cocina";
	
	private Habitacion Habitacion1 = new Habitacion(id, nombreAloj, ubicacion, numHabitaciones, cod_Habitacion, tipoHabitacion);
	
	@Test
	public void testConstructorAlojamiento() {
		assertEquals(nombreAloj, Habitacion1.getNombreAloj(), "Alojamiento1");
		assertEquals(ubicacion, Habitacion1.getUbicacion(), "Bilbao");
		assertEquals(numHabitaciones, Habitacion1.getNumHabitaciones(), 2);
		assertEquals(cod_Habitacion, Habitacion1.getCod_Habitacion(), "A0048");
		assertEquals(tipoHabitacion, Habitacion1.getTipoHabitacion(), "cocina");
	}

}
