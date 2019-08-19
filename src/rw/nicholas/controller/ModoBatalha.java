package rw.nicholas.controller;

import rw.nicholas.model.Fase;
import rw.nicholas.model.exceptions.TratamentoDeInput;
import rw.nicholas.model.personagens.Afinidade;
import rw.nicholas.model.personagens.Inimigo;
import rw.nicholas.model.personagens.Paladino;
import rw.nicholas.model.personagens.Personagem;

public class ModoBatalha extends TratamentoDeInput{
	private Personagem vencedor;
	private InimigoController icInimigo;
	
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
	
	private boolean evitarDuelo(Paladino paladino, Personagem personagem) {
		/** Caso o Paladino tenha conseguido persuadir o personagem, ambos serão servidores da Luz **/
		if (personagem instanceof Afinidade) {
			Afinidade carinha = (Afinidade) personagem;
			if (personagem instanceof Inimigo) {
				Inimigo enemy = (Inimigo) personagem;
				boolean eAlterado = enemy.alterarAfinidade(paladino);
				System.out.println("--Eu: Não brigue irmão, a luz ainda poderá redimir suas regressões!");
				pausarDialogo(3);
				if (eAlterado == false) {
					System.out.println("--"+personagem.getNome()+": Não seja patético, Paladino!");
					pausarDialogo(2);
				}
			}
			if (carinha.matchAfinidade(paladino)) {
				System.out.println("A Luz foi mais forte, não haverá sangue!");
				icInimigo.deletarInimigo(personagem);
				return true;
			}
		}
		return false;
	}
	
	public Personagem duelar(Paladino paladino, Personagem personagem) {
		if (!paladino.getVivo()) {
			System.out.println("A crueldade é tamanha, que mesmo com o Paladino prostrado no chão"
					+ "... Seus agressores não param.\n");
		}
		
		if (evitarDuelo(paladino, personagem) == true) {
			return paladino;
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
