package edu.asselvi.orcamentoobras.model.dao.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.DBUtils;
import edu.asselvi.orcamentoobras.model.dao.exception.ConnectionFailureException;
import edu.asselvi.orcamentoobras.model.enumerator.EDataBase;
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
	
	private ConectorBancoFactory() {}
	
	private static ConectorBancoFactory INSTANCE;
	
	public static ConectorBancoFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ConectorBancoFactory();
		}
		return INSTANCE;
	}
	
	/**
	 * Retorna conexao de acordo com o configuracao
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
	 * Retorna conexao de acordo com parametros enviados
	 * 
	 * @return
	 */
	public synchronized Connection getConexao(String url, String user, String passwd) throws SQLException {
		
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
	 * Carrega os parametros necessarios para a conexao
	 */
	private void loadParameters() {
		String host = PropertiesLocator.getPropValue(EPropertieKeys.DB_HOST.getPropName());
		String port = PropertiesLocator.getPropValue(EPropertieKeys.DB_PORT.getPropName());
		String base = PropertiesLocator.getPropValue(EPropertieKeys.DB_BASE.getPropName());
		
		url =  DBUtils.gerarUrl(host, port, base, EDataBase.MYSQL); 
		user = PropertiesLocator.getPropValue(EPropertieKeys.DB_USER.getPropName());
		passwd = PropertiesLocator.getPropValue(EPropertieKeys.DB_PASSWD.getPropName());
		
		parametersLoaded = true;
	}
}