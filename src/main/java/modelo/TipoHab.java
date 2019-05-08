package modelo;

public class TipoHab {
	
	private int cantHabs;
	private int individual;
	private int matrimonio;
	private int doble;

	public TipoHab(int cantHabs, int individual, int matrimonio, int doble) {
		this.cantHabs = cantHabs;
		this.individual = individual;
		this.matrimonio = matrimonio;
		this.doble = doble;
	}

	public int getcantHabs() {
		return cantHabs;
	}

	public void setcantHabs(int cantHabs) {
		this.cantHabs = cantHabs;
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
