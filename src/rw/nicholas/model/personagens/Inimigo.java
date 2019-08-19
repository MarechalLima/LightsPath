package rw.nicholas.model.personagens;

import rw.nicholas.model.Fase;

public class Inimigo extends Personagem implements Afinidade{
	private Fase fase;
	private String afinidade;
	
	public Inimigo(String nome, int dado, Fase fase) {
		super(nome, dado);
		this.fase = fase;
		this.afinidade = "fogo eterno"; //Eles são inimigos, é óbvio que a afinidade vai ser diferente do paladino
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
	
	public String getAfinidade() {
		return afinidade;
	}

	public void setAfinidade(String afinidade) {
		this.afinidade = afinidade;
	}
	
	public boolean matchAfinidade(Paladino paladino) {
		return (this.afinidade.equalsIgnoreCase(paladino.AFINIDADE)) ? true : false;
	}
	
	public boolean alterarAfinidade(Paladino  paladino) {
		int persuasaoPaladino = paladino.randDado(20, 1);
		int feInimigo = randDado(20, 1);
		
		if (feInimigo > 15) {
			return false;
		}
		if (persuasaoPaladino >= 15) {
			setAfinidade(paladino.AFINIDADE); //luz
			return true;
		}
		return false;
	}
	
}
