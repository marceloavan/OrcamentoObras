package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.Terreno;

/**
 * Comportamento padrão para toda DAO de {@link Terreno}
 * 
 * @author Leandro Rebelo
 *
 */
public interface ITerrenoDao extends IDao<Terreno>{
	
	/**
	 * Retorna {@link Terreno} pelo identificador do mesmo
	 * 
	 * @param id
	 * @return {@link Terreno}
	 * @throws SQLExpeption
	 */
	
	public Terreno getPeloCodigo(Integer codigo) throws SQLException;

}
