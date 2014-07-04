package edu.asselvi.orcamentoobras.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;
import edu.asselvi.orcamentoobras.model.beans.PessoaFisica;
import edu.asselvi.orcamentoobras.model.beans.PessoaJuridica;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.IDaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IPessoaDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPessoaFisicaDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPessoaJuridicaDao;

public class PessoaDao extends AbstractDao implements IPessoaDao {

	private IPessoaFisicaDao pessoaFisicaDao;
	private IPessoaJuridicaDao pessoaJuridicaDao;
	private IDaoFactory daoFactory = DaoFactory.getInstance();

	public PessoaDao() {
		pessoaFisicaDao = daoFactory.getPessoaFisicaDao();
		pessoaJuridicaDao = daoFactory.getPessoaJuridicaDao();
	}

	@Override
	public void inserir(AbstractPessoa param) throws SQLException {
		if (param.isPessoaFisica()) {
			pessoaFisicaDao.inserir((PessoaFisica) param);
		} else if (param.isPessoaJuridica()) {
			pessoaJuridicaDao.inserir((PessoaJuridica) param);
		}
	}

	@Override
	public void atualizar(AbstractPessoa param) throws SQLException {
		if (param.isPessoaFisica()) {
			pessoaFisicaDao.atualizar((PessoaFisica) param);
		} else if (param.isPessoaJuridica()) {
			pessoaJuridicaDao.atualizar((PessoaJuridica) param);
		}
	}

	@Override
	public void remover(AbstractPessoa param) throws SQLException {
		if (param.isPessoaFisica()) {
			pessoaFisicaDao.remover((PessoaFisica) param);
		} else if (param.isPessoaJuridica()) {
			pessoaJuridicaDao.remover((PessoaJuridica) param);
		}
	}

	@Override
	public List<AbstractPessoa> getTodos() throws SQLException {
		List<AbstractPessoa> pessoasList = new ArrayList<AbstractPessoa>();
		pessoasList.addAll(pessoaFisicaDao.getTodos());
		pessoasList.addAll(pessoaJuridicaDao.getTodos());
		return pessoasList;
	}

	@Override
	public AbstractPessoa getPeloCodigo(Integer codigo) throws SQLException {
		return null;
	}

	@Override
	public void createTable() throws SQLException {
	}

}