package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.Orcamento;
import edu.asselvi.orcamentoobras.model.PrevisaoOrcamento;

/**
 * Comportamento padrão de DAOs para trabalhar com {@link PrevisaoOrcamento}
 * 
 * @author Marcelo Avancini
 *
 */
public interface IPrevisaoOrcamentoDao extends IDao<PrevisaoOrcamento> {
 
	/**
	 * Retorna a {@link PrevisaoOrcamento} pelo Id da Mesma
	 * 
	 * @param id
	 * @return {@link PrevisaoOrcamento}
	 */
	public PrevisaoOrcamento getPeloCodigo(Integer codigo) throws SQLException;
	
	/**
	 * Retorna todas as {@link PrevisaoOrcamento}'s de algum orcamento
	 * 
	 * @param orcamento
	 * @return
	 * @throws SQLException
	 */
	public PrevisaoOrcamento getPeloOrcamento(Orcamento orcamento) throws SQLException;
	
}
