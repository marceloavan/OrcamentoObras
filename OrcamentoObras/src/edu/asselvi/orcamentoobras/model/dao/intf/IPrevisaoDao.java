package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.beans.Previsao;

/**
 * Comportamento padr�o de DAOs para trabalhar com {@link Previsao}
 * 
 * @author Marcelo
 *
 */
public interface IPrevisaoDao extends IDao<Previsao>{

	public Previsao getPeloCodigo(Integer codigo) throws SQLException;
	
}
