package rw.nicholas;
import rw.nicholas.personagens.Medico;
import rw.nicholas.personagens.Paladino;

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
