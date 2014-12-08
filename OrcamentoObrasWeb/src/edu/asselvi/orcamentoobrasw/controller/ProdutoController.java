package edu.asselvi.orcamentoobrasw.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.asselvi.orcamentoobras.model.beans.Produto;
import edu.asselvi.orcamentoobras.service.ProdutoService;

public class ProdutoController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String LISTA_PRODUTO_PG = "/modules/cadastro/produto/lista-produto.jsp";
	private final String CADASTRO_PRODUTO_PG = "/modules/cadastro/produto/cadastro-produto.jsp";
	private ProdutoService produtoService;
	
	public ProdutoController() {
		produtoService = new ProdutoService();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		RequestDispatcher rd = null;
		
		switch (action) {
		case "listar": {
			req.setAttribute("produtoLista", produtoService.getProdutos());
			rd = req.getRequestDispatcher(LISTA_PRODUTO_PG);
			break;
		}
		case "deletar": {
			Integer id = Integer.parseInt(req.getParameter("id"));
			try {
				produtoService.removerProduto(id);
				req.setAttribute("produtoLista", produtoService.getProdutos());
			} catch (SQLException e) {
			}
			rd = req.getRequestDispatcher(LISTA_PRODUTO_PG);
			 break;
		}
		case "editar": {
			Produto produto = produtoService.getPeloCodigo(Integer.parseInt(req.getParameter("id")));
			
			req.setAttribute("inptCodigo", produto.getCodigo());
			req.setAttribute("inptDescricao", produto.getDescricao());
			req.setAttribute("action", action);
			rd = req.getRequestDispatcher(CADASTRO_PRODUTO_PG);
			
			break;
		}
		
		case "cadastrar": {
			req.setAttribute("action", action);
			req.setAttribute("isEdicao", true);
			req.setAttribute("action", action);
			rd = req.getRequestDispatcher(CADASTRO_PRODUTO_PG);
			break;
		}
		default: {
			rd = req.getRequestDispatcher(CADASTRO_PRODUTO_PG);
			break;
		}	
		}
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		Integer codigo = Integer.parseInt(req.getParameter("inptCodigo"));
		String descricao = req.getParameter("inptDescricao");
		
		String action = req.getParameter("action");
		
		Produto produto = new Produto(codigo, descricao);
		
		switch (action) {
		case "cadastrar": {
			try {
				produtoService.cadastrarProduto(produto);
			} catch (SQLException e) {
			}
			break;
		}
		case "editar": {
			try {
				produtoService.atualizarProduto(produto);
			} catch (SQLException e) {
			}
			break;
		}
		}
		resp.sendRedirect("ProdutoController?action=listar");
	}
}
