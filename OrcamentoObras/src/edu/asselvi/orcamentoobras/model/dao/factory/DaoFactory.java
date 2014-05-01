package edu.asselvi.orcamentoobras.model.dao.factory;

import edu.asselvi.orcamentoobras.model.dao.MunicipioDao;
import edu.asselvi.orcamentoobras.model.dao.UnidadeFederativaDao;


public class DaoFactory implements IDaoFactory {
	
	private static DaoFactory INSTANCE;
	
	private DaoFactory() {
		// Sigleton
	}
	
	public static DaoFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DaoFactory();
		}
		return INSTANCE;
	}

	@Override
	public UnidadeFederativaDao getUnidadeFederativaDao() {
		return new UnidadeFederativaDao();
	}

	@Override
	public MunicipioDao getMunicipioDao() {
		return new MunicipioDao();
	}
}
