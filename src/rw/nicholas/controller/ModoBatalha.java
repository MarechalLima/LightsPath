package rw.nicholas.controller;
import java.util.Scanner;

import rw.nicholas.model.personagens.Paladino;
import rw.nicholas.model.personagens.Personagem;

public class ModoBatalha {
	private Paladino paladino;
	private Personagem personagem;
	private Personagem vencedor;
	
	public ModoBatalha(Paladino paladino, Personagem personagem) {
		this.paladino = paladino;
		this.personagem = personagem;
	}
	
	public Personagem batalhar() {
		int percepcaoPaladino = paladino.randDado(20, 1);
		int percepcaoPersonagem = personagem.randDado(20, 1);

		if (percepcaoPaladino >= percepcaoPersonagem) {
			while(personagem.getVivo() && paladino.getVivo()) {
				personagem.subtrairVida(paladino.getDano());
				paladino.subtrairVida(personagem.getDano());
			}
		} else {
			while(personagem.getVivo() && paladino.getVivo()) {
				paladino.subtrairVida(personagem.getDano());
				personagem.subtrairVida(paladino.getDano());
			}
		}
		
		if (paladino.getVivo()) {
			this.vencedor = paladino;
			System.out.println(paladino.getNome()+" derrotou "+personagem.getNome());
		} else {
			this.vencedor = personagem;
			System.out.println(personagem.getNome()+" derrotou "+paladino.getNome());
		}
		Scanner input = new Scanner(System.in);
		if(input.hasNextLine()) {
			input.nextLine();
		}
		input.close();
		return this.vencedor;
	}
	
	public Personagem quemVenceu() {
		return this.vencedor;
	}
	
	
}
