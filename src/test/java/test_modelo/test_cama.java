package test_modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Cama;

public class test_cama {

	private String nombreAloj = "Alojamiento1";
	private String ubicacion = "Bilbao";
	private int numHabitaciones = 2;
	private String cod_Habitacion ="A0048";
	private String tipoHabitacion = "cocina";
	private String tipoCama = "doble";
	private Cama Cama1 = new Cama(nombreAloj, ubicacion, numHabitaciones, cod_Habitacion, tipoHabitacion, tipoCama);
	
	@Test
	public void testConstructorAlojamiento() {
		assertEquals(nombreAloj, Cama1.getNombreAloj(), "Alojamiento1");
		assertEquals(ubicacion, Cama1.getUbicacion(), "Bilbao");
		assertEquals(numHabitaciones, Cama1.getNumHabitaciones(), 2);
		assertEquals(cod_Habitacion, Cama1.getCod_Habitacion(), "A0048");
		assertEquals(tipoHabitacion, Cama1.getTipoHabitacion(), "cocina");
		assertEquals(tipoHabitacion, Cama1.getTipoCama(), "doble");

	}

}