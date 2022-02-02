package topos.estructura;

import java.util.LinkedList;

import topos.juego.ContribucionJuego;

public class Escenario {

	// Atributos
	private final int ancho;
	private final int alto;
	private PanelBasico[][] paneles;

	// Getters
	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public PanelBasico getPanel(int posX, int posY) {
		return paneles[posX][posY];
	}

	public PanelBasico getPanel(Posicion posicion) {
		if (validarPanel(posicion) == false)
			return null;
		else
			return paneles[posicion.getX()][posicion.getY()];
	}

	// Constructores
	public Escenario(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		this.paneles = new PanelBasico[ancho][alto];
		for (int i = 0; i < ancho; i++) {
			for (int j = 0; j < alto; j++) {
				paneles[i][j] = new PanelBasico(i, j);
			}
		}
	}

	// Funcionalidad
	public boolean validarPanel(Posicion posicion) {
		if ((posicion.getX() >= 0) && (posicion.getX() <= (ancho - 1)) && (posicion.getY() >= 0)
				&& (posicion.getY() <= (alto - 1)))
			return true;
		return false;
	}

	public void establecerPanel(PanelBasico panel) {
		if (validarPanel(panel.getPosicion())) {
			paneles[panel.getPosicion().getX()][panel.getPosicion().getY()] = panel;
		}
	}

	public boolean consultarPanel(Posicion posicion) {
		if (paneles[posicion.getX()][posicion.getY()].getEstado() == Estado.DERRIBADO)
			return true;
		return false;
	}

	public void derribarPanel(Posicion posicion) {
		if (validarPanel((posicion)))
			paneles[posicion.getX()][posicion.getY()].derribar();
	}

	public void actualizar() {
		for (int i = 0; i < this.ancho; i++) {
			for (int j = 0; j < this.alto; j++) {
				this.paneles[i][j].actualizar(this);
			}
		}
	}

	public LinkedList<ContribucionJuego> capturar(Posicion posicion) {
		if (!consultarPanel(posicion)) {
			return new LinkedList<ContribucionJuego>();
		}
		else return this.getPanel(posicion).capturar();
	}
	
	// Método toString
	@Override
	public String toString() {
		return "Escenario [ancho=" + ancho + ", alto=" + alto + "]";
	}
}
