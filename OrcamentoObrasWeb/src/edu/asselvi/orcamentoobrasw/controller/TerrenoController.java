package edu.asselvi.orcamentoobrasw.controller;

import java.io.IOException;
import java.math.BigDecimal;
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

import edu.asselvi.orcamentoobras.model.beans.Endereco;
import edu.asselvi.orcamentoobras.model.beans.Terreno;
import edu.asselvi.orcamentoobras.service.EnderecoService;
import edu.asselvi.orcamentoobras.service.TerrenoService;

public class TerrenoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String LISTA_TERRENO_PG = "/modules/cadastro/terreno/lista-terreno.jsp";
	private final String CADASTRO_TERRENO_PG = "/modules/cadastro/terreno/cadastro-terreno.jsp";
	private TerrenoService terrenoService;
	private EnderecoService enderecoService;
	
	public TerrenoController() {
		terrenoService = new TerrenoService();
		enderecoService = new EnderecoService();
	}
	
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		RequestDispatcher rd = null;
		
		switch (action) {
		case "listar": {
			req.setAttribute("terrenoLista", terrenoService.getTerrenos());
			rd = req.getRequestDispatcher(LISTA_TERRENO_PG);
			break;
		}
		case "deletar":{
			Integer id = Integer.parseInt(req.getParameter("id"));
			try {
				terrenoService.removerTerreno(id);
				req.setAttribute("terrenoLista", terrenoService.getTerrenos());
			} catch (SQLException e) {
			}
			rd = req.getRequestDispatcher(LISTA_TERRENO_PG);
			break;
		}
		
		case "editar": {
			Terreno terreno = terrenoService.getPeloCodigo(Integer.parseInt(req.getParameter("id")));
			
			req.setAttribute("inptCodigo", terreno.getCodigo());
			req.setAttribute("inptDescricao", terreno.getDescricao());
			req.setAttribute("inptMetragem", terreno.getMetragem());
			req.setAttribute("inptValorVenda", terreno.getValorVenda());
			req.setAttribute("inptValorITBI", terreno.getValorITBI());
			req.setAttribute("inptValorFRJ", terreno.getValorFRJ());
			req.setAttribute("inptValorEscritura", terreno.getValorEscritura());
			req.setAttribute("inptValorRegistro", terreno.getValorRegistro());
			req.setAttribute("action", action);
			
			Set<Endereco> enderecoLista = new LinkedHashSet<Endereco>();
			enderecoLista.add(terreno.getEndereco());
			enderecoLista.addAll(enderecoService.getTodos());
			
			req.setAttribute("enderecoLista", enderecoLista);

			rd = req.getRequestDispatcher(CADASTRO_TERRENO_PG);
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
			rd = req.getRequestDispatcher(CADASTRO_TERRENO_PG);
			break;
		}
		
		default: {
			rd = req.getRequestDispatcher(CADASTRO_TERRENO_PG);
			break;
		}	
		}
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String descricao = req.getParameter("inptDescricao");
		Double metragem = Double.parseDouble(req.getParameter("inptMetragem"));
		BigDecimal valorVenda = new BigDecimal(req.getParameter("inptValorVenda"));
		BigDecimal valorITBI = new BigDecimal(req.getParameter("inptValorITBI"));
		BigDecimal valorFRJ = new BigDecimal(req.getParameter("inptValorFRJ"));
		BigDecimal escritura = new BigDecimal(req.getParameter("inptValorEscritura"));
		BigDecimal registro = new BigDecimal(req.getParameter("inptValorRegistro"));
		Integer codigoEndereco = Integer.valueOf(req.getParameter("cbEndereco"));
		
		String action = req.getParameter("action");
		
		Endereco endereco = enderecoService.getById(codigoEndereco);
		
		Terreno terreno = new Terreno(descricao, valorVenda, endereco, metragem);
		terreno.setValorITBI(valorITBI);
		terreno.setValorFRJ(valorFRJ);
		terreno.setValorEscritura(escritura);
		terreno.setValorRegistro(registro);
		terreno.setEndereco(endereco);
	
		switch (action) {
		case "cadastrar": {
			try {
				terrenoService.cadastrarTerreno(terreno);
			} catch (SQLException e) {
			}
			break;
		}
		case "editar": {
			Integer codigo = Integer.parseInt(req.getParameter("inptCodigo"));
			terreno.setCodigo(codigo);
			try {
				terrenoService.atualizarTerreno(terreno);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		}
		resp.sendRedirect("TerrenoController?action=listar");
	}
	
}
