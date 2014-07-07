package edu.asselvi.orcamentoobras.controller.exception;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Municipio;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IMunicipioDao;

public class MunicipioController {
	private IMunicipioDao municipioDao;
	
	public MunicipioController() {
		municipioDao = DaoFactory.getInstance().getMunicipioDao();
	}
	
	public List<Municipio> getTodos() {
		try {
			return municipioDao.getTodos();
		} catch (SQLException e) {
		}
		return Collections.emptyList();
	}
}
