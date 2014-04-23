package edu.asselvi.orcamentoobras.model;

import java.math.BigDecimal;

/**
 * Representa o custo real do Or�amento
 * 
 * @author Leandro Rebelo
 * 
 */
public class CustoReal {

	private Integer id;
	private BigDecimal valor;

	public CustoReal(Integer id, BigDecimal valor) {
		this.id = id;
		this.valor = valor;
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

	@Override
	public String toString() {
		return String.format("Custo Real do Or�amento - valor: %s", valor);
	}
}
