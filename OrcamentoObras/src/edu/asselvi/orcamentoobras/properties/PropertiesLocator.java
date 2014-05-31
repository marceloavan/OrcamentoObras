package edu.asselvi.orcamentoobras.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLocator {

	private static String propFileName = "config";
	private static Properties properties;
	
	private PropertiesLocator() { /* Singleton */ }
	
	public static String getPropValue(String key) {
		loadPropFile();
		try {
			return properties.getProperty(key);
		} catch (NullPointerException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static void setPropValue(String key, String value) {
		loadPropFile();
		properties.setProperty(key, value);
	}
	
	private static void loadPropFile() {
		if (properties == null) {
			String pathProp = System.getProperty("user.dir") + "\\properties\\" + propFileName + ".properties";
			File file = new File(pathProp);
			properties = new Properties();
			try {
				InputStream in = new FileInputStream(file);
				properties.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
