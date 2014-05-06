package edu.asselvi.orcamentoobras.model;

import java.math.BigDecimal;
import java.util.List;

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
	private List<CustoReal> custoRealLista;

	public Previsao(String descricao, BigDecimal valor, List<CustoReal> custoRealLista) {
		setDescricao(descricao);
		setValor(valor);
		setCustoRealLista(custoRealLista);
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

	public List<CustoReal> getCustoRealLista() {
		return custoRealLista;
	}

	public void setCustoRealLista(List<CustoReal> custoRealLista) {
		this.custoRealLista = custoRealLista;
	}
	
	public void adicionaCustoReal(CustoReal custoReal) {
		custoRealLista.add(custoReal);
	}

	@Override
	public String toString() {
		return String.format("Valor da Previsão do Orçamento: %s ", getValor());
	}
}
