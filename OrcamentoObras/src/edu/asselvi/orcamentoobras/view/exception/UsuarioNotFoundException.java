package edu.asselvi.orcamentoobras.view.exception;

public class UsuarioNotFoundException extends Exception {

	/**
	 * Exceção lançada ao tentar ser consultado algum usuário que não
	 * exista
	 * 
	 * @author Marcelo Avancini
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNotFoundException(String mensagem) {
		super(mensagem);
	}
}
