package edu.asselvi.orcamentoobrasw.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.asselvi.orcamentoobras.installer.DataBaseConfig;
import edu.asselvi.orcamentoobras.model.enumerator.EPropertieKeys;
import edu.asselvi.orcamentoobrasw.helper.PropertiesHelperWeb;

public class DatabaseConfigController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String CONFIG_DATABASE_PG = "modules/database-config.jsp";
	private DataBaseConfig databaseConfig;
	
	public DatabaseConfigController() {
		databaseConfig = new DataBaseConfig();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PropertiesHelperWeb.loadPropFile(req.getServletContext());

		String host = req.getParameter("inptHost");
		String port = req.getParameter("inptPort");
		String database = req.getParameter("inptDatabase");
		String user = req.getParameter("inptUsuario");
		String passwd = req.getParameter("inptPasswd");
		
		databaseConfig.saveProperties(makePropMap(host, port, database, user, passwd));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PropertiesHelperWeb.loadPropFile(req.getServletContext());

		Map<String, String> mapProps = databaseConfig.loadProperties();
		
		String action = req.getParameter("action");
		if (action.equals("configurar")) {
			req.setAttribute("inptHost", mapProps.get(EPropertieKeys.DB_HOST.getPropName()));
			req.setAttribute("inptPort", mapProps.get(EPropertieKeys.DB_PORT.getPropName()));
			req.setAttribute("inptDatabase", mapProps.get(EPropertieKeys.DB_BASE.getPropName()));
			req.setAttribute("inptUsuario", mapProps.get(EPropertieKeys.DB_USER.getPropName()));
		}
		
		req.getRequestDispatcher(CONFIG_DATABASE_PG).forward(req, resp);
	}
	
	private Map<String, String> makePropMap(String host, String port, String database, String user, String passwd) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put(EPropertieKeys.DB_HOST.getPropName(), host);
		map.put(EPropertieKeys.DB_PORT.getPropName(), port);
		map.put(EPropertieKeys.DB_BASE.getPropName(), database);
		map.put(EPropertieKeys.DB_USER.getPropName(), user);
		map.put(EPropertieKeys.DB_PASSWD.getPropName(), passwd);
		
		return map;
		
	}
}