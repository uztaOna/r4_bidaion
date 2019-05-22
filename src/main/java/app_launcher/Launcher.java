package app_launcher;

import vista.Vista;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import controlador.Controlador;
import modelo.*;

public class Launcher {

	public static Modelo modelo;
	public static Vista vista;
	
	public static void main(String[] args) {
		
		// Instancia de las clases necesarias para el programa
 
		vista = new Vista();
		modelo = new Modelo();
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, fall back to cross-platform
		    try {
		        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		    } catch (Exception ex) {
		        // not worth my time
		    }
		}
		
		Controlador control = new Controlador(vista,modelo);
	
		// Hacer la vista visible 
		vista.setVisible(true);
	}
}
