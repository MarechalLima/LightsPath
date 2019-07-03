package rw.nicholas.personagens;

public class Plebeu extends Neutro implements Afinidade{
	public String afinidade;
	
	public Plebeu(String nome, int dado, String afinidade) {
		super(nome, dado);
		this.afinidade = afinidade;
	}

	public String getAfinidade() {
		return afinidade;
	}

	public void setAfinidade(String afinidade) {
		this.afinidade = afinidade;
	}
	
	public boolean matchAfinidade(Paladino paladino) {
		return (this.afinidade.equalsIgnoreCase(paladino.AFINIDADE)) ? true : false;
	}
	
	

}
