package modelo;

public class Hotel extends Alojamiento{
	
	protected int categoria;
	protected double precio;
	protected String id;
	
	public Hotel() {}
	
	public Hotel(String id, String nombreAloj, String ubicacion, int numHabitaciones, int categoria, double precio) {
		super(nombreAloj, ubicacion, numHabitaciones);
		
		this.id = id;
		this.categoria = categoria;
		this.precio = precio;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	//Crea un hotel y lo mete en un array de hoteles
	public void add() {
		
	}

	@Override
	public String toString() {
		return "Hotel" + 
				nombreAloj + 
				ubicacion + 
				categoria + " estrellas" +
				precio +
				"]";
	}
}