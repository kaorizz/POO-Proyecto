package topos.elementos;

import topos.estructura.Direccion;
import topos.estructura.Escenario;

public abstract class Topos extends ElementosActivos {
	
	// Constantes
	private static final long TIEMPO_POR_DEFECTO = 3000;
	
	// Atributos
	private long marcaTiempo;
	private Direccion ultDesplazamiento;
	
	// Getters
	public long getMarcaTiempo() {
		return marcaTiempo;
	}
	
	public Direccion getUltDesplazamiento() {
		return ultDesplazamiento; 
	}
	
	// Constructores
	public Topos() {
		this.marcaTiempo = System.currentTimeMillis();
	}
	
	
	// Funcionalidad
	abstract public boolean isMovible(Escenario escenario);
	
	abstract public Direccion getDesplazamiento(Escenario escenario);
	
	public void actualizar(Escenario escenario) {
		if (isMovible(escenario)) {
			long tiempo = System.currentTimeMillis() - marcaTiempo;
			if (tiempo > TIEMPO_POR_DEFECTO) {
				Direccion dir = getDesplazamiento(escenario);
				boolean desp = this.desplazar(dir, escenario);
				if (desp) {
					marcaTiempo = System.currentTimeMillis();
					ultDesplazamiento = dir;
				}
			}
		}
	}
}
