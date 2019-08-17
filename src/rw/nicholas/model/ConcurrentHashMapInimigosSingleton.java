package rw.nicholas.model;

import java.util.concurrent.ConcurrentHashMap;

import rw.nicholas.model.personagens.Inimigo;

public class ConcurrentHashMapInimigosSingleton {
	public ConcurrentHashMap<String, Inimigo> inimigos = new ConcurrentHashMap<String, Inimigo>();
	private static ConcurrentHashMapInimigosSingleton INSTANCE = new ConcurrentHashMapInimigosSingleton();
	
	private ConcurrentHashMapInimigosSingleton() {}
	
	public static ConcurrentHashMapInimigosSingleton getInstance() {
		return INSTANCE;
	}
}
