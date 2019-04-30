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
		vista.panelHoteles.hoteles.addListSelectionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) throws SQLException {
		//Guardar ubicacion seleccionada
		Hotel ubicacion = (Hotel) vista.panelBuscador.comboBox.getSelectedItem();
		
		
		if(ubicacion != null) {
			String ubicString = ubicacion.getUbicacion();
			System.out.println("1111" + ubicString + "111");
			
			//Limpiar el JList de hoteles
			vista.panelHoteles.hoteles.removeAll();
			
			//Cargar los hoteles de la ubicacion seleccionada desde la bbdd
			hotelesList = modelo.consulta.getHoteles(ubicString);
			
			//Mostrar hoteles en JList
			for(int i=0; i<hotelesList.size(); i++) {
				vista.panelHoteles.modeloHoteles.addElement(hotelesList.get(i));
				vista.panelHoteles.hoteles.setModel(vista.panelHoteles.modeloHoteles);
			}
		}
	}
}
