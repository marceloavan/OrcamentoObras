package edu.asselvi.orcamentoobrasw.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.asselvi.orcamentoobras.model.beans.Usuario;
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
		
		switch (action) {
			case "listar": {
				req.setAttribute("usuariosLista", usuarioService.getTodosUsuarios());
				rd = req.getRequestDispatcher(LISTA_USUARIO_PG);
				break;
			}
			
			case "deletar": {
				String userName = req.getParameter("userName");
				try {
					usuarioService.excluirUsuario(userName);
					req.setAttribute("usuariosLista", usuarioService.getTodosUsuarios());
				} catch (UsuarioNotFoundException e) {
				}
				rd = req.getRequestDispatcher(LISTA_USUARIO_PG);
				break;
			}
			
			case "editar": {
				Usuario usuario = usuarioService.getUsuarioPeloUserName(req.getParameter("userName"));
				
				req.setAttribute("inptLogin", usuario.getUserName());
				req.setAttribute("inptNomeComp", usuario.getNomeCompleto());
				req.setAttribute("action", action);
				req.setAttribute("isEdicao", true);
				rd = req.getRequestDispatcher(CADASTRO_USUARIO_PG);
				break;
			}
			
			case "cadastrar": {
				req.setAttribute("action", action);
				req.setAttribute("isEdicao", false);
				rd = req.getRequestDispatcher(CADASTRO_USUARIO_PG);
				break;
			}
			
			default: {
				rd = req.getRequestDispatcher(CADASTRO_USUARIO_PG);
				break;
			}
		}
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomeCompleto = req.getParameter("inptNomeComp");
		String userName = req.getParameter("inptLogin");
		String passwd = req.getParameter("inptPasswd");
		String action = req.getParameter("action");
		
		switch (action) {
			case "cadastrar": {
				try {
					usuarioService.cadastrarUsuario(new Usuario(userName, passwd, nomeCompleto));
				} catch (SQLException e) {
				}
				break;
			}
			
			case "editar": {
				try {
					usuarioService.atualizarUsuario(new Usuario(userName, passwd, nomeCompleto));
				} catch (SQLException e) {
				}
				break;
			}
		}
		resp.sendRedirect("UsuarioController?action=listar");
	}
}
