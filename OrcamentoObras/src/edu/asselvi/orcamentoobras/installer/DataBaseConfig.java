package edu.asselvi.orcamentoobras.installer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import edu.asselvi.orcamentoobras.model.DBUtils;
import edu.asselvi.orcamentoobras.model.dao.conector.ConectorBancoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.IDaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IDao;
import edu.asselvi.orcamentoobras.model.enumerator.EDataBase;
import edu.asselvi.orcamentoobras.model.enumerator.EPropertieKeys;
import edu.asselvi.orcamentoobras.properties.PropertiesLocator;

/**
 * Contém métodos para configuração e criação da base de dados do sistema,
 * com uso aconselhavel em alguma UI.
 * 
 * @author Leandro Rebelo
 * @author Marcelo Avancini
 *
 */
public class DataBaseConfig {
	
	private IDaoFactory daoFactory;
	private String currentDir;
	private ConectorBancoFactory cbf;
	private Map<String, String> propMap = new HashMap<String, String>();
	
	public DataBaseConfig() {
		daoFactory = DaoFactory.getInstance();
		currentDir = System.getProperty("user.dir");
		cbf = ConectorBancoFactory.getInstance();
	}
	
	public Map<String, String> loadProperties() {
		propMap.put(EPropertieKeys.DB_HOST.getPropName(), PropertiesLocator.getPropValue(EPropertieKeys.DB_HOST.getPropName()));
		propMap.put(EPropertieKeys.DB_PORT.getPropName(), PropertiesLocator.getPropValue(EPropertieKeys.DB_PORT.getPropName()));
		propMap.put(EPropertieKeys.DB_BASE.getPropName(), PropertiesLocator.getPropValue(EPropertieKeys.DB_BASE.getPropName()));
		
		propMap.put(EPropertieKeys.DB_USER.getPropName(), PropertiesLocator.getPropValue(EPropertieKeys.DB_USER.getPropName()));
		propMap.put(EPropertieKeys.DB_PASSWD.getPropName(), PropertiesLocator.getPropValue(EPropertieKeys.DB_PASSWD.getPropName()));
		
		propMap.put(EPropertieKeys.DB_DATABASE_TYPE.getPropName(), PropertiesLocator.getPropValue(EPropertieKeys.DB_DATABASE_TYPE.getPropName()));
		
		return propMap;
	}
	
	public void saveProperties(Map<String, String> propMap) {
		
	}
	
	/**
	 * Método responsável por executar o createTable em todos os DAOs
	 * @throws SQLException 
	 */
	public void generateDataBase() throws SQLException {
		validaDataBase();
		for (IDao<?> dao : daoFactory.getTodosDaos()) {
			try {
				dao.createTable();
			} catch (SQLException e) {
				throw new SQLException("Problema ao criar tabela para o dao: "+dao.toString());
			}
		}
	}
	
	/**
	 * Método responsável por executar o script SQL referente a inserção do cadastro de UF e Municipios
	 * @throws SQLException
	 */
	public void insertDataBase() throws SQLException {
		
		String s = new String();
		StringBuilder sb = new StringBuilder();
		Statement st = null;
		
		try {

			FileReader fr = new FileReader(new java.io.File(currentDir + "/sql/mysql/insert"));
			
			BufferedReader br = new BufferedReader(fr);
			
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			br.close();
			
			String[] inst = sb.toString().split(";");
			st = cbf.getConexao().createStatement();
			
			for (int i = 0; i < inst.length; i++) {
				st.executeUpdate(inst[i]);
				System.out.println(inst[i]);
			}
			
		} catch (Exception e) {
			throw new SQLException("Não foi possível inserir os registros");
		} finally {
			if (st != null) st.close();
		}
	}
	
	public void demoDataBase() throws SQLException {
		
		String s = new String();
		StringBuilder sb = new StringBuilder();
		Statement st = null;
		
		try {
			FileReader fr = new FileReader(new File(currentDir + "/sql/mysql/demo"));
			
			BufferedReader br = new BufferedReader(fr);
			
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			br.close();
			
			String[] inst = sb.toString().split(";");
			st = cbf.getConexao().createStatement();
			
			for (int i = 0; i < inst.length; i++) {
				st.executeUpdate(inst[i]);
			}
			
		} catch (Exception e) {
			throw new SQLException("Não foi possível inserir os registros da base demonstração");
		} finally {
			if (st != null) st.close();
		}
	}
	
	private void validaDataBase() throws SQLException {
		String baseName = PropertiesLocator.getPropValue(EPropertieKeys.DB_BASE.getPropName());
		if(!dataBaseExist(baseName)) {
			createDataBase(baseName);
		}
	}
	
	private void createDataBase(String baseName) throws SQLException {
		loadProperties();

		String host = propMap.get(EPropertieKeys.DB_HOST.getPropName());
		String port = propMap.get(EPropertieKeys.DB_PORT.getPropName());
		String url = DBUtils.gerarUrl(host, port, null, EDataBase.MYSQL);
		String user = propMap.get(EPropertieKeys.DB_USER.getPropName());
		String passwd = propMap.get(EPropertieKeys.DB_PASSWD.getPropName());
		
		String sql = "CREATE DATABASE "+baseName;
		Connection conn = cbf.getConexao(url, user, passwd);
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.execute();
	}
	
	private boolean dataBaseExist(String baseName) throws SQLException {
		loadProperties();

		String host = propMap.get(EPropertieKeys.DB_HOST.getPropName());
		String port = propMap.get(EPropertieKeys.DB_PORT.getPropName());
		String url = DBUtils.gerarUrl(host, port, null, EDataBase.MYSQL);
		String user = propMap.get(EPropertieKeys.DB_USER.getPropName());
		String passwd = propMap.get(EPropertieKeys.DB_PASSWD.getPropName());
		
		DatabaseMetaData metaData = cbf.getConexao(url, user, passwd).getMetaData();
		ResultSet rs = metaData.getCatalogs();
		while (rs.next()) {
			if (rs.getString("TABLE_CAT").equals(baseName)) {
				return true;
			}
		}
		return false;
	}
}
