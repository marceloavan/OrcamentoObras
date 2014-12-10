package edu.asselvi.orcamentoobrasw.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.asselvi.orcamentoobras.model.beans.Orcamento;
import edu.asselvi.orcamentoobras.model.beans.Previsao;
import edu.asselvi.orcamentoobras.model.beans.PrevisaoOrcamento;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IPrevisaoDao;
import edu.asselvi.orcamentoobras.model.dao.intf.IPrevisaoOrcamentoDao;
import edu.asselvi.orcamentoobras.service.OrcamentoService;

public class PrevisaoOrcamentoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IPrevisaoDao previsaoDao;
	private IPrevisaoOrcamentoDao previsaoOrcamentoDao;
	private OrcamentoService orcamentoService;
	
	public PrevisaoOrcamentoController() {
		previsaoDao = DaoFactory.getInstance().getPrevisaoDao();
		previsaoOrcamentoDao = DaoFactory.getInstance().getPrevisaoOrcamentoDao();
		orcamentoService = new OrcamentoService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		String previsaoStr = req.getParameter("inptPrevisao");
		Double valorPrevisao = Double.valueOf(req.getParameter("inptValorPrevisao"));
		Integer orcamentoId = Integer.valueOf(req.getParameter("orcamentoId"));
		
		try {
			Previsao previsao = new Previsao(previsaoStr);
			previsaoDao.inserir(previsao);
			
			Orcamento orcamento = orcamentoService.getById(orcamentoId);
			PrevisaoOrcamento previsaoOrcamento = new PrevisaoOrcamento(new BigDecimal(valorPrevisao), previsao,orcamento);
			previsaoOrcamentoDao.inserir(previsaoOrcamento);
		} catch (SQLException e) {
		}
		
		resp.sendRedirect("OrcamentoController?action=gerenciar&orcamentoId=" + orcamentoId);
	}

}
