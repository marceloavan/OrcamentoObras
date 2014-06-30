package edu.asselvi.orcamentoobras.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.IDaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IPessoaFisicaDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPessoaJuridicaDao;

public class PessoaController {
	
	private IDaoFactory daoFactory = DaoFactory.getInstance();
	private IPessoaFisicaDao pessoaFisicaDao;
	private IPessoaJuridicaDao pessoaJuridicaDao;
	
	public PessoaController() {
		pessoaFisicaDao = daoFactory.getPessoaFisicaDao();
		pessoaJuridicaDao = daoFactory.getPessoaJuridicaDao();
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
	
}
