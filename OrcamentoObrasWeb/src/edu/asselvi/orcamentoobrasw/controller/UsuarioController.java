package edu.asselvi.orcamentoobrasw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.asselvi.orcamentoobras.service.UsuarioService;

public class UsuarioController extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String LISTAR_USUARIO_PG = "modules/cadastro/usuario/cadastro-usuario.jsp";
	private UsuarioService usuarioService;
	
	public UsuarioController() {
		//TODO fazer factory de serviços
		usuarioService = new UsuarioService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action.equals("listarUsuarios")) {
			req.setAttribute("usuariosLista", usuarioService.getTodosUsuarios());
		}
		RequestDispatcher rd = req.getRequestDispatcher(LISTAR_USUARIO_PG);
		rd.forward(req, resp);
	}

}
