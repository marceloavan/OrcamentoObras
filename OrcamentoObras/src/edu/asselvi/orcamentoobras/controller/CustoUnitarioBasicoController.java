package edu.asselvi.orcamentoobras.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.CustoUnitarioBasico;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.ICustoUnitarioBasicoDao;

public class CustoUnitarioBasicoController {
	
	private ICustoUnitarioBasicoDao cubDao;
	
	public CustoUnitarioBasicoController() {
		cubDao = DaoFactory.getInstance().getCubDao();
	}
	
	public List<CustoUnitarioBasico> getCustos() {
		try {
			return cubDao.getTodos();
		} catch (SQLException e) {
		}
		return Collections.emptyList();
	}
}
