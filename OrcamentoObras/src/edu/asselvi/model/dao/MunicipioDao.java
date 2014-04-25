package edu.asselvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import edu.asselvi.model.Municipio;

public class MunicipioDao extends AbstractDao<Municipio> {

	@Override
	public void inserir(Municipio param) throws SQLException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO MUNICIPIO");
		sb.append(" (COD_MUNICIPIO, DESCRICAO, COD_UF)");
		sb.append(" VALUES (?, ?, ?)");
		
		String sql = sb.toString();
		PreparedStatement stmt = null;
		try {
			stmt = getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, param.getCodigo());
			stmt.setString(2, param.getDescricao());
			stmt.setInt(3, param.getUf().getCodigo());
			
			stmt.execute();
			
			int linhasAfetadas = stmt.executeUpdate();
	        if (linhasAfetadas == 0) {
	            throw new SQLException("Falha ao criar registro");
	        }

		} finally {
			if (stmt != null) stmt.close();
			getConexao().close();
		}
	}

	@Override
	public void atualizar(Municipio param) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void remover(Municipio param) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Municipio> getTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}