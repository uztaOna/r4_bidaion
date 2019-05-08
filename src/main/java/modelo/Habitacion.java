package modelo;

public class Habitacion {
	
	private String codHabitacion;
	private String tipoHabitacion;
	private double precio;
	
	public Habitacion(String codHabitacion, String tipoHabitacion, double precio) {
		this.codHabitacion = codHabitacion;
		this.tipoHabitacion = tipoHabitacion;
		this.precio = precio;
	}

	public String getCodHabitacion() {
		return codHabitacion;
	}

	public void setCodHabitacion(String codHabitacion) {
		this.codHabitacion = codHabitacion;
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}	
}
