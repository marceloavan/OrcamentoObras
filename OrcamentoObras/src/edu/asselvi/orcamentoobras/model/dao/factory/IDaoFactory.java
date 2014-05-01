package edu.asselvi.orcamentoobras.model.dao.factory;

import edu.asselvi.orcamentoobras.model.dao.MunicipioDao;
import edu.asselvi.orcamentoobras.model.dao.UnidadeFederativaDao;

public interface IDaoFactory {

	UnidadeFederativaDao getUnidadeFederativaDao();
	
	MunicipioDao getMunicipioDao();
	
}
