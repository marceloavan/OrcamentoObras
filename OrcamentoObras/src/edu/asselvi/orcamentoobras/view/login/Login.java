package edu.asselvi.orcamentoobras.view.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import edu.asselvi.orcamentoobras.cripto.Cripto;
import edu.asselvi.orcamentoobras.model.Usuario;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IUsuarioDao;
import edu.asselvi.orcamentoobras.view.components.ButtonDefault;
import edu.asselvi.orcamentoobras.view.exception.PasswdInvalidException;
import edu.asselvi.orcamentoobras.view.exception.UsuarioNotFoundException;
import edu.asselvi.orcamentoobras.view.manager.LoginManager;
import edu.asselvi.orcamentoobras.view.pages.HomePage;
import edu.asselvi.orcamentoobras.view.templates.GeneralTemplate;

public class Login extends GeneralTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userTf;
	private JPasswordField passwdTf;
	private JButton loginBtn;
	private LoginManager loginManager;

	public Login() {
		super(500, 700);

		loginManager = new LoginManager();
		
		//Criação do painel de login
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		loginPanel.setBackground(Color.LIGHT_GRAY);
		loginPanel.setBounds(174, 184, 345, 130);
		getContentPane().add(loginPanel);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.setBackground(Color.BLACK);
		panelTitulo.setBounds(0, 0, 345, 25);
		loginPanel.add(panelTitulo);
		
		JLabel tituloLb = new JLabel("OrcaObras - Gest\u00E3o de Or\u00E7amento em Obras");
		tituloLb.setForeground(Color.WHITE);
		tituloLb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tituloLb.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitulo.add(tituloLb);
		
		JLabel userLb = new JLabel("Usu\u00E1rio:");
		userLb.setHorizontalAlignment(SwingConstants.RIGHT);
		userLb.setBounds(25, 40, 65, 15);
		loginPanel.add(userLb);
		
		userTf = new JTextField();
		userTf.setBounds(100, 35, 220, 20);
		loginPanel.add(userTf);
		
		JLabel passwdLb = new JLabel("Senha:");
		passwdLb.setHorizontalAlignment(SwingConstants.RIGHT);
		passwdLb.setBounds(25, 70, 65, 15);
		loginPanel.add(passwdLb);
		
		passwdTf = new JPasswordField();
		passwdTf.setBounds(100, 65, 220, 20);
		loginPanel.add(passwdTf);
		
		loginBtn = new ButtonDefault("Login");
		loginBtn.setBounds(230, 95, 90, 25);
		loginPanel.add(loginBtn);
		
		addActions();
		
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	@Deprecated
	private void makeBackgroundLogin() {
		getContentPane().setBackground(Color.WHITE);

		String path = System.getProperty("user.dir") + "\\resources\\img\\obras_login.png";
		
		JLabel imageBg = new JLabel();
		imageBg.setIcon(new ImageIcon(path));
		imageBg.setBounds(-18, 96, 345, 300);
		
		getContentPane().add(imageBg);
	}
	
	@Override
	protected void addActions() {
		
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String userName = userTf.getText();
				String passwd = passwdTf.getText();

				if (userName.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe o login do usuário");
					return;
				} 
				if (passwd.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe a senha");
					return;
				}
				
				try {
					loginManager.validarLogin(userName, passwd);
				} catch (UsuarioNotFoundException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (PasswdInvalidException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				new HomePage();
				dispose();
			}
		});
	}
}