package rw.nicholas.personagens;

public class Paladino extends Personagem{
	private int maxVida; //O médico cura apenas o paladino, por enquanto
	
	public Paladino(String nome, int dado, int ouro) {
		super(nome, dado, ouro);
		maxVida = super.getVida();
	}
	
	public void aumentarVida() {
		super.setVida(randDado(getDado(), 1));
	}
	
	public void curar() {
		restaurarVida(maxVida);
	}

	public int getMaxVida() {
		return maxVida;
	}

	public void setMaxVida(int maxVida) {
		this.maxVida = maxVida;
	}
	
}
