package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.beans.PessoaFisica;

public interface IPessoaFisicaDao extends IDao<PessoaFisica> {
	
	public PessoaFisica getPeloCodigo(Integer codigo) throws SQLException;
	
}