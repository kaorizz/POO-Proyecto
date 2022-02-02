package topos.elementos;

import topos.estructura.Escenario;
import topos.estructura.PanelBasico;
import topos.juego.ContribucionJuego;

public abstract class Elemento {

	// Atributos
	private PanelBasico panel;

	// Getters y Setters
	public PanelBasico getPanel() {
		return panel;
	}

	public void setPanel(PanelBasico panel) {
		this.panel = panel;
	}
	
	abstract public ContribucionJuego getContribucion();
	
	abstract public String getRuta();
	
	abstract public void actualizar(Escenario escenario);
	
	// Constructores
	public Elemento() {
		panel = null;
	}
}
