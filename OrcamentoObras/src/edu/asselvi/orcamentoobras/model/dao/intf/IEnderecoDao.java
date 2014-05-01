package edu.asselvi.orcamentoobras.model.dao.intf;

import edu.asselvi.orcamentoobras.model.Endereco;

/**
 * Comportamento padrão para toda DAO de {@link Endereco}
 * 
 * @author Marcelo Avancini
 *
 */
public interface IEnderecoDao {

	/**
	 * Retorna {@link Endereco} considerando o identificador do mesmo
	 * 
	 * @param id
	 * @return {@link Endereco}
	 */
	public Endereco getPeloId(Integer id);
	
}
