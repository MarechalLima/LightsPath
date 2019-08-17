package rw.nicholas.model;

import rw.nicholas.model.personagens.Inimigo;
import rw.nicholas.model.personagens.Personagem;

public class ConcurrentHashMapInimigosDAO {
	
	public void inserirInimigo (String id, Inimigo inimigo) {
		ConcurrentHashMapInimigosSingleton.getInstance().inimigos.put(id, inimigo);
	}
	
	public void removerInimigo (String id) {
		ConcurrentHashMapInimigosSingleton.getInstance().inimigos.remove(id);
	}
	
	public void removerInimigo (Personagem personagem) {
		ConcurrentHashMapInimigosSingleton.getInstance().inimigos.values().remove(personagem);
	}
	
	public String[] listarID() {
		String[] output = new String[ConcurrentHashMapInimigosSingleton.getInstance().inimigos.size()];
		int i = 0;
		for (String id : ConcurrentHashMapInimigosSingleton.getInstance().inimigos.keySet()) {
			output[i++] = id;
		}
		return output;
	}
	
	public Inimigo getInimigo(String id) {
		return ConcurrentHashMapInimigosSingleton.getInstance().inimigos.get(id);
	}
	
	public boolean isEmpty() {
		return ConcurrentHashMapInimigosSingleton.getInstance().inimigos.isEmpty();
	}
}
