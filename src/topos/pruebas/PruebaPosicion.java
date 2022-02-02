package topos.pruebas;

import topos.estructura.Direccion;
import topos.estructura.Posicion;

public class PruebaPosicion {

	public static void main(String[] args) {
		
		Posicion pos1 = new Posicion(1,3);
		
		pos1.desplazar(Direccion.ARRIBA);
		Posicion vecina = pos1.getVecina(Direccion.ARRIBA);
		System.out.println(pos1.toString());
		System.out.println(vecina.toString());
		pos1.desplazar(Direccion.ABAJO);
		vecina = pos1.getVecina(Direccion.ABAJO);
		System.out.println(pos1.toString());
		System.out.println(vecina.toString());
		pos1.desplazar(Direccion.DERECHA);
		vecina = pos1.getVecina(Direccion.DERECHA);
		System.out.println(pos1.toString());
		System.out.println(vecina.toString());
		pos1.desplazar(Direccion.IZQUIERDA);
		vecina = pos1.getVecina(Direccion.IZQUIERDA);
		System.out.println(pos1.toString());
		System.out.println(vecina.toString());
		
		
	}
	
}
