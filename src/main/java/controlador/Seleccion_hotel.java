package controlador;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Hotel;
import modelo.Modelo;
import vista.Ventana;

public class Seleccion_hotel {

	/*Mete los datos en el label correspondiente
	 * 
	 */
	
	public static void listadoHoteles(Ventana vis, String nombre) {		
		vis.panelHoteles.labelNombreHotel.setText(nombre);
	}
	
	public static void datosHotel(Ventana vis, String nombre, String ubicacion, double precio, int estrellas) {		
		vis.panelHoteles.labelNombreHotel.setText(nombre);
		vis.panelHoteles.labelUbicacion.setText(ubicacion);
		vis.panelHoteles.labelPrecio.setText(Double.toString(precio));
		vis.panelHoteles.labelCategoria.setText(Integer.toString(estrellas));
	}
	
	/*Inserta los hoteles en el combobox de hoteles
	 * 
	 */
	
	public static void meterHotelesEnComboBox(Ventana vis, String [] nombreHotel) {
		for (int i = 0; i <nombreHotel.length; i++) {
			vis.panelHoteles.jlistHoteles.setListData(nombreHotel);
		}
	}
	
	public static ArrayList<String> listadoHotelesToString (ArrayList<Hotel> listHoteles) {
		ArrayList<Hotel> nomHoteles = new ArrayList<Hotel>();
		ArrayList<String> nomHotelesString = new ArrayList<String>();
		String s = "";
		Hotel A = null;

		nomHoteles = listHoteles;
		for (int i = 0; i <nomHoteles.size(); i++) {
			s = listHoteles.get(i);
//			String s = ""; 
//			nomHoteles.add(s);
			nomHotelesString.add(s);
		}
		return nomHotelesString;
		
	}
	
	/*Muestra los datos de cada hotel
	 * 
	 */
	public static void mostrarDatos(Ventana vis, ArrayList <Hotel> listHoteles) {
		//vis.panelHoteles.hoteles.setSelectedIndex(0);
		int seleccionado=vis.panelHoteles.jlistHoteles.getSelectedIndex();
		
		datosHotel(vis, listHoteles[seleccionado].getNombreAloj(), listHoteles[seleccionado].getUbicacion(),4, listHoteles[seleccionado].getCategoria());
	}
	
	public static void tres(Ventana vis) {
		String nombre="";
		if(nombre==vis.panelHoteles.labelNombreHotel.getText()) {
			if(JOptionPane.showConfirmDialog(null,"gxdd")==JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			else {
				JOptionPane.showConfirmDialog(null,"no has cerrado nada");
			}
		}
	}
	
	/*devuelve la ubicacion
	 * 
	 */
	public String devolverUbicacion(Ventana vis) {
		String ubicacion=(String) vis.panelBuscador.comboBox.getSelectedItem();
		return ubicacion;
	}
	
}
