package edu.asselvi.orcamentoobras.service;

import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Produto;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.IDaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IProdutoDao;

public class ProdutoService {
	private IDaoFactory daoFactory = DaoFactory.getInstance();
	private IProdutoDao produtoDao;
	
	public ProdutoService (){
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
	
	public Produto getPeloCodigo (Integer codigo) {
		try {
			return daoFactory.getProdutoDao().getPeloCodigo(codigo);
		} catch (SQLException e) {
		}
		return null;
	}

}
