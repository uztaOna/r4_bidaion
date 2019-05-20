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
		assertEquals(rva1.getDestino(), null);
		assertEquals(rva1.getHotel(), null);
		assertEquals(rva1.getFechaIni(), null);
		assertEquals(rva1.getFechaFin(), null);
		assertEquals(rva1.getDni(), null);
		assertEquals(rva1.getNomUsuario(), null);
		assertEquals(rva1.getApeUsuario(),null);
		assertEquals(rva1.getTipoHab(), 0);
		assertEquals(rva1.getExtras(), null);
		assertEquals(rva1.getPrecio(), 0f, 0);
	}
	
	@Test
	public void testConstructorReserva() {
		Date inicDate = new Date(01-05-2019);
		Date finDate = new Date(12-05-2019);
		
		Reserva rva2 = new Reserva(1001, "Narnia", "Hotel Narnio", inicDate, finDate, 
				"00110011X", "Pitt", "Anguila", 2, "Spa", 88.50f);
		
		assertEquals(rva2.getCodigoReserva(), 1001);
		assertEquals(rva2.getDestino(), "Narnia");
		assertEquals(rva2.getHotel(), "Hotel Narnio");
		assertEquals(rva2.getFechaIni(), inicDate);
		assertEquals(rva2.getFechaFin(), finDate);
		assertEquals(rva2.getDni(), "00110011X");
		assertEquals(rva2.getNomUsuario(), "Pitt");
		assertEquals(rva2.getApeUsuario(), "Anguila");
		assertEquals(rva2.getTipoHab(), 2);
		assertEquals(rva2.getExtras(), "Spa");
		assertEquals(rva2.getPrecio(), 88.50f, 0);
	}
	
	Date inicDate = new Date(01-05-2019);
	Date finDate = new Date(12-05-2019);
	Reserva rva3 = new Reserva();
	
	@Test
	public void setCodigoReserva() {
		rva3.setCodigoReserva(1003);
		assertEquals(rva3.getCodigoReserva(), 1003);
	}

	@Test
	public void setDestino() {
		rva3.setDestino("Orereta");
		assertEquals(rva3.getDestino(), "Orereta");
	}

	@Test
	public void setHotel() {
		rva3.setHotel("Gudari Hotela");
		assertEquals(rva3.getHotel(), "Gudari Hotela");
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

	@Test
	public void setDni() {
		rva3.setDni("00110011X");
		assertEquals(rva3.getDni(), "00110011X");
	}
	
	@Test
	public void setNomUsuario() {
		rva3.setNomUsuario("Argala");
		assertEquals(rva3.getNomUsuario(), "Argala");
	}
	
	@Test
	public void setApeUsuario() {
		rva3.setApeUsuario("Beñaran");
		assertEquals(rva3.getApeUsuario(), "Beñaran");
	}

	@Test
	public void setTipoHab() {
		rva3.setTipoHab(5);
		assertEquals(rva3.getTipoHab(), 5);
	}

	@Test
	public void setExtras() {
		rva3.setExtras("Wifi");
		assertEquals(rva3.getExtras(), "Wifi");
	}
	
	@Test
	public void setPrecio() {
		rva3.setPrecio(88.50f);
		assertEquals( rva3.getPrecio(), 88.50f, 0);
	}
}
