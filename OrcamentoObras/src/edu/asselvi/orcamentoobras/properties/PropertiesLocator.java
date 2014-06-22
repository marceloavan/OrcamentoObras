package edu.asselvi.orcamentoobras.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Classe responsável pela interegação com arquivos de propriedades 
 * 
 * @author Marcelo Avancini
 *
 */
public class PropertiesLocator {

	private static String propFileName = "config";
	private static String pathProp = System.getProperty("user.dir") + "/properties/" + propFileName + ".properties";
	private static Properties properties;
	
	private PropertiesLocator() { /* Singleton */ }
	
	/**
	 * Retorna o valor de alguma propridade persistida no formato String
	 * 
	 * @param key
	 * @return
	 */
	public static String getPropValue(String key) {
		loadPropFile();
		try {
			return properties.getProperty(key);
		} catch (NullPointerException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * Seta (criar ou altera) o valor de alguma propriedade considerando a chave da propriedade
	 * e o valor que deverá ser persistido
	 * 
	 * @param key
	 * @param value
	 */
	public static void setPropValue(String key, String value) {
		setPropValue(key, value, true);
	}
	
	/**
	 * Método privado de persistencia que decide se o arquivo deverá ser salvo em disco
	 * ou se apenas ficará em memória. Utilizado internamente: no caso de uma lista, irá setar
	 * todos o itens e depois persistir em disco. Caso num envio unico, será persistido de imediado
	 * 
	 * @param key
	 * @param value
	 * @param storePropFile
	 */
	private static void setPropValue(String key, String value, boolean storePropFile) {
		loadPropFile();
		properties.setProperty(key, value);
		if (storePropFile) {
			storePropFile();
		}
		refreshProps();
	}
	
	/**
	 * Armazena uma lista de propriedades em memória e em ao final armazena em disco
	 * 
	 * @param props
	 */
	public static void setPropsValues(Map<String, String> props) {
		loadPropFile();
		for (String key : props.keySet()) {
			setPropValue(key, props.get(key), false);
		}
		storePropFile();
	}
	
	/**
	 * Carrega as propridades persistidas em disco caso ainda não tenham sido carregadas ainda
	 *  
	 */
	private static void loadPropFile() {
		if (properties == null) {
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
	
	/**
	 * Armazena as propriedades em disco
	 */
	private static void storePropFile() {
		File file = new File(pathProp);
		try {
			OutputStream out = new FileOutputStream(file);
			properties.store(out, "CONFIGURAÇÕES ALTERADAS EM:");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Possibilidade de recarregar as propriedades caso seja necessário
	 * 
	 */
	public static void refreshProps() {
		properties = null;
		loadPropFile();
	}
}