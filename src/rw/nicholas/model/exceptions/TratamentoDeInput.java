package rw.nicholas.model.exceptions;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TratamentoDeInput {
	protected Scanner input = new Scanner(System.in);
	
	public void limparScanner() {
		if(input.hasNextLine()) {
			input.nextLine(); //Descartar o \n
		}
	}
	
	public void pausarDialogo(int seg) {
		try {
			TimeUnit.SECONDS.sleep(seg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
