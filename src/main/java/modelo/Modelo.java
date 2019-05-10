package modelo;

import java.sql.Date;

public class Modelo {

	public Conexion conexion;
	public Consultas consulta;
	public Hotel hotel;
	public float precioTotal;
	
	public Date fechaIni, fechaFin;
	
	public Modelo() {
		//crear objeto conexion que establecera una conexion a bbdd
		conexion = new Conexion();
		conexion.conectar();
	
	
		//crear objeto conexion que establecera una conexion a bbdd
		consulta = new Consultas(conexion);
		
		//Inicializar los objetos de la consulta nueva a null
		hotel = null;
		
		//guardar el precio de la reserva
		precioTotal = 0;
	}
}
