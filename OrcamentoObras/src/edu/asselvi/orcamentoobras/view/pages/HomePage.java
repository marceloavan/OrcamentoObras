package edu.asselvi.orcamentoobras.view.pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.asselvi.orcamentoobras.view.pages.cadastros.CadastroCubPage;
import edu.asselvi.orcamentoobras.view.pages.cadastros.CadastroProdutoPage;
import edu.asselvi.orcamentoobras.view.pages.cadastros.CadastroTerrenoPage;
import edu.asselvi.orcamentoobras.view.pages.cadastros.CadastroUsuarioPage;
import edu.asselvi.orcamentoobras.view.templates.TemplateHomePage;

public class HomePage extends TemplateHomePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomePage() {
		super();
		addActions();
	}
	
	@Override
	protected void addActions() {
		
		getGeneralMenu().getItemAdministracaoUsuarios().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastroUsuarioPage();
			}
		});
		
		getGeneralMenu().getItemOrcamentoGestaoOrcamento().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new OrcamentoPage();
			}
		});
		
		getGeneralMenu().getItemCadastroProduto().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastroProdutoPage();
			}
		});
		
		getGeneralMenu().getItemCadastroTerreno().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastroTerrenoPage();				
			}
		});
		
		getGeneralMenu().getItemOrcamentoCub().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastroCubPage();				
			}
		});
		
		
		super.addActions();
	}
}
