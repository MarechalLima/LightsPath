package rw.nicholas.model;

import rw.nicholas.model.exceptions.EntradaProibidaException;
import rw.nicholas.model.exceptions.EscolhaInvalidaException;
import rw.nicholas.model.exceptions.TratamentoDeInput;

public abstract class Fase extends TratamentoDeInput{	
	public abstract void start();
	
	public int entrada(int n1, int nf) throws EntradaProibidaException, EscolhaInvalidaException{
		int escolha = -1;
		if(input.hasNextLine() && !input.hasNextInt()) {
			limparScanner();
		}
		
		if(input.hasNextInt()) {
			escolha = input.nextInt();
			
			if (escolha < n1 || escolha > nf) {
				throw new EscolhaInvalidaException();
			}
		} else {
			throw new EntradaProibidaException();
		}
		
		return escolha;
	}
}
