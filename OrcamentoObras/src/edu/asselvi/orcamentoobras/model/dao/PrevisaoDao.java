package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.Previsao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPrevisaoDao;


public class PrevisaoDao extends AbstractDao<Previsao> implements IPrevisaoDao{

	@Override
	public void inserir(Previsao param) throws SQLException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO PREVISAO");
		sb.append(" (DESCRICAO, VALOR)");
		sb.append(" VALUES (?, ?)");
		
		String sql = sb.toString();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, param.getDescricao());
			stmt.setDouble(2, param.getValor().doubleValue());
			
			int linhasAfetadas = stmt.executeUpdate();
	        if (linhasAfetadas == 0) {
	            throw new SQLException("Falha ao criar registro");
	        }
	        
	        rs = stmt.getGeneratedKeys();
	        if (rs.next()) {
	            param.setId(rs.getInt(1));
	        } else {
	            throw new SQLException("Nao foi possivel buscar a chave gerada");
	        }
			
		} finally {
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
			getConexao().close();
		}
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
	public Previsao getPeloId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
