package edu.asselvi.model;

import edu.asselvi.model.enumerator.ETipoPessoa;

/**
 * Contém atributos e fornece métodos especificos para qualquer {@link ETipoPessoa}
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
			// TODO criar exceção especifica para essa situação -- alterar o throws :D
			throw new Exception("O tamanho do documento está em desacordo");
		}
	}
}
