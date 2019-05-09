package test_modelo;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;
import modelo.Cliente;

public class test_cliente {

	@Test
	public void testConstructorVacioCliente() {		
		Cliente user1 = new Cliente();
		
		assertEquals(user1.getNombre(), null);
		assertEquals(user1.getApellido(), null);
		assertEquals(user1.getDni(), null);
		assertEquals(user1.getSexo(), null);
		assertEquals(user1.getFechaNac(), null);
		assertEquals(user1.getContrasenia(),null);
		assertEquals(user1.getNCuenta(), 0);
		assertEquals(user1.getSaldo(), 0f, 0);
		assertNull(user1.getFechaNac());
	}
	
	@Test
	public void testConstructorCliente() {
		Date date = new Date(01-12-1990);
		char[] password = "password".toCharArray();
		
		Cliente user1 = new Cliente("Pit", "El Anguila", "01234567X", 'H', date, 
				password, 1234567890, 1000f);
		
		assertEquals(user1.getNombre(), "Pit");
		assertEquals(user1.getApellido(), "El Anguila");
		assertEquals(user1.getDni(), "01234567X");
		assertEquals(user1.getSexo(), 'H');
		assertEquals(user1.getFechaNac(), date);
		assertEquals(user1.getContrasenia(),password);
		assertEquals(user1.getNCuenta(),1234567890);
		assertEquals(user1.getSaldo(), 1000f, 0);
	}
	
	Date date2 = new Date(01-12-1990);
	char[] password2 = "password".toCharArray();
	Cliente user2 = new Cliente("Pit", "El Anguila", "01234567X", 'H', date2, 
			password2, 1234567890, 1000f);
	
	@Test
	public void setNommbre() {
		user2.setNombre("Pit");
		assertEquals("Pit", user2.getNombre());
	}
	
	@Test
	public void setApellido() {
		user2.setApellido("El Anguila");
		assertEquals("El Anguila", user2.getApellido());
	}
	
	@Test
	public void setDni() {
		user2.setDni("01234567X");
		assertEquals("01234567X", user2.getDni());
	}
	
	@Test
	public void setSexo() {
		user2.setSexo('H');
		assertEquals('H', user2.getSexo());
	}
	
	@Test
	public void setFechaNac() {
		user2.setFechaNac(date2);
		assertEquals(date2, user2.getFechaNac());
	}
	
	@Test
	public void setContrasenia() {
		user2.setContrasenia(password2);
		assertEquals(password2, user2.getContrasenia());
	}
	
	@Test
	public void setNCuenta() {
		user2.setNCuenta(1234567890);
		assertEquals(1234567890, user2.getNCuenta());
	}
	
	@Test
	public void setSaldo() {
		user2.setSaldo(1000f);
		assertEquals(1000f, user2.getSaldo(), 0);
	}
}
