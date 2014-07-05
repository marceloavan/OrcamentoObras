package edu.asselvi.orcamentoobras.view.pages.cadastros;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import edu.asselvi.orcamentoobras.controller.ProdutoController;
import edu.asselvi.orcamentoobras.view.templates.TemplateCadastroPages;

public class CadastroProdutoPage extends TemplateCadastroPages{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane = new JScrollPane();
	
	private JTextField codigoTf;
	private JTextField descricaoTf;
	
	private ProdutoController produtoManager;
	
	public CadastroProdutoPage() {
		super(500,500);
		
		produtoManager = new ProdutoController();
		
		getContentPane().add(scrollPane);
		
		JLabel codigoLb = new JLabel();
		codigoLb.setHorizontalAlignment(SwingConstants.RIGHT);
		codigoLb.setBounds(10, 275, 90, 15);
		getContentPane().add(codigoLb);
		
		JLabel descricaoLb = new JLabel();
		descricaoLb.setHorizontalAlignment(SwingConstants.RIGHT);
		descricaoLb.setBounds(10, 250, 90, 15);
		getContentPane().add(descricaoLb);
		
		int yPosition = 245;
		codigoTf = new JTextField();
		codigoTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		codigoTf.setColumns(10);
		getContentPane().add(codigoTf);
		
		
		yPosition += getDistanceTf();
		descricaoTf = new JTextField();
		descricaoTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		descricaoTf.setColumns(10);
		getContentPane().add(descricaoTf);
		
		
		addActions();
		SwingUtilities.updateComponentTreeUI(this);
		
	}
	
	@Override
	protected void addActions() {
		// TODO Auto-generated method stub
		
	}

}
