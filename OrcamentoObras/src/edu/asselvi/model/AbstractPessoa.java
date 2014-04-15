package edu.asselvi.model;

import edu.asselvi.model.enumerator.ETipoPessoa;
import edu.asselvi.model.exception.DocumentoForaDoPadraoException;

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
	
	private void validaDocumento() throws DocumentoForaDoPadraoException {
		if (tipoPessoa.getLengthDocumento() != documento.toString().length()) {
			String message = String.format("O tamanho do documento está em desacordo. Tipo: %s. Tamanho esperado: %d.", tipoPessoa.getNomenclatura(), tipoPessoa.getLengthDocumento());
			throw new DocumentoForaDoPadraoException(message);
		}
	}
}