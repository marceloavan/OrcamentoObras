package edu.asselvi.orcamentoobrasw.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;
import edu.asselvi.orcamentoobras.model.beans.Endereco;
import edu.asselvi.orcamentoobras.service.EnderecoService;
import edu.asselvi.orcamentoobras.service.PessoaService;

public class PessoaController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String LISTA_PESSOA_PG = "";
	private final String CADASTRO_PESSOA_PG = "";
	PessoaService pessoaService;
	EnderecoService enderecoService;
	
	public PessoaController() {
		pessoaService = new PessoaService();
		enderecoService =  new EnderecoService();
	}
	
	protected void doGet(HttpServletResponse resp, HttpServletRequest req) throws ServletException, IOException {
		String action = req.getParameter("action");
		RequestDispatcher rd = null;
		
		switch (action) {
			
			
		case "listar": {
			req.setAttribute("pessoaLista", pessoaService.getPessoas());
			rd = req.getRequestDispatcher(LISTA_PESSOA_PG);
			break;
		}
		
		case "deletar": {
			Integer id = Integer.parseInt(req.getParameter("id"));
			try {
				pessoaService.removerPessoa(id);
				req.setAttribute("pessoaLista", pessoaService.getPessoas());
			} catch (SQLException e) {
			}
			rd = req.getRequestDispatcher(LISTA_PESSOA_PG);
			break;
		}
		
		case "editar": {
			AbstractPessoa pessoa = pessoaService.getPeloCodigo(Integer.parseInt("id"));
			
			Set<Endereco> enderecoLista = new LinkedHashSet<Endereco>();
			enderecoLista.add(pessoa.getEndereco());
			enderecoLista.addAll(enderecoService.getTodos());
			
			req.setAttribute("enderecoLista", enderecoLista);
			
			break;
		}
		
		case "cadastrar": {
			req.setAttribute("action", action);
			req.setAttribute("isEdicao", true);
			
			List<Endereco> enderecoLista = new ArrayList<Endereco>();
			enderecoLista.add(null);
			enderecoLista.addAll(enderecoService.getTodos());
			req.setAttribute("enderecoLista", enderecoLista);
			req.setAttribute("action", action);
			rd = req.getRequestDispatcher(CADASTRO_PESSOA_PG);
			break;
		}
		
		default: {
			rd = req.getRequestDispatcher(CADASTRO_PESSOA_PG);
		}
		}
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String action = req.getParameter("action");
		
		switch (action) {
		case "cadastrar": {
			break;
		}
		
		case "editar": {
			break;
		}
		}
		resp.sendRedirect("PessoaController?action=listar");
	}

}
