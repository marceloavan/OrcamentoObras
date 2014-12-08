package edu.asselvi.orcamentoobrasw.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.asselvi.orcamentoobras.model.beans.CustoUnitarioBasico;
import edu.asselvi.orcamentoobras.model.beans.Orcamento;
import edu.asselvi.orcamentoobras.model.beans.Terreno;
import edu.asselvi.orcamentoobras.model.exception.MetragemConstrucaoMaiorTerrenoException;
import edu.asselvi.orcamentoobras.service.OrcamentoService;

public class OrcamentoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String LISTA_ORCAMENTO_PG = "modules/orcamento/lista-orcamentos.jsp";
	private final String PAGE_ORCAMENTO = "modules/orcamento/orcamento-page.jsp";
	private final String CADASTRO_ORCAMENTO = "modules/orcamento/cadastro-orcamento.jsp";
	private OrcamentoService orcamentoService;
	
	public OrcamentoController() {
		orcamentoService = new OrcamentoService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		RequestDispatcher rd = null;
		
		switch (action) {
			case "listar": {
				try {
					req.setAttribute("orcamentosLista", orcamentoService.getAllOrcamentos());
				} catch (SQLException e) {
				}
				rd = req.getRequestDispatcher(LISTA_ORCAMENTO_PG);
				break;
			}
			
			case "deletar": {
				Integer orcamentoId = Integer.valueOf(req.getParameter("orcamentoId"));
				try {
					orcamentoService.removerOrcamentoById(orcamentoId);
					req.setAttribute("orcamentosLista", orcamentoService.getAllOrcamentos());
					rd = req.getRequestDispatcher(LISTA_ORCAMENTO_PG);
				} catch (SQLException e) {
				}
				break;
			}
			
			case "editar": {
				Integer orcamentoId = Integer.valueOf(req.getParameter("orcamentoId"));
				try {
					Orcamento orcamento = orcamentoService.getById(orcamentoId);
					req.setAttribute("orcamento", orcamento);
				} catch (SQLException e) {
				}
				rd = req.getRequestDispatcher(PAGE_ORCAMENTO);
				break;
			}
			
			case "cadastrar": {
				rd = req.getRequestDispatcher(CADASTRO_ORCAMENTO);
				break;
			}
			
			default: {
				break;
			}
		}
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		String nome = req.getParameter("inptNome");
		String descricao = req.getParameter("inptDesc");
		Double metragemConstrucao = Double.valueOf(req.getParameter("inptMetragemConst"));
		
		CustoUnitarioBasico cub = null;
		Terreno terreno = null;
		
		
		switch (action) {
			case "cadastrar": {

				try {
					Orcamento orcamento = new Orcamento(nome, descricao, cub, terreno, metragemConstrucao);
					orcamentoService.cadastrarOrcamento(orcamento);
				} catch (MetragemConstrucaoMaiorTerrenoException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
			
			case "editar": {
				break;
			}
		}
		resp.sendRedirect("UsuarioController?action=listar");
	}
}
