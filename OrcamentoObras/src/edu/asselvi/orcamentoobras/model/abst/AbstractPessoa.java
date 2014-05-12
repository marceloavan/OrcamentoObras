package edu.asselvi.orcamentoobras.model.abst;

import edu.asselvi.orcamentoobras.model.Endereco;
import edu.asselvi.orcamentoobras.model.enumerator.ETipoPessoa;
import edu.asselvi.orcamentoobras.model.exception.DocumentoForaDoPadraoException;

/**
 * Contém atributos e fornece métodos especificos para qualquer {@link ETipoPessoa}
 * 
 * @author Marcelo Avancini
 *
 */
public abstract class AbstractPessoa {

	private Integer id;
	private String documento;
	private ETipoPessoa tipoPessoa;
	private Endereco endereco;
	
	public AbstractPessoa(String documento, ETipoPessoa tipoPessoa, Endereco endereco) throws Exception {
		this.documento = documento;
		this.tipoPessoa = tipoPessoa;
		setEndereco(endereco);
		validaDocumento();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocumento() {
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

	/**
	 * Valida o documento informado de acordo com o {@link ETipoPessoa}, já que o mesmo
	 * possui o length do documento para cada tipo existente
	 * 
	 * @throws DocumentoForaDoPadraoException
	 */
	private void validaDocumento() throws DocumentoForaDoPadraoException {
		if (tipoPessoa.getLengthDocumento() != documento.toString().length()) {
			String message = String.format("O tamanho do documento está em desacordo. Tipo: %s. Tamanho esperado: %d.", tipoPessoa.getNomenclatura(), tipoPessoa.getLengthDocumento());
			throw new DocumentoForaDoPadraoException(message);
		}
	}
}