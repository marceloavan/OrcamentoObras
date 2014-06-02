package edu.asselvi.orcamentoobras.view.templates;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import edu.asselvi.orcamentoobras.view.components.GeneralMenu;
import edu.asselvi.orcamentoobras.view.login.Login;

public abstract class TempateHomePage extends GeneralTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5437083454847063426L;

	GeneralMenu generalMenu;
	
	public TempateHomePage() {
		super(700, 900);
		
		generalMenu = new GeneralMenu(900);
		getContentPane().add(generalMenu);
		
		addActions();
		
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	@Override
	protected void addActions() {
		
		generalMenu.getItemSairLogout().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
			}
		});
		
		generalMenu.getItemSairFechar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
}
