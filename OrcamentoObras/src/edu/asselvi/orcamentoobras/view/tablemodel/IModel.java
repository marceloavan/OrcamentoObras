package edu.asselvi.orcamentoobras.view.tablemodel;

public interface IModel<T> {
	
	public String[] getColumnNames();
	
	public Object[][] getData();
	
	public T getObjectByRowIndex(int index);
	
}
