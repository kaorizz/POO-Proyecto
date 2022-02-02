package topos.juego;

import java.awt.Color;
import java.util.LinkedList;

import topos.elementos.Moneda;
import topos.elementos.Municion;
import topos.elementos.Ratas;
import topos.elementos.Reloj;
import topos.elementos.TopoCiego;
import topos.elementos.TopoListo;
import topos.elementos.TopoTorpe;
import topos.estructura.Direccion;
import topos.estructura.PanelAleatorio;
import topos.estructura.PanelBasico;
import topos.estructura.PanelDebil;
import topos.estructura.PanelResistente;
import topos.vista1.Alarma;
import topos.vista1.Pantalla;

public class Programa {

	// Constantes
	private static final int ANCHO_PARTIDA = 7;
	private static final int ALTO_PARTIDA = 7;
	private static final int TIEMPO_PARTIDA = 60;
	private static final int DISPAROS_PARTIDA = 5;

	private static final int TAMANO_SECCION = 50;
	private static final Color COLOR_FONDO = java.awt.Color.GREEN;

	private static final String ARRIBA = "i";
	private static final String IZQUIERDA = "j";
	private static final String ABAJO = "k";
	private static final String DERECHA = "l";
	private static final String DISPARO = "d";

	// Main
	public static void main(String[] args) {
		Partida partida = new Partida(ANCHO_PARTIDA, ALTO_PARTIDA, TIEMPO_PARTIDA, DISPAROS_PARTIDA);
		Pantalla pantalla = new Pantalla(ANCHO_PARTIDA, ALTO_PARTIDA, TAMANO_SECCION, COLOR_FONDO);
		PanelAleatorio aleatorio = new PanelAleatorio(2,5);
		PanelDebil debil = new PanelDebil(4,6);
		PanelResistente resistente = new PanelResistente(6,2,4);
		
		PanelBasico basico1 = new PanelBasico(0,1);
		PanelBasico basico2 = new PanelBasico(0,2);
		PanelBasico basico3 = new PanelBasico(0,3);
		PanelBasico basico4 = new PanelBasico(0,0);
		
		basico1.introducirElemento(new TopoListo());
		basico2.introducirElemento(new TopoCiego());
		basico3.introducirElemento(new TopoTorpe());
		basico4.introducirElemento(new Ratas());
		
		debil.introducirElemento(new Municion(100));
		aleatorio.introducirElemento(new Reloj(60));
		resistente.introducirElemento(new Moneda(5));
		
		partida.arrancar();
		partida.addPaneles(debil, resistente, aleatorio, basico1, basico2, basico3, basico4);

		while (partida.isPartidaEnJuego()) {
			pantalla.resetear();
			if (pantalla.hayTecla()) {
				String tecla = pantalla.leerTecla();
				switch (tecla) {
				case ARRIBA:
					partida.desplazar(Direccion.ARRIBA);
					break;
				case ABAJO:
					partida.desplazar(Direccion.ABAJO);
					break;
				case IZQUIERDA:
					partida.desplazar(Direccion.IZQUIERDA);
					break;
				case DERECHA:
					partida.desplazar(Direccion.DERECHA);
					break;
				case DISPARO:
					partida.disparar();
					break;
				}
				partida.actualizar();
				LinkedList<Imagen> imagenes = partida.getImagenes();
				for (Imagen im : imagenes) {
					pantalla.addImagen(im.getX(), im.getY(), im.getRuta());
				}
				String info = "Tiempo restante: "+partida.getSegundosRestantes()+" s - Disparos : "+partida.getDisparos()+" - Puntos: "+partida.getPuntos();
				pantalla.setBarraEstado(info);
				pantalla.dibujar();
				Alarma.dormir(200);				
			}
		}
		pantalla.setBarraEstado("FIN DEL JUEGO - Puntos conseguidos: "+partida.getPuntos());
	}
}
