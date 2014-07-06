package edu.asselvi.orcamentoobras.controller;

import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Produto;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.IDaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IProdutoDao;

public class ProdutoController {
	private IDaoFactory daoFactory = DaoFactory.getInstance();
	private IProdutoDao produtoDao;
	
	public ProdutoController (){
		produtoDao = daoFactory.getProdutoDao();
	}
	
	public List<Produto> getProdutos(){
		try {
			return produtoDao.getTodos();
		} catch (SQLException e){
		}
		return null;
	}
	
	public void cadastrarProduto (Produto produto) throws SQLException {
		produtoDao.inserir(produto);
	}
	
	public void atualizarProduto (Produto produto) throws SQLException {
		produtoDao.atualizar(produto);
	}
	
	public void removerProduto (Integer codigo) throws SQLException {
		Produto produto = daoFactory.getProdutoDao().getPeloCodigo(codigo);
		produtoDao.remover(produto);
	}

}
