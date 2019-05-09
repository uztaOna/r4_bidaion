package test_modelo;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;
import modelo.Reserva;

public class test_reserva {

	@Test
	public void testConstructorVacioReserva() {		
		Reserva rva1 = new Reserva();
		
		assertEquals(rva1.getCodigoReserva(), 0);
		assertEquals(rva1.getUsuario(), null);
		assertEquals(rva1.getHotel(), null);
		assertEquals(rva1.getPrecio(), 0f, 0);
		assertEquals(rva1.getFechaIni(), null);
		assertEquals(rva1.getFechaFin(),null);
	}
	
	@Test
	public void testConstructorReserva() {
		Date inicDate = new Date(01-05-2019);
		Date finDate = new Date(12-05-2019);
		
		Reserva rva2 = new Reserva(1001, "Sabino", "Hotel Euzkadi", 88.50f, inicDate, finDate);
		
		assertEquals(rva2.getCodigoReserva(), 1001);
		assertEquals(rva2.getUsuario(), "Sabino");
		assertEquals(rva2.getHotel(), "Hotel Euzkadi");
		assertEquals(rva2.getPrecio(), 88.50f, 0);
		assertEquals(rva2.getFechaIni(), inicDate);
		assertEquals(rva2.getFechaFin(), finDate);
	}
	
	Date inicDate = new Date(01-05-2019);
	Date finDate = new Date(12-05-2019);
	Reserva rva3 = new Reserva(1001, "Sabino", "Hotel Euzkadi", 88.50f, inicDate, finDate);
	
	@Test
	public void setCodigoReserva() {
		rva3.setCodigoReserva(1001);
		assertEquals(rva3.getCodigoReserva(), 1001);
	}
	
	@Test
	public void setUsuario() {
		rva3.setUsuario("Sabino");
		assertEquals(rva3.getUsuario(), "Sabino");
	}
	
	@Test
	public void setHotel() {
		rva3.setHotel("Hotel Euzkadi");
		assertEquals(rva3.getHotel(), "Hotel Euzkadi");
	}
	
	@Test
	public void setPrecio() {
		rva3.setPrecio(88.50f);
		assertEquals( rva3.getPrecio(), 88.50f, 0);
	}
	
	@Test
	public void setFechaIni() {
		rva3.setFechaIni(inicDate);
		assertEquals(rva3.getFechaIni(), inicDate);
	}
	
	@Test
	public void setFechaFin() {
		rva3.setFechaFin(finDate);
		assertEquals(rva3.getFechaFin(), finDate);
	}

}
