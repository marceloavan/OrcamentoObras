package edu.asselvi.orcamentoobras.model.abst;

import edu.asselvi.orcamentoobras.model.beans.Endereco;
import edu.asselvi.orcamentoobras.model.beans.PessoaFisica;
import edu.asselvi.orcamentoobras.model.beans.PessoaJuridica;
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
	 * Retorna uma string que representa o nome da pessoa em questão
	 * 
	 * @return
	 */
	public String getNomeAbs() {
		if (this instanceof PessoaFisica) {
			return ((PessoaFisica) this).getNome();
		} else if (this instanceof PessoaJuridica) {
			return ((PessoaJuridica) this).getRazaoSocial();
		}
		return "";
	}
	
	/**
	 * Retorna uma string que representa o nome da pessoa em questão
	 * 
	 * @return
	 */
	public String getSecondNomeAbs() {
		if (this instanceof PessoaFisica) {
			return ((PessoaFisica) this).getSobreNome();
		} else if (this instanceof PessoaJuridica) {
			return ((PessoaJuridica) this).getNomeFantasia();
		}
		return "";
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
	
	public boolean isPessoaFisica() {
		return getTipoPessoa().equals(ETipoPessoa.FISICA);
	}
	
	public boolean isPessoaJuridica() {
		return getTipoPessoa().equals(ETipoPessoa.JURIDICA);
	}
	
	@Override
	public String toString() {
		return getNomeAbs() + getDocumento();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractPessoa other = (AbstractPessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}