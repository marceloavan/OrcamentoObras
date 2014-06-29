package edu.asselvi.orcamentoobras.controller.exception;

public class PasswdInvalidException extends Exception {

	/**
	 * Exce��o lan�ada ao ocorreu algum erro relacionado a senha inv�lida
	 * 
	 * @author Marcelo Avancini
	 */
	private static final long serialVersionUID = 1L;
	
	public PasswdInvalidException(String mensagem) {
		super(mensagem);
	}
}

