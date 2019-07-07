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
		inimigos.put("thugVigia", new Inimigo("Salamandra", 8));
		plebeus.put("plebeuTraira", new Plebeu("Ingvar", 6, "fogo eterno"));
		plebeus.put("plebeuTaverna", new Plebeu("Sigvarson", 6, "luz"));
	}
	
	public void start() {
		System.out.println("Você finalmente chegou a Novigrad, uma cidade deslumbrante à primeira vista.");
		while (!inimigos.isEmpty() && paladino.getVivo()) {
			System.out.println("Você está nas ruas de Novigrad, o que você deseja fazer?");
			int opt = menu();
			
			switch (opt) {
			case 1:
				tabernaDialog();
				break;
			case 2:
				medicDialog();
				break;
			case 3:
				casaPlebeuDialog();
				break;
			case 4:
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
				+ "\t3- Procurar ajuda em alguma casa\n"
				+ "\t4- Ver informações do Paladino\n");
		int retorno = input.nextInt();
		
		return retorno;
	}
	
	private void tabernaDialog() {
		System.out.println("\tTaberneiro: Bom dia, senhor... Eu acho melhor o senhor se retirar, a Luz foi há muito"
				+ " substituida pelo Fogo Eterno... Além do mais, há sempre guarda aqui.");
		int opt = tabernaMenuTaberneiro();
		
		switch (opt) {
		case 1:
			tabernaDialog1();
			break;
		case 2:
			tabernaDialog2();
			break;
		case 3:
			tabernaDialog3();
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
		
	}
	
	private int tabernaMenuTaberneiro() {
		System.out.println("\t1- Não estou fazendo nada de errado, quero apenas um hidromel\n"
				+ "\t2- Estou protegido pela Luz, nem exércitos poderão me tocar\n"
				+ "\t3- Tudo bem, que a Luz seja seu guia (Sair)\n");
		int retorno = input.nextInt();
		
		return retorno;
	}
	
	private void tabernaDialog1() {
		System.out.println("\t --"+inimigos.get("thugTaberna").getNome()+": Vejam só o que temos aqui, um escravo da Luz..."
				+ " Achei que sua raça estivesse extinta... Mas não importa, eu me certificarei disso\n");
		ModoBatalha duelo = new ModoBatalha(paladino, inimigos.get("thugTaberna"));
		duelo.batalhar();
		if (duelo.quemVenceu() instanceof Paladino) {
			System.out.println("Embora tivesse vencido, o Paladino sabia que precisaria de ajuda para continuar...\n");
			inimigos.remove("thugTaberna");
		}
	}
	
	private void tabernaDialog2() {
		System.out.println("\t"+inimigos.get("thugTaberna").getNome()+": Vejam só o que temos aqui, um idiota, e ainda se acha... Veremos se"
				+ " ele vai conseguir sair vivo daqui! "+inimigos.get("thugVigia").getNome()+"! Venha já aqui, temos que"
						+ " tirar o lixo!");
		for (Inimigo e : inimigos.values()) {
			ModoBatalha fight = new ModoBatalha(paladino, e);
			fight.batalhar();
		}
		if (paladino.getVivo()) {
			for (String chave : inimigos.keySet()) {
				inimigos.remove(chave);
			}
		}
	}
	
	private void tabernaDialog3() {
		System.out.println("\t --"+inimigos.get("thugVigia").getNome()+": Onde pensa que vai, Paladino?");
		ModoBatalha duelo = new ModoBatalha(paladino, inimigos.get("thugVigia"));
		duelo.batalhar();
		if (duelo.quemVenceu() instanceof Paladino) {
			System.out.println("\t --"+plebeus.get("plebeuTaberna").getNome()+": Você deveria procurar um médico antes, "
					+ "é perigoso até mesmo para um Paladino andar ferido.");
		}
	}
	
	private void casaPlebeuDialog() {
		System.out.println("\t --"+plebeus.get("plebeuTraira").getNome()+": GUARDAS, O PALADINO ESTÁ AQUI!");
		System.out.println("--------- "+plebeus.get("plebeuTraira").getNome()+"ataca você enquanto os guardas chegam ---------");
		ModoBatalha duelo = new ModoBatalha(paladino, plebeus.get("plebeuTraira"));
		duelo.batalhar();
		if (duelo.quemVenceu() instanceof Paladino) {
			System.out.println("\t --Guardas: Ataquem o Paladino!");
			
			for (Inimigo e : inimigos.values()) {
				ModoBatalha fight = new ModoBatalha(paladino, e);
				fight.batalhar();
			}
			
			if (paladino.getVivo()) {
				for (String chave : inimigos.keySet()) {
					inimigos.remove(chave);
				}
			}
		}
	}
	
	private void medicDialog() {
		System.out.println("\t"+medico.getNome()+": O que posso fazer por você, meu filho?");
		System.out.println("\t\t1- Curar\n"
				+ "\t\t2- Aumentar vida\n"
				+ "\t\t3- Desculpe-me, foi um engano\n");
		int opt = input.nextInt();
		ModoCura mc = new ModoCura(paladino, medico);
		switch (opt) {
		case 1:
			if (mc.curar()) {
				System.out.println("\t --"+medico.getNome()+": Deixe-me ver isso ... Pronto, agora está inteiro novamente!");
			} else {
				System.out.println("Você não tem ouro suficiente!");
			}
			break;
		case 2:
			if (mc.aumentarVida()) {
				System.out.println("\t --"+medico.getNome()+": Quanta força, meu filho! Eu costumava ser um aventureiro "
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
