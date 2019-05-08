package test_modelo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.Apartamento;

public class test_apartamento {
	
	private Apartamento apto2 = new Apartamento("A1", "Alojamiento1", "Bilbao", 100, 10);
	
	@Test
	public void testConstructorAlojamiento2() {		
		assertEquals(apto2.getId(), "A1");
		assertEquals(apto2.getNombreAloj(), "Alojamiento1");
		assertEquals(apto2.getUbicacion(), "Bilbao");
		assertEquals(apto2.getNumHabitaciones(), 100);
		assertEquals(apto2.getNpiso(), 10);
	}

	@Test
	public void testNPiso() {
		apto2.setNpiso(12);
		assertEquals(12, apto2.getNpiso());
	}	
}
