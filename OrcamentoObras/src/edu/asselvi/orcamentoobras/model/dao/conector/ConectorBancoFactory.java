package edu.asselvi.orcamentoobras.model.dao.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.asselvi.orcamentoobras.properties.PropertiesLocator;

/**
 * Classe responsável por gerar os conectores para banco de dados
 * Caso seja necessário incluir outro DB, essa classe deverá ser
 * refatorada
 * 
 * @author Marcelo Avancini
 *
 */
public class ConectorBancoFactory {

	public Connection getConexao() {
		
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } 
		
		String url = PropertiesLocator.getPropValue("db.url");
		String user = PropertiesLocator.getPropValue("db.user");
		String passwd = PropertiesLocator.getPropValue("db.passwd");
		
		try {
			return DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
