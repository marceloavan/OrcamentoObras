package edu.asselvi.orcamentoobras.model.dao;

import java.sql.Connection;

import edu.asselvi.orcamentoobras.model.dao.conector.ConectorBancoFactory;

public abstract class AbstractDao<T> {

	private Connection conn;
	
	public AbstractDao() {
		ConectorBancoFactory cbf = new ConectorBancoFactory();
		conn = cbf.getConexao();
	}
	
	public Connection getConexao() {
		return conn;
	}
	
	public abstract void inserir(T param);
	
	public abstract void atualizar(T param);
}