package rw.nicholas.view;

import rw.nicholas.controller.InimigoController;
import rw.nicholas.controller.ModoBatalha;
import rw.nicholas.model.Fase;
import rw.nicholas.model.personagens.Paladino;

public class SaidaDeNovigrad extends Fase{
	private Paladino paladino;
	private InimigoController icInimigos;
	
	public SaidaDeNovigrad (Paladino paladino) {
		this.paladino = paladino;
		icInimigos = new InimigoController();
	}

	@Override
	public void start() {
		if (icInimigos.isEmpty(new Encruzilhada()) == false) {
			System.out.println("\nAo sair de Novigrad... Você encontra aqueles brutamontes que você foi"
					+ " capaz de evitar, mas essa não será uma opção agora!");
			pausarDialogo(4);
			ModoBatalha fight = new ModoBatalha();
			fight.batalhar(paladino, new Encruzilhada());
		}
		
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Encruzilhada) {
			return true;
		}
		return false;
	}

}
