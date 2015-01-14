package edu.asselvi.orcamentoobrasw.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;

import javax.servlet.ServletContext;

import edu.asselvi.orcamentoobras.properties.PropertiesLocator;

/**
 * Classe auxiliar para carregar propriedades para web
 * 
 * @author marcelo
 *
 */
public class PropertiesHelperWeb {
	
	public static void loadPropFile(ServletContext context) {
		try {
			String filePath = context.getResource("/WEB-INF/properties/config.properties").getPath();
			File file = new File(filePath);
			PropertiesLocator.setInputStreamProp(new FileInputStream(file));
			PropertiesLocator.setOutputStreamProp(new FileOutputStream(file));
		} catch (FileNotFoundException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param key
	 */
	public static void getPropValue(String key) {
		PropertiesLocator.getPropValue(key);
	}
}