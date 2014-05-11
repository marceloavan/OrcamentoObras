package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.Produto;
import edu.asselvi.orcamentoobras.model.dao.intf.IProdutoDao;

public class ProdutoDao extends AbstractDao implements IProdutoDao {

	private PreparedStatement stmt;

	@Override
	public void inserir(Produto param) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO PRODUTO");
		sb.append(" (DESCRICAO)");
		sb.append("VALUES (?)");

		String sql = sb.toString();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = getConexao().prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, param.getDescricao());

			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas == 0) {
				throw new SQLException("Falha ao criar registro");
			}

			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				param.setCodigo(rs.getInt(1));
			} else {
				throw new SQLException("Não foi possivel buscar a chave gerada");
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
	public void atualizar(Produto param) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE PRODUTO");
		sb.append("SET DESCRICAO = ?");
		sb.append("WHERE COD_PRODUTO = ?");

		String sql = sb.toString();

		stmt = null;
		try {
			stmt.getConnection().prepareStatement(sql);
			stmt.setString(1, param.getDescricao());
			stmt.setInt(2, param.getCodigo());

			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas == 0) {
				throw new SQLException("Falha ao atualizar registro");
			}
		} finally {
			finalizarConexoes(stmt, null);

		}
	}

	@Override
	public void remover(Produto param) throws SQLException {

		String sql = "DELETE FROM PRODUTOS WHERE COD_PRODUTO = ?";

		PreparedStatement stmt = null;

		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, param.getCodigo());

			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas == 0) {
				throw new SQLException("Falha ao remover registro");
			}
		} finally {
			finalizarConexoes(stmt, null);
		}

	}

	@Override
	public List<Produto> getTodos() throws SQLException {
		List<Produto> produtoLista = new ArrayList<Produto>();

		String sql = "SELECT * FROM PRODUTO";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = getConexao().prepareStatement(sql);

			rs = stmt.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("COD_PRODUTO");
				String descricao = rs.getString("DESCRICAO");

				Produto produto = new Produto(id, descricao);
				produto.setCodigo(id);
				produtoLista.add(produto);
			}

		} finally {
			finalizarConexoes(stmt, rs);
		}
		return produtoLista;
	}

	@Override
	public Produto getPeloCodigo(Integer codigo) throws SQLException {

		Produto produto = null;
		String sql = "SELECT * FROM PRODUTO WHERE COD_PRODUTO = ?";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, codigo);

			rs = stmt.executeQuery();

			if (rs.next()) {
				Integer id = rs.getInt("COD_PRODUTO");
				String descricao = rs.getString("DESCRICAO");

				produto = new Produto(id, descricao);
				produto.setCodigo(id);
			}
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return produto;
	}

}
