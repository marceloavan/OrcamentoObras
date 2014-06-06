package edu.asselvi.orcamentoobras.view.templates;

import javax.swing.JButton;

import edu.asselvi.orcamentoobras.view.components.ButtonDefault;
import javax.swing.JPanel;
import java.awt.Color;

public abstract class TemplateCadastroPages extends GeneralTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton salvarBtn;
	private JButton cancelarBtn;
	
	public TemplateCadastroPages() {
		this(500, 500);
	}
	
	public TemplateCadastroPages(Integer height, Integer width) {
		super(height, width);
		addActions();
		
		JPanel panelBtns = new JPanel();
		panelBtns.setBounds(0, 415, width, 60);
		panelBtns.setBackground(Color.LIGHT_GRAY);
		panelBtns.setLayout(null);

		salvarBtn = new ButtonDefault("Salvar");
		salvarBtn.setBounds(10, 5, 65, 25);
		panelBtns.add(salvarBtn);
		
		cancelarBtn = new ButtonDefault("Cancelar");
		cancelarBtn.setBounds(85, 5, 75, 25);
		panelBtns.add(cancelarBtn);
		
		getContentPane().add(panelBtns);
	}

	public JButton getSalvarBtn() {
		return salvarBtn;
	}

	public JButton getCancelarBtn() {
		return cancelarBtn;
	}
}
