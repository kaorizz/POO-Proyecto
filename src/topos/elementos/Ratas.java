package topos.elementos;

import topos.estructura.Direccion;
import topos.estructura.Escenario;
import topos.estructura.Estado;
import topos.juego.ContribucionJuego;

public class Ratas extends ElementosActivos {

	@Override
	public void actualizar(Escenario escenario) {
		if (this.getPanel().getEstado() == Estado.LEVANTADO) {
			if ((escenario.validarPanel(this.getPanel().getPosicion().getVecina(Direccion.DERECHA))) 
				&& (escenario.consultarPanel(this.getPanel().getPosicion().getVecina(Direccion.DERECHA)))) {
					this.desplazar(Direccion.DERECHA, escenario);
			}
			else if ((escenario.validarPanel(this.getPanel().getPosicion().getVecina(Direccion.ARRIBA))) 
					&& (escenario.consultarPanel(this.getPanel().getPosicion().getVecina(Direccion.ARRIBA)))) {
						this.desplazar(Direccion.ARRIBA, escenario);
				}
			else if ((escenario.validarPanel(this.getPanel().getPosicion().getVecina(Direccion.IZQUIERDA))) 
					&& (escenario.consultarPanel(this.getPanel().getPosicion().getVecina(Direccion.IZQUIERDA)))) {
						this.desplazar(Direccion.IZQUIERDA, escenario);
				}
			else this.desplazar(Direccion.ABAJO, escenario);
			}
		}
	
	@Override
	public ContribucionJuego getContribucion() {
		return new ContribucionJuego(-1,0,0);
	}
	
	@Override
	public String getRuta() {
		return "imagenes/rata.png";
	}
}
