package edu.asselvi.orcamentoobras.model;

import java.math.BigDecimal;

/**
 * Responsável por gerenciar os custos do cub
 * 
 * @author Marcelo
 *
 */
public class CustoUnitarioBasico {
	
	private BigDecimal valorMetroQuadrado;
	private Integer mes;
	private Integer ano;
	
	public CustoUnitarioBasico(BigDecimal valorMetroQuadrado, Integer mes, Integer ano) {
		this.valorMetroQuadrado = valorMetroQuadrado;
		this.mes = mes;
		this.ano = ano;
	}

	public BigDecimal getValorMetroQuadrado() {
		return valorMetroQuadrado;
	}
	
	public void setValorMetroQuadrado(BigDecimal valorMetroQuadrado) {
		this.valorMetroQuadrado = valorMetroQuadrado;
	}
	
	public Integer getMes() {
		return mes;
	}
	
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	@Override
	public String toString() {
		return String.format("Valor do CUB - mês/ano $d/$d - valor: %s", mes, ano, valorMetroQuadrado);
	}
}