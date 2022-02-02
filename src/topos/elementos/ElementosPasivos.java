package topos.elementos;

import topos.estructura.Escenario;

public abstract class ElementosPasivos extends Elemento {

	// Atributos
	private final int cantidad;
	
	// Getters
	public int getCantidad() {
		return cantidad;
	}
	
	public ElementosPasivos(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public void actualizar(Escenario escenario) {
	}
}
