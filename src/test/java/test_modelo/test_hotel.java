package test_modelo;

import static org.junit.Assert.*;
import org.junit.Test;
import modelo.Hotel;

public class test_hotel {

	private Hotel hotel2 = new Hotel("H1", "Hotel2", "Bilbao", 100, 5, 50.5f);
	
	@Test
	public void testConstructorVacioHotel() {
		Hotel hotel = new Hotel();
		
		assertEquals(hotel.getId(), null);
		assertEquals(hotel.getNombreAloj(), null);
		assertEquals(hotel.getUbicacion(), null);
		assertEquals(hotel.getNumHabitaciones(), 0);
		assertEquals(hotel.getCategoria(), 0);
		assertEquals(hotel.getPrecio(), 0f, 0);
	}
	
	@Test
	public void testConstructorHotel2() {
		Hotel hotel2 = new Hotel("H1", "Hotel2", "Bilbao", 100, 5, 50.5f);
		
		assertEquals(hotel2.getId(), "H1");
		assertEquals(hotel2.getNombreAloj(), "Hotel2");
		assertEquals(hotel2.getUbicacion(), "Bilbao");
		assertEquals(hotel2.getNumHabitaciones(), 100);
		assertEquals(hotel2.getCategoria(), 5);
		assertEquals(hotel2.getPrecio(), 50.50f, 0);
	}
	
	@Test
	public void testToStringNombre() {
		String expectedString = "Hotel3";
		
		Hotel hotel3 = new Hotel("H1", "Hotel3", "Bilbao", 100, 5, 50.5f);
		
		assertEquals(expectedString, hotel3.toStringNombre());
	}
	
	@Test
	public void testToString() {
		String expectedString = "H1 + Hotel3 + \r\n" + 
				"				Bilbao + \r\n" + 
				"				5 + \" estrellas\" +\r\n" + 
				"				50,50";
		
		Hotel hotel3 = new Hotel("H1", "Hotel3", "Bilbao", 100, 5, 50.5f);
		
		assertEquals(expectedString, hotel3.toString());
	}
	
	@Test
	public void testSetId() {
		hotel2.setId("Id1");
		assertEquals("Id1", hotel2.getId());
	}
	
	@Test
	public void testSetNombre() {
		hotel2.setNombreAloj("nombre aloj");
		assertEquals("nombre aloj", hotel2.getNombreAloj());		
	}
	
	@Test
	public void testSetUbicacion() {
		hotel2.setUbicacion("Calabria");
		assertEquals("Calabria", hotel2.getUbicacion());
	}
	
	@Test
	public void testSetNumHabs() {
		hotel2.setNumHabitaciones(12);
		assertEquals(12, hotel2.getNumHabitaciones());
	}
	
	@Test
	public void testSetCategoria() {
		hotel2.setCategoria(1);
		assertEquals(1, hotel2.getCategoria());
	}
	
	@Test
	public void testSetPrecio() {
		hotel2.setPrecio(20.2f);
		assertEquals(20.2f, 0, hotel2.getPrecio());
	}

}
