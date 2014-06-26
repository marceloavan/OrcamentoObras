package edu.asselvi.orcamentoobras.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Orcamento;
import edu.asselvi.orcamentoobras.model.dao.intf.IOrcamentoDao;

public class OrcamentoDao extends AbstractDao implements IOrcamentoDao {

	@Override
	public void inserir(Orcamento param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Orcamento param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Orcamento param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Orcamento> getTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orcamento getPeloCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createTable() throws SQLException {
		String sql = "CREATE TABLE ORCAMENTO ("
				+ "  	COD_ORCAMENTO 			INTEGER NOT NULL,"
				+ "  	CLIENTE 				INTEGER NOT NULL,"
				+ "  	TERRENO 				INTEGER NOT NULL,"
				+ "  	NOME 					VARCHAR(100) NOT NULL,"
				+ "  	DESCRICAO 				VARCHAR(100) NOT NULL,"
				+ "  	CUSTO_UNITARIO_BASICO 	INTEGER NOT NULL,"
				+ "  	METRAGEM_CONSTRUCAO 	DECIMAL(10,2) NOT NULL,"
				+ "  	PERCENTUAL_LUCRO 		DECIMAL(10,2) NOT NULL,"
				+ "  	CONSTRAINT 				PK_ORCAMENTO PRIMARY KEY (COD_ORCAMENTO),"
				+ "  	CONSTRAINT 				FK_ORCAMENTO_PESSOA FOREIGN KEY (CLIENTE) REFERENCES PESSOA(COD_PESSOA),"
				+ "  	CONSTRAINT				FK_ORCAMENTO_TERRENO FOREIGN KEY (TERRENO) REFERENCES TERRENO(COD_TERRENO))";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = getConexao().prepareStatement(sql);
			rs = stmt.executeQuery();
			
		} finally {
			
			finalizarConexoes(stmt, rs);
		}
	}
}
