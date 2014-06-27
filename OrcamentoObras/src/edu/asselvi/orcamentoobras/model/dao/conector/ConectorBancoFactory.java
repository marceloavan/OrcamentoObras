package edu.asselvi.orcamentoobras.model.dao.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.enumerator.EPropertieKeys;
import edu.asselvi.orcamentoobras.properties.PropertiesLocator;

/**
 * Classe respons�vel por gerar os conectores para banco de dados
 * Caso seja necess�rio incluir outro DB, essa classe dever� ser
 * refatorada
 * 
 * @author Marcelo Avancini
 *
 */
public class ConectorBancoFactory {

	private String url;
	private String user;
	private String passwd;
	private boolean parametersLoaded;
	
	/**
	 * Retorna conex�o de acordo com o configura��o no <b>user.dir/properties/config.properties</b>
	 * 
	 * @return
	 */
	public Connection getConexao() {
		
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } 
		
		if (!parametersLoaded) {
			loadParameters();
		}
		
		try {
			return DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Carrega os parametros necess�rios para a conex�o
	 */
	private void loadParameters() {
		String host = PropertiesLocator.getPropValue(EPropertieKeys.DB_HOST.getPropName());
		String port = PropertiesLocator.getPropValue(EPropertieKeys.DB_PORT.getPropName());
		String base = PropertiesLocator.getPropValue(EPropertieKeys.DB_BASE.getPropName());
		
		url = "jdbc:mysql://" + host + ":" + port + "/" + base; 
		user = PropertiesLocator.getPropValue(EPropertieKeys.DB_USER.getPropName());
		passwd = PropertiesLocator.getPropValue(EPropertieKeys.DB_PASSWD.getPropName());
		
		parametersLoaded = true;
	}
}
