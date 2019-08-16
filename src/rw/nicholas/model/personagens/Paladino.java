package rw.nicholas.model.personagens;

import rw.nicholas.model.Escudo;

public class Paladino extends Personagem{
	private int maxVida; //O médico cura apenas o paladino, por enquanto
	public final String AFINIDADE = "luz";
	public Escudo escudo;
	
	public Paladino(String nome, int dado, int ouro) {
		super(nome, dado, ouro);
		maxVida = super.getVida();
		escudo = new Escudo(randDado(4, 1));	
	}

	
	public void aumentarVida() {
		super.setVida(randDado(getDado(), 1));
	}
	
	public void curar() {
		restaurarVida(maxVida);
		escudo.recuperarExplosaoDeLuz();
	}

	public int getMaxVida() {
		return maxVida;
	}

	public void setMaxVida(int maxVida) {
		this.maxVida = maxVida;
	}
	
	@Override
	public int getDano() {
		int danoTotal = super.getDano();
		if (escudo.getExplosaoDeLuz()) {
			danoTotal += escudo.getDano() * randDado(6, 1);
			escudo.usarExplosaoDeLuz();
		} else {
			danoTotal += escudo.getDano();
		}

		return danoTotal;
	}
	
	@Override
	public String toString() {
		return "Nome: " + super.getNome() + " | Vida: " + getVida() + " | Ouro: " + super.getOuro() + " | Afinidade: " + AFINIDADE;
	}
	
}
