package edu.asselvi.orcamentoobras.view.templates;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

import edu.asselvi.orcamentoobras.view.components.GeneralMenu;
import edu.asselvi.orcamentoobras.view.components.GeneralPanel;

public abstract class GeneralTempatePages extends GeneralTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5437083454847063426L;

	private String title = "Orca Obras";
	
	public GeneralTempatePages() {
		super();
		JPanel generalPanel = new GeneralPanel(Color.LIGHT_GRAY, title);
		generalPanel.setSize(1000, 120);
		generalPanel.setLocation(183, 0);
		getContentPane().add(generalPanel);
		
		JMenuBar generalMenu = new GeneralMenu();
		getContentPane().add(generalMenu);
		setExtendedState(GeneralTempatePages.MAXIMIZED_BOTH);
	}
}
