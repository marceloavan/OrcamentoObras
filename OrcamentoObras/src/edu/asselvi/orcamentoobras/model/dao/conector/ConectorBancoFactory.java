package edu.asselvi.orcamentoobras.model.dao.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.dao.exception.ConnectionFailureException;
import edu.asselvi.orcamentoobras.model.enumerator.EPropertieKeys;
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

	private String url;
	private String user;
	private String passwd;
	private boolean parametersLoaded;
	
	private ConectorBancoFactory() {}
	
	public static ConectorBancoFactory getInstance() {
		return new ConectorBancoFactory();
	}
	
	/**
	 * Retorna conexão de acordo com o configuração no <b>user.dir/properties/config.properties</b>
	 * 
	 * @return
	 */
	public synchronized Connection getConexao() throws SQLException {
		
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
			throw new ConnectionFailureException(e.getMessage());
		}
	}
	
	/**
	 * Carrega os parametros necessários para a conexão
	 */
	private void loadParameters() {
		String host = PropertiesLocator.getPropValue(EPropertieKeys.DB_HOST.getPropName());
		String port = PropertiesLocator.getPropValue(EPropertieKeys.DB_PORT.getPropName());
		String base = PropertiesLocator.getPropValue(EPropertieKeys.DB_BASE.getPropName());
		
		url = "jdbc:mysql://" + host + ":" + port + "/" + (base == null ? "" : base.trim()); 
		user = PropertiesLocator.getPropValue(EPropertieKeys.DB_USER.getPropName());
		passwd = PropertiesLocator.getPropValue(EPropertieKeys.DB_PASSWD.getPropName());
		
		parametersLoaded = true;
	}
}