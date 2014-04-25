package edu.asselvi.orcamentoobras.model.abst;

import edu.asselvi.orcamentoobras.model.Endereco;
import edu.asselvi.orcamentoobras.model.enumerator.ETipoPessoa;
import edu.asselvi.orcamentoobras.model.exception.DocumentoForaDoPadraoException;

/**
 * Cont�m atributos e fornece m�todos especificos para qualquer {@link ETipoPessoa}
 * 
 * @author Marcelo Avancini
 *
 */
public abstract class AbstractPessoa {

	private Long documento;
	private ETipoPessoa tipoPessoa;
	private Endereco endereco;
	
	public AbstractPessoa(Long documento, ETipoPessoa tipoPessoa, Endereco endereco) throws Exception {
		this.tipoPessoa = tipoPessoa;
		this.documento = documento;
		this.endereco = endereco;
		validaDocumento();
	}

	public Long getDocumento() {
		return documento;
	}

	public ETipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	private void validaDocumento() throws DocumentoForaDoPadraoException {
		if (tipoPessoa.getLengthDocumento() != documento.toString().length()) {
			String message = String.format("O tamanho do documento est� em desacordo. Tipo: %s. Tamanho esperado: %d.", tipoPessoa.getNomenclatura(), tipoPessoa.getLengthDocumento());
			throw new DocumentoForaDoPadraoException(message);
		}
	}
}