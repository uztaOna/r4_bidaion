package test_modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.TipoHab;

public class test_tipoHab {

	@Test
	public void test() {
		TipoHab tipo1 = new TipoHab(100, 30, 50, 20);
		
		assertEquals(tipo1.getcantHabs(), 100);
		assertEquals(tipo1.getIndividual(), 30);
		assertEquals(tipo1.getMatrimonio(), 50);
		assertEquals(tipo1.getDoble(), 20);
	}
	 
	private TipoHab tipo2 = new TipoHab(10, 3, 5, 2);
	
	@Test
	public void setcantHabs() {
		tipo2.setcantHabs(10);
		assertEquals(10, tipo2.getcantHabs(), 0);
	}
	
	@Test
	public void setIndividual() {
		tipo2.setIndividual(3);
		assertEquals(3, tipo2.getIndividual());
	}
	
	@Test
	public void setMatrimonio() {
		tipo2.setMatrimonio(5);
		assertEquals(5, tipo2.getMatrimonio());
	}
	
	@Test
	public void setDoble() {
		tipo2.setDoble(2);
		assertEquals(2, tipo2.getDoble());
	}

}
