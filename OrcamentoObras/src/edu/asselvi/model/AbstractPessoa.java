package edu.asselvi.model;

import edu.asselvi.model.enumerator.ETipoPessoa;

public abstract class AbstractPessoa {

	protected Long documento;
	protected ETipoPessoa tipoPessoa;
	
	public AbstractPessoa(Long documento, ETipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
		this.documento = documento;
		validaDocumento();
	}

	public Long getDocumento() {
		return documento;
	}

	public ETipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	
	private void validaDocumento() {
		
	}
}
