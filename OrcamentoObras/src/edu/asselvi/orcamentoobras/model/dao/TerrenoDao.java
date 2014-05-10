package edu.asselvi.orcamentoobras.model.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.Endereco;
import edu.asselvi.orcamentoobras.model.Terreno;
import edu.asselvi.orcamentoobras.model.dao.intf.ITerrenoDao;

public class TerrenoDao extends AbstractDao implements ITerrenoDao {

	@Override
	public void inserir(Terreno param) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO TERRENO");
		sb.append(" (DESCRICAO, VALOR_VENDA, METRAGEM, VALOR_ITBI, VALOR_FRJ, VALOR_ESCRITURA, VALOR_REGISTRO, ENDERECO)");
		sb.append(" VALUES (?,?,?,?,?,?,?,?)");

		String sql = sb.toString();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = getConexao().prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, param.getDescricao());
			stmt.setBigDecimal(2, param.getValorVenda());
			stmt.setDouble(3, param.getMetragem());
			stmt.setBigDecimal(4, param.getValorITBI());
			stmt.setBigDecimal(5, param.getValorFRJ());
			stmt.setBigDecimal(6, param.getValorEscritura());
			stmt.setBigDecimal(7, param.getValorRegistro());
			stmt.setInt(8, param.getEndereco().getId());

			int linhasAlteradas = stmt.executeUpdate();
			if (linhasAlteradas == 0) {
				throw new SQLException("Falha ao criar registro");
			}

			rs = stmt.getGeneratedKeys();
			if (rs.next()) {

			} else {
				throw new SQLException("Nao foi possivel buscar a chave gerada");
			}
		} finally {
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
			getConexao().close();
		}

	}

	@Override
	public void atualizar(Terreno param) throws SQLException {
		StringBuilder sb = new StringBuilder();

		sb.append("UPDATE TERRENO");
		sb.append(" SET DESCRICAO = ?,");
		sb.append(" VALOR_VENDA = ?,");
		sb.append(" METRAGEM = ?,");
		sb.append(" VALOR_ITBI = ?,");
		sb.append(" VALOR_FRJ = ?");
		sb.append(" VALOR_ESCRITURA = ?");
		sb.append(" VALOR_REGISTRO = ?");
		sb.append(" ENDERECO = ?");
		sb.append(" WHERE COD_TERRENO = ?");

		String sql = sb.toString();

		PreparedStatement stmt = null;

		try {

			stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, param.getDescricao());
			stmt.setBigDecimal(2, param.getValorVenda());
			stmt.setDouble(3, param.getMetragem());
			stmt.setBigDecimal(4, param.getValorITBI());
			stmt.setBigDecimal(5, param.getValorFRJ());
			stmt.setBigDecimal(6, param.getValorEscritura());
			stmt.setBigDecimal(7, param.getValorRegistro());
			stmt.setInt(8, param.getEndereco().getId());
			stmt.setInt(9, param.getId());

			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas == 0) {
				throw new SQLException("Falha ao atualizar registro");
			}

		} finally {
			finalizarConexoes(stmt, null);
		}

	}

	@Override
	public void remover(Terreno param) throws SQLException {
		String sql = "DELETE FROM TERRENO WHERE COD_TERRENO = ?";

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
	public List<Terreno> getTodos() throws SQLException {
		List<Terreno> terrenoLista = new ArrayList<Terreno>();

		String sql = "SELECT * FROM TERRENO";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = getConexao().prepareStatement(sql);

			rs = stmt.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("COD_TERRENO");
				String descricao = rs.getString("DESCRICAO");
				Double metragem = rs.getDouble("METRAGEM");
				BigDecimal valorVenda = rs.getBigDecimal("VALOR_VENDA");
				BigDecimal valorITBI = rs.getBigDecimal("VALOR_ITBI");
				BigDecimal valorFRJ = rs.getBigDecimal("VALOR_FRJ");
				BigDecimal valorEscritura = rs.getBigDecimal("VALOR_ESCRITURA");
				BigDecimal valorRegistro = rs.getBigDecimal("VALOR_REGISTRO");
				Integer codigoEndereco = rs.getInt("ENDERECO");
				Endereco endereco = getDaoFactory().getEnderecoDao()
						.getPeloCodigo(codigoEndereco);

				Terreno terreno = new Terreno(id, descricao, valorVenda,
						endereco, metragem);
				terreno.setValorITBI(valorITBI);
				terreno.setValorFRJ(valorFRJ);
				terreno.setValorEscritura(valorEscritura);
				terreno.setValorRegistro(valorRegistro);
				terrenoLista.add(terreno);
			}

		} finally {
			finalizarConexoes(stmt, rs);
		}
		return terrenoLista;
	}

	@Override
	public Terreno getPeloCodigo(Integer codigo) throws SQLException {

		Terreno terreno = null;
		String sql = "SELECT * FROM TERRENO WHERE COD_TERRENO = ?";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, codigo);

			rs = stmt.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt("COD_TERRENO");
				String descricao = rs.getString("DESCRICAO");
				Double metragem = rs.getDouble("METRAGEM");
				BigDecimal valorVenda = rs.getBigDecimal("VALOR_VENDA");
				BigDecimal valorITBI = rs.getBigDecimal("VALOR_ITBI");
				BigDecimal valorFRJ = rs.getBigDecimal("VALOR_FRJ");
				BigDecimal valorEscritura = rs.getBigDecimal("VALOR_ESCRITURA");
				BigDecimal valorRegistro = rs.getBigDecimal("VALOR_REGISTRO");
				Integer codigoEndereco = rs.getInt("ENDERECO");
				Endereco endereco = getDaoFactory().getEnderecoDao()
						.getPeloCodigo(codigoEndereco);

				terreno = new Terreno(id, descricao, valorVenda, endereco,
						metragem);
				terreno.setValorITBI(valorITBI);
				terreno.setValorFRJ(valorFRJ);
				terreno.setValorEscritura(valorEscritura);
				terreno.setValorRegistro(valorRegistro);
			}

		} finally {
			finalizarConexoes(stmt, rs);
		}
		return terreno;
	}

}
