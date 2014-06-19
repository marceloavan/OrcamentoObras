package edu.asselvi.orcamentoobras.view.pages.cadastros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import edu.asselvi.orcamentoobras.model.beans.Usuario;
import edu.asselvi.orcamentoobras.view.components.CustomTable;
import edu.asselvi.orcamentoobras.view.manager.UsuarioManager;
import edu.asselvi.orcamentoobras.view.tablemodel.TableModelImpl;
import edu.asselvi.orcamentoobras.view.tablemodel.UsuarioModelConverter;
import edu.asselvi.orcamentoobras.view.templates.TemplateCadastroPages;

public class CadastroUsuarioPage extends TemplateCadastroPages {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane = new JScrollPane();
	private CustomTable table;
	private UsuarioModelConverter usuarioModelConverter;
	private AbstractTableModel tableModel;
	
	private JTextField nomeCompletoTf;
	private JTextField userNameTf;
	
	private JPasswordField passwdTf;
	private UsuarioManager usuarioManager;
	
	public CadastroUsuarioPage() {
		super(500, 500);
		
		usuarioManager = new UsuarioManager();
		
		usuarioModelConverter = new UsuarioModelConverter();
		generateTable();
		
		getContentPane().add(scrollPane);
		
		JLabel loginLb = new JLabel("Login");
		loginLb.setHorizontalAlignment(SwingConstants.RIGHT);
		loginLb.setBounds(10, 275, 90, 15);
		getContentPane().add(loginLb);
		
		JLabel nomeCompletoLb = new JLabel("Nome Completo");
		nomeCompletoLb.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeCompletoLb.setBounds(10, 250, 90, 15);
		getContentPane().add(nomeCompletoLb);
		
		JLabel senhaLb = new JLabel("Senha");
		senhaLb.setHorizontalAlignment(SwingConstants.RIGHT);
		senhaLb.setBounds(10, 300, 90, 15);
		getContentPane().add(senhaLb);
		
		nomeCompletoTf = new JTextField();
		nomeCompletoTf.setBounds(110, 245, 280, 20);
		getContentPane().add(nomeCompletoTf);
		nomeCompletoTf.setColumns(10);
		
		userNameTf = new JTextField();
		userNameTf.setColumns(10);
		userNameTf.setBounds(110, 270, 280, 20);
		getContentPane().add(userNameTf);
		
		passwdTf = new JPasswordField();
		passwdTf.setBounds(110, 295, 280, 20);
		getContentPane().add(passwdTf);
		
		addActions();
		
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	private void limparCampos() {
		nomeCompletoTf.setText("");
		userNameTf.setText("");
		passwdTf.setText("");
		userNameTf.setEnabled(true);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	private void loadCamposByObject(Usuario usuario) {
		nomeCompletoTf.setText(usuario.getNomeCompleto());
		userNameTf.setText(usuario.getUserName());
		passwdTf.setText("");
	}
	
	private void generateTable() {
		tableModel = new TableModelImpl(usuarioModelConverter);
		
		table = new CustomTable();
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumn("Login").setPreferredWidth(200);
		table.getColumn("Nome").setPreferredWidth(250);
		
		scrollPane.setViewportView(table);
		scrollPane.setBounds(10, 40, 470, 180);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(null);
		
		SwingUtilities.updateComponentTreeUI(this);
	}

	@Override
	protected void addActions() {

		getSalvarBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String nomeCompleto = nomeCompletoTf.getText();
				String  userName = userNameTf.getText();
				String passwd = passwdTf.getText();

				if (userName.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informa o nome do usuário");
					return;
				} 
				if (passwd.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe a senha");
					return;
				}
				if (nomeCompleto.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe o nome completo do usuário");
					return;
				}
				try {
					if (usuarioManager.isUsuarioExistente(userName)) {
						usuarioManager.atualizarUsuario(userName, passwd, nomeCompleto);
					} else {
						usuarioManager.cadastrarUsuario(userName, passwd, nomeCompleto);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o usuário");
					return;
				}
				limparCampos();
				generateTable();
				JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
			}
		});
		
		getNovoBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
				limparCampos();
			}
		});
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() > -1) {
					Usuario usuario = usuarioModelConverter.getObjectByRowIndex(table.getSelectedRow());
					loadCamposByObject(usuario);
					userNameTf.setEnabled(false);
				}
			}
		});
	}
}
