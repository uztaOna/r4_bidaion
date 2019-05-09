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
		Date fIni = new Date(01-05-2019);
		Date fFin = new Date(12-05-2019);
//		Reserva rva2 = new Reserva(0001, "Sabino", "Hotel Euzkadi", 88.50f, fIni, fFin);
//		
//		assertEquals(rva2.getCodigoReserva(), 0001);
//		assertEquals(rva2.getUsuario(), "Sabino");
//		assertEquals(rva2.getHotel(), "Hotel Euzkadi");
//		assertEquals(rva2.getPrecio(), 88.50f, 0);
//		assertEquals(rva2.getFechaIni(), fIni);
//		assertEquals(rva2.getFechaFin(), fFin);
	}

}
