package edu.asselvi.orcamentoobras.controller.exception;

public class PasswdInvalidException extends Exception {

	/**
	 * Exceção lançada ao ocorreu algum erro relacionado a senha inválida
	 * 
	 * @author Marcelo Avancini
	 */
	private static final long serialVersionUID = 1L;
	
	public PasswdInvalidException(String mensagem) {
		super(mensagem);
	}
}

