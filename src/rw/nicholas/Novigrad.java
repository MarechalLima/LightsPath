package rw.nicholas;

import java.util.ArrayList;
import java.util.Scanner;

import rw.nicholas.personagens.Inimigo;
import rw.nicholas.personagens.Paladino;
import rw.nicholas.personagens.Plebeu;

public class Novigrad {
	private Paladino paladino;
	private Scanner input = new Scanner(System.in);
	private ArrayList<Inimigo> inimigos = new ArrayList<Inimigo>();
	private ArrayList<Plebeu> plebeus = new ArrayList<Plebeu>();
	
	public Novigrad(Paladino paladino) {
		this.paladino = paladino;
	}
	
	public void start() {
		System.out.println("Você finalmente chegou a Novigrad, uma cidade deslumbrante à primeira vista.\n"
				+ "O que você deseja fazer?");
		while (!inimigos.isEmpty()) {
			
		}
	}
	
	private int menu() {
		System.out.println("\t1- Ir a taberna\n"
				+ "\t2- Visitar um médico\n"
				+ "\t3- Ver informações do Paladino");
		int retorno = input.nextInt();
		
		return retorno;
	}
}
