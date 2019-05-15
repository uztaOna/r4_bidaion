package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Modelo;
import vista.Ventana;

public class Control_bienvenida implements ActionListener{
	
	Modelo modelo;
	Ventana vista;
	
	public Control_bienvenida(Modelo modelo,Ventana vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void inicializar_eventos_bienvenida()
	{
		this.vista.panelBienvenida.btnInicio.addActionListener(this);
	}
	
	public void addUbicacionesCombo(Modelo modelo, Ventana vista) {
		//Cargar las ciudades de la bbdd y mostrar
		 ArrayList<String> ubicaciones = modelo.consulta.getUbicaciones();
		
		//Limpiar combobox de ubicaciones de la interfaz
		vista.panelBuscador.comboBox.removeAllItems();
		
		//Recorrer el arraylist de ubicaciones y 
		//rellenarlos con las ubicaciones disponibles
		for(int i=0; i < ubicaciones.size(); i++) {
			vista.panelBuscador.comboBox.addItem(ubicaciones.get(i).toString());
		}
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.vista.panelBienvenida.btnInicio) {
			addUbicacionesCombo(this.modelo, this.vista);
			this.vista.setContentPane(this.vista.panelBuscador);
			Control_reserva.validarFecha(vista);
		}
	}
	
}
