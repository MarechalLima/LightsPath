package rw.nicholas.controller;

import rw.nicholas.model.Fase;
import rw.nicholas.model.exceptions.TratamentoDeInput;
import rw.nicholas.model.personagens.Inimigo;
import rw.nicholas.model.personagens.Paladino;
import rw.nicholas.model.personagens.Personagem;
import rw.nicholas.view.Novigrad;

public class ModoBatalha extends TratamentoDeInput{
//	private Paladino paladino;
//	private Personagem personagem;
	private Personagem vencedor;
	private InimigoController icInimigo;
	
//	public ModoBatalha(Paladino paladino, Personagem personagem) {
//		this.paladino = paladino;
//		this.personagem = personagem;
//	}
	
	public ModoBatalha() {
		icInimigo = new InimigoController();
	}
	
	public Personagem batalhar(Paladino paladino, Fase fase) {
		if (icInimigo == null) {
			System.out.println("Inicialização errada!\n");
			return paladino;
		}
		
		for (String inimigoKey : icInimigo.listarInimigos()) {
			if (icInimigo.getInimigo(inimigoKey).getFase().equals(fase)) {
				Inimigo enemy = icInimigo.getInimigo(inimigoKey);
				vencedor = duelar(paladino, enemy);
			}
		}
		return vencedor;
	}
	
	public Personagem duelar(Paladino paladino, Personagem personagem) {
		if (!paladino.getVivo()) {
			System.out.println("A crueldade é tamanha, que mesmo com o Paladino prostrado no chão"
					+ "... Seus agressores não param.\n");
		}
		
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
		
		icInimigo.deletarInimigo(personagem);
		pausarDialogo(2);
		
		return this.vencedor;
	}
	
	public Personagem quemVenceu() {
		return this.vencedor;
	}
	
	
}
