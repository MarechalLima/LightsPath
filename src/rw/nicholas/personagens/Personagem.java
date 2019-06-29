package rw.nicholas.personagens;

import java.util.Random;

public abstract class Personagem {
	private int vida;
	private int dinheiro; //inteiro pelo contexto, o dinheiro é uma unidade 
	private boolean vivo;	  //	... fixa de troca, sem ponto flutuante: moedas de ouro, por exemplo
	
	private Random rand = new Random();
	
	public Personagem() {
		this.vivo = true;
		this.aumentarVida();
		this.dinheiro = rand.nextInt(100)+1; // para todos os personagem o dinheiro inicial é random, apenas para um futuro loot
	}
	
	public abstract void aumentarVida(); //por ser um rpg, essa característica é definida randomicamente
	
	public boolean subtrairVida(int vida) { //Retorna se o personagem está vivo também
		if (vida >= 0) {
			this.vida -= vida;
		}
		if (this.vida <= 0) {
			this.vivo = false;
		}
		
		return this.vivo;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public int getDinheiro() {
		return this.dinheiro;
	}
	
	public void removerDinheiro(int dinheiro) {
		if (dinheiro >= 0 && (this.dinheiro - dinheiro) >= 0) {
			this.dinheiro -= dinheiro;
		}
	}
	
	public void inserirDinheiro(int dinheiro) {
		if (dinheiro >= 0) {
			this.dinheiro += dinheiro;
		}
	}
}
