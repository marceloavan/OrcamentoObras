package edu.asselvi.orcamentoobras.model.beans;

/**
 * Representa o endereço de qualquer objeto seja relevante
 * ser localizado
 * 
 * @author Marcelo Avancini
 *
 */
public class Endereco {
	
	private Integer id;
	private String logradouro;
	private Integer numero;
	private String bairro;
	private Municipio municipio;
	private Long cep;
	
	public Endereco(String logradouro, Integer numero, String bairro, Municipio municipio, Long cep) {
		setLogradouro(logradouro);
		setNumero(numero);
		setBairro(bairro);
		setMunicipio(municipio);
		setCep(cep);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public Municipio getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep2) {
		this.cep = cep2;
	}

	@Override
	public String toString() {
		return getLogradouro() + ", " + getNumero() + " - " + getBairro() + " - "
				+ getMunicipio().getDescricao() + "/" + getMunicipio().getUf().getSigla() + " - "
				+ getCep();
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}