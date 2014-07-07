package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Orcamento;
import edu.asselvi.orcamentoobras.model.beans.PrevisaoOrcamento;

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
	public List<PrevisaoOrcamento> getPeloOrcamento(Orcamento orcamento) throws SQLException;
	
}
