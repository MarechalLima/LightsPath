package rw.nicholas;

import java.util.HashMap;

import rw.nicholas.personagens.Inimigo;
import rw.nicholas.personagens.Plebeu;

public class Taberna {
	protected HashMap<String, Inimigo> inimigos;
	protected HashMap<String, Plebeu> plebeus;
	
	public Taberna(HashMap<String, Inimigo> inimigos, HashMap<String, Plebeu> plebeus) {
		this.inimigos = inimigos;
		this.plebeus = plebeus;
	}
	
	
}
