package edu.asselvi.orcamentoobras.model.dao.factory;

import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.dao.CustoRealDao;
import edu.asselvi.orcamentoobras.model.dao.CustoUnitarioBasicoDao;
import edu.asselvi.orcamentoobras.model.dao.EnderecoDao;
import edu.asselvi.orcamentoobras.model.dao.MunicipioDao;
import edu.asselvi.orcamentoobras.model.dao.OrcamentoDao;
import edu.asselvi.orcamentoobras.model.dao.PessoaFisicaDao;
import edu.asselvi.orcamentoobras.model.dao.PessoaJuridicaDao;
import edu.asselvi.orcamentoobras.model.dao.PrevisaoDao;
import edu.asselvi.orcamentoobras.model.dao.PrevisaoOrcamentoDao;
import edu.asselvi.orcamentoobras.model.dao.ProdutoDao;
import edu.asselvi.orcamentoobras.model.dao.TerrenoDao;
import edu.asselvi.orcamentoobras.model.dao.UnidadeFederativaDao;
import edu.asselvi.orcamentoobras.model.dao.UsuarioDao;
import edu.asselvi.orcamentoobras.model.dao.intf.ICustoRealDao;
import edu.asselvi.orcamentoobras.model.dao.intf.ICustoUnitarioBasicoDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IDao;
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

	@Override
	public IPrevisaoOrcamentoDao getPrevisaoOrcamentoDao() {
		return new PrevisaoOrcamentoDao();
	}

	@Override
	public IPrevisaoDao getPrevisaoDao() {
		return new PrevisaoDao();
	}

	@Override
	public IOrcamentoDao getOrcamentoDao() {
		return new OrcamentoDao();
	}
	
	@Override
	public ICustoUnitarioBasicoDao getCub() {
		return new CustoUnitarioBasicoDao();
	}
	
	@Override
	public ICustoRealDao getCustoReal() {
		return new CustoRealDao();
	}

	@Override
	public List<IDao> getTodosDaos() {
		List<IDao> lista = new ArrayList<IDao>();
		lista.add(getUsuarioDao());
		lista.add(getCub());
		lista.add(getProdutoDao());
		lista.add(getPrevisaoDao());
		lista.add(getUnidadeFederativaDao());
		lista.add(getMunicipioDao());
		lista.add(getEnderecoDao());
		lista.add(getTerrenoDao());
		lista.add(getPessoaFisicaDao());
		lista.add(getPessoaJuridicaDao());
		lista.add(getOrcamentoDao());
		lista.add(getCustoReal());
		lista.add(getPrevisaoOrcamentoDao());

		return lista;
	}

	
}