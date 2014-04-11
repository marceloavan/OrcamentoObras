package edu.asselvi.model;

/**
 * Representa cada <b>Unidade Federativa</b> brasileira
 * considerando regras do IBGE
 * 
 * @author Marcelo
 *
 */
public class UnidadeFederativa {
	
	private String sigla;
	private String descricao;
	private Integer codigo;
	
	public UnidadeFederativa(String sigla, String descricao, Integer codigo) {
		this.sigla = sigla;
		this.descricao = descricao;
		this.codigo = codigo;
	}

	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
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
	
	@Override
	public String toString() {
		return getDescricao();
	}
}
