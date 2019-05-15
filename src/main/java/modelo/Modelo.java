package modelo;

import java.sql.Date;

import controlador.Control_login;

public class Modelo {

	public Conexion conexion;
	public Consultas consulta;
	public Hotel hotel;
	public float precioTotal;
	public Cliente clienteRegistrado;
	
	public Control_login metodoLogin;
	public Consultas cbd;
	
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
