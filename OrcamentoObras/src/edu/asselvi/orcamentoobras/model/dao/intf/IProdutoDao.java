package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.beans.Produto;

/**
 * Comportamento padrão para toda DAO de {@link Produto}
 * 
 * @author Leandro Rebelo
 * 
 */

public interface IProdutoDao extends IDao<Produto> {

	/**
	 * Retorna {@link Produto} considerando o identificador do mesmo
	 * 
	 * @param id
	 * @return {@link Produto}
	 * @throws SQLExpection
	 */
	public Produto getPeloCodigo(Integer codigo) throws SQLException;

}
