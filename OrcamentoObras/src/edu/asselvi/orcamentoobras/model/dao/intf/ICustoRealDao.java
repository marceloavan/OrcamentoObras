package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.CustoReal;
import edu.asselvi.orcamentoobras.model.beans.PrevisaoOrcamento;

/**
 * Comportamento padrão para toda DAO de {@link CustoReal} 
 * 
 * @author Leandro Rebelo
 *
 */

public interface ICustoRealDao extends IDao<CustoReal>{
	/**
	 * 
	 * Retorna {@link CustoReal} considerando o identificador do mesmo
	 * @param id
	 * @return {@link CustoReal}
	 * @throws SQLException
	 * 
	 */
	
	public CustoReal getPeloCodigo (Integer codigo) throws SQLException;
	
	public List<CustoReal> getPelaPrevisao (PrevisaoOrcamento previsao) throws SQLException;
		
}
