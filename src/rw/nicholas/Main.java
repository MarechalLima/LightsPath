package rw.nicholas;

import java.util.ArrayList;
import java.util.Scanner;

import rw.nicholas.personagens.Paladino;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("ATENÇÃO: Este jogo utiliza um d20 para verificar se uma ação sua é bem-sucedida, bem como para"
				+ " determinar quem inicia uma batalha. Além disso, todos as informações dos personagens, também são definidas"
				+ " randomicamente por um dado de X faces. Utilize a tecla Enter para avançar diálogos!");
		input.nextLine(); //Pausa para Disclaimer
		
		System.out.println("Qual o seu nome (primeiro apenas)?");
		String jogador = input.next();
		input.nextLine(); //Descartando \n
		
		Paladino paladino = new Paladino(jogador, 20, 100);
		Encruzilhada encruzilhada = new Encruzilhada(paladino);
		Novigrad novigrad = new Novigrad(paladino);
		
		ArrayList<Fase> fases = new ArrayList<Fase>();
		fases.add(encruzilhada);
		fases.add(novigrad);
		
		System.out.println("Muito bem, " + jogador + ". Prepare-se para uma aventura que se passa nos reinos"
				+ " do norte.\n\n\tVocê é um Paladino, uma classe de fiéis guerreiros da Luz, que com a perseguição"
				+ " instaurada contra os seguidores da Luz a partir da ascensão do culto ao Fogo Eterno,"
				+ " sua Ordem se viu dizimada, e com o fim da Ordem dos Paladinos você decide exilar-se a fim de estudar a Luz,"
				+ " como bom Paladino que é, você sabe que sua fé é tão importante quanto o aço que carrega"
				+ " empunhado.\n\nDiante de uma encruzilhada, você tem 4 possíveis caminhos: \n\t1- À sua frente Novigrad"
				+ "\n\t2- À sua esquerda Kaer Morhen\n\t3- Atrás de você, está Velen\n\t4- E à sua direita Oxenfurt"
				+ "\n\nQual caminho você irá escolher? Sabendo que no caminho de Novigrad você vê a chama do Fogo Eterno.");
		
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
