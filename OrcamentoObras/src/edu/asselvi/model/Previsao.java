package edu.asselvi.model;

import java.math.BigDecimal;

/**
 * Representa o valor da previsão do orçamento
 * 
 * @author Leandro Rebelo
 * 
 */
public class Previsao {

	private Integer id;
	private String descricao;
	private BigDecimal valor;

	public Previsao(Integer id, String descricao, BigDecimal valor) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
