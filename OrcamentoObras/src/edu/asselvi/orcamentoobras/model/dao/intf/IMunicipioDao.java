package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.Municipio;
import edu.asselvi.orcamentoobras.model.UnidadeFederativa;

/**
 * Comportamento padrão para qualquer DAO de {@link Municipio}
 * 
 * @author Marcelo
 *
 */
public interface IMunicipioDao {

	/**
	 * Deverá retornar todos os {@link Municipio}s associados a uma {@link UnidadeFederativa} 
	 * 
	 * @param {@link UnidadeFederativa} uf
	 * @return List {@link Municipio}
	 * @throws SQLException
	 */
	public List<Municipio> getTodosDaUf(UnidadeFederativa uf) throws SQLException;
	
	/**
	 * Retorna um {@link Municipio} a partir do seu código unico, de acordo
	 * com tabela do IBGE
	 * 
	 * @param codigoMunicipio
	 * @return {@link Municipio}
	 * @throws SQLException
	 */
	public Municipio getPeloCodigo(Integer codigoMunicipio) throws SQLException;
	
}
