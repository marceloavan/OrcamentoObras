package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

	/**
	 * Respons�vel por inserir um novo registro na base de dados para
	 * a entidade em quest�o
	 * 
	 * @param {@link T} param - entidade a ser persistida
	 * @throws SQLException
	 */
	public void inserir(T param) throws SQLException;
	
	/**
	 * Repons�nvel por atualizar informa��es de uma entidade j� persistida
	 * na base dados. Para tanto, ser� considerado o identificador da entidade
	 * na verifica��o
	 * 
	 * @param {@link T} param - entidade que ser� atualizada
	 * @throws SQLException
	 */
	public void atualizar(T param) throws SQLException;
	
	/**
	 * Repons�vel por remover e entidade da base de dados
	 * 
	 * @param {@link T} param - entidade que ser� removida da base de dados
	 * @throws SQLException
	 */
	public void remover(T param) throws SQLException;
	
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
	public List<T> getTodos() throws SQLException;
	
	
	/**
	 * Responsável por criar uma entidade na base de dados em questão
	 * 
	 * @param param
	 * @throws SQLException
	 */
	public void createTable () throws SQLException;
	
}
