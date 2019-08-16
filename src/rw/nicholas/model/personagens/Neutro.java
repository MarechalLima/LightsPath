package rw.nicholas.model.personagens;

public abstract class Neutro extends Personagem{
	
	public Neutro(String nome, int dado) {
		super(nome, dado);

	}
	
	public Neutro(String nome, int dado, int ouro) {
		super(nome, dado, ouro);
	}
	
	@Override
	public void aumentarVida() {
		setVida((int)(randDado(getDado(), 1)/2));
	}
}
