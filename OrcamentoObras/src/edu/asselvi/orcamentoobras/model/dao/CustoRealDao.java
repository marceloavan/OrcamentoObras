package edu.asselvi.orcamentoobras.model.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.CustoReal;
import edu.asselvi.orcamentoobras.model.beans.Orcamento;
import edu.asselvi.orcamentoobras.model.beans.Previsao;
import edu.asselvi.orcamentoobras.model.beans.Produto;
import edu.asselvi.orcamentoobras.model.dao.intf.ICustoRealDao;

public class CustoRealDao extends AbstractDao implements ICustoRealDao{

	@Override
	public void inserir(CustoReal param) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO CUSTOREAL");
		sb.append(" (PRODUTO, PREVISAO, ORCAMENTO, VALOR)");
		sb.append(" VALUES (?, ?, ?, ?)");
		
		String sql = sb.toString();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, param.getProduto().getCodigo());
			stmt.setInt(2, param.getPrevisao().getCodigo());
			stmt.setInt(3, param.getOrcamento().getId());
			stmt.setBigDecimal(4, param.getValor());
			
			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas == 0) {
				throw new SQLException("Falha ao criar registro");
			}
			rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				param.setId(rs.getInt(1));
			} else {
				throw new SQLException("Não foi possível buscar a chave gerada");
			}
			
		} finally {
			finalizarConexoes(stmt, rs);
		}
		
		
	}

	@Override
	public void atualizar(CustoReal param) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE CUSTOREAL SET");
		sb.append(" PRODUTO = ?,");
		sb.append(" PREVISAO = ?,");
		sb.append(" ORCAMENTO = ?,");
		sb.append(" VALOR = ?");
		sb.append(" WHERE COD_CUSTOREAL = ?");
		
		String sql = sb.toString();
		PreparedStatement stmt = null;
		
		try {
			
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, param.getProduto().getCodigo());
			stmt.setInt(2, param.getPrevisao().getCodigo());
			stmt.setInt(3, param.getOrcamento().getId());
			stmt.setBigDecimal(4, param.getValor());
			stmt.setInt(5, param.getId());
			
			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas == 0) {
				throw new SQLException("Falha ao atualizar registro");
			}
		} finally {
			finalizarConexoes(stmt, null);
		}
		
	}

	@Override
	public void remover(CustoReal param) throws SQLException {
		String sql = "DELETE FROM CUSTO_REAL WHERE COD_CUSTOREAL = ?";
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
	public List<CustoReal> getTodos() throws SQLException {
		List<CustoReal> custoRealLista = new ArrayList<CustoReal>();
		
		String sql = "SELECT * FROM CUSTO_REAL";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = getConexao().prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Integer id = rs.getInt("COD_CUSTOREAL");
				BigDecimal valor = rs.getBigDecimal("VALOR");
				Integer codigoProduto = rs.getInt("PRODUTO");
				Integer codigoPrevisao = rs.getInt("PREVISAO");
				Integer codigoOrcamento = rs.getInt("ORCAMENTO");
				
				Produto produto = getDaoFactory().getProdutoDao().getPeloCodigo(codigoProduto);
				Previsao previsao = getDaoFactory().getPrevisaoDao().getPeloCodigo(codigoPrevisao);
				Orcamento orcamento = getDaoFactory().getOrcamentoDao().getPeloCodigo(codigoOrcamento);
				
				CustoReal custoReal = new CustoReal(valor, produto, previsao);
				custoReal.setId(id);
				custoReal.setOrcamento(orcamento);
				
				custoRealLista.add(custoReal);
			}
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return custoRealLista;
	}

	@Override
	public CustoReal getPeloCodigo(Integer codigo) throws SQLException {
		
		CustoReal custoReal = null;
		String sql = "SELECT * FROM CUSTO_REAL WHERE COD_CUSTOREAL = ?";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Integer codProduto = rs.getInt("PRODUTO");
				Integer codPrevisao = rs.getInt("PREVISAO");
				Integer codOrcamento = rs.getInt("ORCAMENTO");
				BigDecimal valor = rs.getBigDecimal("VALOR");
				
				Produto produto = getDaoFactory().getProdutoDao().getPeloCodigo(codProduto);
				Previsao previsao = getDaoFactory().getPrevisaoDao().getPeloCodigo(codPrevisao);
				Orcamento orcamento = getDaoFactory().getOrcamentoDao().getPeloCodigo(codOrcamento);
				
				custoReal = new CustoReal(valor, produto, previsao);
				custoReal.setOrcamento(orcamento);
			}
			
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return custoReal;
	}

	@Override
	public List<CustoReal> getPelaPrevisao(Previsao previsao) throws SQLException {
		List<CustoReal> custoRealLista = new ArrayList<CustoReal>();

		String sql = "SELECT * FROM CUSTO_REAL WHERE PREVISAO = ?";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, previsao.getCodigo());
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Integer id = rs.getInt("COD_CUSTOREAL");
				Integer codProduto = rs.getInt("PRODUTO");
				Integer codOrcamento = rs.getInt("ORCAMENTO");
				BigDecimal valor = rs.getBigDecimal("VALOR");
				
				Produto produto = getDaoFactory().getProdutoDao().getPeloCodigo(codProduto);
				Orcamento orcamento = getDaoFactory().getOrcamentoDao().getPeloCodigo(codOrcamento);
				
				CustoReal custoReal = new CustoReal(valor, produto, previsao);
				custoReal.setId(id);
				custoReal.setOrcamento(orcamento);
				
				custoRealLista.add(custoReal);
			}
			
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return custoRealLista;
	}

	@Override
	public void createTable() throws SQLException {
		String sql = "CREATE TABLE CUSTO_REAL ("
				+ "  	COD_CUSTOREAL 		INTEGER AUTO_INCREMENT,"
				+ "  	PRODUTO 			INTEGER,"
				+ "  	PREVISAO 			INTEGER,"
				+ "  	ORCAMENTO 			INTEGER,"
				+ " 	VALOR				DECIMAL(10,2),"
				+ "  	CONSTRAINT 			PK_CUSTO_REAL PRIMARY KEY (COD_CUSTOREAL),"
				+ "  	CONSTRAINT 			FK_CUSTO_REAL_PRODUTO FOREIGN KEY (PRODUTO) REFERENCES PRODUTO(COD_PRODUTO),"
				+ "  	CONSTRAINT 			FK_CUSTO_REAL_PREVISAO FOREIGN KEY (PREVISAO) REFERENCES PREVISAO(COD_PREVISAO),"
				+ "  	CONSTRAINT 			FK_CUSTO_REAL_ORCAMENTO FOREIGN KEY (ORCAMENTO) REFERENCES ORCAMENTO(COD_ORCAMENTO))";
		
		PreparedStatement stmt = null;
		
		try {
			
			stmt = getConexao().prepareStatement(sql);
			stmt.execute(sql);
			
		} finally {
			
			finalizarConexoes(stmt, null);
			
		}
	}

}
