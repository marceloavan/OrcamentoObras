package edu.asselvi.orcamentoobras.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.IDaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IPessoaDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPessoaFisicaDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPessoaJuridicaDao;

public class PessoaService {
	
	private IDaoFactory daoFactory = DaoFactory.getInstance();
	private IPessoaFisicaDao pessoaFisicaDao;
	private IPessoaJuridicaDao pessoaJuridicaDao;
	private IPessoaDao pessoaDao;
	
	public PessoaService() {
		pessoaFisicaDao = daoFactory.getPessoaFisicaDao();
		pessoaJuridicaDao = daoFactory.getPessoaJuridicaDao();
		pessoaDao = daoFactory.getPessoaDao();
	}
	
	public List<AbstractPessoa> getPessoas() {
		List<AbstractPessoa> pessoasList = new ArrayList<AbstractPessoa>();
		try {
			pessoasList.addAll(pessoaFisicaDao.getTodos());
		} catch (SQLException e) {
		}
		try {
			pessoasList.addAll(pessoaJuridicaDao.getTodos());
		} catch (SQLException e) {
		}
		return pessoasList;
	}
	
	public void inserirPessoa (AbstractPessoa pessoa) {
		try {
			pessoaDao.inserir(pessoa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarPessoa (AbstractPessoa pessoa) {
		try {
			pessoaDao.atualizar(pessoa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removerPessoa (Integer codigo) throws SQLException {
		AbstractPessoa pessoa = daoFactory.getPessoaDao().getPeloCodigo(codigo);
		pessoaDao.remover(pessoa);
	}
	
	public AbstractPessoa getPeloCodigo (Integer codigo) {
		try {
			return daoFactory.getPessoaDao().getPeloCodigo(codigo);
		} catch (SQLException e) {
		}
		return null;
	}
}
