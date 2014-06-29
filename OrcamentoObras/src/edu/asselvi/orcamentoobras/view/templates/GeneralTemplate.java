package edu.asselvi.orcamentoobras.view.templates;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public abstract class GeneralTemplate extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Dimension dimension;
	private int widthTf = 280;
	private int heightTf = 27;
	private int distanceTf = 25;
	
	public GeneralTemplate(int height, int width) {
		
		setLookAndFeel();
		
		dimension = new Dimension(width, height);
		setFixedSize();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setLayout(null);
		setContentPane(scrollPane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Centraliza a tela
		setLocationRelativeTo(null);
		
		// Seta o layout para posicionamento absoluto
		setLayout(null);
		
		// Bloqueia a edição de tamanho
		setResizable(false);
		
		setTitle("OrcaObras - Gestão de orçamentos em obras");
		
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
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
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
	
	/**
	 * Método que adiciona os actions presentes em cada tela 
	 */
	protected abstract void addActions();
	
	public Dimension getDimension() {
		return dimension;
	}
	
	public int getWidthTf() {
		return widthTf;
	}
	
	public int getHeightTf() {
		return heightTf;
	}
	
	public int getDistanceTf() {
		return distanceTf;
	}
}
