package rw.nicholas.model.exceptions;

import java.util.Scanner;

public class TratamentoDeInput {
	protected Scanner input = new Scanner(System.in);
	
	public void limparScanner() {
		if(input.hasNextLine()) {
			input.nextLine(); //Descartar o \n
		}
	}
	
	public void pausarDialogo() {
		limparScanner();
	}
}
