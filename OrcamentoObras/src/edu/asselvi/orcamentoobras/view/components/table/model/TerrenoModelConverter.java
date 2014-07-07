package edu.asselvi.orcamentoobras.view.components.table.model;

import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Terreno;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;

public class TerrenoModelConverter implements IModelConverter<Terreno>{
	
	private int qtdColumns = 2;
	public List<Terreno> terrenoList;
	
	@Override
	public String[] getColumnNames() {
		return new String[] {"Descrição","Metragem"};
	}

	@Override
	public Object[][] getData() {
		Object[][] objects;
		
		try {
			terrenoList = DaoFactory.getInstance().getTerrenoDao().getTodos();
		} catch (SQLException e) {
			e.getMessage();
		}
		
		int row = 0;
		objects = new Object[terrenoList.size()][qtdColumns];
		
		for (Terreno terreno : terrenoList) {
			objects[row][0] = (Object) terreno.getDescricao();
			objects[row][1] = (Object) terreno.getMetragem();
			row++;
		}
		return objects;
	}

	@Override
	public Terreno getObjectByRowIndex(int index) {
		return terrenoList.get(index);
	}

}
