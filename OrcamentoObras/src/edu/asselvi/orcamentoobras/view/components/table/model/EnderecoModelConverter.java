package edu.asselvi.orcamentoobras.view.components.table.model;

import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Endereco;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;

public class EnderecoModelConverter implements IModelConverter<Endereco>{

	int qtdColumns = 2;
	public List<Endereco> enderecoList;
	
	@Override
	public String[] getColumnNames() {
		return new String[] {"Logradouro", "Bairro"};
	}

	@Override
	public Object[][] getData() {
		Object[][] objects;
		
		try {
			enderecoList = DaoFactory.getInstance().getEnderecoDao().getTodos();
		} catch (SQLException e) {
			e.getMessage();
		}
		
		int row = 0;
		objects = new Object[enderecoList.size()][qtdColumns];
		for (Endereco endereco : enderecoList) {
			objects[row][0] = (Object) endereco.getLogradouro();
			objects[row][1] = (Object) endereco.getBairro();
			row++;
		}
		return objects;
	}

	@Override
	public Endereco getObjectByRowIndex(int index) {
		return enderecoList.get(index);
	}

}
