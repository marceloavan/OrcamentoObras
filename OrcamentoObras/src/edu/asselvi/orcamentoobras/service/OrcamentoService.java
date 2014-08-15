package edu.asselvi.orcamentoobras.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Orcamento;
import edu.asselvi.orcamentoobras.model.beans.Previsao;
import edu.asselvi.orcamentoobras.model.beans.PrevisaoOrcamento;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.IDaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IOrcamentoDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPrevisaoDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPrevisaoOrcamentoDao;


public class OrcamentoService {
	
	private IDaoFactory daoFactory = DaoFactory.getInstance();
	private IOrcamentoDao orcamentoDao;
	private IPrevisaoDao previsaoDao;
	private IPrevisaoOrcamentoDao previsaoOrcamentoDao;
	
	public OrcamentoService() {
		orcamentoDao = daoFactory.getOrcamentoDao();
		previsaoDao = daoFactory.getPrevisaoDao();
		previsaoOrcamentoDao = daoFactory.getPrevisaoOrcamentoDao();
	}
	
	public void cadastrarOrcamento(Orcamento orcamento) throws SQLException {
		orcamentoDao.inserir(orcamento);
	}
	
	public void atualizarOrcamento(Orcamento orcamento) throws SQLException {
		orcamentoDao.atualizar(orcamento);
	}
	
	public List<Previsao> getAllPrevisoes() {
		try {
			return previsaoDao.getTodos();
		} catch (SQLException e) {
		}
		return Collections.emptyList();
	}
	
	public void cadastrarPrevisaoOrcamento(PrevisaoOrcamento previsaoOrcamento) throws SQLException {
		previsaoOrcamentoDao.inserir(previsaoOrcamento);
	}
	
	public void removerOrcamento(Orcamento orcamento) throws SQLException {
		orcamentoDao.remover(orcamento);
	}
}