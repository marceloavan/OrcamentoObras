package edu.asselvi.orcamentoobras.view.components.table.model;

import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;

public class PessoaModelConverter implements IModelConverter<AbstractPessoa>{

	private int qtdColumns = 2;
	public List<AbstractPessoa> pessoaList;
	
	@Override
	public String[] getColumnNames() {
		return new String[] {"Nome", "Documento"};
	}

	@Override
	public Object[][] getData() {
		Object[][] objects;
		
		try {
			pessoaList = DaoFactory.getInstance().getPessoaDao().getTodos();
		} catch (SQLException e) {
			
		}
		
		objects = new Object[pessoaList.size()][qtdColumns];
		
		int row = 0;
		for (AbstractPessoa pessoa : pessoaList) {
			objects[row][0] = (Object) pessoa.getNomeAbs();
			objects[row][1] = (Object) pessoa.getDocumento();
			row++;
		}
		
		return objects;
	}

	@Override
	public AbstractPessoa getObjectByRowIndex(int index) {
		return pessoaList.get(index);
	}

	
}
