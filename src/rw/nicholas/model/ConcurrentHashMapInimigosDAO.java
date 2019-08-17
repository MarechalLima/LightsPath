package rw.nicholas.model;

import rw.nicholas.model.personagens.Inimigo;

public class ConcurrentHashMapInimigosDAO {
	public void inserirInimigo (String id, Inimigo inimigo) {
		ConcurrentHashMapInimigos.inimigos.put(id, inimigo);
	}
	
	public void removerInimigo (String id) {
		ConcurrentHashMapInimigos.inimigos.remove(id);
	}
	
	public String[] listarID() {
		String[] output = new String[ConcurrentHashMapInimigos.inimigos.size()];
		int i = 0;
		for (String id : ConcurrentHashMapInimigos.inimigos.keySet()) {
			output[i++] = id;
		}
		return output;
	}
}
