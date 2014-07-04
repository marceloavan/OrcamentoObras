package edu.asselvi.orcamentoobras.model.beans;

import java.math.BigDecimal;

/**
 * Responsável por gerenciar os custos do cub
 * 
 * @author Marcelo
 *
 */
public class CustoUnitarioBasico {
	
	private Integer id;
	private BigDecimal valorMetroQuadrado;
	private Integer mes;
	private Integer ano;
	
	public CustoUnitarioBasico(Integer id, BigDecimal valorMetroQuadrado, Integer mes, Integer ano) {
		setId(id);
		setValorMetroQuadrado(valorMetroQuadrado);
		setMes(mes);
		setAno(ano);
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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
		return String.format("Mês/ano: %d/%d - valor: %s", mes, ano, valorMetroQuadrado);
	}
}