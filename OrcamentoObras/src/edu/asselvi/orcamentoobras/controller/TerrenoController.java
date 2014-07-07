package edu.asselvi.orcamentoobras.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Terreno;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.IDaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.ITerrenoDao;

public class TerrenoController {
	
	private IDaoFactory daoFactory = DaoFactory.getInstance();
	private ITerrenoDao terrenoDao;
	
	public TerrenoController() {
		terrenoDao = daoFactory.getTerrenoDao();
	}
	
	public List<Terreno> getTerrenos() {
		try {
			return terrenoDao.getTodos();
		} catch (SQLException e) {
		}
		return Collections.emptyList();
	}
	
	public void cadastrarTerreno(Terreno terreno) throws SQLException{
		terrenoDao.inserir(terreno);
	}
	
	public void atualizarTerreno (Terreno terreno) throws SQLException{
		terrenoDao.atualizar(terreno);
	}
	
	public void removerTerreno (Integer codigo) throws SQLException {
		Terreno terreno = daoFactory.getTerrenoDao().getPeloCodigo(codigo);
		terrenoDao.remover(terreno);
	}

}
