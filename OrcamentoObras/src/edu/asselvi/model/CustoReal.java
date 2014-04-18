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
}
