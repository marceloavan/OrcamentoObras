package edu.asselvi.orcamentoobrasw.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.asselvi.orcamentoobras.model.beans.CustoUnitarioBasico;
import edu.asselvi.orcamentoobras.service.CustoUnitarioBasicoService;

public class CustoUnitarioBasicoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String LISTA_CUB_PG = "/modules/cadastro/cub/lista-cub.jsp";
	private final String CADASTRO_CUB_PG = "/modules/cadastro/cub/cadastro-cub.jsp";
	private CustoUnitarioBasicoService cubService;
	
	public CustoUnitarioBasicoController() {
		cubService = new CustoUnitarioBasicoService();
	}
	
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		RequestDispatcher rd = null;
		
		switch (action) {
			case "listar": {
				req.setAttribute("cubLista", cubService.getCustos());
				rd = req.getRequestDispatcher(LISTA_CUB_PG);
				break;
			}
			
			case "deletar": {
				Integer id = Integer.parseInt(req.getParameter("id"));
				try {
					cubService.excluirCub(id);
					req.setAttribute("cubLista", cubService.getCustos());
				} catch (SQLException e) {	
				} 
				rd = req.getRequestDispatcher(LISTA_CUB_PG);
				break;
			}
			
			case "editar": {
				CustoUnitarioBasico cub = cubService.getCubPeloCodigo(Integer.parseInt(req.getParameter("id")));
				
				req.setAttribute("inptId", cub.getId());
				req.setAttribute("inptMes", cub.getMes());
				req.setAttribute("inptAno", cub.getAno());
				req.setAttribute("inptValor", cub.getValorMetroQuadrado());
				req.setAttribute("action", action);
				req.setAttribute("isEdicao", true);
				rd = req.getRequestDispatcher(CADASTRO_CUB_PG);
				break;
			}
			
			case "cadastrar":{
				req.setAttribute("action", action);
				req.setAttribute("isEdicao", true);
				rd = req.getRequestDispatcher(CADASTRO_CUB_PG);
				break;
			}
			
			default : {
				rd = req.getRequestDispatcher(CADASTRO_CUB_PG);
				break;
			}
		}
		rd.forward(req, resp);
	}
	
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Integer mes = Integer.parseInt(req.getParameter("inptMes"));
		Integer ano = Integer.parseInt(req.getParameter("inptAno"));
		BigDecimal valor = new BigDecimal(req.getParameter("inptValor"));
		
		String action = req.getParameter("action");
		
		CustoUnitarioBasico cub = new CustoUnitarioBasico(valor, mes, ano);
		
		switch (action) {
			case "cadastrar": {
				try {
					cubService.inserirCub(cub);
				} catch (SQLException e) {
				}
				break;
			}
			
			case "editar": {
				try {
					Integer id = Integer.parseInt(req.getParameter("inptId"));
					cub.setId(id);
					cubService.atualizarCub(cub);					
				} catch (SQLException e) {
				}
			}
		}
		resp.sendRedirect("CustoUnitarioBasicoController?action=listar");
	}

}
