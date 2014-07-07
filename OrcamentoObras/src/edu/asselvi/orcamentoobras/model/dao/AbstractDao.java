package edu.asselvi.orcamentoobras.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.dao.conector.ConectorBancoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;

/**
 * Possui defini��es abstratas que todas as todas dever�o extender
 * Al�m disso, cont�m m�todos auxiliares que poder�o facilitar em
 * algumas tarefas que utilizem SQL
 * 
 * @author Marcelo Avancini
 *
 * @param <T> Objeto que ser� persistido de acordo com a DAO que est�
 * extendendo
 */
public abstract class AbstractDao {

	private ConectorBancoFactory cbf;
	private DaoFactory daoFactory;
	private Connection conn;
	
	public AbstractDao() {
		cbf = ConectorBancoFactory.getInstance();
		daoFactory = DaoFactory.getInstance();
	}
	
	/**
	 * Retorna uma nova conex�o com o banco de dados
	 * 
	 * @return {@link Connection}
	 */
	public Connection getConexao() throws SQLException {
		conn = cbf.getConexao();
		return conn;
	}
	
	/**
	 * Retorna a instacia da DaoFactory utilizada
	 * 
	 * @return {@link DaoFactory}
	 */
	public DaoFactory getDaoFactory() {
		return daoFactory;
	}

	/**
	 * Finaliza as conex�es abertas com o DB, caso n�o exista
	 * algum dos parametros, envie <b>null</b>
	 * 
	 * @param stmt
	 * @param rs
	 * @throws SQLException
	 */
	public void finalizarConexoes(PreparedStatement stmt, ResultSet rs) throws SQLException {
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
		if (conn != null) conn.close();
	}
}