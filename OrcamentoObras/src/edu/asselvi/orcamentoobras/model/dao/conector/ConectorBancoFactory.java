package edu.asselvi.orcamentoobras.model.dao.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por gerar os conectores para banco de dados
 * 
 * @author Marcelo
 *
 */
public class ConectorBancoFactory {

	public Connection getConexao() {
		
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } 
		
		String url = "";
		String user = "";
		String passwd = "";
		
		try {
			return DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
