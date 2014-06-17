package edu.asselvi.orcamentoobras.model.dao.intf;

import edu.asselvi.orcamentoobras.model.beans.Orcamento;

public interface IOrcamentoDao extends IDao<Orcamento>{

	public Orcamento getPeloCodigo();
	
}
