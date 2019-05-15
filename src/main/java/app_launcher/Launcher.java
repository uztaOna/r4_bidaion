package app_launcher;

import vista.Vista;
import controlador.Controlador;
import modelo.*;

public class Launcher {

	public static Modelo modelo;
	public static Vista vista;
	
	public static void main(String[] args) {
		
		// Instancia de las clases necesarias para el programa
 
		vista = new Vista();
		modelo = new Modelo();
		
		Controlador control = new Controlador(vista,modelo);
	
		// Hacer la vista visible 
		vista.setVisible(true);
	}
}
