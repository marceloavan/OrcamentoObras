package edu.asselvi.orcamentoobras.view.exception;

public class UsuarioNotFoundException extends Exception {

	/**
	 * Exce��o lan�ada ao tentar ser consultado algum usu�rio que n�o
	 * exista
	 * 
	 * @author Marcelo Avancini
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNotFoundException(String mensagem) {
		super(mensagem);
	}
}
