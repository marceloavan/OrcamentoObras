package edu.asselvi.orcamentoobras.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.UnidadeFederativa;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IUnidadeFederativaDao;

public class UnidadeFederativaController {
	private IUnidadeFederativaDao unidadeFederativaDao;
	
	public UnidadeFederativaController() {
		unidadeFederativaDao = DaoFactory.getInstance().getUnidadeFederativaDao();
	}
	
	public List<UnidadeFederativa> getTodos() {
		try {
			return unidadeFederativaDao.getTodos();
		} catch (SQLException e) {
			return Collections.emptyList();
		}
	}

}
