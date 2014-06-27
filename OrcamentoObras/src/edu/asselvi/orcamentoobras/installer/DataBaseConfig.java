package edu.asselvi.orcamentoobras.installer;

import java.util.HashMap;
import java.util.Map;

import edu.asselvi.orcamentoobras.model.enumerator.EPropertieKeys;
import edu.asselvi.orcamentoobras.properties.PropertiesLocator;

/**
 * Cont�m m�todos para configura��o e cria��o da base de dados do sistema,
 * com uso aconselhavel em alguma UI.
 * 
 * @author Leandro Rebelo
 * @author Marcelo Avancini
 *
 */
public class DataBaseConfig {
	
	public Map<String, String> loadProperties() {
		
		Map<String, String> propMap = new HashMap<String, String>();
		propMap.put(EPropertieKeys.DB_HOST.getPropName(), PropertiesLocator.getPropValue(EPropertieKeys.DB_HOST.getPropName()));
		
		return propMap;
	}
	
	public void saveProperties(Map<String, String> propMap) {
		
	}

}
