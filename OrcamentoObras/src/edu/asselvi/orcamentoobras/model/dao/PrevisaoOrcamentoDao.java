package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Orcamento;
import edu.asselvi.orcamentoobras.model.beans.PrevisaoOrcamento;
import edu.asselvi.orcamentoobras.model.dao.intf.IPrevisaoOrcamentoDao;


public class PrevisaoOrcamentoDao extends AbstractDao implements IPrevisaoOrcamentoDao{

	@Override
	public void inserir(PrevisaoOrcamento param) throws SQLException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO PREVISAO");
		sb.append(" (DESCRICAO, VALOR)");
		sb.append(" VALUES (?, ?)");
		
		String sql = sb.toString();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
	public void atualizar(PrevisaoOrcamento param) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void remover(PrevisaoOrcamento param) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public List<PrevisaoOrcamento> getTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrevisaoOrcamento getPeloCodigo(Integer codigo) {
		String sql = "SELECT * FROM PREVISAO WHERE COD_PREVISAO = ?";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			rs = stmt.getResultSet();
			if (rs.next()) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PrevisaoOrcamento getPeloOrcamento(Orcamento orcamento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createTable() throws SQLException {
		String sql = "CREATE TABLE ORCAMENTO_PREVISAO ("
				+ "	COD_ORC_PREV 		INTEGER NOT NULL,"
				+ "	PREVISAO 			INTEGER NOT NULL,"
				+ "	ORCAMENTO 			INTEGER NOT NULL,"
				+ "	VALOR 				DECIMAL(10,2) NOT NULL,"
				+ "	CONSTRAINT 			PK_COD_ORC_PREV PRIMARY KEY (COD_ORC_PREV),"
				+ "	CONSTRAINT 			FK_ORCAMENTO_PREVISAO_PREVISAO FOREIGN KEY (PREVISAO) REFERENCES PREVISAO(COD_PREVISAO),"
				+ " CONSTRAINT 			FK_ORCAMENTO_PREVISAO_ORCAMENTO FOREIGN KEY (ORCAMENTO) REFERENCES ORCAMENTO(COD_ORCAMENTO))";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = getConexao().prepareStatement(sql);
			rs = stmt.executeQuery();
			
		} finally {
			
			finalizarConexoes(stmt, rs);
			
		}
	}
}
