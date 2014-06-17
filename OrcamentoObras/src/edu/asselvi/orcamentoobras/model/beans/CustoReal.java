package edu.asselvi.orcamentoobras.model.beans;

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
	private PrevisaoOrcamento previsao;
	private Orcamento orcamento;

	public CustoReal(BigDecimal valor, Produto produto, PrevisaoOrcamento previsao) {
		setValor(valor);
		setProduto(produto);
		setPrevisao(previsao);
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

	public PrevisaoOrcamento getPrevisao() {
		return previsao;
	}

	public void setPrevisao(PrevisaoOrcamento previsao) {
		this.previsao = previsao;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	@Override
	public String toString() {
		return String.format("Custo Real do Orçamento - valor: %s", valor);
	}
}
