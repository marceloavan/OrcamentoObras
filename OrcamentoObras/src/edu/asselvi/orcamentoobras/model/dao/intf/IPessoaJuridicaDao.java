package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.beans.PessoaJuridica;

public interface IPessoaJuridicaDao extends IDao<PessoaJuridica> {
	
	public PessoaJuridica getPeloCodigo(Integer codigo) throws SQLException;
	
}