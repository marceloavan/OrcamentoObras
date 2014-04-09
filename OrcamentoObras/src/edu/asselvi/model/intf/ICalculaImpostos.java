package edu.asselvi.model.intf;

import java.math.BigDecimal;

/**
 * Interface responsável por definir os métodos de calculo de imposto sobre terreno
 * 
 * @author Marcelo
 *
 */
public interface ICalculaImpostos {
	
	/**
	 * Retorna o valor dos impostos aplicados sobre o objeto
	 * 
	 * @return BigDecimal valorImpostos
	 */
	public BigDecimal getValorImpostos();
	
	/**
	 * Valor total incluindo os impostos calculados
	 * 
	 * @return BigDecimal valorTotalComImpostos
	 */
	public BigDecimal getValorTotalComImpostos();
	
	/**
	 * Valor de venda sem impostos
	 * 
	 * @return BigDecimal valorVenda
	 */
	public BigDecimal getValorVenda();
	
}
