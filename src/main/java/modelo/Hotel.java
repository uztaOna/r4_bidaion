package modelo;

public class Hotel extends Alojamiento{
	
	protected int categoria;
	
	public Hotel(String nombreAloj, String ubicacion, int categoria) {
		super(nombreAloj, ubicacion, categoria);
		
		this.nombreAloj = nombreAloj;
		this.ubicacion = ubicacion;
		this.categoria = categoria;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
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
				"]";
	}
	
}
