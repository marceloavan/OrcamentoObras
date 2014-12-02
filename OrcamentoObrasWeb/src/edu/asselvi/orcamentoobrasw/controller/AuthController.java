package edu.asselvi.orcamentoobrasw.controller;

import static edu.asselvi.orcamentoobrasw.session.SessionValidator.MESSAGE_NEW_SESSION;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.asselvi.orcamentoobras.service.UsuarioService;
import edu.asselvi.orcamentoobras.service.exception.PasswdInvalidException;
import edu.asselvi.orcamentoobras.service.exception.UsuarioNotFoundException;
import edu.asselvi.orcamentoobrasw.helper.PropertiesHelper;
import edu.asselvi.orcamentoobrasw.session.SessionValidator;

public class AuthController  extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService;
	private SessionValidator sessionValidator;
	
	public AuthController() {
		usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		sessionValidator = (SessionValidator) req.getSession().getAttribute("sessionValidator");
		String logout = req.getParameter("logout");
		if (logout.equals("1")) {
			cleanLogin();
			resp.sendRedirect(req.getContextPath()+"?logout=1");
		}
	}
	
	private void cleanLogin() {
		sessionValidator.setUltimaMovimentacao(null);
		sessionValidator.setUsuarioLogado(null);
		sessionValidator.setMessage(MESSAGE_NEW_SESSION);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		sessionValidator = SessionValidator.newInstance();
		PropertiesHelper.loadPropFile(req.getServletContext());
		
		String userName = req.getParameter("userNameLogin");
		String passwd = req.getParameter("passwdLogin");
		try {
			sessionValidator.setUsuarioLogado(usuarioService.validarLogin(userName, passwd));
			sessionValidator.setUltimaMovimentacao(new Date());
			
			req.getSession().setAttribute("sessionValidator", sessionValidator);
		} catch (UsuarioNotFoundException | PasswdInvalidException e) {
			req.setAttribute("errorMessage", e.getMessage());
			req.getRequestDispatcher("modules/login.jsp").forward(req, resp);
			return;
		}
		resp.sendRedirect(req.getContextPath());
	}
}
