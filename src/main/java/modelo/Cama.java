package modelo;

public class Cama extends Habitacion{
	
	private int individual;
	private int matrimonio;
	private int doble;

	public Cama(String id, String nombreAloj, String ubicacion, int numHabitaciones, String cod_Habitacion, String habitacion,
			int individual, int matrimonio, int doble) {
		super(id, nombreAloj, ubicacion, numHabitaciones, cod_Habitacion, habitacion);
		this.individual = individual;
		this.matrimonio = matrimonio;
		this.doble = doble;
	}
	
	public Cama() {
		super();
	}

	public int getIndividual() {
		return individual;
	}

	public void setIndividual(int individual) {
		this.individual = individual;
	}

	public int getMatrimonio() {
		return matrimonio;
	}

	public void setMatrimonio(int matrimonio) {
		this.matrimonio = matrimonio;
	}

	public int getDoble() {
		return doble;
	}

	public void setDoble(int doble) {
		this.doble = doble;
	}
	
}
