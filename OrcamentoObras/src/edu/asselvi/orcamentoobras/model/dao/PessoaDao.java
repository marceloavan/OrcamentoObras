package edu.asselvi.orcamentoobras.model.dao;

import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;
import edu.asselvi.orcamentoobras.model.beans.PessoaFisica;
import edu.asselvi.orcamentoobras.model.beans.PessoaJuridica;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.IDaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPessoaFisicaDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPessoaJuridicaDao;

public class PessoaDao implements IDao<AbstractPessoa> {

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
			pessoaFisicaDao.inserir((PessoaFisica)param);
		} else if (param.isPessoaJuridica()) {
			pessoaJuridicaDao.inserir((PessoaJuridica)param);
		}
	}

	@Override
	public void atualizar(AbstractPessoa param) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void remover(AbstractPessoa param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AbstractPessoa> getTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createTable() throws SQLException {
		// TODO Auto-generated method stub
	}
}