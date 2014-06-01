package edu.asselvi.orcamentoobras.model.dao.factory;

import edu.asselvi.orcamentoobras.model.dao.EnderecoDao;
import edu.asselvi.orcamentoobras.model.dao.MunicipioDao;
import edu.asselvi.orcamentoobras.model.dao.PessoaFisicaDao;
import edu.asselvi.orcamentoobras.model.dao.PessoaJuridicaDao;
import edu.asselvi.orcamentoobras.model.dao.ProdutoDao;
import edu.asselvi.orcamentoobras.model.dao.TerrenoDao;
import edu.asselvi.orcamentoobras.model.dao.UnidadeFederativaDao;
import edu.asselvi.orcamentoobras.model.dao.UsuarioDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IEnderecoDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IMunicipioDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPessoaFisicaDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPessoaJuridicaDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IProdutoDao;
import edu.asselvi.orcamentoobras.model.dao.intf.ITerrenoDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IUnidadeFederativaDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IUsuarioDao;


public class DaoFactory implements IDaoFactory {
	
	private static DaoFactory INSTANCE;
	
	private DaoFactory() {
		// Sigleton
	}
	
	public static DaoFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DaoFactory();
		}
		return INSTANCE;
	}

	@Override
	public IUnidadeFederativaDao getUnidadeFederativaDao() {
		return new UnidadeFederativaDao();
	}

	@Override
	public IMunicipioDao getMunicipioDao() {
		return new MunicipioDao();
	}

	@Override
	public IEnderecoDao getEnderecoDao() {
		return new EnderecoDao();
	}

	@Override
	public IProdutoDao getProdutoDao() {
		return new ProdutoDao();
	}

	@Override
	public ITerrenoDao getTerrenoDao() {
		return new TerrenoDao();
	}

	@Override
	public IPessoaFisicaDao getPessoaFisicaDao() {
		return new PessoaFisicaDao();
	}

	@Override
	public IPessoaJuridicaDao getPessoaJuridicaDao() {
		return new PessoaJuridicaDao();
	}

	@Override
	public IUsuarioDao getUsuarioDao() {
		return new UsuarioDao();
	}
}