package test_modelo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.Alojamiento;

public class test_alojamiento {

	private String nombreAloj = "Alojamiento1";
	private String ubicacion = "Bilbao";
	private int numHabitaciones = 2;
	private Alojamiento Alojamiento1 = new Alojamiento(nombreAloj, ubicacion, numHabitaciones);
	
	@Test
	public void testConstructorAlojamiento() {
		assertEquals(nombreAloj, Alojamiento1.getNombreAloj(), "Alojamiento1");
		assertEquals(ubicacion, Alojamiento1.getUbicacion(), "Bilbao");
		assertEquals(numHabitaciones, Alojamiento1.getNumHabitaciones(), 2);
	}
	
	@Test
	public void testNombre() {
		Alojamiento1.setNombreAloj(nombreAloj);
		assertEquals(nombreAloj, Alojamiento1.getNombreAloj());
	}
}
