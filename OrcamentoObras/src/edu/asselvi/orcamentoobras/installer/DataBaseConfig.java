package edu.asselvi.orcamentoobras.installer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import edu.asselvi.orcamentoobras.model.dao.AbstractDao;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.IDaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IDao;
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
public class DataBaseConfig extends AbstractDao{
	
	private IDaoFactory daoFactory;
	private String currentDir;
	
	public DataBaseConfig() {
		daoFactory = DaoFactory.getInstance();
		currentDir = System.getProperty("user.dir");
	}
	
	public Map<String, String> loadProperties() {
		
		Map<String, String> propMap = new HashMap<String, String>();
		propMap.put(EPropertieKeys.DB_HOST.getPropName(), PropertiesLocator.getPropValue(EPropertieKeys.DB_HOST.getPropName()));
		
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
			st = getConexao().createStatement();
			
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
	
	public void demoDataBase() throws SQLException{
		
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
			st = getConexao().createStatement();
			
			for (int i = 0; i < inst.length; i++) {
				st.executeUpdate(inst[i]);
			}
			
		} catch (Exception e) {
			throw new SQLException("Não foi possível inserir os registros da base demonstração");
		} finally {
			if (st != null) st.close();
		}
	}
	
	private void validaDataBase() {
		// deverá verificar se o data base existe, se não, criar
		// ou tratar para perguntar ao usuário se ele quer criar, sei lá
	}
}
