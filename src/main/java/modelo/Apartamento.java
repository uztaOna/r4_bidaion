package modelo;

public class Apartamento extends Alojamiento{

	protected int npiso;
	protected double precio;
	
	public Apartamento() {}
	
	public Apartamento(String id, String nombre, String ubicacion, int nhabitaciones, int npiso, double precio) {
		super(id, nombre, ubicacion, nhabitaciones);
		
		this.npiso = npiso;
		this.precio = precio;
	}

	public int getNpiso() {
		return npiso;
	}

	public void setNpiso(int npiso) {
		this.npiso = npiso;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
