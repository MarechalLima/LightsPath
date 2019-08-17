package rw.nicholas.model;

import rw.nicholas.model.personagens.Inimigo;
import rw.nicholas.model.personagens.Personagem;

public class ConcurrentHashMapInimigosDAO {
	
	public void inserirInimigo (String id, Inimigo inimigo) {
		ConcurrentHashMapInimigosSingleton.getInstance().inimigos.put(id, inimigo); //Seria o INSERT
	}
	
	public void removerInimigo (String id) {
		ConcurrentHashMapInimigosSingleton.getInstance().inimigos.remove(id); //Seria o DELETE
	}
	
	public void removerInimigo (Personagem personagem) {
		ConcurrentHashMapInimigosSingleton.getInstance().inimigos.values().remove(personagem); //Seria o DELETE
	}
	
	public String[] listarID() {
		String[] output = new String[ConcurrentHashMapInimigosSingleton.getInstance().inimigos.size()];
		int i = 0;
		for (String id : ConcurrentHashMapInimigosSingleton.getInstance().inimigos.keySet()) {
			output[i++] = id;
		}
		return output; //SELECT id
	}
	
	public Inimigo getInimigo(String id) {
		return ConcurrentHashMapInimigosSingleton.getInstance().inimigos.get(id); //Seria um SELECT ... WHERE id = ?;
	}
	
	public boolean isEmpty() {
		return ConcurrentHashMapInimigosSingleton.getInstance().inimigos.isEmpty(); //Seria um SELECT COUNT(id) retornando 0
	}
}
