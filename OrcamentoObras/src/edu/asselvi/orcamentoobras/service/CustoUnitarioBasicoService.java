package edu.asselvi.orcamentoobras.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.CustoUnitarioBasico;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.ICustoUnitarioBasicoDao;

public class CustoUnitarioBasicoService {
	
	private ICustoUnitarioBasicoDao cubDao;
	
	public CustoUnitarioBasicoService() {
		cubDao = DaoFactory.getInstance().getCubDao();
	}
	
	public List<CustoUnitarioBasico> getCustos() {
		try {
			return cubDao.getTodos();
		} catch (SQLException e) {
		}
		return Collections.emptyList();
	}
	
	public void inserirCub (CustoUnitarioBasico cub) throws SQLException{
		cubDao.inserir(cub);
	}
	
	public void atualizarCub (CustoUnitarioBasico cub) throws SQLException{
		cubDao.atualizar(cub);
	}
	
	public void excluirCub (Integer codigo) throws SQLException{
		CustoUnitarioBasico cub = DaoFactory.getInstance().getCubDao().getPeloCodigo(codigo);
		cubDao.remover(cub);
	}
	
	public CustoUnitarioBasico getCubPeloCodigo (Integer codigo) {
		try {
			return cubDao.getPeloCodigo(codigo);
		} catch (SQLException e) {	
		}
		return null;
	}
}
