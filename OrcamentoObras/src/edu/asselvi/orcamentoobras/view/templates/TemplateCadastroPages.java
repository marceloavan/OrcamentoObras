package edu.asselvi.orcamentoobras.view.templates;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.asselvi.orcamentoobras.view.components.ButtonDefault;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class TemplateCadastroPages extends GeneralTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton salvarBtn;
	private JButton novoBtn;
	private JButton excluirBtn;
	private JButton fecharBtn;
	
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
		salvarBtn.setBounds(10, 11, 70, 25);
		panelBtns.add(salvarBtn);
		
		novoBtn = new ButtonDefault("Novo");
		novoBtn.setBounds(90, 11, 75, 25);
		panelBtns.add(novoBtn);
		
		excluirBtn = new ButtonDefault("Excluir");
		excluirBtn.setBounds(175, 11, 75, 25);
		panelBtns.add(excluirBtn);
		
		fecharBtn = new ButtonDefault("Fechar");
		fecharBtn.setBounds(260, 11, 75, 25);
		panelBtns.add(fecharBtn);

		addDefaultActions();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(panelBtns);
	}

	public JButton getSalvarBtn() {
		return salvarBtn;
	}

	public JButton getNovoBtn() {
		return novoBtn;
	}
	
	public JButton getExcluirBtn() {
		return excluirBtn;
	}
	
	public void addDefaultActions() {
		fecharBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
