package edu.asselvi.orcamentoobras.model;

/**
 * Representa cada <b>Municipio</b> brasileiro
 * considerando regras do IBGE
 * 
 * @author Marcelo Avancini
 *
 */
public class Municipio {
	
	private Long codigo;
	private String descricao;
	private UnidadeFederativa uf;
	
	
	public Municipio(Long codigo, String descricao, UnidadeFederativa uf) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.uf = uf;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public UnidadeFederativa getUf() {
		return uf;
	}

	public void setUf(UnidadeFederativa uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return getDescricao() + " / " + getUf().toString();
	}
}
