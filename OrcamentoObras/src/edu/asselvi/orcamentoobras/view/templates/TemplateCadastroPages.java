package edu.asselvi.orcamentoobras.view.templates;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.asselvi.orcamentoobras.view.components.ButtonDefault;

import javax.swing.JPanel;

import java.awt.Color;

public abstract class TemplateCadastroPages extends GeneralTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton salvarBtn;
	private JButton novoBtn;
	
	public TemplateCadastroPages() {
		this(500, 500);
	}
	
	public TemplateCadastroPages(Integer height, Integer width) {
		super(height, width);
		
		JPanel panelBtns = new JPanel();
		panelBtns.setBounds(0, 390, 500, 92);
		panelBtns.setBackground(Color.LIGHT_GRAY);
		panelBtns.setLayout(null);

		salvarBtn = new ButtonDefault("Salvar");
		salvarBtn.setBounds(10, 11, 65, 25);
		panelBtns.add(salvarBtn);
		
		novoBtn = new ButtonDefault("Novo");
		novoBtn.setBounds(85, 11, 75, 25);
		panelBtns.add(novoBtn);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		getContentPane().add(panelBtns);
	}

	public JButton getSalvarBtn() {
		return salvarBtn;
	}

	public JButton getNovoBtn() {
		return novoBtn;
	}
}
