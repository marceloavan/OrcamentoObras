package edu.asselvi.model;

import edu.asselvi.model.enumerator.ETipoPessoa;

/**
 * Possui funções especificas para Pessoa Fisica
 * 
 * @author Marcelo
 *
 */
public final class PessoaFisica extends AbstractPessoa {

	public PessoaFisica(Long documento, ETipoPessoa tipoPessoa) throws Exception {
		super(documento, ETipoPessoa.FISICA);
	}
}