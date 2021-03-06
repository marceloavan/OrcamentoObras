package edu.asselvi.orcamentoobras.view.pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import edu.asselvi.orcamentoobras.installer.DataBaseConfig;
import edu.asselvi.orcamentoobras.properties.PropertiesLocator;
import edu.asselvi.orcamentoobras.view.components.ButtonDefault;
import edu.asselvi.orcamentoobras.view.templates.GeneralTemplate;

/**
 * Tela respons�vel pela configura��o da conex�o com o banco de dados
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
	private ButtonDefault sairBtn;
	private JTextArea logText;
	private DataBaseConfig dataBaseConfig;
	
	public ConfigDbPage() {
		super(400, 600);
		getContentPane().setBackground(Color.WHITE);

		// Cria��o do painel de configura��o do banco de dados
		JPanel configPanel = new JPanel();
		configPanel.setLayout(null);
		configPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		configPanel.setBackground(Color.LIGHT_GRAY);
		configPanel.setBounds(10, 35, 578, 329);
		getContentPane().add(configPanel);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.setBackground(Color.BLACK);
		panelTitulo.setBounds(10, 11, 578, 25);
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
		hostTf.setBounds(85, 17, 220, getHeightTf());
		configPanel.add(hostTf);

		JLabel portLb = new JLabel("Port:");
		portLb.setHorizontalAlignment(SwingConstants.CENTER);
		portLb.setBounds(25, 49, 65, 15);
		configPanel.add(portLb);

		portTf = new JTextField();
		portTf.setBounds(85, 46, 220, getHeightTf());
		configPanel.add(portTf);

		JLabel baseLb = new JLabel("Base:");
		baseLb.setHorizontalAlignment(SwingConstants.CENTER);
		baseLb.setBounds(25, 77, 65, 15);
		configPanel.add(baseLb);

		baseTf = new JTextField();
		baseTf.setBounds(85, 74, 220, getHeightTf());
		configPanel.add(baseTf);

		JLabel userLb = new JLabel("Usu\u00E1rio:");
		userLb.setHorizontalAlignment(SwingConstants.CENTER);
		userLb.setBounds(25, 106, 65, 15);
		configPanel.add(userLb);

		userTf = new JTextField();
		userTf.setBounds(85, 103, 220, getHeightTf());
		configPanel.add(userTf);

		JLabel passwdLb = new JLabel("Senha:");
		passwdLb.setHorizontalAlignment(SwingConstants.CENTER);
		passwdLb.setBounds(25, 135, 65, 15);
		configPanel.add(passwdLb);

		passwdTf = new JPasswordField();
		passwdTf.setBounds(85, 132, 220, getHeightTf());
		configPanel.add(passwdTf);

		JLabel logLb = new JLabel("Log:");
		logLb.setHorizontalAlignment(SwingConstants.CENTER);
		logLb.setBounds(25, 161, 65, 15);
		configPanel.add(logLb);

		logText = new JTextArea();
		logText.setBackground(new Color(255, 255, 255));
		logText.setBounds(86, 161, 220, 157);
		configPanel.add(logText);
		logText.setLineWrap(true);

		salvarBtn = new ButtonDefault("Salvar Configura��es");
		salvarBtn.setBounds(347, 18, 180, 25);
		configPanel.add(salvarBtn);

		criarBtn = new ButtonDefault("Criar DataBase/Tabelas");
		criarBtn.setBounds(347, 54, 180, 25);
		configPanel.add(criarBtn);

		inserirBtn = new ButtonDefault("Inserir UF/Municipios");
		inserirBtn.setBounds(347, 90, 180, 25);
		configPanel.add(inserirBtn);

		demoBtn = new ButtonDefault("Base Demonstra��o");
		demoBtn.setBounds(347, 126, 180, 25);
		configPanel.add(demoBtn);
		
		sairBtn = new ButtonDefault("Sair");
		sairBtn.setBounds(347, 162, 180, 25);
		configPanel.add(sairBtn);

		addActions();

		SwingUtilities.updateComponentTreeUI(this);
		
		dataBaseConfig = new DataBaseConfig();
		
		loadConfig();
		
	}

	public void loadConfig () {
		String port = PropertiesLocator.getPropValue("db.port");
		String host = PropertiesLocator.getPropValue("db.host");
		String base = PropertiesLocator.getPropValue("db.base");
		String user = PropertiesLocator.getPropValue("db.user");
		String passwd = PropertiesLocator.getPropValue("db.passwd");
		
		portTf.setText(port);
		hostTf.setText(host);
		baseTf.setText(base);
		userTf.setText(user);
		passwdTf.setText(passwd);
	}
	
	public boolean checkField() {
		String port = portTf.getText();
		String host = hostTf.getText();
		String base = baseTf.getText();
		String user = userTf.getText();
		String passwd = passwdTf.getText();

		if (port.isEmpty() || port == null) {
			JOptionPane.showMessageDialog(null, "Informe a porta");
			return false;
		} else if (host.isEmpty() || host == null) {
			JOptionPane.showMessageDialog(null, "Informe o host");
			return false;
		} else if (base.isEmpty() || base == null) {
			JOptionPane.showMessageDialog(null, "Informe a base");
			return false;
		} else if (user.isEmpty() || user == null) {
			JOptionPane.showMessageDialog(null, "Informe o login do usu�rio");
			return false;
		} else if (passwd.isEmpty() || passwd == null) {
			JOptionPane.showMessageDialog(null, "Informe a senha");
			return false;
		}
		return true;
	}

	public JTextArea getLogText() {
		return logText;
	}

	public void setLogText(JTextArea logText) {
		this.logText = logText;
	}

	@Override
	protected void addActions() {
		salvarBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {

				if (!checkField()) {
					return;
				}

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
				if (!checkField()) {
					return;
				}
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
				try {
					logText.setText("");
					logText.append("Aguarde...");
					dataBaseConfig.generateDataBase();
					logText.setText("");
				} catch (SQLException e1) {
					logText.setText("");
					logText.append(e1.getMessage());
					JOptionPane.showMessageDialog(null, "N�o foi poss�vel executar a tarefa");
					return;
				}
				JOptionPane.showMessageDialog(null, "Tarefa executada com sucesso");
			}
		});

		inserirBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!checkField()) {
					return;
				}
				
				try {
					logText.setText("");
					logText.append("Aguarde...");
					dataBaseConfig.insertDataBase();
					logText.setText("");
				} catch (SQLException e1) {
					logText.setText("");
					logText.append(e1.getMessage());
					JOptionPane.showMessageDialog(null, "N�o foi poss�vel executar a tarefa");
					return;
				}
				JOptionPane.showMessageDialog(null, "Tarefa executada com sucesso");
			}
		});

		demoBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!checkField()) {
					return;
				}
				
				try {
					logText.setText("");
					logText.append("Aguarde...");
					dataBaseConfig.demoDataBase();
					logText.setText("");
				} catch (SQLException e1) {
					logText.setText("");
					logText.append(e1.getMessage());
					JOptionPane.showMessageDialog(null, "N�o foi poss�vel executar a tarefa");
					return;
				}
				JOptionPane.showMessageDialog(null, "Tarefa executada com sucesso");
			}
		});
		
		sairBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	/**
	 * main para configurar outro banco caso necess�rio
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	new ConfigDbPage();
	        }
	    });
	}
}
