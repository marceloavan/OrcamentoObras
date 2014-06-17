package edu.asselvi.orcamentoobras.model;

/**
 * Representa cada <b>Municipio</b> brasileiro
 * considerando regras do IBGE
 * 
 * @author Marcelo Avancini
 *
 */
public class Municipio {
	
	private Integer codigo;
	private String descricao;
	private UnidadeFederativa uf;
	
	
	public Municipio(Integer codigo, String descricao, UnidadeFederativa uf) {
		setCodigo(codigo);
		setDescricao(descricao);
		setUf(uf);
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
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
