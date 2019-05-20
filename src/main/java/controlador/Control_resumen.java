package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.Vista;

public class Control_resumen implements ActionListener {

	Vista vista;
	Modelo modelo;
	Cliente cliente;
	
	public Control_resumen(Modelo modelo, Vista vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	public void inicializar_eventos_resumen() {
		this.vista.panelResumen.btnFin.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		
	}
	
	/*
	 * Muestra los datos de la reserva
	 */
	public void mostrarReserva(Reserva rva, Cliente cliete, DefaultTableModel tablaModel) {
		
		Object[] datosRva = new Object[11];
		tablaModel.setRowCount(0);
		
		datosRva[0] = rva.getCodigoReserva(); //Codigo Reserva
		datosRva[1] = modelo.hotel.getUbicacion(); //Destino
		datosRva[2] = modelo.hotel.getNombreAloj(); //Nombre de alojamiento
		datosRva[3] = rva.getFechaIni(); //Fecha de llegada
		datosRva[4] = rva.getFechaFin(); //fecha de salida
		datosRva[5] = rva.getUsuario(); //Dni de cliente
		datosRva[6] = cliete.getNombre(); //Nombre de cliente
		datosRva[7] = cliente.getApellido(); //Apellido de cliente
		datosRva[8] = modelo; //Descripcion de las habitaciones reservadas (tipoHab + cantidad)
		datosRva[9] = rva.getUsuario(); //Servicios extras contratados (si los hubiese)
		datosRva[10] = rva.getPrecio() + "€"; //Precio final de la reserva
		
		tablaModel.addRow(datosRva);
	}
	
}
