package edu.asselvi.orcamentoobras.view.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
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
		
		JLabel labelTitle = new JLabel(title);
		labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelTitle.setBounds(100, 25, 315, 50);
		setBounds(0, 0, 850, 100);
		setLayout(null);
		add(labelTitle);
	}
}