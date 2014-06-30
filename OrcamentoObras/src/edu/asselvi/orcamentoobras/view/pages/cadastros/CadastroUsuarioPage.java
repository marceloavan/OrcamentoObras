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

import edu.asselvi.orcamentoobras.controller.UsuarioController;
import edu.asselvi.orcamentoobras.controller.exception.UsuarioNotFoundException;
import edu.asselvi.orcamentoobras.model.beans.Usuario;
import edu.asselvi.orcamentoobras.view.components.CustomTable;
import edu.asselvi.orcamentoobras.view.components.table.model.TableModelImpl;
import edu.asselvi.orcamentoobras.view.components.table.model.UsuarioModelConverter;
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
	private UsuarioController usuarioManager;
	
	private boolean editingUser = false;
	
	public CadastroUsuarioPage() {
		super(500, 500);
		
		usuarioManager = new UsuarioController();
		
		usuarioModelConverter = new UsuarioModelConverter();
		generateTable();
		
		getContentPane().add(scrollPane);
		
		JLabel loginLb = new JLabel("Login");
		loginLb.setHorizontalAlignment(SwingConstants.RIGHT);
		loginLb.setBounds(10, 275, 90, 15);
		getContentPane().add(loginLb);
		
		JLabel nomeCompletoLb = new JLabel("Nome Comp.");
		nomeCompletoLb.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeCompletoLb.setBounds(10, 250, 90, 15);
		getContentPane().add(nomeCompletoLb);
		
		JLabel senhaLb = new JLabel("Senha");
		senhaLb.setHorizontalAlignment(SwingConstants.RIGHT);
		senhaLb.setBounds(10, 300, 90, 15);
		getContentPane().add(senhaLb);
		
		int yPosition = 245;
		nomeCompletoTf = new JTextField();
		nomeCompletoTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(nomeCompletoTf);
		nomeCompletoTf.setColumns(10);
		
		yPosition += getDistanceTf();
		userNameTf = new JTextField();
		userNameTf.setColumns(10);
		userNameTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(userNameTf);
		
		yPosition += getDistanceTf();
		passwdTf = new JPasswordField();
		passwdTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
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
		addActionToTable();
		
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
						if (!editingUser) {
							JOptionPane.showMessageDialog(null, "Usuário já existe. Selecione o usuário na tabela para entrar no modo de edição");
							return;
						}
						usuarioManager.atualizarUsuario(new Usuario(userName, passwd, nomeCompleto));
					} else {
						usuarioManager.cadastrarUsuario(new Usuario(userName, passwd, nomeCompleto));
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
				editingUser = false;
			}
		});
		
		getExcluirBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				try {
					String userName = userNameTf.getText();
					if (usuarioManager.isUsuarioLogado(userName)) {
						JOptionPane.showMessageDialog(null, "Não é possível excluir o usuário logado");
						return;
					}
					usuarioManager.excluirUsuario(userName);
					limparCampos();
					generateTable();
				} catch (UsuarioNotFoundException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					return;
				}
				JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso");
			}
		});
	}
	
	/**
	 * Método separado porque a tabela é recriada quando algum registro é criado/ removido
	 */
	private void addActionToTable() {
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() > -1) {
					Usuario usuario = usuarioModelConverter.getObjectByRowIndex(table.getSelectedRow());
					loadCamposByObject(usuario);
					userNameTf.setEnabled(false);
					editingUser = true;
				}
			}
		});
	}
}
