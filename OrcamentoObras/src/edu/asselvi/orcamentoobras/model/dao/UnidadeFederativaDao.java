package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.UnidadeFederativa;

public class UnidadeFederativaDao extends AbstractDao<UnidadeFederativa> {

	@Override
	public void inserir(UnidadeFederativa param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(UnidadeFederativa param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(UnidadeFederativa param) throws SQLException {
		// TODO Auto-generated method stub
		
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
			finalizarConexaoes(stmt, rs);
		}
	}
	
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
			finalizarConexaoes(stmt, rs);
		}
	}
}