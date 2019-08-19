package rw.nicholas;

import java.util.ArrayList;
import rw.nicholas.model.Fase;
import rw.nicholas.model.exceptions.TratamentoDeInput;
import rw.nicholas.model.personagens.Paladino;
import rw.nicholas.view.Encruzilhada;
import rw.nicholas.view.Novigrad;
import rw.nicholas.view.SaidaDeNovigrad;

class Run extends TratamentoDeInput{
	public void start() {
		System.out.println("ATENÇÃO: Este jogo utiliza um d20 para verificar se uma ação sua é bem-sucedida, bem como para"
				+ " determinar quem inicia uma batalha. Além disso, todos as informações dos personagens, também são "
				+ "definidas randomicamente por um dado de X faces. Os diálogos avançarão AUTOMATICAMENTE!\n");
		pausarDialogo(10);
		System.out.println("AGUARDE!\n");
		pausarDialogo(1);
		
		System.out.println("Qual o seu nome (primeiro apenas)?");
		String jogador = input.next(); // O jogador pode dar o nome que desejar, logo sem try
		limparScanner();
		
		Paladino paladino = new Paladino(jogador, 20, 100);
		Encruzilhada encruzilhada = new Encruzilhada(paladino);
		Novigrad novigrad = new Novigrad(paladino);
		SaidaDeNovigrad saidaNovigrad = new SaidaDeNovigrad(paladino);
		
		ArrayList<Fase> fases = new ArrayList<Fase>();
		fases.add(encruzilhada);
		fases.add(novigrad);
		fases.add(saidaNovigrad);
		
		for (Fase e : fases) {
			if (paladino.getVivo())
				e.start();
		}
		
		
		//Fim de Jogo
		System.out.println(paladino.toString());
		if (paladino.getVivo() == false) {
			System.out.println("\nO Fogo Eterno queimou você. Fim de Jogo!");
		} else {
			System.out.println("\nVocê eliminou os soldados do Fogo Eterno, cumprindo seu objetivo, Paladino! Que a Luz seja sempre seu guia!");
		}
	}
}

public class Main {

	public static void main(String[] args) {
		Run run = new Run();
		run.start();
	}
}
