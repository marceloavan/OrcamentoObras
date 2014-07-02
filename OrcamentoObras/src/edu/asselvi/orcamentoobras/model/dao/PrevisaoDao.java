package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Previsao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPrevisaoDao;

public class PrevisaoDao extends AbstractDao implements IPrevisaoDao {

	@Override
	public void inserir(Previsao param) throws SQLException {

		StringBuilder sb = new StringBuilder();

		sb.append("INSERT INTO PREVISAO");
		sb.append(" (COD_PREVISAO, DESCRICAO)");
		sb.append(" VALUES (?, ?)");

		String sql = sb.toString();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			stmt = getConexao().prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, param.getCodigo());
			stmt.setString(2, param.getDescricao());

			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas == 0) {
				throw new SQLException("Falha ao criar registro");
			}

			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				param.setCodigo(rs.getInt(1));
			} else {
				throw new SQLException("Nao foi possivel buscar a chave gerada");
			}

		} finally {

			finalizarConexoes(stmt, rs);

		}

	}

	@Override
	public void atualizar(Previsao param) throws SQLException {

		StringBuilder sb = new StringBuilder();

		sb.append("UPDATE PREVISAO");
		sb.append(" DESCRICAO = ?");
		sb.append(" WHERE COD_PREVISAO = ?");

		String sql = sb.toString();
		PreparedStatement stmt = null;

		try {

			stmt = getConexao().prepareStatement(sql);

			stmt.setString(1, param.getDescricao());
			stmt.setInt(2, param.getCodigo());

			int linhasAfetadas = stmt.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new SQLException("Falha ao atualizar registro");
			}

		} finally {
			finalizarConexoes(stmt, null);
		}

	}

	@Override
	public void remover(Previsao param) throws SQLException {

		String sql = "DELETE FROM PREVISAO WHERE COD_PREVISAO = ?";

		PreparedStatement stmt = null;

		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, param.getCodigo());

			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas == 0) {
				throw new SQLException("Falha ao remover registro");
			}
		} finally {
			finalizarConexoes(stmt, null);
		}

	}

	@Override
	public List<Previsao> getTodos() throws SQLException {
		List<Previsao> previsaoLista = new ArrayList<Previsao>();
		
		String sql = "SELECT * FROM PREVISAO";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = getConexao().prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Integer codigo = rs.getInt("COD_PREVISAO");
				String descricao = rs.getString("DESCRICAO");
				
				Previsao previsao = new Previsao(descricao);
				previsao.setCodigo(codigo);
				
				previsaoLista.add(previsao);
			}
			
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return previsaoLista;
	}

	@Override
	public Previsao getPeloCodigo(Integer codigo) throws SQLException {
		
		Previsao previsao = null;
		
		String sql = "SELECT * FROM PREVISAO WHERE COD_PREVISAO = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, codigo);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				String descricao = rs.getString("DESCRICAO");
				
				previsao = new Previsao(descricao);
				previsao.setCodigo(codigo);
			}
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return previsao;
	}

	@Override
	public void createTable() throws SQLException {
		String sql = "CREATE TABLE PREVISAO ("
				+ "  	COD_PREVISAO 		INTEGER NOT NULL AUTO_INCREMENT,"
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