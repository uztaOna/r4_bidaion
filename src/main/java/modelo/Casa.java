package modelo;

public class Casa extends Alojamiento{
	protected int nbanos;
	protected double tamano;
	
	public Casa(String nombre, String ubicacion, int nhabitaciones, int nbanos, double tamano) {
		super(nombre, ubicacion, nhabitaciones);
		this.nbanos = nbanos;
		this.tamano = tamano;
	}
	
	public int getNbanos() {
		return nbanos;
	}
	public void setNbanos(int nbanos) {
		this.nbanos = nbanos;
	}
	public double getTamano() {
		return tamano;
	}
	public void setTamano(double tamano) {
		this.tamano = tamano;
	}

	
	
}
