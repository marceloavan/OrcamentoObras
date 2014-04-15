package edu.asselvi.model.intf;

import java.math.BigDecimal;

/**
 * Define métodos básicos para qualquer orçamento
 * 
 * @author Marcelo
 *
 */
public interface IOrcamento {

	/**
	 * Gera o valor do orçamento considerando padrões do CUB - Centro Unitario Basico  
	 * 
	 * @return Valor de venda segundo o cub
	 */
	public BigDecimal getValorVendaCub();
	
	/**
	 * Gera o valor de acordo com previsões do usuário
	 * 
	 * @return Valor de venda segundo previsões
	 */
	public BigDecimal getValorVendaPrevisoes();
	
}
