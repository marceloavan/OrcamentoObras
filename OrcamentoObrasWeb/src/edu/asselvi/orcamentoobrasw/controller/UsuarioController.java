package edu.asselvi.orcamentoobrasw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.asselvi.orcamentoobras.service.UsuarioService;
import edu.asselvi.orcamentoobras.service.exception.UsuarioNotFoundException;

public class UsuarioController extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String LISTA_USUARIO_PG = "modules/cadastro/usuario/lista-usuario.jsp";
	private final String CADASTRO_USUARIO_PG = "modules/cadastro/usuario/cadastro-usuario.jsp";
	private UsuarioService usuarioService;
	
	public UsuarioController() {
		//TODO fazer factory de servicos
		usuarioService = new UsuarioService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		RequestDispatcher rd = null;
		
		if (action.equals("listarUsuarios")) {
			req.setAttribute("usuariosLista", usuarioService.getTodosUsuarios());
			rd = req.getRequestDispatcher(LISTA_USUARIO_PG);
		} else if (action.equals("deletar")) {
			String userName = req.getParameter("userName");
			try {
				usuarioService.excluirUsuario(userName);
				req.setAttribute("usuariosLista", usuarioService.getTodosUsuarios());
			} catch (UsuarioNotFoundException e) {
			}
			rd = req.getRequestDispatcher(LISTA_USUARIO_PG);
		} else {
			rd = req.getRequestDispatcher(CADASTRO_USUARIO_PG);
		}
		rd.forward(req, resp);
	}

}
