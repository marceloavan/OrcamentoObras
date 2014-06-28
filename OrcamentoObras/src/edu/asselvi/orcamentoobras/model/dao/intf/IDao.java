package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

	/**
	 * Responsável por inserir um novo registro na base de dados para
	 * a entidade em questão
	 * 
	 * @param {@link T} param - entidade a ser persistida
	 * @throws SQLException
	 */
	public void inserir(T param) throws SQLException;
	
	/**
	 * Reponsánvel por atualizar informações de uma entidade já persistida
	 * na base dados. Para tanto, será considerado o identificador da entidade
	 * na verificação
	 * 
	 * @param {@link T} param - entidade que será atualizada
	 * @throws SQLException
	 */
	public void atualizar(T param) throws SQLException;
	
	/**
	 * Reponsável por remover e entidade da base de dados
	 * 
	 * @param {@link T} param - entidade que será removida da base de dados
	 * @throws SQLException
	 */
	public void remover(T param) throws SQLException;
	
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
	public List<T> getTodos() throws SQLException;
	
	
	/**
	 * Responsável por criar uma entidade na base de dados em questão
	 * 
	 * @param param
	 * @throws SQLException
	 */
	public void createTable () throws SQLException;
	
}
