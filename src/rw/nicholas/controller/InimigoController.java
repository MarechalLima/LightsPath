package rw.nicholas.controller;

import rw.nicholas.model.ConcurrentHashMapInimigosDAO;
import rw.nicholas.model.Fase;
import rw.nicholas.model.personagens.Inimigo;
import rw.nicholas.model.personagens.Personagem;

public class InimigoController {
	private ConcurrentHashMapInimigosDAO inimigoDAO = new ConcurrentHashMapInimigosDAO();
	
	public void inserirInimigo(String id, String nome, int dado, Fase fase) {
		Inimigo inimigo = new Inimigo(nome, dado, fase);
		
		inimigoDAO.inserirInimigo(id, inimigo);
	}
	
	public void deletarInimigo(String id) {
		inimigoDAO.removerInimigo(id);
	}
	
	public void deletarInimigo(Personagem personagem) {
		inimigoDAO.removerInimigo(personagem);
	}
	
	public String[] listarInimigos () {
		return inimigoDAO.listarID();
	}
	
	public boolean isEmpty (Fase fase) {
		return inimigoDAO.isEmpty(fase);
	}
	
	public Inimigo getInimigo(String id) {
		return inimigoDAO.getInimigo(id);
	}
}
