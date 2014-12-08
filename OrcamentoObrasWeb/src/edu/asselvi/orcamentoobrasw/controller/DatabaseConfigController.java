package edu.asselvi.orcamentoobrasw.controller;

import java.io.IOException;
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
}