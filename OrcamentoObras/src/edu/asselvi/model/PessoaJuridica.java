package edu.asselvi.model;

import edu.asselvi.model.enumerator.ETipoPessoa;

/**
 * Possui fun��es especificas para Pessoa Juridica
 * 
 * @author Marcelo
 *
 */
public final class PessoaJuridica extends AbstractPessoa {

	public PessoaJuridica(Long documento) throws Exception {
		super(documento, ETipoPessoa.JURIDICA);
	}
}