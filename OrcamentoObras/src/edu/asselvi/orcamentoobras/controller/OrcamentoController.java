package edu.asselvi.orcamentoobras.controller;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.beans.Orcamento;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.IDaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IOrcamentoDao;


public class OrcamentoController {
	
	private IDaoFactory daoFactory = DaoFactory.getInstance();
	private IOrcamentoDao orcamentoDao;
	
	public OrcamentoController() {
		orcamentoDao = daoFactory.getOrcamentoDao();
	}
	
	public void cadastrarOrcamento(Orcamento orcamento) throws SQLException {
		orcamentoDao.inserir(orcamento);
	}
}
