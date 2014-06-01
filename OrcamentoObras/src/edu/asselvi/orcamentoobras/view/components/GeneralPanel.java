package edu.asselvi.orcamentoobras.view.components;

import java.awt.Color;

import javax.swing.JPanel;

public class GeneralPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Color color;
	
	public GeneralPanel(Color color, String title) {
		this.color = color;
		setBackground(color);
		
		setBounds(0, 0, 850, 100);
		setLayout(null);
	}
}