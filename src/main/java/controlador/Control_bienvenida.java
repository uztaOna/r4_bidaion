package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import modelo.Consultas;
import modelo.Modelo;
import vista.PanelBuscador;
import vista.Vista;

public class Control_bienvenida implements ActionListener{
	
	Modelo modelo;
	Vista vista;
	
	public Control_bienvenida(Modelo modelo,Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void inicializar_eventos_bienvenida()
	{
		this.vista.panelBienvenida.btnInicio.addActionListener(this);
	}
	
	/*
	 * Añade las ubicaciones de la base de datos a el comboBox
	 */
	public void addUbicacionesCombo(Vista vista, Consultas consultas, PanelBuscador panelBuscador) {
		//Cargar las ciudades de la bbdd y mostrar
		 ArrayList<String> ubicaciones = consultas.getUbicaciones();
		
		//Limpiar combobox de ubicaciones de la interfaz
		panelBuscador.limpiarPanelBuscador();
		
		//Recorrer el arraylist de ubicaciones y 
		//rellenarlos con las ubicaciones disponibles
		for(int i=0; i < ubicaciones.size(); i++) {
			panelBuscador.anadirElementoCombo(ubicaciones.get(i).toString());
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.vista.panelBienvenida.btnInicio) {
			addUbicacionesCombo(this.vista, this.modelo.consulta, this.vista.panelBuscador);
			this.vista.setContentPane(this.vista.panelBuscador);
			validarFecha(vista);
		}
	}
	
	/*Comprueba que la fecha sea anterior a hoy*/
	public static void validarFecha(Vista vista) {
		vista.panelBuscador.dateInicio.setMinSelectableDate(new Date());
		vista.panelBuscador.dateInicio.setDate(new Date());
	}
}
