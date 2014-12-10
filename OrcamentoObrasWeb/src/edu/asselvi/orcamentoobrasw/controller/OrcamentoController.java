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
import edu.asselvi.orcamentoobras.model.beans.CustoUnitarioBasico;
import edu.asselvi.orcamentoobras.model.beans.Orcamento;
import edu.asselvi.orcamentoobras.model.beans.Terreno;
import edu.asselvi.orcamentoobras.model.exception.MetragemConstrucaoMaiorTerrenoException;
import edu.asselvi.orcamentoobras.service.CustoUnitarioBasicoService;
import edu.asselvi.orcamentoobras.service.OrcamentoService;
import edu.asselvi.orcamentoobras.service.PessoaService;
import edu.asselvi.orcamentoobras.service.TerrenoService;

public class OrcamentoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String LISTA_ORCAMENTO_PG = "modules/orcamento/lista-orcamentos.jsp";
	private final String PAGE_ORCAMENTO = "modules/orcamento/orcamento-page.jsp";
	private final String CADASTRO_ORCAMENTO = "modules/orcamento/cadastro-orcamento.jsp";
	
	/*services*/
	private OrcamentoService orcamentoService;
	private CustoUnitarioBasicoService cubService;
	private TerrenoService terrenoService;
	private PessoaService pessoaService;
	
	public OrcamentoController() {
		orcamentoService = new OrcamentoService();
		cubService = new CustoUnitarioBasicoService();
		terrenoService = new TerrenoService();
		pessoaService = new PessoaService();
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
					req.setAttribute("action", action);
					setAttrOrcamento(req, orcamento);
					setListasEdicao(req, orcamento);
				} catch (SQLException e) {
				}
				rd = req.getRequestDispatcher(CADASTRO_ORCAMENTO);
				break;
			}
			
			case "gerenciar": {
				Integer orcamentoId = Integer.valueOf(req.getParameter("orcamentoId"));
				try {
					Orcamento orcamento = orcamentoService.getById(orcamentoId);
					setAttrOrcamento(req, orcamento);
					req.setAttribute("previsaoOrcamentoLista", orcamento.getPrevisaoList());
					
					rd = req.getRequestDispatcher(PAGE_ORCAMENTO);
				} catch (SQLException e) {
				}
				break;
			}

			case "cadastrar": {
				setListasCadastro(req);
				req.setAttribute("action", action);
				rd = req.getRequestDispatcher(CADASTRO_ORCAMENTO);
				break;
			}
			
			default: {
				break;
			}
		}
		rd.forward(req, resp);
	}

	private void setAttrOrcamento(HttpServletRequest req, Orcamento orcamento) {
		req.setAttribute("orcamentoId", orcamento.getId());
		req.setAttribute("inptNome", orcamento.getNome());
		req.setAttribute("inptDesc", orcamento.getDescricao());
		req.setAttribute("inptMetragemConst", orcamento.getMetragemConstrucao());
		req.setAttribute("inptCliente", orcamento.getCliente());
		req.setAttribute("inptTerreno", orcamento.getTerreno());
		req.setAttribute("inptCub", orcamento.getCub());
		req.setAttribute("inptLucro", orcamento.getPercentualLucro());
		req.setAttribute("inptValorVendaCub", String.format("%.2f", orcamento.getValorVendaCub()));
		req.setAttribute("inptValorVendaPrevisao", String.format("%.2f", orcamento.getValorVendaPrevisao()));
	}
	
	private void setListasCadastro(HttpServletRequest req) {
		List<AbstractPessoa> clienteLista = new ArrayList<AbstractPessoa>();
		List<Terreno> terrenoLista = new ArrayList<Terreno>();
		List<CustoUnitarioBasico> cubLista = new ArrayList<CustoUnitarioBasico>();
		
		clienteLista.add(null);
		clienteLista.addAll(pessoaService.getPessoas());
		
		terrenoLista.add(null);
		terrenoLista.addAll(terrenoService.getTerrenos());
		
		cubLista.add(null);
		cubLista.addAll(cubService.getCustos());
		
		req.setAttribute("clienteLista", clienteLista);
		req.setAttribute("terrenoLista", terrenoLista);
		req.setAttribute("cubLista", cubLista);
	}
	
	private void setListasEdicao(HttpServletRequest req, Orcamento orcamento) {
		Set<AbstractPessoa> clienteLista = new LinkedHashSet<AbstractPessoa>();
		Set<Terreno> terrenoLista = new LinkedHashSet<Terreno>();
		Set<CustoUnitarioBasico> cubLista = new LinkedHashSet<CustoUnitarioBasico>();
		
		clienteLista.add(orcamento.getCliente());
		clienteLista.addAll(pessoaService.getPessoas());
		
		terrenoLista.add(orcamento.getTerreno());
		terrenoLista.addAll(terrenoService.getTerrenos());
		
		cubLista.add(orcamento.getCub());
		cubLista.addAll(cubService.getCustos());
		
		req.setAttribute("clienteLista", clienteLista);
		req.setAttribute("terrenoLista", terrenoLista);
		req.setAttribute("cubLista", cubLista);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		String nome = req.getParameter("inptNome");
		String descricao = req.getParameter("inptDesc");
		Double metragemConstrucao = Double.valueOf(req.getParameter("inptMetragemConst"));
		Double percentualLucro = Double.valueOf(req.getParameter("inptLucro"));
		Integer codigoCub = Integer.valueOf(req.getParameter("cbCub"));
		Integer codigoTerreno = Integer.valueOf(req.getParameter("cbTerreno"));
		Integer codigoCliente = Integer.valueOf(req.getParameter("cbCliente"));
		
		CustoUnitarioBasico cub = cubService.getCubPeloCodigo(codigoCub);
		Terreno terreno = terrenoService.getPeloCodigo(codigoTerreno);
		AbstractPessoa cliente = pessoaService.getPeloCodigo(codigoCliente);
		
		switch (action) {
			case "cadastrar": {

				try {
					Orcamento orcamento = new Orcamento(nome, descricao, cub, terreno, metragemConstrucao);
					orcamento.setPercentualLucro(percentualLucro);
					orcamento.setCliente(cliente);
					orcamentoService.cadastrarOrcamento(orcamento);
				} catch (MetragemConstrucaoMaiorTerrenoException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
			
			case "editar": {
				Integer orcamentoId = Integer.valueOf(req.getParameter("orcamentoId"));
				Orcamento orcamento = null;
				try {
					orcamento = orcamentoService.getById(orcamentoId);
				
					orcamento.setNome(nome);
					orcamento.setDescricao(descricao);
					try {
						orcamento.setMetragemConstrucao(metragemConstrucao);
					} catch (MetragemConstrucaoMaiorTerrenoException e) {
					}
					orcamento.setPercentualLucro(percentualLucro);
					orcamento.setCub(cub);
					orcamento.setCliente(cliente);
					orcamento.setTerreno(terreno);

					orcamentoService.atualizarOrcamento(orcamento);

				} catch (SQLException e) {
				}
				break;
			}
		}
		resp.sendRedirect("OrcamentoController?action=listar");
	}
}
