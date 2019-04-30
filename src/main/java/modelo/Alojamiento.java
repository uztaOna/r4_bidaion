package modelo;

public class Alojamiento {
	protected String nombreAloj;
	protected String ubicacion;
	protected int numHabitaciones;
	
	public Alojamiento() {
		super();
	}
	
	public Alojamiento(String nombreAloj, String ubicacion, int numHabitaciones) {
		super();
		this.nombreAloj = nombreAloj;
		this.ubicacion = ubicacion;
		this.numHabitaciones = numHabitaciones;
	}

	public String getNombreAloj() {
		return nombreAloj;
	}

	public void setNombreAloj(String nombreAloj) {
		this.nombreAloj = nombreAloj;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}
	
	
}
