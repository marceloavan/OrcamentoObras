package edu.asselvi.orcamentoobras.view.pages.cadastros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import edu.asselvi.orcamentoobras.controller.EnderecoController;
import edu.asselvi.orcamentoobras.controller.PessoaController;
import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;
import edu.asselvi.orcamentoobras.model.beans.Endereco;
import edu.asselvi.orcamentoobras.model.beans.PessoaFisica;
import edu.asselvi.orcamentoobras.model.beans.PessoaJuridica;
import edu.asselvi.orcamentoobras.view.components.CustomTable;
import edu.asselvi.orcamentoobras.view.components.table.model.PessoaModelConverter;
import edu.asselvi.orcamentoobras.view.components.table.model.TableModelImpl;
import edu.asselvi.orcamentoobras.view.templates.TemplateCadastroPages;

public class CadastroPessoaPage extends TemplateCadastroPages{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CustomTable table;
	private PessoaModelConverter pessoaModelConverter;
	private AbstractTableModel tableModel;
	
	private JScrollPane scrollPane = new JScrollPane();
	private JTextField codigoTf;
	private JTextField nomeTf;
	private JTextField sobrenomeTf;
	private JTextField razaoSocialTf;
	private JTextField nomeFantasiaTf;
	private JTextField cpfTf;
	private JTextField cnpjTf;
	private JComboBox<Endereco> enderecoCb;
	private JRadioButton fisicaRb;
	private JRadioButton juridicaRb;
	private ButtonGroup tipoPessoaBg;
	
	private PessoaController pessoaController;
	private EnderecoController enderecoController;
	
	public CadastroPessoaPage() {
		super(550,500);
		
		pessoaController = new PessoaController();
		enderecoController = new EnderecoController();
		pessoaModelConverter = new PessoaModelConverter();
		
		getContentPane().add(scrollPane);
		
		generateTable();
		
		fisicaRb = new JRadioButton("Física");
		fisicaRb.setBounds(110, 225, 57, 15);
		getContentPane().add(fisicaRb);
		
		juridicaRb = new JRadioButton("Jurídica");
		juridicaRb.setBounds(170, 225, 90, 15);
		getContentPane().add(juridicaRb);
		
		tipoPessoaBg = new ButtonGroup();
		tipoPessoaBg.add(fisicaRb);
		tipoPessoaBg.add(juridicaRb);
		
		JLabel nomeLb = new JLabel("Nome");
		nomeLb.setBounds(10, 250, 90, 15);
		nomeLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(nomeLb);
		
		int yPosition = 245;
		nomeTf = new JTextField();
		nomeTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		nomeTf.setColumns(10);
		getContentPane().add(nomeTf);
		
		JLabel sobrenomeLb = new JLabel("Sobrenome");
		sobrenomeLb.setBounds(10, 275, 90, 15);
		sobrenomeLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(sobrenomeLb);
		
		yPosition += getDistanceTf();
		sobrenomeTf = new JTextField();
		sobrenomeTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		sobrenomeTf.setColumns(10);
		getContentPane().add(sobrenomeTf);
		
		JLabel razaoSocialLb = new JLabel("Razão Social");
		razaoSocialLb.setBounds(10, 300, 90, 15);
		razaoSocialLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(razaoSocialLb);
		
		yPosition += getDistanceTf();
		razaoSocialTf = new JTextField();
		razaoSocialTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		razaoSocialTf.setColumns(10);
		getContentPane().add(razaoSocialTf);
		
		JLabel nomeFantasiaLb = new JLabel("Nome Fantasia");
		nomeFantasiaLb.setBounds(10, 325, 90, 15);
		nomeFantasiaLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(nomeFantasiaLb);
		
		yPosition += getDistanceTf();
		nomeFantasiaTf = new JTextField();
		nomeFantasiaTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		nomeFantasiaTf.setColumns(10);
		getContentPane().add(nomeFantasiaTf);
		
		JLabel enderecoLb = new JLabel("Endereço");
		enderecoLb.setBounds(10, 350, 90, 15);
		enderecoLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(enderecoLb);
		
		yPosition += getDistanceTf();
		enderecoCb = new JComboBox<Endereco>();
		enderecoCb.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(enderecoCb);
		
		JLabel cpfLb = new JLabel("CPF");
		cpfLb.setBounds(10, 375, 90, 15);
		cpfLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(cpfLb);
		
		yPosition += getDistanceTf();
		cpfTf = new JTextField();
		cpfTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		cpfTf.setColumns(10);
		getContentPane().add(cpfTf);
		
		JLabel cnpjLb = new JLabel("CNPJ");
		cnpjLb.setBounds(10, 400, 90, 15);
		cnpjLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(cnpjLb);
		
		yPosition += getDistanceTf();
		cnpjTf = new JTextField();
		cnpjTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		cnpjTf.setColumns(10);
		getContentPane().add(cnpjTf);
		
		yPosition += getDistanceTf();
		codigoTf = new JTextField();
		getContentPane().add(codigoTf);
		
		codigoTf.setVisible(false);
		
		loadItensForCb();
		
		addActions();
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	private void loadItensForCb() {
		enderecoCb.addItem(null);
		for (Endereco endereco : enderecoController.getTodos()) {
			enderecoCb.addItem(endereco);
		}
	}
	
	private void limparCampos() {
		codigoTf.setText("");
		nomeTf.setText("");
		sobrenomeTf.setText("");
		nomeFantasiaTf.setText("");
		razaoSocialTf.setText("");
		cpfTf.setText("");
		cnpjTf.setText("");
	}
	
	private void loadCamposByObject (AbstractPessoa pessoa) {
		if (pessoa.isPessoaFisica()) {
			nomeTf.setEnabled(true);
			nomeTf.setText(pessoa.getNomeAbs());
			razaoSocialTf.setEnabled(false);;
			
			sobrenomeTf.setEnabled(true);;
			sobrenomeTf.setText(pessoa.getSecondNomeAbs());
			nomeFantasiaTf.setEnabled(false);
			
			cpfTf.setEnabled(true);
			cnpjTf.setEnabled(false);
			
			cpfTf.setText(pessoa.getDocumento());
			cnpjTf.setText("");
		}
		if (pessoa.isPessoaJuridica()) {
			nomeTf.setEnabled(false);
			razaoSocialTf.setText(pessoa.getNomeAbs());
			razaoSocialTf.setEnabled(true);;
			
			sobrenomeTf.setEnabled(false);
			nomeFantasiaTf.setEnabled(true);
			nomeFantasiaTf.setText(pessoa.getSecondNomeAbs());
			
			cpfTf.setEnabled(false);
			cnpjTf.setEnabled(true);
			
			cpfTf.setText("");
			cnpjTf.setText(pessoa.getDocumento());
		}
	}
	
	private void generateTable() {
		tableModel = new TableModelImpl(pessoaModelConverter);
		
		table = new CustomTable();
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumn("Nome").setPreferredWidth(200);
		table.getColumn("Documento").setPreferredWidth(200);
		
		scrollPane.setViewportView(table);
		scrollPane.setBounds(10, 40, 470, 180);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(null);
		addActionToTable();
		
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	private void addActionToTable() {
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() > -1) {
					AbstractPessoa pessoa = pessoaModelConverter.getObjectByRowIndex(table.getSelectedRow());
					loadCamposByObject(pessoa);
				}
				
			}
		});
	}
	
	@Override
	protected void addActions() {
		getSalvarBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nome = nomeTf.getText();
				String sobreNome = sobrenomeTf.getText();
				String nomeFantasia = nomeFantasiaTf.getText();
				String razaoSocial = razaoSocialTf.getText();
				String cpf = cpfTf.getText();
				String cnpj = cnpjTf.getText();
				Endereco endereco = enderecoCb.getItemAt(enderecoCb.getSelectedIndex());
				
				Character tipoPessoa = null;
				if (fisicaRb.isSelected()) {
					tipoPessoa = 'F';
					try {
						PessoaFisica pessoaFisica = new PessoaFisica(cpf, endereco, nome, sobreNome);
						pessoaController.inserirPessoa(pessoaFisica);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o cliente");
						return;
					}
					limparCampos();
					generateTable();
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
				} else if (juridicaRb.isSelected()) {
					tipoPessoa = 'J';
					try {
						PessoaJuridica pessoaJuridica = new PessoaJuridica(cnpj, endereco, razaoSocial, nomeFantasia);
						pessoaController.inserirPessoa(pessoaJuridica);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o cliente");
						return;
					}
					limparCampos();
					generateTable();
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
				}
				
			}
		});
		
		getNovoBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCampos();
				table.clearSelection();
				
			}
		});
		
		getExcluirBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer codigo = new Integer(codigoTf.getText());
				try {
					pessoaController.removerPessoa(codigo);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				limparCampos();
				generateTable();
				
			}
		});
		
	}
}
