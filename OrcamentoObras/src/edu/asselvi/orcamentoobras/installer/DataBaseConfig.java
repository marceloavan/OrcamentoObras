package edu.asselvi.orcamentoobras.installer;

import java.util.HashMap;
import java.util.Map;

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
	
	public Map<String, String> loadProperties() {
		
		Map<String, String> propMap = new HashMap<String, String>();
		propMap.put("db.host", PropertiesLocator.getPropValue("db.host"));
		
		return propMap;
	}
	
	public void saveProperties(Map<String, String> propMap) {
		
	}

}
