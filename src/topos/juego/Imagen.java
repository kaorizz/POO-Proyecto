package topos.juego;

public final class Imagen {

	// Atributos
	private final String ruta;
	private final int x;
	private final int y;

	// Getters
	public String getRuta() {
		return ruta;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// Constructores
	public Imagen(String ruta, int x, int y) {
		this.ruta = ruta;
		this.x = x;
		this.y = y;
	}
}