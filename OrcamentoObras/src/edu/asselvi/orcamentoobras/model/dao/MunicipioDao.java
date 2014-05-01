package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.Municipio;
import edu.asselvi.orcamentoobras.model.UnidadeFederativa;

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

	@Deprecated
	@Override
	public List<Municipio> getTodos() throws SQLException {
		
		List<Municipio> municipioLista = new ArrayList<Municipio>();

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM MUNICIPIO");
		String sql = sb.toString();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Long codigoMunicipio = rs.getLong("COD_MUNICIPIO");
				String descricao = rs.getString("DESCRICAO");
				Integer codigoUf = rs.getInt("COD_UF");
				UnidadeFederativa uf = getDaoFactory().getUnidadeFederativaDao().getPeloCodigo(codigoUf);
				municipioLista.add(new Municipio(codigoMunicipio, descricao, uf));
			}
			
		} finally {
			finalizarConexaoes(stmt, rs);
		}
		return municipioLista;
	}
}