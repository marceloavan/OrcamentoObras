package edu.asselvi.orcamentoobras.view.pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.asselvi.orcamentoobras.view.pages.cadastros.CadastroUsuarioPage;
import edu.asselvi.orcamentoobras.view.templates.TempateHomePage;

public class HomePage extends TempateHomePage {

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
		
		super.addActions();
		
	}
}
