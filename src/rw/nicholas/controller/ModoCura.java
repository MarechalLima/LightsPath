package rw.nicholas.controller;
import rw.nicholas.model.personagens.Medico;
import rw.nicholas.model.personagens.Paladino;

public class ModoCura {
	private Paladino paladino;
	private Medico medico;
	
	public ModoCura(Paladino paladino, Medico medico) {
		this.paladino = paladino;
		this.medico = medico;
	}
	
	public boolean curar() {
		return medico.Curar(paladino);
	}
	
	public boolean aumentarVida() {
		return medico.aumentarVidaDe(paladino);
	}
	
}
