package topos.juego;

import java.util.LinkedList;

import topos.estructura.Direccion;
import topos.estructura.Escenario;
import topos.estructura.Estado;
import topos.estructura.PanelBasico;
import topos.estructura.Posicion;

public class Partida {

	// Constantes
	private static final String IMAGEN_OBJETIVO = "imagenes/objetivo.png";

	// Atributos
	private Escenario escenario;
	private Posicion objetivo;
	private int segundos;
	private int disparos;
	private int puntos;
	private long inicio;

	// Getters
	public Escenario getEscenario() {
		return escenario;
	}

	public Posicion getObjetivo() {
		return objetivo;
	}

	public int getSegundos() {
		return segundos;
	}

	public int getDisparos() {
		return disparos;
	}

	public int getPuntos() {
		return puntos;
	}

	public boolean isPartidaFin() {
		if (getSegundosRestantes() == 0)
			return true;
		return false;
	}

	public boolean isPartidaEnJuego() {
		if ((!isPartidaFin()) && (getDisparos() > 0))
			return true;
		return false;
	}

	public int getSegundosRestantes() {
		double transcurridos = System.currentTimeMillis() - this.inicio;
		double segRestantes = (this.segundos * 1000 - transcurridos) / 1000;
		if (segRestantes < 0)
			return 0;
		return (int) Math.ceil(segRestantes);
	}

	public LinkedList<Imagen> getImagenes() {
		LinkedList<Imagen> imagenes = new LinkedList<Imagen>();
		for (int i = 0; i < escenario.getAlto(); i++) {
			for (int j = 0; j < escenario.getAncho(); j++) {
				for (Imagen im : escenario.getPanel(i, j).getImagenPanel()) {
					imagenes.add(im);
				}
				if (i==this.getObjetivo().getX() && j==this.getObjetivo().getY()) {
					imagenes.add(new Imagen(IMAGEN_OBJETIVO, objetivo.getX(), objetivo.getY()));
				}
			}
		}
		return imagenes;
	}

	// Constructores
	public Partida(int anchoEscenario, int altoEscenario, int segundos, int disparosIni) {
		this.escenario = new Escenario(anchoEscenario, altoEscenario);
		this.segundos = segundos;
		this.disparos = disparosIni;
		this.puntos = 0;
		this.objetivo = new Posicion(0, 0);
	}

	// Funcionalidad
	public void arrancar() {
		this.inicio = System.currentTimeMillis();
	}

	public boolean desplazar(Direccion direccion) {
		if (escenario.validarPanel(objetivo.getVecina(direccion))) {
			objetivo.desplazar(direccion);
			return true;
		}
		return false;
	}

	public void disparar() {
		if (isPartidaEnJuego()) {
			if (((escenario.getPanel(objetivo)).getEstado()) == Estado.LEVANTADO) {
				escenario.derribarPanel(objetivo);
			}
			else {
				LinkedList<ContribucionJuego> contribuciones = escenario.capturar(getObjetivo());
				for (ContribucionJuego cont : contribuciones) {
					segundos += cont.getTiempo();
					disparos += cont.getDisparos();
					puntos += cont.getPuntos();
				}
			}
			disparos -= 1;
		}
	}

	public void actualizar() {
		escenario.actualizar();
	}

	public void addPaneles(PanelBasico... paneles) {
		for (PanelBasico pan : paneles) {
			escenario.establecerPanel(pan);
		}
	}

}
