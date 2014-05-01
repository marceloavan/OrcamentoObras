package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.UnidadeFederativa;

/**
 * Comportamento padrão de DAOs para trabalhar com {@link UnidadeFederativa}
 * 
 * @author Marcelo Avancini
 *
 */
public interface IUnidadeFederativaDao {

	public void inserir(UnidadeFederativa uf) throws SQLException;
	
	public void atualizar(UnidadeFederativa uf) throws SQLException;
	
	public void remover(UnidadeFederativa uf) throws SQLException;
	
	/**
	 * Retorna {@link UnidadeFederativa} pelo código que a representa
	 * 
	 * @param codigoUf
	 * @return
	 * @throws SQLException
	 */
	public UnidadeFederativa getPeloCodigo(Integer codigoUf) throws SQLException;
	
}
