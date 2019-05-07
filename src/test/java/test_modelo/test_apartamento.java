package test_modelo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.Alojamiento;
import modelo.Apartamento;

public class test_apartamento {

	@Test
	public void testConstructorVacioApto() {
		Apartamento apto = new Apartamento();
		
		assertEquals(apto.getId(), null);
		assertEquals(apto.getNombreAloj(), null);
		assertEquals(apto.getUbicacion(), null);
		assertEquals(apto.getNumHabitaciones(), 0);
		assertEquals(apto.getNbanos(), 0);
		assertEquals(apto.getTamano(), 0f, 0);
		assertEquals(apto.getNpiso(), 0);
	}
	
	private Apartamento apto2 = new Apartamento("A1", "Alojamiento1", "Bilbao", 100);
	
	@Test
	public void testConstructorAlojamiento2() {		
		assertEquals(apto2.getId(), "A1");
		assertEquals(apto2.getNombreAloj(), "Alojamiento1");
		assertEquals(apto2.getUbicacion(), "Bilbao");
		assertEquals(apto2.getNumHabitaciones(), 2);
	}
	
	@Test
	public void testSetId() {
		apto2.setId("Id1");
		assertEquals("Id1", apto2.getId());
	}
	
	@Test
	public void testSetNombre() {
		apto2.setNombreAloj("nombre aloj");
		assertEquals("nombre aloj", apto2.getNombreAloj());		
	}
	
	@Test
	public void testSetUbicacion() {
		apto2.setUbicacion("Calabria");
		assertEquals("Calabria", apto2.getUbicacion());
	}
	
	@Test
	public void testNPiso() {
		apto2.setNpiso(12);
		assertEquals(12, apto2.getNpiso());
	}	
}
