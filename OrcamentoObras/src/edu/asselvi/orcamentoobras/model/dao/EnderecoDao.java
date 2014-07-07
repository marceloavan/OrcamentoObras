package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Endereco;
import edu.asselvi.orcamentoobras.model.beans.Municipio;
import edu.asselvi.orcamentoobras.model.dao.intf.IEnderecoDao;

public class EnderecoDao extends AbstractDao implements IEnderecoDao {

	@Override
	public void inserir(Endereco param) throws SQLException {

		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ENDERECO");
		sb.append(" (LOGRADOURO, NUMERO, BAIRRO, CEP, MUNICIPIO)");
		sb.append(" VALUES (?, ?, ?, ?, ?)");

		String sql = sb.toString();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getConexao().prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, param.getLogradouro());
			stmt.setInt(2, param.getNumero());
			stmt.setString(3, param.getBairro());
			stmt.setLong(4, param.getCep());
			stmt.setInt(5, param.getMunicipio().getCodigo());

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
	public void atualizar(Endereco param) throws SQLException {

		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ENDERECO");
		sb.append(" SET LOGRADOURO = ?,");
		sb.append(" NUMERO = ?,");
		sb.append(" BAIRRO = ?,");
		sb.append(" CEP = ?,");
		sb.append(" MUNICIPIO = ?");
		sb.append(" WHERE COD_ENDERECO = ?");

		String sql = sb.toString();
		PreparedStatement stmt = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, param.getLogradouro());
			stmt.setInt(2, param.getNumero());
			stmt.setString(3, param.getBairro());
			stmt.setLong(4, param.getCep());
			stmt.setInt(5, param.getMunicipio().getCodigo());
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
	public void remover(Endereco param) throws SQLException {

		String sql = "DELETE FROM ENDERECO WHERE COD_ENDERECO = ?";

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
	public List<Endereco> getTodos() throws SQLException {
		List<Endereco> enderecoLista = new ArrayList<Endereco>();

		String sql = "SELECT * FROM ENDERECO";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = getConexao().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("COD_ENDERECO");
				String logradouro = rs.getString("LOGRADOURO");
				Integer numero = rs.getInt("NUMERO");
				String bairro = rs.getString("BAIRRO");
				Long cep = rs.getLong("CEP");
				Integer codigoMunicipio = rs.getInt("MUNICIPIO");
				
				Municipio municipio = getDaoFactory().getMunicipioDao()
						.getPeloCodigo(codigoMunicipio);

				Endereco endereco = new Endereco(logradouro, numero, bairro,
						municipio, cep);
				endereco.setId(id);
				enderecoLista.add(endereco);
			}

		} finally {
			finalizarConexoes(stmt, rs);
		}
		return enderecoLista;
	}

	@Override
	public Endereco getPeloCodigo(Integer codigo) throws SQLException {

		Endereco endereco = null;
		String sql = "SELECT * FROM ENDERECO WHERE COD_ENDERECO = ?";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, codigo);

			rs = stmt.executeQuery();
			while (rs.next()) {
				String logradouro = rs.getString("LOGRADOURO");
				Integer numero = rs.getInt("NUMERO");
				String bairro = rs.getString("BAIRRO");
				Long cep = rs.getLong("CEP");
				Integer codigoMunicipio = rs.getInt("MUNICIPIO");
				Municipio municipio = getDaoFactory().getMunicipioDao()
						.getPeloCodigo(codigoMunicipio);

				endereco = new Endereco(logradouro, numero, bairro, municipio,
						cep);
				endereco.setId(codigo);
			}

		} finally {
			finalizarConexoes(stmt, rs);
		}
		return endereco;
	}

	@Override
	public void createTable() throws SQLException {
		String sql = "CREATE TABLE ENDERECO ("
				+ "		COD_ENDERECO 		INTEGER AUTO_INCREMENT,"
				+ "  	LOGRADOURO 			VARCHAR(100),"
				+ "  	NUMERO 				INTEGER,"
				+ "  	BAIRRO 				VARCHAR(100),"
				+ "  	CEP 				INTEGER,"
				+ "  	MUNICIPIO 			INTEGER,"
				+ "  	CONSTRAINT 			PK_ENDERECO PRIMARY KEY (COD_ENDERECO),"
				+ "  	CONSTRAINT 			FK_ENDERECO_MUNICIPIO FOREIGN KEY (MUNICIPIO) REFERENCES MUNICIPIO(COD_MUNICIPIO))";

		PreparedStatement stmt = null;

		try {

			stmt = getConexao().prepareStatement(sql);
			stmt.execute(sql);

		} finally {
			
			finalizarConexoes(stmt, null);
		}

	}
}