package edu.asselvi.orcamentoobras.model.dao.intf;

import edu.asselvi.orcamentoobras.model.Previsao;

/**
 * Comportamento padr�o de DAOs para trabalhar com {@link Previsao}
 * 
 * @author Marcelo Avancini
 *
 */
public interface IPrevisaoDao {
	
	/**
	 * Retorna a {@link Previsao} pelo Id da Mesma
	 * 
	 * @param id
	 * @return {@link Previsao}
	 */
	public Previsao getPeloId(Integer id);
	
}
