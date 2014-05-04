package edu.asselvi.orcamentoobras.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.dao.conector.ConectorBancoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;

/**
 * Possui definições abstratas que todas as todas deverão extender
 * Além disso, contém métodos auxiliares que poderão facilitar em
 * algumas tarefas que utilizem SQL
 * 
 * @author Marcelo Avancini
 *
 * @param <T> Objeto que será persistido de acordo com a DAO que está
 * extendendo
 */
public abstract class AbstractDao {

	private ConectorBancoFactory cbf;
	private DaoFactory daoFactory;
	
	public AbstractDao() {
		cbf = new ConectorBancoFactory();
		daoFactory = DaoFactory.getInstance();
	}
	
	/**
	 * Retorna uma nova conexão com o banco de dados
	 * 
	 * @return {@link Connection}
	 */
	public Connection getConexao() {
		return cbf.getConexao();
	}
	
	/**
	 * Retorna a instacia da DaoFactory utilizada
	 * 
	 * @return {@link DaoFactory}
	 */
	public DaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void finalizarConexaoes(PreparedStatement stmt, ResultSet rs) throws SQLException {
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
		getConexao().close();
	}
}