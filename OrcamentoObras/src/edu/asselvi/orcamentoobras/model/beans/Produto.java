package edu.asselvi.orcamentoobras.model;

/**
 * Definição de um produto
 * 
 * @author Leandro Rebelo
 * 
 */
public class Produto {

	private Integer codigo;
	private String descricao;

	public Produto(Integer codigo, String descricao) {
		setCodigo(codigo);
		setDescricao(descricao);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return getCodigo() + " - " + getDescricao();
	}
}
