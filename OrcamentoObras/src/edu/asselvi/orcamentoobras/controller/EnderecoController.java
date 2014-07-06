package edu.asselvi.orcamentoobras.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Endereco;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IEnderecoDao;

public class EnderecoController {
	private IEnderecoDao enderecoDao;
	
	public EnderecoController(){
		enderecoDao = DaoFactory.getInstance().getEnderecoDao();
	}
	
	public List<Endereco> getTodos(){
		try {
			return enderecoDao.getTodos();
		} catch (SQLException e){
		}
		return Collections.emptyList();
		
	}
}
