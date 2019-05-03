package controlador;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Hotel;
import vista.*;

public class Seleccion_hotel {
	
	public static void listadoHoteles(Ventana vis, String nombre) {		
		vis.panelHoteles.lblNomHotel.setText(nombre);
	}
	
	
	public static ArrayList<Hotel> listadoHotelesToString (ArrayList<Hotel> listHoteles) {		
		for (int i = 0; i <listHoteles.size(); i++) {
			listHoteles.get(i);
		}
		return listHoteles;
	}
	
	
	public static void tres(Ventana vis) {
		String nombre = "";
		if(nombre==vis.panelHoteles.lblNomHotel.getText()) {
			if(JOptionPane.showConfirmDialog(null,"gxdd")==JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			else {
				JOptionPane.showConfirmDialog(null,"no has cerrado nada");
			}
		}
	}
}
