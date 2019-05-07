package modelo;

public class Habitacion extends Alojamiento {
	protected String cod_Habitacion;
	protected String tipoHabitacion;
	
	public Habitacion(String id, String nombreAloj, String ubicacion, int numHabitaciones, String cod_Habitacion, String tipoHabitacion) {
		super(id, nombreAloj, ubicacion, numHabitaciones);
		this.cod_Habitacion = cod_Habitacion;
		this.tipoHabitacion = tipoHabitacion;
	}
	
	public Habitacion() {
		super();
	}

	public String getCod_Habitacion() {
		return cod_Habitacion;
	}

	public void setCod_Habitacion(String cod_Habitacion) {
		this.cod_Habitacion = cod_Habitacion;
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	
	
	
}
