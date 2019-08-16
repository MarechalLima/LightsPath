package rw.nicholas.view;

import java.util.ArrayList;
import java.util.Scanner;

import rw.nicholas.model.Fase;
import rw.nicholas.model.personagens.Inimigo;
import rw.nicholas.model.personagens.Paladino;
import rw.nicholas.controller.ModoBatalha;

public class Encruzilhada extends Fase{
	private int tmpCount;
	private Scanner input = new Scanner(System.in);
	private Paladino paladino;
	
	public Encruzilhada(Paladino paladino) {
		this.paladino = paladino;
		tmpCount = 0;
	}
	
	public void start() {
		do {
			int opt = input.nextInt();
			input.nextLine(); //Descartar o \n
			
			switch (opt) {
			case 1:
				System.out.println("Como fiél guerreiro da Luz, você irá defender o direito daqueles que também quiserem seguir o caminho da Luz.\n");
				input.nextLine(); //Dar pausa no jogo
				bandidosEncruzilhada();
				tmpCount = 3; // Para sair do loop
				break;

			default:
				if (opt <=0 || opt > 4) {
					System.out.println("Opção inválida");
				} else if (tmpCount == 0){
					System.out.println("Você é um guerreiro da Luz, Novigrad está sendo oprimida pelos nobres que aderiram ao culto do Fogo Eterno.\n"
							+ "Você tem certeza que não quer defender o povo lá? Qual caminho você irá escolher?");
				}
				tmpCount++;
				break;
			}
		} while (tmpCount < 2);
		if (tmpCount == 2) {
			System.out.println("Tudo bem, você morreu abandonado pela Luz.");
			paladino.subtrairVida(paladino.getMaxVida());
			
		}
	}
	
	private void bandidosEncruzilhada() {
		int opt = 0;
		boolean continuar = true;
		ArrayList<Inimigo> inimigos = new ArrayList<Inimigo>();
		inimigos.add(new Inimigo("Quebra-Ossos", 10));
		inimigos.add(new Inimigo("Palitinho", 6));
		
		do {
			System.out.println("Seguindo sua viagem a Novigrad, você dá de cara com dois brutamontes que tinham a insígnia do Fogo Eterno em seus trapos."
					+ "\nO que você faz?\n"
					+ "\t1- Esconder-se\n"
					+ "\t2- Sacar arma\n"
					+ "\t3- Consultar informações do seu Paladino");
			opt = input.nextInt();
			input.nextLine(); //Descartar o \n
			
			switch (opt) {
			case 1:
				if (paladino.randDado(20, 1) >= 15) {
					System.out.println("Parabéns, você conseguiu conjurar 'Manto do Exilado', ficando oculto.");
					input.nextLine(); //Pausa
					continuar = false;
					break;
				} else {
					System.out.println("Não foi dessa vez, prepare-se para a batalha!");
					input.nextLine(); //Pausa
				}
			case 2:
				for (Inimigo e : inimigos) {
					ModoBatalha fight = new ModoBatalha(paladino, e);
					fight.batalhar();
				}
				if (paladino.getVivo()) {
					System.out.println("Parabéns, por meio de sua fé e determinação você foi capaz de derrotá-los.\n");
					input.nextLine(); //Pausa
					continuar = false;
				} else {
					continuar = false;
				}
				break;
			case 3:
				System.out.println(paladino.toString());
				continuar = true;
				break;

			default:
				System.out.println("Opção inválida!");
				continuar = true;
				break;
			}
		} while(continuar);
		
	}
	
}
