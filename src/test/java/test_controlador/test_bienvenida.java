package test_controlador;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

import controlador.Control_bienvenida;
import modelo.Consultas;
import modelo.Modelo;
import vista.PanelBuscador;
import vista.Vista;

public class test_bienvenida {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Vista vistaMock = mock(Vista.class);
		//Modelo ModeloMock = mock(Modelo.class);
		Modelo modelo = new Modelo();
		Consultas consultaMock = mock(Consultas.class);
		PanelBuscador panelBuscadorMock = mock(PanelBuscador.class);
		ArrayList<String> ubicacionesTest = new ArrayList<String>();
		ubicacionesTest.add("Bilbao");
		when(consultaMock.getUbicaciones()).thenReturn(ubicacionesTest);
		Control_bienvenida m2 = new Control_bienvenida(modelo, vistaMock);
	       
		
	    
		m2.addUbicacionesCombo(vistaMock, consultaMock, panelBuscadorMock);
		verify(panelBuscadorMock, times(1)).limpiarPanelBuscador();
		//verify(panelBuscadorMock, times(1)).anadirElementoCombo(AnyString());
	}

}
