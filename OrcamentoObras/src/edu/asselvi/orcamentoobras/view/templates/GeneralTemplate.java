package edu.asselvi.orcamentoobras.view.templates;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GeneralTemplate extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Dimension dimension;
	
	public GeneralTemplate(int height, int width) {
		
		setLookAndFeel();
		
		dimension = new Dimension(width, height);
		setFixedSize();
		
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,	JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setContentPane(scrollPane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Centraliza a tela
		setLocationRelativeTo(null);
		
		//Seta o layout para posicionamento absoluto
		setLayout(null);
		
		setVisible(true);
	}
	
	public GeneralTemplate() {
		this(600, 850);
	}
	
	/**
	 * Aplica o tamanho fixo da página de acordo com o tamanho solicitado
	 * 
	 */
	private void setFixedSize() {
		setSize(dimension);
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		setPreferredSize(dimension);
	}
	
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
