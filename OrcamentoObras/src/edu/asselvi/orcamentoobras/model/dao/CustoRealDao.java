package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.CustoReal;
import edu.asselvi.orcamentoobras.model.Previsao;
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
	public List<CustoReal> getPelaPrevisao(Previsao previsao) throws SQLException {
		// TODO Vai trazer uma lista de todos os Custos com base no ID da previsão
		return null;
	}

}
