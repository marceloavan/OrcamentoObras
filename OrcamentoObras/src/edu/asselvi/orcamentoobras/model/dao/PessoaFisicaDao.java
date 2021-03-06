package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Endereco;
import edu.asselvi.orcamentoobras.model.beans.PessoaFisica;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.IDaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IPessoaFisicaDao;

public class PessoaFisicaDao extends AbstractDao implements IPessoaFisicaDao {

	@Override
	public void inserir(PessoaFisica param) throws SQLException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO PESSOA (NOME_PESSOA, SOBRENOME_PESSOA, DOCUMENTO, TIPO_PESSOA)");
		sb.append(" VALUES (?, ?, ?, ?)");
		
		String sql = sb.toString();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, param.getNome());
			stmt.setString(2, param.getSobreNome());
			stmt.setString(3, param.getDocumento());
			stmt.setString(4, param.getTipoPessoa().getSigla().toString());
			
			int linhasAfetadas = stmt.executeUpdate();
	        if (linhasAfetadas == 0) {
	            throw new SQLException("Falha ao criar registro");
	        }
	        
	        rs = stmt.getGeneratedKeys();
	        if (rs.next()) {
	            param.setId(rs.getInt(1));
	        } else {
	            throw new SQLException("N�o foi possivel buscar a chave gerada");
	        }
			
		} finally {
			finalizarConexoes(stmt, rs);
		}
	}

	@Override
	public void atualizar(PessoaFisica param) throws SQLException {

		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE PESSOA");
		sb.append(" SET RAZAO_SOCIAL = '',");
		sb.append(" NOME_FANTASIA = '',");
		sb.append(" DOCUMENTO = ?,");
		sb.append(" NOME_PESSOA = ?,");
		sb.append(" SOBRENOME_PESSOA = ?,");
		sb.append(" ENDERECO = ?,");
		sb.append(" TIPO_PESSOA = ?");
		sb.append(" WHERE COD_PESSOA = ?");
		
		String sql = sb.toString();
		PreparedStatement stmt = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, param.getDocumento());
			stmt.setString(2, param.getNome());
			stmt.setString(3, param.getSobreNome());
			stmt.setInt(4, param.getEndereco().getId());
			stmt.setString(5, param.getTipoPessoa().getSigla().toString());
			stmt.setInt(6, param.getId());
			
			int linhasAfetadas = stmt.executeUpdate();
	        if (linhasAfetadas == 0) {
	            throw new SQLException("Falha ao atualizar registro");
	        }
			
		} finally {
			finalizarConexoes(stmt, null);
		}
	}

	@Override
	public void remover(PessoaFisica param) throws SQLException {

		String sql = "DELETE FROM PESSOA WHERE COD_PESSOA = ?";
		
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
	public List<PessoaFisica> getTodos() throws SQLException {

		List<PessoaFisica> listaPessoaFisica = new ArrayList<PessoaFisica>();
		
		String sql = "SELECT * FROM PESSOA WHERE TIPO_PESSOA = 'F'";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String nome = rs.getString("NOME_PESSOA");
				String sobreNome = rs.getString("SOBRENOME_PESSOA");
				String documento = rs.getString("DOCUMENTO");
				Integer codigoEndereco = rs.getInt("ENDERECO");
				
				IDaoFactory daoFactory = DaoFactory.getInstance();
				Endereco endereco = daoFactory.getEnderecoDao().getPeloCodigo(codigoEndereco);
				
				Integer codigoPessoaFisica = rs.getInt("COD_PESSOA");
				try {
					PessoaFisica pessoaFisica = new PessoaFisica(documento, endereco, nome, sobreNome);
					pessoaFisica.setId(codigoPessoaFisica);
					listaPessoaFisica.add(pessoaFisica);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return listaPessoaFisica;
	}

	@Override
	public void createTable() throws SQLException {
		String sql = "CREATE TABLE PESSOA ("
				+ "  	COD_PESSOA 			INTEGER AUTO_INCREMENT,"
				+ "  	ENDERECO 			INTEGER,"
				+ "  	TIPO_PESSOA 		CHAR(1),"
				+ "  	NOME_PESSOA 		VARCHAR(100),"
				+ "  	SOBRENOME_PESSOA 	VARCHAR(100),"
				+ "  	RAZAO_SOCIAL 		VARCHAR(100),"
				+ "  	NOME_FANTASIA 		VARCHAR(100),"
				+ "  	DOCUMENTO 			VARCHAR(100),"
				+ "  	CONSTRAINT 			PK_PESSOA PRIMARY KEY(COD_PESSOA),"
				+ "  	CONSTRAINT 			PESSOA_ENDERECO FOREIGN KEY (ENDERECO) REFERENCES ENDERECO(COD_ENDERECO),"
				+ "  	CONSTRAINT 			UK_PESSOA UNIQUE KEY (DOCUMENTO))";
		
		PreparedStatement stmt = null;
		
		try {
			
			stmt = getConexao().prepareStatement(sql);
			stmt.execute(sql);
			
		} finally {
			
			finalizarConexoes(stmt, null);
			
		}
		
	}

	@Override
	public PessoaFisica getPeloCodigo(Integer codigo) throws SQLException {
		String sql = "SELECT * FROM PESSOA WHERE COD_PESSOA = ? AND TIPO_PESSOA = 'F'";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Integer codigoEndereco = rs.getInt("ENDERECO");
				String nome = rs.getString("NOME_PESSOA");
				String sobreNome = rs.getString("SOBRENOME_PESSOA");
				String documento = rs.getString("DOCUMENTO");
				
				IDaoFactory daoFactory = DaoFactory.getInstance();
				Endereco endereco = daoFactory.getEnderecoDao().getPeloCodigo(codigoEndereco);
				try {
					PessoaFisica pessoa = new PessoaFisica(documento, endereco, nome, sobreNome);
					pessoa.setId(codigo);
					return pessoa;
				} catch (Exception e) {
					throw new SQLException("Base de dados n�o consistente");
				}
			}
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return null;
	}
}