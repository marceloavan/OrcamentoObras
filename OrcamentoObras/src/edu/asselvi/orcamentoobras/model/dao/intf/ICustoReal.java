package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.CustoReal;

/**
 * Comportamento padrão para toda DAO de {@link CustoReal} 
 * 
 * @author Leandro Rebelo
 *
 */

public interface ICustoReal extends IDao<CustoReal>{
	/**
	 * 
	 * Retorna {@link CustoReal} considerando o identificador do mesmo
	 * @param id
	 * @return {@link CustoReal}
	 * @throws SQLException
	 * 
	 */
	
	public CustoReal getPeloCodigo (Integer codigo) throws SQLException;
		
}
