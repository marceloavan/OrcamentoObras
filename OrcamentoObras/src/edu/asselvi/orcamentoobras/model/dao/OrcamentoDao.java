package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;
import edu.asselvi.orcamentoobras.model.beans.CustoUnitarioBasico;
import edu.asselvi.orcamentoobras.model.beans.Orcamento;
import edu.asselvi.orcamentoobras.model.beans.PrevisaoOrcamento;
import edu.asselvi.orcamentoobras.model.beans.Terreno;
import edu.asselvi.orcamentoobras.model.dao.intf.IOrcamentoDao;
import edu.asselvi.orcamentoobras.model.exception.MetragemConstrucaoMaiorTerrenoException;
import edu.asselvi.orcamentoobras.model.exception.TerrenoNullException;

public class OrcamentoDao extends AbstractDao implements IOrcamentoDao {

	@Override
	public void inserir(Orcamento param) throws SQLException {

		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ORCAMENTO");
		sb.append(" (CLIENTE, TERRENO, NOME, DESCRICAO,");
		sb.append(" CUSTO_UNITARIO_BASICO, METRAGEM_CONSTRUCAO, PERCENTUAL_LUCRO)");
		sb.append(" VALUES (?, ?, ?, ?, ?, ?, ?)");

		String sql = sb.toString();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			stmt = getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, param.getCliente().getId());
			stmt.setInt(2, param.getTerreno().getCodigo());
			stmt.setString(3, param.getNome());
			stmt.setString(4, param.getDescricao());
			stmt.setInt(5, param.getCub().getId());
			stmt.setDouble(6, param.getMetragemConstrucao());
			stmt.setDouble(7, param.getPercentualLucro());

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
	public void atualizar(Orcamento param) throws SQLException {

		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ORCAMENTO SET");
		sb.append(" CLIENTE = ?,");
		sb.append(" TERRENO = ?,");
		sb.append(" NOME = ?,");
		sb.append(" DESCRICAO = ?,");
		sb.append(" CUSTO_UNITARIO_BASICO = ?,");
		sb.append(" METRAGEM_CONSTRUCAO = ?,");
		sb.append(" PERCENTUAL_LUCRO = ?");
		sb.append(" WHERE COD_ORCAMENTO = ?");

		String sql = sb.toString();
		PreparedStatement stmt = null;

		try {

			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, param.getCliente().getId());
			stmt.setInt(2, param.getTerreno().getCodigo());
			stmt.setString(3, param.getNome());
			stmt.setString(4, param.getDescricao());
			stmt.setInt(5, param.getCub().getId());
			stmt.setDouble(6, param.getMetragemConstrucao());
			stmt.setDouble(7, param.getPercentualLucro());
			stmt.setInt(8, param.getId());

			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas == 0) {
				throw new SQLException("Falha ao atualiza registro");
			}

		} finally {

			finalizarConexoes(stmt, null);
		}

	}

	@Override
	public void remover(Orcamento param) throws SQLException {
		String sql = "DELETE FROM ORCAMENTO WHERE COD_ORCAMENTO = ?";

		PreparedStatement stmt = null;
		for (PrevisaoOrcamento item : param.getPrevisaoList()) {
			getDaoFactory().getPrevisaoOrcamentoDao().remover(item);
		}
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
	public List<Orcamento> getTodos() throws SQLException {
		
		List<Orcamento> orcamentoLista = new ArrayList<Orcamento>();

		String sql = "SELECT * FROM ORCAMENTO";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = getConexao().prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer id = rs.getInt("COD_ORCAMENTO");
				String nome = rs.getString("NOME");
				String descricao = rs.getString("DESCRICAO");
				Integer codigoCub = rs.getInt("CUSTO_UNITARIO_BASICO");
				Integer codigoTerreno = rs.getInt("TERRENO");
				Double metragemConstrucao = rs.getDouble("METRAGEM_CONSTRUCAO");
				Double percentualLucro = rs.getDouble("PERCENTUAL_LUCRO");
				Integer codigoCliente = rs.getInt("CLIENTE");
	
				CustoUnitarioBasico cub = getDaoFactory().getCubDao().getPeloCodigo(codigoCub);
				Terreno terreno = getDaoFactory().getTerrenoDao().getPeloCodigo(codigoTerreno);
				AbstractPessoa cliente = getDaoFactory().getPessoaDao().getPeloCodigo(codigoCliente);
	
				Orcamento orcamento = new Orcamento(nome, descricao, cub, terreno, metragemConstrucao);
				orcamento.setId(id);
				orcamento.setPercentualLucro(percentualLucro);
				orcamento.setCliente(cliente);
				
				List<PrevisaoOrcamento> previsaoList = getDaoFactory().getPrevisaoOrcamentoDao().getPeloOrcamento(orcamento);
				orcamento.setPrevisaoList(previsaoList);
				
				orcamentoLista.add(orcamento); 
			}

		} catch (MetragemConstrucaoMaiorTerrenoException e) {
			throw new SQLException(e.getMessage() + " Sua base de dados inconsistente");
		} catch (TerrenoNullException e) {
			throw new SQLException(e.getMessage() + " Sua base de dados inconsistente");
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return orcamentoLista;
	}

	@Override
	public Orcamento getPeloCodigo(Integer codigo) throws SQLException {
		
		Orcamento orcamento = null;
		String sql = "SELECT * FROM ORCAMENTO WHERE COD_ORCAMENTO = ?";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				Integer id = rs.getInt("COD_ORCAMENTO");
				String nome = rs.getString("NOME");
				String descricao = rs.getString("DESCRICAO");
				Integer codigoCub = rs.getInt("CUSTO_UNITARIO_BASICO");
				Integer codigoTerreno = rs.getInt("TERRENO");
				Double metragemConstrucao = rs.getDouble("METRAGEM_CONSTRUCAO");
				Double percentualLucro = rs.getDouble("PERCENTUAL_LUCRO");
				Integer codigoCliente = rs.getInt("CLIENTE");
				
				CustoUnitarioBasico cub = getDaoFactory().getCubDao().getPeloCodigo(codigoCub);
				Terreno terreno = getDaoFactory().getTerrenoDao().getPeloCodigo(codigoTerreno);
				AbstractPessoa cliente = getDaoFactory().getPessoaDao().getPeloCodigo(codigoCliente);
				
				orcamento = new Orcamento(nome, descricao, cub, terreno, metragemConstrucao);
				orcamento.setId(id);
				orcamento.setPercentualLucro(percentualLucro);
				orcamento.setCliente(cliente);
				
				List<PrevisaoOrcamento> previsaoList = getDaoFactory().getPrevisaoOrcamentoDao().getPeloOrcamento(orcamento);
				orcamento.setPrevisaoList(previsaoList);
				
			}
		} catch (MetragemConstrucaoMaiorTerrenoException e) {
			throw new SQLException(e.getMessage() + " Sua base de dados inconsistente");
		} catch (TerrenoNullException e) {
			throw new SQLException(e.getMessage() + " Sua base de dados inconsistente");
		} finally {
			finalizarConexoes(stmt, rs);
		}
		return orcamento;
	}

	@Override
	public void createTable() throws SQLException {
		String sql = "CREATE TABLE ORCAMENTO ("
				+ "  	COD_ORCAMENTO 			INTEGER AUTO_INCREMENT,"
				+ "  	CLIENTE 				INTEGER,"
				+ "  	TERRENO 				INTEGER,"
				+ "  	NOME 					VARCHAR(100),"
				+ "  	DESCRICAO 				VARCHAR(100),"
				+ "  	CUSTO_UNITARIO_BASICO 	INTEGER,"
				+ "  	METRAGEM_CONSTRUCAO 	DECIMAL(10,2),"
				+ "  	PERCENTUAL_LUCRO 		DECIMAL(10,2),"
				+ "  	CONSTRAINT 				PK_ORCAMENTO PRIMARY KEY (COD_ORCAMENTO),"
				+ "  	CONSTRAINT 				FK_ORCAMENTO_PESSOA FOREIGN KEY (CLIENTE) REFERENCES PESSOA(COD_PESSOA),"
				+ "  	CONSTRAINT				FK_ORCAMENTO_TERRENO FOREIGN KEY (TERRENO) REFERENCES TERRENO(COD_TERRENO),"
				+ "  	CONSTRAINT				FK_ORCAMENTO_CUB FOREIGN KEY (CUSTO_UNITARIO_BASICO) REFERENCES CUB(COD_CUB))";

		PreparedStatement stmt = null;

		try {

			stmt = getConexao().prepareStatement(sql);
			stmt.execute(sql);

		} finally {

			finalizarConexoes(stmt, null);
		}
	}

}
