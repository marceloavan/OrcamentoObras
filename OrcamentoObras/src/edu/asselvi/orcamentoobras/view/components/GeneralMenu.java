package edu.asselvi.orcamentoobras.view.components;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class GeneralMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GeneralMenu() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 100, 275, 250);
		setLayout(null);
		setVisible(true);
	}

	public List<JMenu> generateMenus() {
		List<JMenu> menuLista = new ArrayList<JMenu>();
		
		return menuLista;
	}
	
}