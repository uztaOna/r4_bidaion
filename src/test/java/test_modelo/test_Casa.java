package test_modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Casa;

public class test_Casa {

	private String id = "ID1";
	private String nombreAloj = "Alojamiento1";
	private String ubicacion = "Bilbao";
	private int numHabitaciones = 2;
	private int nbanos = 2;
	private int tamano = 2;
	private Casa Casa1 = new Casa(id, nombreAloj, ubicacion, numHabitaciones, 7, 4);
	
	@Test
	public void testConstructorAlojamiento() {
		assertEquals(id, Casa1.getId(), "ID1");
		assertEquals(nombreAloj, Casa1.getNombreAloj(), "Alojamiento1");
		assertEquals(ubicacion, Casa1.getUbicacion(), "Bilbao");
		assertEquals(numHabitaciones, Casa1.getNumHabitaciones(), 2);
		assertEquals(nbanos, Casa1.getNbanos(), 2);
		assertEquals(tamano, Casa1.getTamano(), 2);
	}

}
