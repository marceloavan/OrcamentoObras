package edu.asselvi.orcamentoobras.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
public abstract class AbstractDao<T> {

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
	
	/**
	 * Responsável por inserir um novo registro na base de dados para
	 * a entidade em questão
	 * 
	 * @param {@link T} param - entidade a ser persistida
	 * @throws SQLException
	 */
	public abstract void inserir(T param) throws SQLException;
	
	/**
	 * Reponsánvel por atualizar informações de uma entidade já persistida
	 * na base dados. Para tanto, será considerado o identificador da entidade
	 * na verificação
	 * 
	 * @param {@link T} param - entidade que será atualizada
	 * @throws SQLException
	 */
	public abstract void atualizar(T param) throws SQLException;
	
	/**
	 * Reponsável por remover e entidade da base de dados
	 * 
	 * @param {@link T} param - entidade que será removida da base de dados
	 * @throws SQLException
	 */
	public abstract void remover(T param) throws SQLException;
	
	/**
	 * Irá retornar todos os registros da entidade associada,
	 * especialmente para fins de listagem e etc.
	 * 
	 * Caso a entidade nao possua essa caracteristica por algum motivo,
	 * a mesma deverá retornar <b>null<b>. Nesse casos o método implementado
	 * estará deprecado
	 * 
	 * @return {@link T} List com todos os registros
	 * @throws SQLException
	 */
	public abstract List<T> getTodos() throws SQLException;
	
	/**
	 * Finaliza a conexão corrente e demais 
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