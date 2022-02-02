package topos.elementos;

import topos.estructura.Direccion;
import topos.estructura.Escenario;
import topos.estructura.Posicion;

public abstract class ElementosActivos extends Elemento {

	// Funcionalidad
	protected boolean desplazar(Direccion direccion, Escenario escenario) {
		Posicion vecino = this.getPanel().getPosicion().getVecina(direccion);
		if (escenario.validarPanel(vecino)) {
			this.getPanel().quitarElemento(this);
			this.setPanel(escenario.getPanel(vecino));
			this.getPanel().introducirElemento(this);
			return true;
		}
		return false;
	}
}
