package rw.nicholas.model.personagens;

public class Inimigo extends Personagem{
	
	public Inimigo(String nome, int dado) {
		super(nome, dado);
	}
	
	public void aumentarVida() {
		setVida(randDado(getDado(), 1)); //Os inimigos irão evoluir de forma parecida com o Paladino
	}
	
}
