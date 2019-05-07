package controlador;

import vista.Ventana;
import modelo.*;

public class Launcher_sprint1 {

	public static Modelo modelo;
	public static Ventana vista;
	
	public static void main(String[] args) {
		
		// Instancia de las clases necesarias para el programa
 
		vista = new Ventana();
		modelo = new Modelo();
		
		Controlador control = new Controlador(vista,modelo);
	
		// Hacer la vista visible 
		vista.setVisible(true);
	}
}
