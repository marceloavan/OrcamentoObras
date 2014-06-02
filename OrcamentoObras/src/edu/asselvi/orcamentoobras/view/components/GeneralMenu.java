package edu.asselvi.orcamentoobras.view.components;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GeneralMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GeneralMenu(Integer width) {
		setBounds(0, 0, width, 25);
		generateMenu();
	}

	private void generateMenu() {

		JMenu menuAdministracao = new JMenu("Administração");
		add(menuAdministracao);
		
		JMenuItem itemUsuarios = new JMenuItem("Usu\u00E1rios");
		menuAdministracao.add(itemUsuarios);
		
		JMenuItem itemTrocarSenha = new JMenuItem("Trocar senha");
		menuAdministracao.add(itemTrocarSenha);
		
	}
	
}