package edu.asselvi.orcamentoobras.installer;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
public class DataBaseConfig {
	
	private IDaoFactory daoFactory;
	
	public DataBaseConfig() {
		daoFactory = DaoFactory.getInstance();
	}
	
	public Map<String, String> loadProperties() {
		
		Map<String, String> propMap = new HashMap<String, String>();
		propMap.put(EPropertieKeys.DB_HOST.getPropName(), PropertiesLocator.getPropValue(EPropertieKeys.DB_HOST.getPropName()));
		
		return propMap;
	}
	
	public void saveProperties(Map<String, String> propMap) {
		
	}
	
	public void generateDataBase() {
		for (IDao<?> dao : daoFactory.getTodosDaos()) {
			try {
				dao.createTable();
			} catch (SQLException e) {
				System.out.println("Probela ao criar tabela para o dao: "+dao.toString());
			}
		}
	}

}
