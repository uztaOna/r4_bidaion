package test_modelo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import modelo.Cliente;

public class test_cliente {

	@Test
	public void testConstructorCliente() {
		Cliente user1 = new Cliente("Pit", "El Anguila", "01234567X", "H", "01/10/1990", 
				"password", "1234567890",   80.80f);
		assertEquals(user1.getId(), "ID1");
		assertEquals(user1.getNombreAloj(), "Alojamiento1");
		assertEquals(user1.getUbicacion(), "Bilbao");
		assertEquals(Casa1.getNumHabitaciones(), 12);
		assertEquals(Casa1.getNbanos(), 3);
		assertEquals(Casa1.getTamano(), 112f, 0);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
