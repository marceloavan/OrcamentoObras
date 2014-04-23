package edu.asselvi.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.asselvi.model.Municipio;

public class MunicipioDao extends AbstractDao<Municipio> {

	@Override
	public void inserir(Municipio param) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO MUNICIPIO");
		sb.append(" (COD_MUNICIPIO, DESCRICAO, COD_UF)");
		sb.append(" VALUES (?, ?, ?)");
		
		String sql = sb.toString();
		
		PreparedStatement stmt = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setLong(1, param.getCodigo());
			stmt.setString(2, param.getDescricao());
			stmt.setInt(3, param.getUf().getCodigo());
			
			stmt.execute();

		} catch (SQLException e) {
			// TODO Criar exceção para Municipio nao cadastrado
		} finally {
			try {
				stmt.close();
				getConexao().close();
			} catch (SQLException e) {
				// TODO Criar exceção
			}
		}
	}

	@Override
	public void atualizar(Municipio param) {
		
	}
}