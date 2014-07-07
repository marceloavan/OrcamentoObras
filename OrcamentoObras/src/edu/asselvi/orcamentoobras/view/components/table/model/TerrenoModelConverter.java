package edu.asselvi.orcamentoobras.view.components.table.model;

import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Terreno;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;

public class TerrenoModelConverter implements IModelConverter<Terreno>{
	
	private int qtdColumns = 8;
	public List<Terreno> terrenoList;
	
	@Override
	public String[] getColumnNames() {
		return new String[] {"Descrição","Endereço","Metragem","Vlr. Venda","Vlr. ITBI","Vlr. FRJ","Vlr. Escritura","Vlr Registro"};
	}

	@Override
	public Object[][] getData() {
		Object[][] objects;
		
		try {
			terrenoList = DaoFactory.getInstance().getTerrenoDao().getTodos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int row = 0;
		objects = new Object[terrenoList.size()][qtdColumns];
		
		for (Terreno terreno : terrenoList) {
			objects[row][0] = (Object) terreno.getDescricao();
			objects[row][1] = (Object) terreno.getEndereco().getLogradouro();
			objects[row][2] = (Object) terreno.getMetragem();
			objects[row][3] = (Object) terreno.getValorVenda();
			objects[row][4] = (Object) terreno.getValorITBI();
			objects[row][5] = (Object) terreno.getValorFRJ();
			objects[row][6] = (Object) terreno.getValorEscritura();
			objects[row][7] = (Object) terreno.getValorRegistro();
			row++;
		}
		return objects;
	}

	@Override
	public Terreno getObjectByRowIndex(int index) {
		return terrenoList.get(index);
	}

}
