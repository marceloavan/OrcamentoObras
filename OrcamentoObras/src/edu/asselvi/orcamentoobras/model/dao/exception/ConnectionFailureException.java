package edu.asselvi.orcamentoobras.model.dao.exception;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.dao.conector.ConectorBancoFactory;

/**
 * Representa uma conexão falha com algum sistema de gerenciamento de dados
 * 
 * 
 * @author Marcelo Avancini
 * @see ConectorBancoFactory
 * @see RuntimeException
 *
 */
public class ConnectionFailureException extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConnectionFailureException(String message) {
		super(message);
	}
}