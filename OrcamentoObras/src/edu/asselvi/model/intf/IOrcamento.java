package edu.asselvi.model.intf;

import java.math.BigDecimal;

/**
 * Define m�todos b�sicos para qualquer or�amento
 * 
 * @author Marcelo
 *
 */
public interface IOrcamento {

	/**
	 * Gera o valor do or�amento considerando padr�es do CUB - Centro Unitario Basico  
	 * 
	 * @return Valor de venda segundo o cub
	 */
	public BigDecimal getValorVendaCub();
	
	/**
	 * Gera o valor de acordo com previs�es do usu�rio
	 * 
	 * @return Valor de venda segundo previs�es
	 */
	public BigDecimal getValorVendaPrevisoes();
	
}
