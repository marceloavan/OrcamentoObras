package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Previsao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPrevisaoDao;

public class PrevisaoDao extends AbstractDao implements IPrevisaoDao {

	@Override
	public void inserir(Previsao param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Previsao param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Previsao param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Previsao> getTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Previsao getPeloCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createTable() throws SQLException {
		String sql = "CREATE TABLE PREVISAO ("
				+ "  	COD_PREVISAO 		INTEGER NOT NULL,"
				+ "  	DESCRICAO 			VARCHAR(100) NOT NULL,"
				+ "  	CONSTRAINT 			PK_PREVISAO PRIMARY KEY(COD_PREVISAO))";
		
		PreparedStatement stmt = null;
		
		try {
			
			stmt = getConexao().prepareStatement(sql);
			stmt.execute(sql);
			
		} finally {
			
			finalizarConexoes(stmt, null);
			
		}
		
	}
}