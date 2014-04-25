package edu.asselvi.model;

import java.math.BigDecimal;

/**
 * Representa o custo real do Orçamento
 * 
 * @author Leandro Rebelo
 * 
 */
public class CustoReal {

	private Integer id;
	private BigDecimal valor;
	private Produto produto;

	public CustoReal(Integer id, BigDecimal valor, Produto produto) {
		this.id = id;
		this.valor = valor;
		this.produto = produto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return String.format("Custo Real do Orçamento - valor: %s", valor);
	}
}
