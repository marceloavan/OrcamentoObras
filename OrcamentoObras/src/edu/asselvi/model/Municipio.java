package edu.asselvi.model;

/**
 * Representa cada <b>Municipio</b> brasileiro
 * considerando regras do IBGE
 * 
 * @author Marcelo
 *
 */

public class Municipio {
	
	private String descricao;
	private Long codigo;
	private UnidadeFederativa uf;
	
	
	public Municipio(String descricao, Long codigo, UnidadeFederativa uf) {
		this.descricao = descricao;
		this.codigo = codigo;
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
