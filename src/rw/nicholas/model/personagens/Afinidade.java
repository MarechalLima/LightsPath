package rw.nicholas.model.personagens;

public interface Afinidade {
	public String getAfinidade();

	public void setAfinidade(String afinidade);
	
	public boolean matchAfinidade(Paladino paladino);
	//TODO futuramente um aplicar teste de persuasão para talvez converter a afinidade do personagem
}
