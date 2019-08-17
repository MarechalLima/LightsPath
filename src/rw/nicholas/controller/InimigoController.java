package rw.nicholas.controller;

import rw.nicholas.model.ConcurrentHashMapInimigosDAO;
import rw.nicholas.model.Fase;
import rw.nicholas.model.personagens.Inimigo;

public class InimigoController {
	public void inserirInimigo(String id, String nome, int dado, Fase fase) {
		Inimigo inimigo = new Inimigo(nome, dado, fase);
		
		ConcurrentHashMapInimigosDAO inimigoDAO = new ConcurrentHashMapInimigosDAO();
		inimigoDAO.inserirInimigo(id, inimigo);
	}
	
	public void deletarInimigo(String id) {
		ConcurrentHashMapInimigosDAO inimigoDAO = new ConcurrentHashMapInimigosDAO();
		inimigoDAO.removerInimigo(id);
	}
	
	public String[] listarInimigos () {
		ConcurrentHashMapInimigosDAO inimigoDAO = new ConcurrentHashMapInimigosDAO();
		return inimigoDAO.listarID();
	}
}
