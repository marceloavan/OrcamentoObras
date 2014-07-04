package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;

public interface IPessoaDao extends IDao<AbstractPessoa> {
	
	public AbstractPessoa getPeloCodigo (Integer codigo) throws SQLException;

}
