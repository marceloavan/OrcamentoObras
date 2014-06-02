package edu.asselvi.orcamentoobras.view.configdb;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import edu.asselvi.orcamentoobras.view.components.ButtonDefault;
import edu.asselvi.orcamentoobras.view.templates.GeneralTemplate;

import javax.swing.JTextPane;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigDb extends GeneralTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField hostTf;
	private JTextField portTf;
	private JTextField baseTf;
	private JTextField userTf;
	private JPasswordField passwdTf;
	ButtonDefault salvarBtn;
	ButtonDefault criarBtn;
	ButtonDefault inserirBtn;
	ButtonDefault demoBtn;

	public ConfigDb() {
		super(400, 500);
		getContentPane().setBackground(Color.WHITE);

		// Criação do painel de configuração do banco de dados
		JPanel configPanel = new JPanel();
		configPanel.setLayout(null);
		configPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		configPanel.setBackground(Color.LIGHT_GRAY);
		configPanel.setBounds(10, 35, 474, 329);
		getContentPane().add(configPanel);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.setBackground(Color.BLACK);
		panelTitulo.setBounds(10, 11, 474, 25);
		getContentPane().add(panelTitulo);

		JLabel tituloCb = new JLabel("Configura\u00E7\u00E3o do Banco de Dados");
		tituloCb.setForeground(Color.WHITE);
		tituloCb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tituloCb.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitulo.add(tituloCb);

		JLabel hostLb = new JLabel("Host:");
		hostLb.setHorizontalAlignment(SwingConstants.CENTER);
		hostLb.setBounds(25, 20, 65, 15);
		configPanel.add(hostLb);

		hostTf = new JTextField();
		hostTf.setBounds(85, 17, 220, 20);
		configPanel.add(hostTf);

		JLabel portLb = new JLabel("Port:");
		portLb.setHorizontalAlignment(SwingConstants.CENTER);
		portLb.setBounds(25, 49, 65, 15);
		configPanel.add(portLb);

		portTf = new JTextField();
		portTf.setBounds(85, 46, 220, 20);
		configPanel.add(portTf);

		JLabel baseLb = new JLabel("Base:");
		baseLb.setHorizontalAlignment(SwingConstants.CENTER);
		baseLb.setBounds(25, 77, 65, 15);
		configPanel.add(baseLb);

		baseTf = new JTextField();
		baseTf.setBounds(85, 74, 220, 20);
		configPanel.add(baseTf);

		JLabel userLb = new JLabel("Usu\u00E1rio:");
		userLb.setHorizontalAlignment(SwingConstants.CENTER);
		userLb.setBounds(25, 106, 65, 15);
		configPanel.add(userLb);

		userTf = new JTextField();
		userTf.setBounds(85, 103, 220, 20);
		configPanel.add(userTf);

		JLabel passwdLb = new JLabel("Senha:");
		passwdLb.setHorizontalAlignment(SwingConstants.CENTER);
		passwdLb.setBounds(25, 135, 65, 15);
		configPanel.add(passwdLb);

		passwdTf = new JPasswordField();
		passwdTf.setBounds(85, 132, 220, 20);
		configPanel.add(passwdTf);

		JLabel logLb = new JLabel("Log:");
		logLb.setHorizontalAlignment(SwingConstants.CENTER);
		logLb.setBounds(25, 161, 65, 15);
		configPanel.add(logLb);

		JTextPane logText = new JTextPane();
		logText.setBackground(new Color(255, 255, 255));
		logText.setBounds(86, 161, 220, 157);
		configPanel.add(logText);

		salvarBtn = new ButtonDefault("Salvar");
		salvarBtn.setBounds(347, 18, 90, 25);
		configPanel.add(salvarBtn);
		
		criarBtn = new ButtonDefault("Criar");
		criarBtn.setBounds(347, 54, 90, 25);
		configPanel.add(criarBtn);
		
		inserirBtn = new ButtonDefault("Inserir");
		inserirBtn.setBounds(347, 90, 90, 25);
		configPanel.add(inserirBtn);
		
		demoBtn = new ButtonDefault("Demo");
		demoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		demoBtn.setBounds(347, 126, 90, 25);
		configPanel.add(demoBtn);

		SwingUtilities.updateComponentTreeUI(this);

	}

	@Override
	protected void addActions() {
		// TODO Auto-generated method stub

	}
}
