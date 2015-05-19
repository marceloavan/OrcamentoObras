package edu.asselvi.orcamentoobras.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Terreno;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.IDaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.ITerrenoDao;

public class TerrenoService {
	
	private IDaoFactory daoFactory = DaoFactory.getInstance();
	private ITerrenoDao terrenoDao;
	
	public TerrenoService() {
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
	
	public Terreno getPeloCodigo (Integer codigo){
		try {
			return daoFactory.getTerrenoDao().getPeloCodigo(codigo);
		} catch (SQLException e){
		}
		return null;
	}

}
