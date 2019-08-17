package rw.nicholas.model;

import java.util.concurrent.ConcurrentHashMap;

import rw.nicholas.model.personagens.Inimigo;

public class ConcurrentHashMapInimigos {
	public static ConcurrentHashMap<String, Inimigo> inimigos = new ConcurrentHashMap<String, Inimigo>();
}
