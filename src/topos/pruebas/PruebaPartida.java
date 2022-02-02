package topos.pruebas;

import topos.estructura.Direccion;
import topos.juego.Partida;

public class PruebaPartida {

	public static void main(String[] args) {
		
		Partida partida1 = new Partida(5,5,60,3);
		partida1.arrancar();
		System.out.println(partida1.isPartidaEnJuego());
		System.out.println(partida1.getPuntos());
		
		partida1.desplazar(Direccion.DERECHA);
		System.out.println(partida1.getObjetivo());
		
		partida1.disparar();
		partida1.disparar();
		System.out.println(partida1.getDisparos());
		
		long fin = System.currentTimeMillis() + 4000;
		while (System.currentTimeMillis() < fin);
		
		System.out.println(partida1.getSegundosRestantes());
		System.out.println(partida1.isPartidaFin());
		
		partida1.disparar();
		System.out.println(partida1.isPartidaEnJuego());
	}
}
