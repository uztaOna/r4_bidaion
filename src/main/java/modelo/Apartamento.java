package modelo;

public class Apartamento extends Alojamiento{

	protected int npiso;
	
	public Apartamento(String id, String nombre, String ubicacion, int nhabitaciones, int npiso) {
		super(id, nombre, ubicacion, nhabitaciones);
		
		this.npiso = npiso;
	}

	public int getNpiso() {
		return npiso;
	}

	public void setNpiso(int npiso) {
		this.npiso = npiso;
	}
}
