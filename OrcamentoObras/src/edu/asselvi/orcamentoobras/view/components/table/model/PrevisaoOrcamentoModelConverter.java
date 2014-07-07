package edu.asselvi.orcamentoobras.view.components.table.model;

import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Orcamento;
import edu.asselvi.orcamentoobras.model.beans.PrevisaoOrcamento;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;

public class PrevisaoOrcamentoModelConverter implements IModelConverter<PrevisaoOrcamento> {

	private Orcamento orcamento;
	private int qtdColumns = 2;
	private List<PrevisaoOrcamento> previsaoOrcamentosList;
	
	public PrevisaoOrcamentoModelConverter(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	
	@Override
	public String[] getColumnNames() {
		return new String[] {"Previsão", "Valor"};
	}

	@Override
	public Object[][] getData() {
		Object[][] objects;
		
		if (orcamento == null) {
			return new Object[][] {};
		}
		
		try {
			previsaoOrcamentosList = DaoFactory.getInstance().getPrevisaoOrcamentoDao().getPeloOrcamento(orcamento);
		} catch (SQLException e) {
		}

		objects = new Object[previsaoOrcamentosList.size()][qtdColumns];
		
		int row = 0;
		for (PrevisaoOrcamento previsaoOrcamento : previsaoOrcamentosList) {
			objects[row][0] = (Object) previsaoOrcamento.getPrevisao().getDescricao();
			objects[row][1] = (Object) previsaoOrcamento.getValor();
			row++;
		}
		return objects;
	}

	@Override
	public PrevisaoOrcamento getObjectByRowIndex(int index) {
		return previsaoOrcamentosList.get(index);
	}
}
