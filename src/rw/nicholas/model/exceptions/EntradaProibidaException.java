package rw.nicholas.model.exceptions;

public class EntradaProibidaException extends Exception{

	/**
	 * Eclipse tava pedindo...
	 */
	private static final long serialVersionUID = -1111312439598196007L;

	public EntradaProibidaException() {
		super("A entrada fornecida está errada!\n");
	}
}
