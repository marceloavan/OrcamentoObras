package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.Previsao;

/**
 * Comportamento padrão de DAOs para trabalhar com {@link Previsao}
 * 
 * @author Marcelo Avancini
 *
 */
public interface IPrevisaoDao {
	
	public void inserir(Previsao previsao) throws SQLException;
	
	public void atualizar(Previsao previsao) throws SQLException;
	
	public void remover(Previsao previsao) throws SQLException;
	
	/**
	 * Retorna a {@link Previsao} pelo Id da Mesma
	 * 
	 * @param id
	 * @return {@link Previsao}
	 */
	public Previsao getPeloId(Integer id);
	
}
