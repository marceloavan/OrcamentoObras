package edu.asselvi.orcamentoobras.view.components.table.model;

import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Produto;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;

public class ProdutoModelConverter implements IModelConverter<Produto>{

	private int qtdColumns = 2;
	public List<Produto> produtoList;
	
	@Override
	public String[] getColumnNames() {
		return new String [] {"Código", "Descrição"};
	}

	@Override
	public Object[][] getData() {
		Object [][] objetcs;
		
		try {
			produtoList = DaoFactory.getInstance().getProdutoDao().getTodos();
		} catch (SQLException e) {
		}
		
		objetcs = new Object[produtoList.size()][qtdColumns];
		
		int row = 0;
		for (Produto produto : produtoList) {
			objetcs[row][0] = (Object) produto.getCodigo();
			objetcs[row][1] = (Object) produto.getDescricao();
			row++;
		}
		
		return objetcs;
	}

	@Override
	public Produto getObjectByRowIndex(int index) {
		return produtoList.get(index);
	}

}
