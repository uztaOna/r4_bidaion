package modelo;

public class Apartamento extends Casa{

	protected int npiso;
	
	public Apartamento(String nombre, String ubicacion, int nhabitaciones, int nbanos, double tamano) {
		super(nombre, ubicacion, nhabitaciones, nbanos, tamano);
		this.nbanos = nbanos;
		this.tamano = tamano;
		}
	
}
