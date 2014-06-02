package edu.asselvi.orcamentoobras.view.templates;

import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

import edu.asselvi.orcamentoobras.view.components.GeneralMenu;

public abstract class GeneralTempatePages extends GeneralTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5437083454847063426L;

	public GeneralTempatePages() {
		super(700, 900);
		
		JMenuBar generalMenu = new GeneralMenu(900);
		getContentPane().add(generalMenu);
		
		SwingUtilities.updateComponentTreeUI(this);
	}
}
