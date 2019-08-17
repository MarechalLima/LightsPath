package rw.nicholas.view;

import java.util.concurrent.ConcurrentHashMap;

import rw.nicholas.model.Fase;
import rw.nicholas.model.exceptions.EntradaProibidaException;
import rw.nicholas.model.exceptions.EscolhaInvalidaException;
import rw.nicholas.model.personagens.Inimigo;
import rw.nicholas.model.personagens.Medico;
import rw.nicholas.model.personagens.Paladino;
import rw.nicholas.model.personagens.Plebeu;
import rw.nicholas.controller.ModoBatalha;
import rw.nicholas.controller.ModoCura;

public class Novigrad extends Fase{
	private Paladino paladino;
	private Medico medico;
	private boolean taberna = false;
	private boolean casaPlebeu = false;

	private ConcurrentHashMap<String, Inimigo> inimigos = new ConcurrentHashMap<String, Inimigo>();
	private ConcurrentHashMap<String, Plebeu> plebeus = new ConcurrentHashMap<String, Plebeu>();
	
	public Novigrad() {}
	
	public Novigrad(Paladino paladino) {
		this.paladino = paladino;
		medico = new Medico("Doctor", 5);
		inimigos.put("thugTaberna", new Inimigo("Cabeça de Martelo", 10, new Novigrad()));
		inimigos.put("thugVigia", new Inimigo("Salamandra", 8, new Novigrad()));
		plebeus.put("plebeuTraira", new Plebeu("Ingvar", 6, "fogo eterno"));
		plebeus.put("plebeuTaberna", new Plebeu("Sigvarson", 6, "luz"));
	}
	
	private void menu() throws EntradaProibidaException, EscolhaInvalidaException {
		System.out.println("\t1- Ir a taberna\n"
				+ "\t2- Visitar um médico\n"
				+ "\t3- Procurar ajuda em alguma casa\n"
				+ "\t4- Ver informações do Paladino\n");
	}
	
	public void start() {
		System.out.println("Você finalmente chegou a Novigrad, uma cidade deslumbrante à primeira vista.");
		while (!inimigos.isEmpty() && paladino.getVivo()) {
			System.out.println("Você está nas ruas de Novigrad, o que você deseja fazer?");
			int opt;
			while(true) {
				try {
					menu();
					opt = entrada(1,4);
					break;
				} catch (EntradaProibidaException epe) {
					System.out.println(epe.getMessage());
				} catch (EscolhaInvalidaException eie) {
					System.out.println(eie.getMessage());
				}
			}
			
			switch (opt) {
			case 1:
				if (taberna == false) {
					tabernaDialog();
					taberna = true;
				} else {
					System.out.println("Você não pode mais entrar aqui!");
				}
				break;
			case 2:
				medicDialog();
				break;
			case 3:
				if (casaPlebeu == false) {
					casaPlebeuDialog();
					casaPlebeu = true;
				} else {
					System.out.println("Você não pode mais entrar aqui!");
				}
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
	
	private void tabernaDialog() {
		System.out.println("\t --Taberneiro: Bom dia, senhor... Eu acho melhor o senhor se retirar, a Luz foi há muito"
				+ " substituida pelo Fogo Eterno... Além do mais, há sempre guardas aqui.");
		int opt;
		while(true) {
			try {
				tabernaMenuTaberneiro();
				opt = entrada(1,3);
				break;
			} catch (EntradaProibidaException epe) {
				System.out.println(epe.getMessage());
			} catch (EscolhaInvalidaException eie) {
				System.out.println(eie.getMessage());
			}
		}
		
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
	
	private void tabernaMenuTaberneiro() {
		System.out.println("\t1- Não estou fazendo nada de errado, quero apenas um hidromel\n"
				+ "\t2- Estou protegido pela Luz, nem exércitos poderão me tocar\n"
				+ "\t3- Tudo bem, que a Luz seja seu guia (Sair)\n");
	}
	
	private void tabernaDialog1() {
		System.out.println("\t --"+inimigos.get("thugTaberna").getNome()+": Vejam só o que temos aqui, um escravo da Luz..."
				+ " Achei que sua raça estivesse extinta... Mas não importa, eu me certificarei disso\n");
		pausarDialogo();
		
		ModoBatalha duelo = new ModoBatalha(paladino, inimigos.get("thugTaberna"));
		duelo.batalhar();
		if (duelo.quemVenceu() instanceof Paladino) {
			System.out.println("Embora tivesse vencido, o Paladino sabia que precisaria de ajuda para continuar...\n");
			inimigos.remove("thugTaberna");
		}
	}
	
	private void tabernaDialog2() {
		System.out.println("\t --"+inimigos.get("thugTaberna").getNome()+": Vejam só o que temos aqui, um idiota, e ainda se acha... Veremos se"
				+ " ele vai conseguir sair vivo daqui! "+inimigos.get("thugVigia").getNome()+"! Venha já aqui, temos que"
						+ " tirar o lixo!");
		pausarDialogo();
		
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
		pausarDialogo();
		
		ModoBatalha duelo = new ModoBatalha(paladino, inimigos.get("thugVigia"));
		duelo.batalhar();
		if (duelo.quemVenceu() instanceof Paladino) {
			System.out.println("\t --"+plebeus.get("plebeuTaberna").getNome()+": Você deveria procurar um médico antes, "
					+ "é perigoso até mesmo para um Paladino andar ferido.");
			pausarDialogo();
		}
	}
	
	private void casaPlebeuDialog() {
		System.out.println("\t --"+plebeus.get("plebeuTraira").getNome()+": GUARDAS, O PALADINO ESTÁ AQUI!");
		System.out.println("--------- "+plebeus.get("plebeuTraira").getNome()+" ataca você enquanto os guardas chegam ---------");
		ModoBatalha duelo = new ModoBatalha(paladino, plebeus.get("plebeuTraira"));
		pausarDialogo();
		
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
	
	private void menuMedicDialog() {
		System.out.println("\t --"+medico.getNome()+": O que posso fazer por você, meu filho?");
		System.out.println("\t\t1- Curar\n"
				+ "\t\t2- Aumentar vida\n"
				+ "\t\t3- Desculpe-me, foi um engano\n");
	}
	
	private void medicDialog() {
		int opt = 0;
		while(true) {
			try {
				menuMedicDialog();
				opt = entrada(1,3);
				break;
			} catch (EntradaProibidaException epe) {
				System.out.println(epe.getMessage());
			} catch (EscolhaInvalidaException eie) {
				System.out.println(eie.getMessage());
			}
		}
		
		ModoCura mc = new ModoCura(paladino, medico);
		switch (opt) {
		case 1:
			if (mc.curar()) {
				System.out.println("\t --"+medico.getNome()+": Deixe-me ver isso ... Pronto, agora está inteiro novamente!");
			} else {
				System.out.println("Não há nada que eu possa fazer aqui!");
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

		case 3:
			System.out.println("\t --"+medico.getNome()+": Estamos de portas abertas, meu filho!");
			break;
		}
		pausarDialogo();
	}
}
