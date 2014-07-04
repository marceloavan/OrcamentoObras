package edu.asselvi.orcamentoobras.model.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa o valor da previsão do orçamento
 * 
 * @author Leandro Rebelo
 * 
 */
public class PrevisaoOrcamento {

	private Integer id;
	private BigDecimal valor;
	private List<CustoReal> custoRealLista;
	private Previsao previsao;
	private Orcamento orcamento;

	public PrevisaoOrcamento(BigDecimal valor, Previsao previsao, Orcamento orcamento) {
		setValor(valor);
		this.previsao = previsao;
		this.orcamento = orcamento;
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

	public List<CustoReal> getCustoRealLista() {
		return custoRealLista;
	}

	public void setCustoRealLista(List<CustoReal> custoRealLista) {
		this.custoRealLista = custoRealLista;
	}
	
	public void addCustoReal(CustoReal custoReal) {
		if (this.custoRealLista == null) {
			this.custoRealLista = new ArrayList<CustoReal>();
		}
		this.custoRealLista.add(custoReal);
	}
	
	public void adicionaCustoReal(CustoReal custoReal) {
		custoRealLista.add(custoReal);
	}

	public Previsao getPrevisao() {
		return previsao;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	@Override
	public String toString() {
		return String.format("Valor da Previsão do Orçamento: %s ", getValor());
	}
}