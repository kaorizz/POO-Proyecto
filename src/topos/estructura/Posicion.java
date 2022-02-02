package topos.estructura;

public class Posicion implements Cloneable {

	// atributos (propiedades)
	
	private int x;
	private int y;
	
	
	// constructores
	
	// sobrecarga
	
	public Posicion(int x, int yInicial) {
		
		this.x = x;
		y = yInicial;
	}
	
	public Posicion(Posicion otro) {
		
		x = otro.getX();
		y = otro.y;
		
	}
	
	
	// métodos (funcionalidad)
	
	// Métodos de acceso y modificación
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	// Métodos
	
	public void desplazar(int incX, int incY) {
		
		x = x + incX;
		y = y + incY;
	}
	
	// Versión sobrecargada
	public void desplazar(Direccion dir) {
		
		// Se presentan dos alternativas
		
		switch (dir) {
			case ARRIBA: this.y++; break;
			case ABAJO: this.y--; break;
			case DERECHA: this.x++; break;
			case IZQUIERDA: this.x--; break;
		}
	}
			
	public Posicion getVecina(Direccion dir) {
		Posicion pos = new Posicion(this.x, this.y);
		pos.desplazar(dir);
		return pos;
	}
	
	
	
	@Override
	public String toString() {
		return "Posicion [x=" + x + ", y=" + y + "]";
	}

	// Solo un parámetro !
	public double distancia(Posicion otro) {
		
		final int difX = this.x - otro.x;
		final int difY = this.y - otro.y;
				
		return Math.sqrt(
				Math.pow(difX, 2) + Math.pow(difY, 2)
			);
	}
	
	
	// La definición nos obliga a que sea un método static
	// En un método ordinario (instancia) el objeto receptor (this) debe
	// ser el protagonista del cálculo.
	
	public static Posicion mayorDistancia(Posicion... puntos) {
		
		Posicion origen = new Posicion(0, 0);
		
		double maximo = -1;
		Posicion masDistante = null;
		// For each
		for (Posicion punto : puntos) {
			double distancia = origen.distancia(punto);
			if (distancia > maximo) {
				maximo = distancia;
				masDistante = punto;
			}
		}
		
		return masDistante;	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	private Posicion copiaSuperficial() {
		try {
			Posicion copiaSuperficial = (Posicion) super.clone();
			return copiaSuperficial;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * M�todo clone asociado a la clase Escaparate
	 */
	@Override
	public Posicion clone() {
		Posicion copia = copiaSuperficial();
		copia.x = this.x;
		copia.y = this.y;
		
		return copia;
	}
}
