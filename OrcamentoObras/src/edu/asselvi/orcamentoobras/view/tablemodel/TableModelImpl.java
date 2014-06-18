package edu.asselvi.orcamentoobras.view.tablemodel;

import javax.swing.table.AbstractTableModel;

public class TableModelImpl extends AbstractTableModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TableModelImpl(String[] columnNames, Object[][] data) {
		this.columnNames = columnNames;
		this.data = data;
	}
	
	private String[] columnNames;
    private Object[][] data;

    public int getColumnCount() {
      return columnNames.length;
    }

    public int getRowCount() {
      return data.length;
    }

    public String getColumnName(int col) {
      return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
      return data[row][col];
    }
}