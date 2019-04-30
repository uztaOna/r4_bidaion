package controlador;
import javax.swing.JOptionPane;

import modelo.Hotel;
import modelo.Modelo;
import vista.Ventana;

public class Seleccion_hotel {

	/*Mete los datos en el label correspondiente
	 * 
	 */
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
	
	public static String [] cosas (Hotel [] hotel) {
		String[] nomHoteles = new String[hotel.length];
		for (int i = 0; i <nomHoteles.length; i++) {
			nomHoteles[i]=hotel[i].getNombreAloj();
		}
		return nomHoteles;
		
	}
	
	/*Muestra los datos de cada hotel
	 * 
	 */
	public static void mostrarDatos(Ventana vis, Hotel [] hotel) {
		//vis.panelHoteles.hoteles.setSelectedIndex(0);
		int seleccionado=vis.panelHoteles.jlistHoteles.getSelectedIndex();
		datosHotel(vis, hotel[seleccionado].getNombreAloj(), hotel[seleccionado].getUbicacion(),4, hotel[seleccionado].getCategoria());
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
