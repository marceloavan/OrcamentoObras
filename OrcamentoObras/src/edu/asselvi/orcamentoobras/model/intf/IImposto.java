package edu.asselvi.orcamentoobras.model.intf;

import java.math.BigDecimal;

/**
 * Define comportamento padrão para qualquer imposto presente
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
	 * Retorna a descrição do imposto, que seria o nome do mesmo 
	 * sem abreviações
	 * 
	 * @return descrição
	 */
	public String getDescricao();
	
}