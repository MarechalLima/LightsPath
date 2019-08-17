package rw.nicholas.model.personagens;

import rw.nicholas.model.Fase;

public class Inimigo extends Personagem{
	private Fase fase;
	
	public Inimigo(String nome, int dado, Fase fase) {
		super(nome, dado);
		this.fase = fase;
	}
	
	public void aumentarVida() {
		setVida(randDado(getDado(), 1)); //Os inimigos irão evoluir de forma parecida com o Paladino
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}
	
}
