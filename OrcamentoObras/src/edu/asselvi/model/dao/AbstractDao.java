package edu.asselvi.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.asselvi.model.dao.conector.ConectorBancoFactory;

public abstract class AbstractDao<T> {

	private Connection conn;
	
	public AbstractDao() {
		ConectorBancoFactory cbf = new ConectorBancoFactory();
		conn = cbf.getConexao();
	}
	
	public Connection getConexao() {
		return conn;
	}
	
	public abstract void inserir(T param) throws SQLException;
	
	public abstract void atualizar(T param) throws SQLException;
	
	public abstract void remover(T param) throws SQLException;
	
	public abstract List<T> getTodos() throws SQLException;
}