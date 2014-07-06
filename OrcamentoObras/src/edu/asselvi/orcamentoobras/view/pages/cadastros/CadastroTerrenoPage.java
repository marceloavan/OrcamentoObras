package edu.asselvi.orcamentoobras.view.pages.cadastros;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import edu.asselvi.orcamentoobras.controller.EnderecoController;
import edu.asselvi.orcamentoobras.controller.TerrenoController;
import edu.asselvi.orcamentoobras.model.beans.Endereco;
import edu.asselvi.orcamentoobras.view.components.CustomTable;
import edu.asselvi.orcamentoobras.view.templates.TemplateCadastroPages;

public class CadastroTerrenoPage extends TemplateCadastroPages{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane = new JScrollPane();
	private CustomTable table;
	private AbstractTableModel tableModel;
	
	private JTextField codigoTf;
	private JTextField descricaoTf;
	private JTextField valorVendaTf;
	private JTextField metragemTf;
	private JTextField itbiTf;
	private JTextField frjTf;
	private JTextField escrituraTf;
	private JTextField registroTf;
	private JComboBox<Endereco> enderecoCb;
	
	private TerrenoController terrenoController;
	private EnderecoController enderecoController;
	
	public CadastroTerrenoPage(){
		super(700,1000);
		getContentPane().add(scrollPane);
	}
	@Override
	protected void addActions() {
		// TODO Auto-generated method stub
		
	}

}
