package edu.asselvi.orcamentoobras.model.dao.factory;

import edu.asselvi.orcamentoobras.model.dao.intf.IEnderecoDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IMunicipioDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IUnidadeFederativaDao;

/**
 * Define os DAOs obrigat�rios que qualquer DaoFactory
 * dever� retornar.
 * 
 * @author Marcelo
 *
 */
public interface IDaoFactory {

	public IUnidadeFederativaDao getUnidadeFederativaDao();
	
	public IMunicipioDao getMunicipioDao();
	
	public IEnderecoDao getEnderecoDao();
	
}