package controlador;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionListener;
import modelo.Alojamiento;
import modelo.Hotel;
import modelo.Modelo;
import vista.Ventana;

public abstract class Control_hoteles implements ListSelectionListener {

	public Ventana vista;
	public Modelo modelo;
	private ArrayList<Alojamiento> hotelesList;
	Hotel ubicacion;
	Hotel hotel;
	
	//Constructor
	public Control_hoteles(Ventana vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	//Añadir listeners a los botones del panel 'hoteles'
	public void addListeners() {
		vista.panelHoteles.jlistHoteles.addListSelectionListener(this);
	}
	
	public static void addHotelesJList() {

		//Panel esta creado en el constructor de vista.
		//Guardar ubicacion seleccionada
		String ubicacion = Launcher_sprint1.vista.panelBuscador.comboBox.getSelectedItem().toString();
		System.out.println("1 ubicacion seleccionada");

		//Lamar ala funcion que lee los hoteles de la BBDD en el modelo
		ArrayList <Hotel> hotelesList =	Launcher_sprint1.modelo.consulta.getHotelesUbicacion(ubicacion);
		controlador.Seleccion_hotel.listadoHotelesToString(hotelesList);
		System.out.println("2 listado hoteles");
		
		//Limpiar el JList de hoteles
		Launcher_sprint1.vista.panelHoteles.jlistHoteles.removeAll();
		System.out.println("3 borrar listado anterior del jlist");
			
		//Mostrar hoteles en JList
		for(int i=0; i<hotelesList.size(); i++) {
			Launcher_sprint1.vista.panelHoteles.modeloHoteles.addElement(hotelesList.get(i));
			System.out.println("4 imprimir hoteles en jlist");
		}
		Launcher_sprint1.vista.panelHoteles.jlistHoteles.setModel(Launcher_sprint1.vista.panelHoteles.modeloHoteles);
	}
}
