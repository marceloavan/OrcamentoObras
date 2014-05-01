package edu.asselvi.orcamentoobras.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
public abstract class AbstractDao<T> {

	private ConectorBancoFactory cbf;
	private DaoFactory daoFactory;
	
	public AbstractDao() {
		cbf = new ConectorBancoFactory();
		daoFactory = DaoFactory.getInstance();
	}
	
	/**
	 * Retorna uma nova conex�o com o banco de dados
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
	
	/**
	 * Respons�vel por inserir um novo registro na base de dados para
	 * a entidade em quest�o
	 * 
	 * @param {@link T} param - entidade a ser persistida
	 * @throws SQLException
	 */
	public abstract void inserir(T param) throws SQLException;
	
	/**
	 * Repons�nvel por atualizar informa��es de uma entidade j� persistida
	 * na base dados. Para tanto, ser� considerado o identificador da entidade
	 * na verifica��o
	 * 
	 * @param {@link T} param - entidade que ser� atualizada
	 * @throws SQLException
	 */
	public abstract void atualizar(T param) throws SQLException;
	
	/**
	 * Repons�vel por remover e entidade da base de dados
	 * 
	 * @param {@link T} param - entidade que ser� removida da base de dados
	 * @throws SQLException
	 */
	public abstract void remover(T param) throws SQLException;
	
	/**
	 * Ir� retornar todos os registros da entidade associada,
	 * especialmente para fins de listagem e etc.
	 * 
	 * Caso a entidade nao possua essa caracteristica por algum motivo,
	 * a mesma dever� retornar <b>null<b>. Nesse casos o m�todo implementado
	 * estar� deprecado
	 * 
	 * @return {@link T} List com todos os registros
	 * @throws SQLException
	 */
	public abstract List<T> getTodos() throws SQLException;
	
	/**
	 * Finaliza a conex�o corrente e demais 
	 * recursos utilizados com essa caracteristica
	 * 
	 * @param stmt
	 * @param rs
	 * @throws SQLException
	 */
	public void finalizarConexaoes(PreparedStatement stmt, ResultSet rs) throws SQLException {
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
		getConexao().close();
	}
}