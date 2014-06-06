package edu.asselvi.orcamentoobras.model.dao.factory;

import edu.asselvi.orcamentoobras.model.dao.intf.IEnderecoDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IMunicipioDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IOrcamentoDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPessoaFisicaDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPessoaJuridicaDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPrevisaoDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPrevisaoOrcamentoDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IProdutoDao;
import edu.asselvi.orcamentoobras.model.dao.intf.ITerrenoDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IUnidadeFederativaDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IUsuarioDao;

/**
 * Define os DAOs obrigatórios que qualquer DaoFactory
 * deverá retornar.
 * 
 * @author Marcelo
 *
 */
public interface IDaoFactory {

	public IUnidadeFederativaDao getUnidadeFederativaDao();
	
	public IMunicipioDao getMunicipioDao();
	
	public IEnderecoDao getEnderecoDao();
	
	public IProdutoDao getProdutoDao();
	
	public ITerrenoDao getTerrenoDao();
	
	public IPessoaFisicaDao getPessoaFisicaDao();
	
	public IPessoaJuridicaDao getPessoaJuridicaDao();
	
	public IUsuarioDao getUsuarioDao();
	
	public IPrevisaoOrcamentoDao getPrevisaoOrcamentoDao();
	
	public IPrevisaoDao getPrevisaoDao();
	
	public IOrcamentoDao getOrcamentoDao();
	
}