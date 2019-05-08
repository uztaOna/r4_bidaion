package test_modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Habitacion;

public class test_habitacion {
	
	private String codHabitacion = "202";
	private String tipoHabitacion = "Matrimonio";
	private double precio = 70.2f;
	
	private Habitacion habitacion = new Habitacion(codHabitacion, tipoHabitacion, precio);
	
	@Test
	public void testConstructorAlojamiento() {
		assertEquals(habitacion.getCodHabitacion(), "202");
		assertEquals(habitacion.getTipoHabitacion(), "Matrimonio");
		assertEquals(habitacion.getPrecio(), 70.2f, 0);
	}
	
	@Test
	public void setCodHabitacion() {
		habitacion.setCodHabitacion("316");
		assertEquals("316", habitacion.getCodHabitacion());
	}
	
	@Test
	public void setTipoHabitacion() {
		habitacion.setTipoHabitacion("Individual");
		assertEquals("Individual", habitacion.getTipoHabitacion());
	}
	
	@Test
	public void setPrecio() {
		habitacion.setPrecio(85.60f);
		assertEquals(85.60f, habitacion.getPrecio(), 0);
	}

}
