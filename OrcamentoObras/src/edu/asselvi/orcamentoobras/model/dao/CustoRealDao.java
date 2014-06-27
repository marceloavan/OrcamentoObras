package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.CustoReal;
import edu.asselvi.orcamentoobras.model.beans.PrevisaoOrcamento;
import edu.asselvi.orcamentoobras.model.dao.intf.ICustoReal;

public class CustoRealDao extends AbstractDao implements ICustoReal{

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
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, param.getProduto().getCodigo());
			stmt.setInt(2, param.getPrevisao().getId());
		} finally {
			finalizarConexoes(stmt, rs);
		}
		
		
	}

	@Override
	public void atualizar(CustoReal param) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("");
		
	}

	@Override
	public void remover(CustoReal param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustoReal> getTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustoReal getPeloCodigo(Integer codigo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustoReal> getPelaPrevisao(PrevisaoOrcamento previsao) throws SQLException {
		// TODO Vai trazer uma lista de todos os Custos com base no ID da previs�o
		return null;
	}

	@Override
	public void createTable() throws SQLException {
		String sql = "CREATE TABLE CUSTO_REAL ("
				+ "  	COD_CUSTOREAL 		INTEGER NOT NULL AUTO_INCREMENT,"
				+ "  	PRODUTO 			INTEGER NOT NULL,"
				+ "  	PREVISAO 			INTEGER NOT NULL,"
				+ "  	ORCAMENTO 			INTEGER NOT NULL,"
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
