package edu.asselvi.orcamentoobras.model.intf;

import java.math.BigDecimal;

/**
 * Define comportamento padr�o para qualquer imposto presente
 * no sistema associado a qualquer outro obj
 * 
 * @author Marcelo Avancini
 *
 */
public interface IImposto {
	
	/**
	 * Sigla referente ao imposto
	 * 
	 * @return sigla
	 */
	public String getSigla();
	
	/**
	 * Retorna o valor percentual que o imposto representa
	 * 
	 * @return percentual
	 */
	public BigDecimal getPercentual();
	
	/**
	 * Retorna a descri��o do imposto, que seria o nome do mesmo 
	 * sem abrevia��es
	 * 
	 * @return descri��o
	 */
	public String getDescricao();
	
}