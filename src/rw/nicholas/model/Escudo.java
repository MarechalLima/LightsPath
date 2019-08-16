package rw.nicholas.model;

public class Escudo {
	private int dano;
	private boolean explosaoDeLuz;
	
	public Escudo(int dano) {
		this.dano = dano;
		explosaoDeLuz = true;
	}
	
	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
	public boolean getExplosaoDeLuz() {
		return explosaoDeLuz;
	}
	public void recuperarExplosaoDeLuz() {
		this.explosaoDeLuz = true;
	}
	public void usarExplosaoDeLuz() {
		this.explosaoDeLuz = false;
	}
	
}
