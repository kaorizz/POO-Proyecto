package topos.elementos;

import topos.juego.ContribucionJuego;

public class Reloj extends ElementosPasivos {

	public Reloj(int cantidad) {
		super(cantidad);
	}

	@Override
	public ContribucionJuego getContribucion() {
		return new ContribucionJuego(0,getCantidad(),0);
	}
	
	@Override
	public String getRuta() {
		return "imagenes/reloj.png";
	}

}
