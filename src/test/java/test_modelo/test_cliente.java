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
	
	Date date = new Date(01-12-1990);
	char[] password = "password".toCharArray();
	Cliente user2 = new Cliente("Pit", "El Anguila", "01234567X", 'H', date, 
			password, 1234567890, 1000f);
	
	@Test
	public void setNbanos() {
		user2.getNombre("Pit");
		assertEquals(user2.getNombre());
	}


}
