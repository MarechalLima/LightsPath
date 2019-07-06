package rw.nicholas;

import java.util.HashMap;
import java.util.Scanner;

import rw.nicholas.personagens.Inimigo;
import rw.nicholas.personagens.Medico;
import rw.nicholas.personagens.Paladino;
import rw.nicholas.personagens.Plebeu;

public class Novigrad extends Fase{
	private Paladino paladino;
	private Scanner input = new Scanner(System.in);
	private Medico medico;

	private HashMap<String, Inimigo> inimigos = new HashMap<String, Inimigo>();
	private HashMap<String, Plebeu> plebeus = new HashMap<String, Plebeu>();
	
	public Novigrad(Paladino paladino) {
		this.paladino = paladino;
		medico = new Medico("Doctor", 5);
		inimigos.put("thugTaberna", new Inimigo("Cabeça de Martelo", 10));
		inimigos.put("thugHospedaria", new Inimigo("Salamandra", 8));
		plebeus.put("plebeuTraira", new Plebeu("Ingvar", 6, "fogo eterno"));
		plebeus.put("plebeuTaverna", new Plebeu("Sigvarson", 6, "luz"));
	}
	
	public void start() {
		System.out.println("Você finalmente chegou a Novigrad, uma cidade deslumbrante à primeira vista.");
		while (!inimigos.isEmpty()) {
			System.out.println("O que você deseja fazer?");
			int opt = menu();
			
			switch (opt) {
			case 1:
				
				break;
			case 2:
				medicDialog();
				break;
			case 3:
				System.out.println(paladino.toString());
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
	}
	
	private int menu() {
		System.out.println("\t1- Ir a taberna\n"
				+ "\t2- Visitar um médico\n"
				+ "\t3- Ver informações do Paladino");
		int retorno = input.nextInt();
		
		return retorno;
	}
	
	private void tabernaDialog() {
		
	}
	
	private void medicDialog() {
		System.out.println("\t"+medico.getNome()+": O que posso fazer por você, meu filho?");
		System.out.println("\t\t1- Curar"
				+ "\t\t2- Aumentar vida"
				+ "\t\t3- Desculpe-me, foi um engano");
		int opt = input.nextInt();
		ModoCura mc = new ModoCura(paladino, medico);
		switch (opt) {
		case 1:
			if (mc.curar()) {
				System.out.println("\t"+medico.getNome()+": Deixe-me ver isso ... Pronto, agora está inteiro novamente!");
			} else {
				System.out.println("Você não tem ouro suficiente!");
			}
			break;
		case 2:
			if (mc.aumentarVida()) {
				System.out.println("\t"+medico.getNome()+": Quanta força, meu filho! Eu costumava ser um aventureiro "
						+ "como você... até que eu levei uma flechada no joelho.");
			} else {
				System.out.println("Você não tem ouro suficiente!");
			}
			break;

		default:
			break;
		}
	}
}
