package test_controlador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

import controlador.Control_bienvenida;
import modelo.Modelo;
import vista.Vista;

public class test_bienvenida {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Vista vistaMock = mock(Vista.class);
		Modelo ModeloMock = mock(Modelo.class);
		Control_bienvenida m2 = new Control_bienvenida(ModeloMock, vistaMock);
	       
		ArrayList<String> ubicacionesTest = new ArrayList<String>();
		when(ModeloMock.consulta.getUbicaciones()).thenReturn(ubicacionesTest);
	    
		m2.addUbicacionesCombo(ModeloMock, vistaMock);
	}

}
