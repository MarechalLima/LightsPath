package rw.nicholas.model.exceptions;

public class EscolhaInvalidaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4183623558430272449L;

	public EscolhaInvalidaException() {
		super("Opção Inexistente!\n");
	}
}
