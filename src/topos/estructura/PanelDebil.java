package topos.estructura;

public class PanelDebil extends PanelBasico {

	// Constantes
	private final static int DERRIBOS = 3;
	
	// Atributos
	private int nDerribos;
	
	public PanelDebil(int posX, int posY) {
		super(posX, posY);
		this.nDerribos = DERRIBOS;
	}

	// Getters
	public int getNDerribos() {
		return nDerribos;
	}
	
	public String getRuta() {
		return "imagenes/panel-debil.gif";

	}
	
	// Funcionalidad
	@Override
	public void derribar() {
		this.nDerribos = this.nDerribos - 1;
		if (getNDerribos() == 0) {
			super.derribar();
		}
	}
}
