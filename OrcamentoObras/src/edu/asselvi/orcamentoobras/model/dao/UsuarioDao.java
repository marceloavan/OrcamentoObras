package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;




import edu.asselvi.orcamentoobras.model.Usuario;
import edu.asselvi.orcamentoobras.model.dao.intf.IUsuarioDao;

public class UsuarioDao extends AbstractDao implements IUsuarioDao {

	@Override
	public void inserir(Usuario param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Usuario param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Usuario param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> getTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
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
}
