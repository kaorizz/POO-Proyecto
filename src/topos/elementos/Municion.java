package topos.elementos;

import topos.juego.ContribucionJuego;

public class Municion extends ElementosPasivos {

	public Municion(int cantidad) {
		super(cantidad);
	}

	@Override
	public ContribucionJuego getContribucion() {
		return new ContribucionJuego(0,0,getCantidad());
	}
	
	@Override
	public String getRuta() {
		return "imagenes/municion.png";
	}

}
