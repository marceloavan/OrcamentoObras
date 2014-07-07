package edu.asselvi.orcamentoobras.view.components.table.model;

import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Orcamento;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;

public class OrcamentoModelConverter implements IModelConverter<Orcamento> {

	private int qtdColumns = 2;
	private List<Orcamento> orcamentosList;
	
	@Override
	public String[] getColumnNames() {
		return new String[] {"Orcamento", "Terreno"};
	}

	@Override
	public Object[][] getData() {
		Object[][] objects;
		
		try {
			orcamentosList = DaoFactory.getInstance().getOrcamentoDao().getTodos();
		} catch (SQLException e) {
		}

		objects = new Object[orcamentosList.size()][qtdColumns];
		
		int row = 0;
		for (Orcamento orcamento : orcamentosList) {
			objects[row][0] = (Object) orcamento.getNome();
			objects[row][1] = (Object) orcamento.getTerreno().getDescricao();
			row++;
		}
		
		return objects;
	}

	@Override
	public Orcamento getObjectByRowIndex(int index) {
		Orcamento oldOrcamento = orcamentosList.get(index);
		Orcamento newOrcamento = null;
		try {
			newOrcamento = DaoFactory.getInstance().getOrcamentoDao().getPeloCodigo(oldOrcamento.getId());
		} catch (SQLException e) {
			return oldOrcamento;
		}
		orcamentosList.set(index, newOrcamento);
		return newOrcamento;
	}
}