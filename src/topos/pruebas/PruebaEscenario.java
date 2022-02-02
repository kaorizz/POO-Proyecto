package topos.pruebas;

import topos.estructura.Escenario;
import topos.estructura.PanelBasico;
import topos.estructura.Posicion;

public class PruebaEscenario {

	public static void main(String[] args) {
		
		Escenario escenario = new Escenario(5,6);
		System.out.println(escenario.toString());
		System.out.println(escenario.validarPanel(new Posicion(1,2)));
		System.out.println(escenario.validarPanel(new Posicion(5,1)));
		Posicion pos = new Posicion(2,3);
		PanelBasico panel1 = new PanelBasico(2,3);
		escenario.establecerPanel(panel1);
		System.out.println(escenario.getPanel(pos).equals(panel1));
		System.out.println(escenario.consultarPanel(pos));
		escenario.derribarPanel(pos);
		System.out.println(escenario.consultarPanel(pos));
	}
}
