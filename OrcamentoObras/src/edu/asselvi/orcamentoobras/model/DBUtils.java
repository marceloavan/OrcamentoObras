package edu.asselvi.orcamentoobras.model;

import edu.asselvi.orcamentoobras.model.enumerator.EDataBase;

public class DBUtils {

	public static String gerarUrl(String host, String port, String base, EDataBase dataBase) {
		String url = "";
		if (dataBase.equals(EDataBase.MYSQL)) {
			url += "jdbc:mysql://";
		}
		url += host + ":" + port + "/" + (base == null ? "" : base.trim());
		return url;
	}
	
}
