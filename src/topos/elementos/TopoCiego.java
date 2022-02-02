package topos.elementos;

import java.util.Random;

import topos.estructura.Direccion;
import topos.estructura.Escenario;
import topos.juego.ContribucionJuego;

public class TopoCiego extends Topos {

	@Override
	public boolean isMovible(Escenario escenario) {
		return true;
	}
	
	@Override
	public Direccion getDesplazamiento(Escenario escenario) {
		Direccion ultima = getUltDesplazamiento();
		Direccion[] direcciones = Direccion.values();
		Random rand = new Random();
		int dirAleatoria = rand.nextInt(direcciones.length);
		while (direcciones[dirAleatoria].equals(ultima)) {
			dirAleatoria = rand.nextInt(direcciones.length);
		}
		return direcciones[dirAleatoria];
	}
	
	@Override
	public ContribucionJuego getContribucion() {
		return new ContribucionJuego(2,0,0);
	}
	
	@Override
	public String getRuta() {
		return "imagenes/topo-ciego.png";
	}
	
	

}
