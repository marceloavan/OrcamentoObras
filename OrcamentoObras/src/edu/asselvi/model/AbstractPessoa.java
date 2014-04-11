package edu.asselvi.model;

import edu.asselvi.model.enumerator.ETipoPessoa;

/**
 * Cont�m atributos e fornece m�todos especificos para qualquer {@link ETipoPessoa}
 * 
 * @author Marcelo Avancini
 *
 */
public abstract class AbstractPessoa {

	protected Long documento;
	protected ETipoPessoa tipoPessoa;
	
	public AbstractPessoa(Long documento, ETipoPessoa tipoPessoa) throws Exception {
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
	
	private void validaDocumento() throws Exception {
		if (tipoPessoa.getLengthDocumento() != documento.toString().length()) {
			// TODO criar exce��o especifica para essa situa��o -- alterar o throws :D
			throw new Exception("O tamanho do documento est� em desacordo");
		}
	}
}
