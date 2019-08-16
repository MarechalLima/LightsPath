package rw.nicholas.model.personagens;

import java.util.Random;

public abstract class Personagem {
	private String nome;
	private int dado; //serve tanto para vida como para dano, ações serão um d20 convencional
	private int vida = 0;
	private int dano = 0;
	private int ouro = 0; //inteiro pelo contexto, o dinheiro é uma unidade e nesse contexto
	private boolean vivo;	  //	... fixa de troca, sem ponto flutuante: moedas de ouro, por exemplo
	
	protected Random rand = new Random();
	
	public Personagem(String nome, int dado) {
		this.vida = randDado(dado, 2);
		this.dano = randDado(dado, 1);
		this.ouro = randDado(50, 1);
		this.dado = dado;
		this.nome = nome;
		this.vivo = true;
	}
	
	public Personagem(String nome, int dado, int ouro) {
		this.vida = randDado(dado, 2);
		this.dano = randDado(dado, 1);
		this.ouro = randDado(ouro, 1);
		this.dado = dado;
		this.nome = nome;
		this.vivo = true;
	}
	
	public int randDado(int dado, int vezes) {
		int retornaValor = 0;
		for (int i = 0; i < vezes; i++) {
			retornaValor += (rand.nextInt(dado)+1);
		}
		return retornaValor;
	}
	
	public abstract void aumentarVida();
	
	public boolean subtrairVida(int vida) { //Retorna se o personagem está vivo também
		if (vida >= 0) {
			this.vida -= vida;
		}
		if (this.vida <= 0) {
			this.vivo = false;
		}
		
		return this.vivo;
	}
	
	public void removerOuro(int ouro) {
		if (ouro >= 0 && (this.ouro - ouro) >= 0) {
			this.ouro -= ouro;
		}
	}
	
	public void inserirOuro(int ouro) {
		if (ouro >= 0) {
			this.ouro += ouro;
		}
	}
	
	public void restaurarVida(int vidaMax) {
		this.vida = vidaMax;
	}
	
	public void setVida(int vida) {
		this.vida+= vida;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public int getOuro() {
		return this.ouro;
	}

	public int getDano() {
		return this.dano;
	}

	public String getNome() {
		return this.nome;
	}

	public int getDado() {
		return this.dado;
	}
	
	public boolean getVivo() {
		return this.vivo;
	}
	
}
