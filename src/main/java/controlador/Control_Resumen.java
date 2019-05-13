package controlador;

import javax.swing.table.DefaultTableModel;
import modelo.*;
import modelo.Cliente;

public class Control_Resumen {

	private Modelo modelo;
	private Cliente cliente;
	
	public void mostrarReserva(Reserva rva, DefaultTableModel tablaModel) {
		
		Object[] datosRva = new Object[11];
		tablaModel.setRowCount(0);
		
		datosRva[0] = rva.getCodigoReserva(); //Codigo Reserva
		datosRva[1] = modelo.hotel.getUbicacion(); //Destino
		datosRva[2] = modelo.hotel.getNombreAloj(); //Nombre de alojamiento
		datosRva[3] = rva.getFechaIni(); //Fecha de llegada
		datosRva[4] = rva.getFechaFin(); //fecha de salida
		datosRva[5] = rva.getUsuario(); //Dni de cliente
		//datosRva[6] = modelo; //Nombre de cliente
		//datosRva[7] = modelo; //Apellido de cliente
		datosRva[8] = modelo; //Descripcion de las habitaciones reservadas (tipoHab + cantidad)
		datosRva[9] = rva.getUsuario(); //Servicios extras contratados (si los hubiese)
		datosRva[10] = rva.getPrecio() + "€"; //Precio final de la reserva
		
		tablaModel.addRow(datosRva);
	}

	public static void mostrarReserva() {
		// TODO Auto-generated method stub
		
	}
}
