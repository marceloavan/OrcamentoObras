package edu.asselvi.orcamentoobras.view.components.table.model;

import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.CustoUnitarioBasico;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;

public class CubModelConverter implements IModelConverter<CustoUnitarioBasico>{

	int qtdColumns = 2;
	public List<CustoUnitarioBasico> cubList;
	
	@Override
	public String[] getColumnNames() {
		return new String[] {"Mes", "Ano"};
	}

	@Override
	public Object[][] getData() {
		Object[][] objects;
		
		try {
			cubList = DaoFactory.getInstance().getCubDao().getTodos();
		} catch (SQLException e) {
			
		}
		
		objects = new Object[cubList.size()][qtdColumns];
		
		int row = 0;
		for (CustoUnitarioBasico cub : cubList) {
			objects[row][0] = (Object) cub.getMes();
			objects[row][1] = (Object) cub.getAno();
			row++;
		}
		return objects;
	}

	@Override
	public CustoUnitarioBasico getObjectByRowIndex(int index) {
		return cubList.get(index);
	}

}
