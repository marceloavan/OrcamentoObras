package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Endereco;
import edu.asselvi.orcamentoobras.model.beans.PessoaJuridica;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.IDaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IPessoaJuridicaDao;

public class PessoaJuridicaDao extends AbstractDao implements IPessoaJuridicaDao {

	@Override
	public void inserir(PessoaJuridica param) throws SQLException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO PESSOA (NOME_FANTASIA, RAZAO_SOCIAL, DOCUMENTO, TIPO_PESSOA)");
		sb.append(" VALUES (?, ?, ?, ?)");
		
		String sql = sb.toString();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, param.getNomeFantasia());
			stmt.setString(2, param.getRazaoSocial());
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
	            throw new SQLException("Nao foi possivel buscar a chave gerada");
	        }
			
		} finally {
			finalizarConexoes(stmt, rs);
		}
		
	}

	@Override
	public void atualizar(PessoaJuridica param) throws SQLException {

		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE PESSOA");
		sb.append(" SET RAZAO_SOCIAL = ?,");
		sb.append(" NOME_FANTASIA = ?,");
		sb.append(" DOCUMENTO = ?,");
		sb.append(" NOME_PESSOA = '',");
		sb.append(" SOBRENOME_PESSOA = '',");
		sb.append(" ENDERECO = ?,");
		sb.append(" TIPO_PESSOA = ?");
		sb.append(" WHERE COD_PESSOA = ?");
		
		String sql = sb.toString();
		PreparedStatement stmt = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, param.getRazaoSocial());
			stmt.setString(2, param.getNomeFantasia());
			stmt.setString(3, param.getDocumento());
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
	public void remover(PessoaJuridica param) throws SQLException {

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
	public List<PessoaJuridica> getTodos() throws SQLException {
		List<PessoaJuridica> listaPessoaJuridica = new ArrayList<PessoaJuridica>();
		
		String sql = "SELECT * FROM PESSOA WHERE TIPO_PESSOA = 'J'";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String nomeFantasia = rs.getString("NOME_FANTASIA");
				String razaoSocial = rs.getString("RAZAO_SOCIAL");
				String documento = rs.getString("DOCUMENTO");
				Integer codigoEndereco = rs.getInt("ENDERECO");
				
				IDaoFactory daoFactory = DaoFactory.getInstance();
				Endereco endereco = daoFactory.getEnderecoDao().getPeloCodigo(codigoEndereco);
				
				Integer codigoPessoaFisica = rs.getInt("COD_PESSOA");
				try {
					PessoaJuridica pessoaJuridica = new PessoaJuridica(documento, endereco, nomeFantasia, razaoSocial);
					pessoaJuridica.setId(codigoPessoaFisica);
					listaPessoaJuridica.add(pessoaJuridica);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return listaPessoaJuridica;
	}

	@Override
	public void createTable() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PessoaJuridica getPeloCodigo(Integer codigo) throws SQLException {
		String sql = "SELECT * FROM PESSOA WHERE COD_PESSOA = ? AND TIPO_PESSOA = 'J'";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Integer codigoEndereco = rs.getInt("ENDERECO");
				String razaoSocial = rs.getString("RAZAO_SOCIAL");
				String nomeFantasia = rs.getString("NOME_FANTASIA");
				String documento = rs.getString("DOCUMENTO");
				
				IDaoFactory daoFactory = DaoFactory.getInstance();
				Endereco endereco = daoFactory.getEnderecoDao().getPeloCodigo(codigoEndereco);
				try {
					PessoaJuridica pessoa = new PessoaJuridica(documento, endereco, razaoSocial, nomeFantasia);
					pessoa.setId(codigo);
					return pessoa;
				} catch (Exception e) {
					throw new SQLException("Base de dados não consistente");
				}
			}
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return null;
	}
}