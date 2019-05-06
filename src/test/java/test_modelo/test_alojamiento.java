package test_modelo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.Alojamiento;

public class test_alojamiento {
 
	@Test
	public void testConstructorVacioAlojamiento() {
		Alojamiento alojamiento = new Alojamiento();
		
		assertEquals(alojamiento.getId(), null);
		assertEquals(alojamiento.getNombreAloj(), null);
		assertEquals(alojamiento.getUbicacion(), null);
		assertEquals(alojamiento.getNumHabitaciones(), 0);
	}
	
	@Test
	public void testConstructorAlojamiento2() {
		Alojamiento alojamiento2 = new Alojamiento("A1", "Alojamiento1", "Bilbao", 100);
		
		assertEquals(alojamiento2.getId(), "A1");
		assertEquals(alojamiento2.getNombreAloj(), "Alojamiento1");
		assertEquals(alojamiento2.getUbicacion(), "Bilbao");
		assertEquals(alojamiento2.getNumHabitaciones(), 2);
	}
}
