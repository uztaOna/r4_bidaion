package test_modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Casa;

public class test_casa {

	private String id = "ID1";
	private String nombreAloj = "Alojamiento1";
	private String ubicacion = "Bilbao";
	private int numHabitaciones = 12;
	private int nbanos = 3;
	private double tamano = 112f;
	
	private Casa Casa1 = new Casa(id, nombreAloj, ubicacion, numHabitaciones, nbanos, tamano);
	
	@Test
	public void testConstructorCasa() {
		assertEquals(Casa1.getId(), "ID1");
		assertEquals(Casa1.getNombreAloj(), "Alojamiento1");
		assertEquals(Casa1.getUbicacion(), "Bilbao");
		assertEquals(Casa1.getNumHabitaciones(), 12);
		assertEquals(Casa1.getNbanos(), 3);
		assertEquals(Casa1.getTamano(), 112f, 0);
	}
	
	private Casa Casa2 = new Casa("c2", "casa2", "Donosti", 10, 2, 82f);
	
	@Test
	public void setNbanos() {
		Casa2.setNbanos(2);
		assertEquals(2, Casa2.getNbanos());
	}

	@Test
	public void setTamano() {
		Casa2.setTamano(82f);
		assertEquals(82f, Casa2.getTamano(), 0);
	}

}
