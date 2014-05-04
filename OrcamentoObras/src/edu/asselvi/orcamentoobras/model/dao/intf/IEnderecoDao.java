package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.Endereco;

/**
 * Comportamento padrão para toda DAO de {@link Endereco}
 * 
 * @author Marcelo Avancini
 *
 */
public interface IEnderecoDao extends IDao<Endereco> {
	
	/**
	 * Retorna {@link Endereco} considerando o identificador do mesmo
	 * 
	 * @param id
	 * @return {@link Endereco}
	 * @throws SQLException 
	 */
	public Endereco getPeloId(Integer id) throws SQLException;
	
}
