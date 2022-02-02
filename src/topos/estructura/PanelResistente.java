package topos.estructura;

public class PanelResistente extends PanelBasico {

	// Constantes
	private final static int DUREZA_POR_DEFECTO = 2;
	
	// Atributos
	private final int dureza;
	private int peticiones;
	
	// Getters
	public int getDureza() {
		return dureza;
	}
	
	public int getPeticiones() {
		return peticiones;
	}
	
	public String getRuta() {
		return "imagenes/panel-resistente.gif";
	}
	
	// Constructores
	public PanelResistente(int posX, int posY, int dureza) {
		super(posX, posY);
		this.dureza = dureza;
		this.peticiones = 0;
	}
	
	public PanelResistente(int posX, int posY) {
		this(posX, posY, DUREZA_POR_DEFECTO);
	}

	// Funcionalidad
	@Override
	public void derribar() {
		peticiones = peticiones + 1; 
		if (peticiones == dureza) {
			super.derribar();
			peticiones = 0;
		}
	}
}
