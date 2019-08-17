package rw.nicholas.model;

import rw.nicholas.model.exceptions.EntradaProibidaException;
import rw.nicholas.model.exceptions.EscolhaInvalidaException;
import rw.nicholas.model.exceptions.TratamentoDeInput;

public abstract class Fase extends TratamentoDeInput{	
	public abstract void start();
	public abstract boolean equals(Object obj);
	
	public int entrada(int n1, int nf) throws EntradaProibidaException, EscolhaInvalidaException{
		int escolha = -1;
		
		if(input.hasNextInt()) {
			escolha = input.nextInt();
			limparScanner();
			if (escolha < n1 || escolha > nf) {
				throw new EscolhaInvalidaException();
			}
		} else {
			limparScanner();
			throw new EntradaProibidaException();
		}
		
		return escolha;
	}
}
