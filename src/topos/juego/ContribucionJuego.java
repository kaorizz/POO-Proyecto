package topos.juego;

public final class ContribucionJuego {

	// Atributos
	private final int puntos;
	private final int tiempo;
	private final int disparos;
	
	// Getters
	public int getPuntos() {
		return puntos;
	}
	
	public int getTiempo() {
		return tiempo;
	}
	
	public int getDisparos() {
		return disparos;
	}
	
	// Constructores
	public ContribucionJuego(int puntos, int tiempo, int disparos) {
		this.puntos = puntos;
		this.tiempo = tiempo;
		this.disparos = disparos;
	}
}
