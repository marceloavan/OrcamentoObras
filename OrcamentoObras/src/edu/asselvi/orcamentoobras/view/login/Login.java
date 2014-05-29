package edu.asselvi.orcamentoobras.view.login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
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

public class Login extends GeneralTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userTf;
	private JPasswordField passwdTf;

	public Login() {
		super(500, 700);

		makeBackgroundLogin();

		//Cria��o do painel de login
		JPanel loginPanel = new JPanel();
		loginPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		loginPanel.setBackground(Color.LIGHT_GRAY);
		loginPanel.setBounds(260, 140, 415, 200);
		loginPanel.setLayout(null);
		getContentPane().add(loginPanel);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.setBackground(Color.BLACK);
		panelTitulo.setBounds(0, 0, 415, 40);
		loginPanel.add(panelTitulo);
		
		JLabel tituloLb = new JLabel("OrcaObras - Gest\u00E3o de Or\u00E7amento em Obras");
		tituloLb.setForeground(Color.WHITE);
		tituloLb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tituloLb.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitulo.add(tituloLb);
		
		JLabel userLb = new JLabel("Usu\u00E1rio:");
		userLb.setHorizontalAlignment(SwingConstants.RIGHT);
		userLb.setBounds(50, 85, 90, 15);
		loginPanel.add(userLb);
		
		userTf = new JTextField();
		userTf.setBounds(150, 80, 220, 20);
		loginPanel.add(userTf);
		userTf.setColumns(10);
		
		JLabel passwdLb = new JLabel("Senha:");
		passwdLb.setHorizontalAlignment(SwingConstants.RIGHT);
		passwdLb.setBounds(50, 115, 90, 15);
		loginPanel.add(passwdLb);
		
		passwdTf = new JPasswordField();
		passwdTf.setBounds(150, 110, 220, 20);
		loginPanel.add(passwdTf);
		
		JButton loginBtn = new ButtonDefault("Login");
		loginBtn.setBounds(280, 140, 90, 25);
		loginPanel.add(loginBtn);
		
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	private void makeBackgroundLogin() {
		getContentPane().setBackground(Color.WHITE);
		JLabel imageBg = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\resourses\\img\\obras_login.png"));
		imageBg.setBounds(10, 81, 312, 338);
		getContentPane().add(imageBg);
	}
}