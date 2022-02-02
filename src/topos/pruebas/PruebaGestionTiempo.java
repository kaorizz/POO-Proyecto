package topos.pruebas;

import topos.estructura.Escenario;
import topos.estructura.Posicion;

public class PruebaGestionTiempo {

	public static void main(String[] args) {
		
		Escenario escenario1 = new Escenario(5,5);
		escenario1.derribarPanel(new Posicion(2,2));
		System.out.println(escenario1.getPanel(new Posicion(2,2)));
		
		long fin = System.currentTimeMillis() + 4000;
		while (System.currentTimeMillis() < fin);
		
		escenario1.actualizar();
		System.out.println(escenario1.getPanel(new Posicion(2,2)));
	}

}
