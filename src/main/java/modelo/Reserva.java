package modelo;

import java.util.Date;

public class Reserva {
	
	private int codigoReserva;
	private String destino;
	private String hotel;
	private Date fechaIni;
	private Date fechaFin;
	private String dni;
	private String nomUsuario;
	private String apeUsuario;
	private int tipoHab;
	private String extras;
	private double precio;
	
	//Constructor vacio de reserva
	public Reserva() {} 
	
	//Constructor con parámetros de reserva
	public Reserva(int codigoReserva, String destino, String hotel, Date fechaIni, Date fechaFin, String dni,
			String nomUsuario, String apeUsuario, int tipoHab, String extras, double precio) {
		super();
		this.codigoReserva = codigoReserva;
		this.destino = destino;
		this.hotel = hotel;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.dni = dni;
		this.nomUsuario = nomUsuario;
		this.apeUsuario = apeUsuario;
		this.tipoHab = tipoHab;
		this.extras = extras;
		this.precio = precio;
	}

	
	//Getters y Setters
	public int getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(int codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getApeUsuario() {
		return apeUsuario;
	}

	public void setApeUsuario(String apeUsuario) {
		this.apeUsuario = apeUsuario;
	}

	public int getTipoHab() {
		return tipoHab;
	}

	public void setTipoHab(int tipoHab) {
		this.tipoHab = tipoHab;
	}
	
	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
