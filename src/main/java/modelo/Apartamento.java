package modelo;

public class Apartamento extends Casa{

	protected int npiso;
	
	public Apartamento(String id, String nombre, String ubicacion, int nhabitaciones, int nbanos, double tamano, int npiso) {
		super(id, nombre, ubicacion, nhabitaciones, nbanos, tamano);
		this.npiso = npiso;
	}

	public int getNpiso() {
		return npiso;
	}

	public void setNpiso(int npiso) {
		this.npiso = npiso;
	}
	
	
	
}
