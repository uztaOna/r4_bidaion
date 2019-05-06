package controlador;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import modelo.Hotel;
import modelo.Modelo;
import vista.Ventana;

public abstract class Control_hoteles implements ListSelectionListener {

	public Ventana vista;
	public Modelo modelo;
	Hotel ubicacion;
	Hotel hotel;
	
	//Constructor
	public Control_hoteles(Ventana vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	
	//Añadir listeners a los botones del panel 'hoteles'
	public void addListeners() {
		vista.panelHoteles.JListHoteles.addListSelectionListener(this);
	}
	

	public static void infoHotelSelec() {
		// 1 Leer JList seleccionado
		String nombreHotel = (String)Launcher_sprint1.vista.panelHoteles.JListHoteles.getSelectedValue();
		
		// 2 Ir a BBDD y sacar datos de hotel pasandole NOMBRE
		Hotel hotel = Launcher_sprint1.modelo.consulta.getDatosHotel(nombreHotel);
		
		// 3 Cambiar labels de pan hoteles con datos de bbdd
		Launcher_sprint1.vista.panelHoteles.ubicacion.setText(hotel.getUbicacion());
		Launcher_sprint1.vista.panelHoteles.categoria.setText(Integer.toString(hotel.getCategoria()) + " estrellas");
		Launcher_sprint1.vista.panelHoteles.precio.setText(Double.toString(hotel.getPrecio()) + " €");
	}
	
	//Añadir listado de hoteles a JList según ubicación
	public static void addHotelesJList() {
		//Panel esta creado en el constructor de vista.
		//Guardar ubicacion seleccionada
		String ubicacion = Launcher_sprint1.vista.panelBuscador.comboBox.getSelectedItem().toString();

		//Lamar a la funcion que lee los hoteles de la BBDD en el modelo
		ArrayList <Hotel> hotelesList =	Launcher_sprint1.modelo.consulta.getHotelesUbicacion(ubicacion);
		Control_hoteles.listadoHoteles(hotelesList); 
		
		//Limpiar el JList de hoteles
		Launcher_sprint1.vista.panelHoteles.JListHoteles.removeAll();
			
		//Mostrar hoteles en JList
		for(int i=0; i<hotelesList.size(); i++) {
			Launcher_sprint1.vista.panelHoteles.modeloHoteles.addElement(hotelesList.get(i).getNombreAloj());
		}
		Launcher_sprint1.vista.panelHoteles.JListHoteles.setModel(Launcher_sprint1.vista.panelHoteles.modeloHoteles);
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
	
	public static void limpiarBox(Ventana vis) {		
		vis.panelHoteles.JListHoteles.removeAll();
	}
	
	public static void cargaNombreHotel(Ventana vis, String nombre) {		
		vis.panelHoteles.lblNomHotel.setText(nombre);
	}
	
	
	public static ArrayList<Hotel> listadoHoteles (ArrayList<Hotel> listHoteles) {	
		for (int i = 0; i <listHoteles.size(); i++) {
			listHoteles.get(i);
		}
		return listHoteles;
	}
}
