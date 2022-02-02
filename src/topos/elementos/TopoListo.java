package topos.elementos;

import java.util.ArrayList;
import java.util.Random;

import topos.estructura.Direccion;
import topos.estructura.Escenario;
import topos.estructura.Posicion;
import topos.juego.ContribucionJuego;

public class TopoListo extends Topos {

	@Override
	public boolean isMovible(Escenario escenario) {
		if (escenario.consultarPanel(this.getPanel().getPosicion())) return true;
		return false;
	}
	
	@Override
	public Direccion getDesplazamiento(Escenario escenario) {
		Posicion arriba = this.getPanel().getPosicion().getVecina(Direccion.ARRIBA);
		Posicion abajo = this.getPanel().getPosicion().getVecina(Direccion.ABAJO);
		Posicion derecha = this.getPanel().getPosicion().getVecina(Direccion.DERECHA);
		Posicion izquierda = this.getPanel().getPosicion().getVecina(Direccion.IZQUIERDA);
		ArrayList<Direccion> levantados = new ArrayList<Direccion>();
		if (escenario.validarPanel(arriba)) levantados.add(Direccion.ARRIBA);
		if (escenario.validarPanel(abajo)) levantados.add(Direccion.ABAJO);
		if (escenario.validarPanel(derecha)) levantados.add(Direccion.DERECHA);
		if (escenario.validarPanel(izquierda)) levantados.add(Direccion.IZQUIERDA);
		Random rand = new Random();
		int numeroAleatorio = rand.nextInt(levantados.size());
		return levantados.get(numeroAleatorio);
	}
	
	@Override
	public ContribucionJuego getContribucion() {
		return new ContribucionJuego(3,0,0);
	}
	
	@Override
	public String getRuta() {
		return "imagenes/topo-listo.png";
	}
}
