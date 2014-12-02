package edu.asselvi.orcamentoobrasw.helper;

import java.io.InputStream;

import javax.servlet.ServletContext;

import edu.asselvi.orcamentoobras.properties.PropertiesLocator;

/**
 * Classe auxiliar para carregar propriedades para web
 * 
 * @author marcelo
 *
 */
public class PropertiesHelper {
	
	public static void loadPropFile(ServletContext context) {
		InputStream in = context.getResourceAsStream("/WEB-INF/properties/config.properties");
		PropertiesLocator.setInputStreamProp(in);
	}

}
