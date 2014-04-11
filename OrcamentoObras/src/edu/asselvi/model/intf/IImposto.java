package edu.asselvi.model.intf;

import java.math.BigDecimal;

/**
 * Define comportamento padr�o para qualquer imposto presente
 * no sistema associado a qualquer outro obj
 * 
 * @author Marcelo
 *
 */

public interface IImposto {

	public String getSigla();
	
	public BigDecimal getPercentual();
	
	public String getDescricao();
	
}
