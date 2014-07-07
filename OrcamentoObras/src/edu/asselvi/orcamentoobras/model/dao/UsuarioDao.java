package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;







import edu.asselvi.orcamentoobras.model.beans.Usuario;
import edu.asselvi.orcamentoobras.model.dao.intf.IUsuarioDao;

public class UsuarioDao extends AbstractDao implements IUsuarioDao {

	@Override
	public void inserir(Usuario param) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO USUARIOS");
		sb.append(" (USER_NAME, PASSWD, NOME_COMP)");
		sb.append(" VALUES (?, ?, ?)");
		
		String sql = sb.toString();
		PreparedStatement stmt = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, param.getUserName());
			stmt.setString(2, param.getPasswd());
			stmt.setString(3, param.getNomeCompleto());
			
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
	public void atualizar(Usuario param) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE USUARIOS SET");
		sb.append(" PASSWD = ?, NOME_COMP = ?");
		sb.append(" WHERE USER_NAME = ?");
		
		String sql = sb.toString();
		PreparedStatement stmt = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, param.getPasswd());
			stmt.setString(2, param.getNomeCompleto());
			stmt.setString(3, param.getUserName());
			
			int linhasAfetadas = stmt.executeUpdate();
	        if (linhasAfetadas == 0) {
	            throw new SQLException("Falha ao atualizar registro");
	        }
	        
		} finally {
			if (stmt != null) stmt.close();
			getConexao().close();
		}
	}

	@Override
	public void remover(Usuario param) throws SQLException {
		String sql = "DELETE FROM USUARIOS WHERE USER_NAME = ?";
		PreparedStatement stmt = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, param.getUserName());
			stmt.executeUpdate();
		} finally {
			finalizarConexoes(stmt, null);
		}
		
	}

	@Override
	public List<Usuario> getTodos() throws SQLException {
		List<Usuario> usuariosList = new ArrayList<Usuario>();
		String sql = "SELECT USER_NAME, PASSWD, NOME_COMP FROM USUARIOS";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String userName = rs.getString("USER_NAME");
				String passwd = rs.getString("PASSWD");
				String nomeCompleto = rs.getString("NOME_COMP");
				usuariosList.add(new Usuario(userName, passwd, nomeCompleto));
			}
			return usuariosList;
			
		} finally {
			finalizarConexoes(stmt, rs);
		}
	}

	@Override
	public Usuario getPeloUserName(String userName) throws SQLException {

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT USER_NAME, PASSWD, NOME_COMP FROM USUARIOS");
		sb.append(" WHERE USER_NAME = ?");
		String sql = sb.toString();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, userName);
			
			rs = stmt.executeQuery();
			Usuario usuario = null;
			if (rs.next()) {
				String passwd = rs.getString("PASSWD");
				String nomeCompleto = rs.getString("NOME_COMP");
				usuario = new Usuario(userName, passwd, nomeCompleto);
			}
			return usuario;
			
		} finally {
			finalizarConexoes(stmt, rs);
		}
	}

	@Override
	public void createTable() throws SQLException {
		String sql = "CREATE TABLE USUARIOS ("
				+ "	USER_NAME			VARCHAR(50),"
				+ "	PASSWD				VARCHAR(255),"
				+ "	NOME_COMP			VARCHAR(100),"
				+ "	CONSTRAINT 			PK_USUARIOS PRIMARY KEY(USER_NAME));";
		
		PreparedStatement stmt = null;
		
		try {
			
			stmt = getConexao().prepareStatement(sql);
			stmt.execute(sql);
			
		} finally {
			
			finalizarConexoes(stmt, null);
			
		}
		
	}
}
