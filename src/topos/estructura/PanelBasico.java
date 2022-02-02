package topos.estructura;

import java.util.LinkedList;

import topos.elementos.Elemento;
import topos.juego.ContribucionJuego;
import topos.juego.Imagen;

public class PanelBasico {
	
	// Constantes
	private static final String IMAGEN_PANEL = "imagenes/panel-basico.gif";
	
	// Propiedades
	private Posicion posicion;
	private Estado estado;
	private LinkedList<Elemento> elementos;
	private long marcaTiempo;
	
	// Getters
	public Posicion getPosicion() {
		return posicion;
	}
	public Estado getEstado() {
		return estado;
	}
	public LinkedList<Elemento> getElementos() {
		return new LinkedList<Elemento>(elementos);
	}
	public String getRuta() {
		return IMAGEN_PANEL;
	}
	
	public LinkedList<Imagen> getImagenPanel() {
		LinkedList<Imagen> imagenes = new LinkedList<Imagen>();
		if (estado!=Estado.LEVANTADO) {
			for (Elemento elem : elementos) {
				imagenes.add(new Imagen(elem.getRuta(), posicion.getX(),posicion.getY()));				
			}
			return imagenes;
		}
		else {
			if (this instanceof PanelBasico) {
				imagenes.add(new Imagen(getRuta(),posicion.getX(),posicion.getY()));
				return imagenes;
			}
			else if (this instanceof PanelDebil) {
				imagenes.add(new Imagen(((PanelDebil) this).getRuta(),posicion.getX(),posicion.getY()));
				return imagenes;
			}
			else if (this instanceof PanelResistente) {
				imagenes.add(new Imagen(((PanelResistente) this).getRuta(),posicion.getX(),posicion.getY()));
				return imagenes;
			}
			else {
				imagenes.add(new Imagen(((PanelAleatorio) this).getRuta(),posicion.getX(),posicion.getY()));
				return imagenes;
			}
		}
	}
	
	
	// Constructores
	public PanelBasico(int posX, int posY) {
		estado=Estado.LEVANTADO;
		posicion=new Posicion(posX, posY);
		elementos=new LinkedList<Elemento>();
	}
	
	// Funcionalidad
	public void derribar() {

        if (this.estado == Estado.LEVANTADO) {
            this.estado = Estado.DERRIBADO;
            this.marcaTiempo= System.currentTimeMillis();
        };
}
	
	public boolean introducirElemento(Elemento elemento) {
		if (!elementos.contains(elemento)) {
			elemento.setPanel(this);
			elementos.add(elemento);
			return true;
		}
		return false;
	}
	
	public boolean quitarElemento(Elemento elemento) {
		if (elementos.contains(elemento)) {
			elementos.remove(elemento);
			elemento.setPanel(null);
			return true;
		}
		return false;
		
		
	}
	
	public void actualizar(Escenario escenario) {
        if ((this.estado == Estado.DERRIBADO) && ((System.currentTimeMillis()-this.marcaTiempo)>=3000)) {
            this.estado = Estado.LEVANTADO;
        }
        for (Elemento elem : elementos) {
        	elem.actualizar(escenario);
        }
    }
	
	public LinkedList<ContribucionJuego> capturar() {
		LinkedList<ContribucionJuego> contribuciones = new LinkedList<ContribucionJuego>();
		for (Elemento elem : elementos) {
			contribuciones.add(elem.getContribucion());
			quitarElemento(elem);
		}
		return contribuciones;
	}
	
	
	@Override
	public String toString() {
		return "PanelBasico [posicion=" + posicion + ", estado=" + estado + "]";
	}
}
