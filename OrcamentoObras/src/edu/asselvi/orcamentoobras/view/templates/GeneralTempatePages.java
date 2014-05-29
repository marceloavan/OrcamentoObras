package edu.asselvi.orcamentoobras.view.templates;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

import edu.asselvi.orcamentoobras.view.components.GeneralMenu;
import edu.asselvi.orcamentoobras.view.components.GeneralPanel;

public class GeneralTempatePages extends GeneralTemplate {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5437083454847063426L;

	private String title = "Orca Obras";
	
	public GeneralTempatePages() {
		super();
		JPanel generalPanel = new GeneralPanel(new Color(192, 192, 192), title);
		getContentPane().add(generalPanel);
		
		JMenuBar generalMenu = new GeneralMenu();
		getContentPane().add(generalMenu);
	}
}
