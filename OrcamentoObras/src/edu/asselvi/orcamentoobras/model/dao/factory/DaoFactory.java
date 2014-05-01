package edu.asselvi.orcamentoobras.model.dao.factory;

import edu.asselvi.orcamentoobras.model.dao.MunicipioDao;
import edu.asselvi.orcamentoobras.model.dao.UnidadeFederativaDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IMunicipioDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IUnidadeFederativaDao;


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
	public IUnidadeFederativaDao getUnidadeFederativaDao() {
		return new UnidadeFederativaDao();
	}

	@Override
	public IMunicipioDao getMunicipioDao() {
		return new MunicipioDao();
	}
}
