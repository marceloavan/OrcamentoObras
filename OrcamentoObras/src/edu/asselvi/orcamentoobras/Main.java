package edu.asselvi.orcamentoobras;

import javax.swing.SwingUtilities;

import edu.asselvi.orcamentoobras.view.login.Login;


public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	new Login();
	        }
	    });
	}
}
