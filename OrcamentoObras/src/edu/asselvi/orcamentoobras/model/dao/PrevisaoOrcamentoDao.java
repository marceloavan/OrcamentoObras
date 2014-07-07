package edu.asselvi.orcamentoobras.model.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Orcamento;
import edu.asselvi.orcamentoobras.model.beans.Previsao;
import edu.asselvi.orcamentoobras.model.beans.PrevisaoOrcamento;
import edu.asselvi.orcamentoobras.model.dao.intf.IPrevisaoOrcamentoDao;

public class PrevisaoOrcamentoDao extends AbstractDao implements
		IPrevisaoOrcamentoDao {

	@Override
	public void inserir(PrevisaoOrcamento param) throws SQLException {

		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO PREVISAO_ORCAMENTO");
		sb.append(" (PREVISAO , ORCAMENTO, VALOR)");
		sb.append(" VALUES (?, ?, ?)");

		String sql = sb.toString();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, param.getPrevisao().getCodigo());
			stmt.setInt(2, param.getOrcamento().getId());
			stmt.setBigDecimal(3, param.getValor());

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
			finalizarConexoes(stmt, rs);
		}
	}

	@Override
	public void atualizar(PrevisaoOrcamento param) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE PREVISAO_ORCAMENTO SET");
		sb.append(" PREVISAO = ?,");
		sb.append(" ORCAMENTO = ?,");
		sb.append(" VALOR = ?");
		sb.append(" WHERE COD_ORC_PREV = ?");
		
		String sql  = sb.toString();
		PreparedStatement stmt = null;
		
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, param.getPrevisao().getCodigo());
			stmt.setInt(2, param.getOrcamento().getId());
			stmt.setBigDecimal(3, param.getValor());
			stmt.setInt(4, param.getId());
			
			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas == 0) {
				throw new SQLException("Falha ao atualizar registro");
			}
		} finally {
			finalizarConexoes(stmt, null);
		}
	}

	@Override
	public void remover(PrevisaoOrcamento param) throws SQLException {
		String sql = "DELETE FROM PREVISAO_ORCAMENTO WHERE COD_ORC_PREV = ?";
		PreparedStatement stmt = null;
		
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, param.getId());
			
			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas == 0) {
				throw new SQLException("Falha ao remover registro");
			}
		} finally {
			finalizarConexoes(stmt, null);
		}
	}

	@Override
	public List<PrevisaoOrcamento> getTodos() throws SQLException {
		List<PrevisaoOrcamento> previsaoOrcamentoLista = new ArrayList<PrevisaoOrcamento>();
		String sql = "SELECT * FROM PREVISAO_ORCAMENTO";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = getConexao().prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Integer id = rs.getInt("COD_ORC_PREV");
				Integer codPrevisao = rs.getInt("PREVISAO");
				Integer codOrcamento = rs.getInt("ORCAMENTO");
				BigDecimal valor = rs.getBigDecimal("VALOR");
				
				Orcamento orcamento = getDaoFactory().getOrcamentoDao().getPeloCodigo(codOrcamento);
				Previsao previsao = getDaoFactory().getPrevisaoDao().getPeloCodigo(codPrevisao);
				
				PrevisaoOrcamento previsaoOrcamento = new PrevisaoOrcamento(valor, previsao, orcamento);
				previsaoOrcamento.setId(id);
				
				previsaoOrcamentoLista.add(previsaoOrcamento);
			}
		} finally {
			finalizarConexoes(stmt, rs);
		}
		
		return previsaoOrcamentoLista;
	}

	@Override
	public PrevisaoOrcamento getPeloCodigo(Integer codigo) throws SQLException {

		PrevisaoOrcamento previsaoOrcamento = null;
		String sql = "SELECT * FROM PREVISAO WHERE COD_PREVISAO = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, codigo);

			rs = stmt.executeQuery();
			while (rs.next()) {
				Integer codPrevisao = rs.getInt("PREVISAO");
				Integer codOrcamento = rs.getInt("ORCAMENTO");
				BigDecimal valor = rs.getBigDecimal("VALOR");

				Orcamento orcamento = getDaoFactory().getOrcamentoDao().getPeloCodigo(codOrcamento);
				Previsao previsao = getDaoFactory().getPrevisaoDao().getPeloCodigo(codPrevisao);

				previsaoOrcamento = new PrevisaoOrcamento(valor, previsao,orcamento);
				previsaoOrcamento.setId(codigo);
			}
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return previsaoOrcamento;
	}

	@Override
	public List<PrevisaoOrcamento> getPeloOrcamento(Orcamento orcamento) throws SQLException {
		
		List<PrevisaoOrcamento> previsaoOrcamentoList = new ArrayList<PrevisaoOrcamento>();
		String sql  = "SELECT * FROM PREVISAO_ORCAMENTO WHERE ORCAMENTO = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, orcamento.getId());
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("COD_ORC_PREV");
				Integer codPrevisao = rs.getInt("PREVISAO");
				BigDecimal valor = rs.getBigDecimal("VALOR");
				
				Previsao previsao = getDaoFactory().getPrevisaoDao().getPeloCodigo(codPrevisao);
				PrevisaoOrcamento previsaoOrcamento = new PrevisaoOrcamento(valor, previsao, orcamento);
				previsaoOrcamento.setId(id);
				previsaoOrcamentoList.add(previsaoOrcamento);
			}
			
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return previsaoOrcamentoList;
	}

	@Override
	public void createTable() throws SQLException {
		String sql = "CREATE TABLE PREVISAO_ORCAMENTO ("
				+ "	COD_ORC_PREV 		INTEGER AUTO_INCREMENT,"
				+ "	PREVISAO 			INTEGER,"
				+ "	ORCAMENTO 			INTEGER,"
				+ "	VALOR 				DECIMAL(10,2) NOT NULL,"
				+ "	CONSTRAINT 			PK_COD_ORC_PREV PRIMARY KEY (COD_ORC_PREV),"
				+ "	CONSTRAINT 			FK_ORCAMENTO_PREVISAO_PREVISAO FOREIGN KEY (PREVISAO) REFERENCES PREVISAO(COD_PREVISAO),"
				+ " CONSTRAINT 			FK_ORCAMENTO_PREVISAO_ORCAMENTO FOREIGN KEY (ORCAMENTO) REFERENCES ORCAMENTO(COD_ORCAMENTO))";

		PreparedStatement stmt = null;

		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.execute(sql);
		} finally {
			finalizarConexoes(stmt, null);
		}
	}
}
