package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.Previsao;

/**
 * Comportamento padrão de DAOs para trabalhar com {@link Previsao}
 * 
 * @author Marcelo Avancini
 *
 */
public interface IPrevisaoDao extends IDao<Previsao> {
 
	/**
	 * Retorna a {@link Previsao} pelo Id da Mesma
	 * 
	 * @param id
	 * @return {@link Previsao}
	 */
	public Previsao getPeloCodigo(Integer codigo) throws SQLException;
	
}
