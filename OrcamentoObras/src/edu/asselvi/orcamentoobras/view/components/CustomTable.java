package edu.asselvi.orcamentoobras.view.components;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class CustomTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomTable() {
		super();
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		this.setAlinhamentoColunas(centralizado);
		this.setResizableColunes(false);
		this.getTableHeader().setReorderingAllowed(false);
	}
	
	public CustomTable(TableModel tableModel) {
		super(tableModel);
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		this.setAlinhamentoColunas(centralizado);
		this.setResizableColunes(false);
		this.getTableHeader().setReorderingAllowed(false);
	}
	
	public void setAlinhamentoColunas(DefaultTableCellRenderer cellRendered) {
		for (int i = 0; i < getColumnCount(); i++) {
			this.getColumnModel().getColumn(i).setCellRenderer(cellRendered);
		}
	}
	
	public void setResizableColunes(boolean resizable) {
		for (int i = 0; i < getColumnCount(); i++) {
			this.getColumnModel().getColumn(i).setResizable(resizable);
		}
	}
	
}
