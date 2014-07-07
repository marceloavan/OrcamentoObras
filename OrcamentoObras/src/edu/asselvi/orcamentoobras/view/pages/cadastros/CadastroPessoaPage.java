package edu.asselvi.orcamentoobras.view.pages.cadastros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

import edu.asselvi.orcamentoobras.controller.EnderecoController;
import edu.asselvi.orcamentoobras.controller.PessoaController;
import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;
import edu.asselvi.orcamentoobras.model.beans.Endereco;
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
		getContentPane().add(fisicaRb);
		
		juridicaRb = new JRadioButton("Jurídica");
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
		nomeTf.setText(pessoa.getNomeAbs());
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
		//addActionToTable();
		
		SwingUtilities.updateComponentTreeUI(this);
	}
	@Override
	protected void addActions() {
		getSalvarBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		getNovoBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		getExcluirBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
