package edu.asselvi.orcamentoobrasw.controller;

import java.io.IOException;
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
	
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		RequestDispatcher rd = null;
		
		switch ("action") {
			case "listar": {
				req.setAttribute("cubLista", cubService.getCustos());
				rd = req.getRequestDispatcher(LISTA_CUB_PG);
				break;
			}
			
			case "deletar": {
				Integer codigo = Integer.parseInt(req.getParameter("codCub"));
				try {
					cubService.excluirCub(codigo);
					req.setAttribute("cubLista", cubService.getCustos());
				} catch (SQLException e) {	
				} 
				rd = req.getRequestDispatcher(LISTA_CUB_PG);
				break;
			}
			
			case "editar": {
				CustoUnitarioBasico cub = cubService.getCubPeloCodigo(Integer.parseInt(req.getParameter("")));
				
				req.setAttribute("", cub.getId());
				req.setAttribute("", cub.getMes());
				req.setAttribute("", cub.getAno());
				req.setAttribute("", cub.getValorMetroQuadrado());
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
		Integer mes = Integer.parseInt(req.getParameter(""));
		Integer ano = Integer.parseInt(req.getParameter(""));
		//BigDecimal valor = 
		String action = req.getParameter("action");
		
		switch (action) {
			case "cadastrar": {
				try {
					cubService.inserirCub(new CustoUnitarioBasico(null, mes, ano));
				} catch (SQLException e) {
				}
				break;
			}
			
			case "editar": {
				try {
					cubService.atualizarCub(new CustoUnitarioBasico(null, mes, ano));
				} catch (SQLException e) {
				}
			}
		}
		resp.sendRedirect("CustoUnitarioBasicoController?action=listar");
	}

}
