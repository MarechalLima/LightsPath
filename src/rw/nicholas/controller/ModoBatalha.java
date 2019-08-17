package rw.nicholas.controller;

import rw.nicholas.model.exceptions.TratamentoDeInput;
import rw.nicholas.model.personagens.Paladino;
import rw.nicholas.model.personagens.Personagem;

public class ModoBatalha extends TratamentoDeInput{
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
		pausarDialogo();
		return this.vencedor;
	}
	
	public Personagem quemVenceu() {
		return this.vencedor;
	}
	
	
}
