package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.UnidadeFederativa;
import edu.asselvi.orcamentoobras.model.dao.intf.IUnidadeFederativaDao;

public class UnidadeFederativaDao extends AbstractDao implements IUnidadeFederativaDao {

	@Deprecated
	@Override
	public void inserir(UnidadeFederativa param) throws SQLException {
		throw new SQLException("N�o ser� necess�rio inserir UF, todas est�o mapeadas");
	}

	@Deprecated
	@Override
	public void atualizar(UnidadeFederativa param) throws SQLException {
		throw new SQLException("N�o ser� necess�rio atualizar UF, todas est�o mapeadas");
	}

	@Deprecated
	@Override
	public void remover(UnidadeFederativa param) throws SQLException {
		throw new SQLException("N�o ser� necess�rio remover UF, todas est�o mapeadas");
	}

	@Override
	public List<UnidadeFederativa> getTodos() throws SQLException {

		List<UnidadeFederativa> unidadeFederativaLista = new ArrayList<UnidadeFederativa>();
		
		String sql = "SELECT * FROM UNIDADE_FEDERATIVA";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Integer codigo = rs.getInt("COD_UF");
				String sigla = rs.getString("SIGLA");
				String descricao = rs.getString("DESCRICAO");
				
				UnidadeFederativa uf = new UnidadeFederativa(sigla, descricao, codigo);
				unidadeFederativaLista.add(uf);
			}
			return unidadeFederativaLista;
			
		} finally {
			finalizarConexoes(stmt, rs);
		}
	}
	
	@Override
	public UnidadeFederativa getPeloCodigo(Integer codigoUf) throws SQLException {
		
		String sql = "SELECT * FROM UNIDADE_FEDERATIVA WHERE COD_UF = ?";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, codigoUf);
			rs = stmt.executeQuery();
			
			UnidadeFederativa uf = null;
			if (rs.next()) {
				Integer codigo = rs.getInt("COD_UF");
				String sigla = rs.getString("SIGLA");
				String descricao = rs.getString("DESCRICAO");
				
				uf = new UnidadeFederativa(sigla, descricao, codigo);
			}
			return uf;
			
		} finally {
			finalizarConexoes(stmt, rs);
		}
	}

	@Override
	public void createTable() throws SQLException {
		String sql = "CREATE TABLE UNIDADE_FEDERATIVA ("
				+ "    COD_UF      		INTEGER NOT NULL,"
				+ "    DESCRICAO   		VARCHAR(100) NOT NULL,"
				+ "    SIGLA       		VARCHAR(2) NOT NULL,"
				+ "    CONSTRAINT 			PK_UNIDADE_FEDERATIVA PRIMARY KEY (COD_UF))";
		
		PreparedStatement stmt = null;
		
		try {
			
			stmt = getConexao().prepareStatement(sql);
			stmt.execute(sql);
			
		} finally {
			
			finalizarConexoes(stmt, null);
			
		}
		
	}
}