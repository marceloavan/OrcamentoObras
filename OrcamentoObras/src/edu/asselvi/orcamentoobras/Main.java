package edu.asselvi.orcamentoobras;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import edu.asselvi.orcamentoobras.model.dao.conector.ConectorBancoFactory;
import edu.asselvi.orcamentoobras.view.login.Login;
import edu.asselvi.orcamentoobras.view.pages.ConfigDbPage;

public class Main {
	public static void main(String[] args) {
		
		boolean failureConnection = false;
		Connection connection;
		try {
			connection = ConectorBancoFactory.getInstance().getConexao();
			if (connection == null) {
				failureConnection = true;
			}
		} catch (SQLException e) {
			failureConnection = true;
		}
		
		if (failureConnection) {
			SwingUtilities.invokeLater(new Runnable() {
		        public void run() {
		        	new ConfigDbPage();
		        	JOptionPane.showMessageDialog(null, "Não possível conectar com a base de dados configurada atualmente.\n"
		        			+ "Verifique a configuração atual.\n"
		        			+ "Caso não saiba do que se trata, contacte o suporte tecnico.");
		        }
		    });
			return;
		}
		
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	new Login();
	        }
	    });
	}
}
