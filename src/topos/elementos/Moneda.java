package topos.elementos;

import topos.juego.ContribucionJuego;

public class Moneda extends ElementosPasivos {

	public Moneda(int cantidad) {
		super(cantidad);
	}

	@Override
	public ContribucionJuego getContribucion() {
		return new ContribucionJuego(getCantidad(),0,0);
	}
	
	@Override
	public String getRuta() {
		return "imagenes/monedas.png";
	}
}
