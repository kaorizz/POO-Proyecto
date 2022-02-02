package topos.estructura;

import java.util.Random;

public class PanelAleatorio extends PanelBasico {

	// Getters
	@Override
	public String getRuta() {
		return "imagenes/panel-aleatorio.png";
	}
	
	// Constructores
	public PanelAleatorio(int posX, int posY) {
		super(posX, posY);
	}

	// Funcionalidad
	@Override
	public void derribar() {
		Random random = new Random();
		// Número aleatorio entre 0 y 1
		int valorAleatorio = random.nextInt(2);
		
		switch (valorAleatorio) {
			case 0:
				break;
			case 1:
				super.derribar();
				break;
		}
	}
}
