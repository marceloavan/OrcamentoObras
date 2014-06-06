package edu.asselvi.orcamentoobras.model.dao.intf;

import edu.asselvi.orcamentoobras.model.Previsao;

/**
 * Comportamento padr�o de DAOs para trabalhar com {@link Previsao}
 * 
 * @author Marcelo
 *
 */
public interface IPrevisaoDao extends IDao<Previsao>{

	public Previsao getPeloCodigo();
	
}
