package modelo;

import java.util.Date;

public class Reserva {
	
	private int codigoReserva;
	private String usuario;
	private String hotel;
	private double precio;
	private Date fechaIni;
	private Date fechaFin;
	
	//Constructor vacio de reserva
	public Reserva() {} 
	
	//Constructor con parámetros de reserva
	public Reserva(int codigoReserva, String usuario, String hotel, float precio, Date fechaIni, Date fechaFin) {
		this.codigoReserva = codigoReserva;
		this.usuario = usuario;
		this.hotel = hotel;
		this.precio = precio;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
	}

	//Getters y Setters
	public int getCodigoReserva() {
		return codigoReserva;
	}
	public void setCodigoReserva(int codigoReserva) {
		this.codigoReserva = codigoReserva;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
}
