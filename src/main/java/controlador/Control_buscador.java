package controlador;

import java.util.ArrayList;

import vista.Ventana;

public class Control_buscador{
	
	public static void addUbicacionesCombo() {
		//Cargar las ciudades de la bbdd y mostrar
		 ArrayList<String> ubicaciones = Launcher_sprint1.modelo.consulta.getUbicaciones();
		
		//Limpiar combobox de ubicaciones de la interfaz
		Launcher_sprint1.vista.panelBuscador.comboBox.removeAllItems();
		
		//Recorrer el arraylist de ubicaciones y 
		//rellenarlos con las ubicaciones disponibles
		for(int i=0; i < ubicaciones.size(); i++) {
			Launcher_sprint1.vista.panelBuscador.comboBox.addItem(ubicaciones.get(i).toString());
		}
	}	
	
}
