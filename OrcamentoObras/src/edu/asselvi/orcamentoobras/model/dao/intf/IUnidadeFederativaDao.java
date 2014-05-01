package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.UnidadeFederativa;

/**
 * Comportamento padr�o de DAOs para trabalhar com {@link UnidadeFederativa}
 * 
 * @author Marcelo Avancini
 *
 */
public interface IUnidadeFederativaDao {

	/**
	 * Retorna {@link UnidadeFederativa} pelo c�digo que a representa
	 * 
	 * @param codigoUf
	 * @return
	 * @throws SQLException
	 */
	public UnidadeFederativa getPeloCodigo(Integer codigoUf) throws SQLException;
	
}
