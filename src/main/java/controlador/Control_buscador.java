package controlador;

import java.util.ArrayList;

public class Control_buscador{
	
	private static ArrayList<String> ubicaciones;


	public static void addUbicacionesCombo() {
		//Cargar las ciudades de la bbdd y mostrar
		ubicaciones = Launcher_sprint1.modelo.consulta.getUbicaciones();
		
		//Limpiar combobox de ubicaciones de la interfaz
		Launcher_sprint1.vista.panelBuscador.comboBox.removeAllItems();
		
		//Recorrer el arraylist de ubicaciones y 
		//rellenarlos con las ubicaciones disponibles
		for(int i=0; i < ubicaciones.size(); i++) {
			Launcher_sprint1.vista.panelBuscador.comboBox.addItem(ubicaciones.get(i).toString());
		}
		
	}
}
