package edu.asselvi.orcamentoobras.model.beans;

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
		return getDescricao();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Municipio other = (Municipio) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
