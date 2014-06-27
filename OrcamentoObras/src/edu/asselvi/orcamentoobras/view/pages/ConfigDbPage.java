package edu.asselvi.orcamentoobras.view.pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import edu.asselvi.orcamentoobras.installer.DataBaseConfig;
import edu.asselvi.orcamentoobras.properties.PropertiesLocator;
import edu.asselvi.orcamentoobras.view.components.ButtonDefault;
import edu.asselvi.orcamentoobras.view.templates.GeneralTemplate;

/**
 * Tela responsável pela configuração da conexão com o banco de dados
 * 
 * @author Leandro Rebelo
 */

public class ConfigDbPage extends GeneralTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField hostTf;
	private JTextField portTf;
	private JTextField baseTf;
	private JTextField userTf;
	private JPasswordField passwdTf;
	private ButtonDefault salvarBtn;
	private ButtonDefault criarBtn;
	private ButtonDefault inserirBtn;
	private ButtonDefault demoBtn;
	private DataBaseConfig dataBaseConfig;
	
	public ConfigDbPage() {
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
		hostTf.setBounds(85, 17, 220, 25);
		configPanel.add(hostTf);

		JLabel portLb = new JLabel("Port:");
		portLb.setHorizontalAlignment(SwingConstants.CENTER);
		portLb.setBounds(25, 49, 65, 15);
		configPanel.add(portLb);

		portTf = new JTextField();
		portTf.setBounds(85, 46, 220, 25);
		configPanel.add(portTf);

		JLabel baseLb = new JLabel("Base:");
		baseLb.setHorizontalAlignment(SwingConstants.CENTER);
		baseLb.setBounds(25, 77, 65, 15);
		configPanel.add(baseLb);

		baseTf = new JTextField();
		baseTf.setBounds(85, 74, 220, 25);
		configPanel.add(baseTf);

		JLabel userLb = new JLabel("Usu\u00E1rio:");
		userLb.setHorizontalAlignment(SwingConstants.CENTER);
		userLb.setBounds(25, 106, 65, 15);
		configPanel.add(userLb);

		userTf = new JTextField();
		userTf.setBounds(85, 103, 220, 25);
		configPanel.add(userTf);

		JLabel passwdLb = new JLabel("Senha:");
		passwdLb.setHorizontalAlignment(SwingConstants.CENTER);
		passwdLb.setBounds(25, 135, 65, 15);
		configPanel.add(passwdLb);

		passwdTf = new JPasswordField();
		passwdTf.setBounds(85, 132, 220, 25);
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

		addActions();

		SwingUtilities.updateComponentTreeUI(this);
		
		dataBaseConfig = new DataBaseConfig();

	}

	public void checkField() {
		String port = portTf.getText();
		String host = hostTf.getText();
		String base = baseTf.getText();
		String user = userTf.getText();
		String passwd = passwdTf.getText();

		if (port.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe a porta");
		} else if (host.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o host");
		} else if (base.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe a base");
		} else if (user.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o login do usuário");
		} else if (passwd.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe a senha");
		}
	}

	@Override
	protected void addActions() {
		salvarBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {

				checkField();

				String port = portTf.getText();
				String host = hostTf.getText();
				String base = baseTf.getText();
				String user = userTf.getText();
				String passwd = passwdTf.getText();

				PropertiesLocator.setPropValue("db.port", port);
				PropertiesLocator.setPropValue("db.host", host);
				PropertiesLocator.setPropValue("db.base", base);
				PropertiesLocator.setPropValue("db.user", user);
				PropertiesLocator.setPropValue("db.passwd", passwd);
			}
		});

		criarBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				checkField();
				dataBaseConfig.generateDataBase();
			}
		});

		inserirBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				checkField();

			}
		});

		demoBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				checkField();

			}
		});
	}
}
