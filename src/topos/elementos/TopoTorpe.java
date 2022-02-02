package topos.elementos;

import java.util.Random;

import topos.estructura.Direccion;
import topos.estructura.Escenario;
import topos.juego.ContribucionJuego;

public class TopoTorpe extends Topos {

	@Override
	public boolean isMovible(Escenario escenario) {
		if (escenario.consultarPanel(this.getPanel().getPosicion())) return true;
		return false;
	}
	
	@Override
	public Direccion getDesplazamiento(Escenario escenario) {
		Direccion[] direcciones = Direccion.values();
		Random random = new Random();
		int valorAleatorio = random.nextInt(direcciones.length);
		return direcciones[valorAleatorio];
	}
	
	@Override
	public ContribucionJuego getContribucion() {
		return new ContribucionJuego(1,0,0);
	}
	
	@Override
	public String getRuta() {
		return "imagenes/topo-torpe.png";
	}
}
