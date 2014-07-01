package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.beans.Orcamento;

/**
 * Comportamento padrão de DAOs para trabalhar com {@link Orcamento}
 * 
 * @author Leandro Rebelo
 *
 */
public interface IOrcamentoDao extends IDao<Orcamento>{

	/**
	 * Retorna o {@link Orcamento} pela Id da mesma
	 * 
	 * @param codigo
	 * @return {@link Orcamento}
	 * @throws SQLException
	 */
	public Orcamento getPeloCodigo(Integer codigo) throws SQLException;
	
}
