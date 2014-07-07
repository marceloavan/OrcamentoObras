package edu.asselvi.orcamentoobras.model.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.CustoUnitarioBasico;
import edu.asselvi.orcamentoobras.model.dao.intf.ICustoUnitarioBasicoDao;

public class CustoUnitarioBasicoDao extends AbstractDao implements
		ICustoUnitarioBasicoDao {

	@Override
	public void inserir(CustoUnitarioBasico param) throws SQLException {

		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO CUB");
		sb.append(" (ANO, MES, VL_METRO_QUADRADO)");
		sb.append(" VALUES (?, ?, ?)");
		
		String sql = sb.toString();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, param.getAno());
			stmt.setInt(2, param.getMes());
			stmt.setBigDecimal(3, param.getValorMetroQuadrado());
			
			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas == 0) {
				throw new SQLException("Falha ao criar registro");
			}
			
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				param.setId(rs.getInt(1));
			} else {
				throw new SQLException("Não foi possivel buscar a chave gerada");
			}
			
		} finally {
			finalizarConexoes(stmt, rs);
		}
		
	}

	@Override
	public void atualizar(CustoUnitarioBasico param) throws SQLException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE CUB SET");
		sb.append(" ANO = ?,");
		sb.append(" MES = ?,");
		sb.append(" VL_METRO_QUADRADO = ?");
		sb.append(" WHERE COD_CUB = ?");
		
		String sql = sb.toString();
		PreparedStatement stmt = null;
		
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, param.getAno());
			stmt.setInt(2, param.getMes());
			stmt.setBigDecimal(3, param.getValorMetroQuadrado());
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
	public void remover(CustoUnitarioBasico param) throws SQLException {
		
		String sql = "DELETE FROM CUB WHERE COD_CUB = ?";
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
	public List<CustoUnitarioBasico> getTodos() throws SQLException {
		List<CustoUnitarioBasico> cubLista = new ArrayList<CustoUnitarioBasico>();
		
		String sql = "SELECT * FROM CUB";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = getConexao().prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Integer id = rs.getInt("COD_CUB");
				Integer ano = rs.getInt("ANO");
				Integer mes = rs.getInt("MES");
				BigDecimal valorMetroQuadrado = rs.getBigDecimal("VL_METRO_QUADRADO");
				
				CustoUnitarioBasico cub = new CustoUnitarioBasico(valorMetroQuadrado, mes, ano);
				cub.setId(id);
				cubLista.add(cub);
			}
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return cubLista;
	}

	@Override
	public CustoUnitarioBasico getPeloMesAno(Integer mes, Integer ano) throws SQLException {
		
		CustoUnitarioBasico cub = null;
		String sql = "SELECT * FROM CUB WHERE MES = ? AND ANO = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, mes);
			stmt.setInt(2, ano);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Integer id = rs.getInt("COD_CUB");
				Integer codAno = rs.getInt("ANO");
				Integer codMes = rs.getInt("MES");
				BigDecimal valorMetroQuadrado = rs.getBigDecimal("VL_METRO_QUADRADO");
				
				cub = new CustoUnitarioBasico(valorMetroQuadrado, codMes, codAno);
				cub.setId(id);
			}
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return cub;
	}

	@Override
	public CustoUnitarioBasico getPeloCodigo(Integer codigo) throws SQLException {
		
		CustoUnitarioBasico cub = null;
		String sql = "SELECT * FROM CUB WHERE COD_CUB = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, codigo);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("COD_CUB");
				Integer ano = rs.getInt("ANO");
				Integer mes = rs.getInt("MES");
				BigDecimal valorMetroQuadrado = rs.getBigDecimal("VL_METRO_QUADRADO");
				
				cub = new CustoUnitarioBasico(valorMetroQuadrado, mes, ano);
				cub.setId(id);
			}
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return cub;
	}

	@Override
	public void createTable() throws SQLException {
		String sql = "CREATE TABLE CUB ("
				+ "COD_CUB				INTEGER AUTO_INCREMENT,"
				+ "ANO					INTEGER," 
				+ "MES					INTEGER,"
				+ "VL_METRO_QUADRADO	DECIMAL(10,2),"
				+ "CONSTRAINT			PK_CUB PRIMARY KEY (COD_CUB),"
				+ "CONSTRAINT			UK_CUB UNIQUE KEU (ANO, MES))";

		PreparedStatement stmt = null;

		try {

			stmt = getConexao().prepareStatement(sql);
			stmt.execute(sql);

		} finally {
			finalizarConexoes(stmt, null);
		}

	}

}
