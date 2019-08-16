package rw.nicholas.model.personagens;

public class Medico extends Neutro{
	
	private int precoCobrar;

	public Medico(String nome, int dado) {
		super(nome, dado);
		this.precoCobrar = 10;
	}
	
	public boolean Curar(Paladino paladino) {
		if (paladino.getOuro() >= precoCobrar && paladino.getVida() < paladino.getMaxVida()) {
			paladino.curar();
			paladino.removerOuro(precoCobrar);
			return true;
		}
		return false;
	}
	
	public boolean aumentarVidaDe(Paladino paladino) {
		if (paladino.getOuro() >= precoCobrar*2) {
			Curar(paladino);
			paladino.setVida(randDado(paladino.getDado(), 1));
			paladino.setMaxVida(paladino.getVida());
			paladino.removerOuro(precoCobrar*2);
			return true;
		}
		return false;
	}
	
}
