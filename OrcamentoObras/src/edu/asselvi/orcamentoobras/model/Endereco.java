package edu.asselvi.orcamentoobras.model;

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
	
	public Endereco(Integer id, String logradouro, Integer numero, String bairro, Municipio municipio, Long cep) {
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.municipio = municipio;
		this.cep = cep;
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

	public void setCep(Long cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return getLogradouro() + ", " + getNumero() + " - " + getBairro() + " - "
				+ getMunicipio().getDescricao() + "/" + getMunicipio().getUf().getSigla() + " - "
				+ getCep();
	}
}
