package topos.pruebas;

import topos.estructura.Direccion;
import topos.estructura.PanelBasico;
import topos.estructura.Posicion;

public class PruebaPanelBasico {

	public static void main(String[] args) {
		
		PanelBasico panel = new PanelBasico(0,0);
		System.out.println(panel.toString());
		
		System.out.println("---------------------");
		
		Posicion pos = new Posicion(panel.getPosicion());
		pos.desplazar(Direccion.DERECHA);
		
		System.out.println(panel.toString());
		System.out.println(pos.toString());
		
		System.out.println("---------------------");
		
		panel.derribar();
		System.out.println(panel.toString());
		
	}
	
}
