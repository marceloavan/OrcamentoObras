package edu.asselvi.orcamentoobras.view.pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;
import edu.asselvi.orcamentoobras.model.beans.CustoUnitarioBasico;
import edu.asselvi.orcamentoobras.model.beans.Orcamento;
import edu.asselvi.orcamentoobras.model.beans.Previsao;
import edu.asselvi.orcamentoobras.model.beans.PrevisaoOrcamento;
import edu.asselvi.orcamentoobras.model.beans.Terreno;
import edu.asselvi.orcamentoobras.model.exception.MetragemConstrucaoMaiorTerrenoException;
import edu.asselvi.orcamentoobras.model.exception.TerrenoNullException;
import edu.asselvi.orcamentoobras.service.CustoUnitarioBasicoService;
import edu.asselvi.orcamentoobras.service.OrcamentoService;
import edu.asselvi.orcamentoobras.service.PessoaService;
import edu.asselvi.orcamentoobras.service.TerrenoService;
import edu.asselvi.orcamentoobras.view.components.CustomTable;
import edu.asselvi.orcamentoobras.view.components.table.model.OrcamentoModelConverter;
import edu.asselvi.orcamentoobras.view.components.table.model.PrevisaoOrcamentoModelConverter;
import edu.asselvi.orcamentoobras.view.components.table.model.TableModelImpl;
import edu.asselvi.orcamentoobras.view.templates.TemplateCadastroPages;

public class OrcamentoPage extends TemplateCadastroPages {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea descricaoOrcamentoTa;
	private JTextField nomeOrcamentoTf;
	private JScrollPane descricaoOrcamentoSp;
	private JComboBox<AbstractPessoa> clienteCb;
	private JComboBox<Terreno> terrenoCb;
	private JComboBox<CustoUnitarioBasico> cubCb;
	private JTextField metragemTf;
	private JTextField percentualLucroTf;
	private JTextField valorVendaCubTf;
	private JTextField valorVendaPrevisaoTf;
	
	private OrcamentoService orcamentoController;
	private PessoaService pessoaController;
	private TerrenoService terrenoController;
	private CustoUnitarioBasicoService custoUnitarioBasicoController;
	
	private JScrollPane scrollPaneTableOrcamento = new JScrollPane();
	private CustomTable tableOrcamento;
	private OrcamentoModelConverter orcamentoModelConverter;
	private AbstractTableModel tableModelOrcamento;
	
	private JScrollPane scrollPaneTablePrevisaoOrcamento = new JScrollPane();
	private CustomTable tablePrevisaoOrcamento;
	private PrevisaoOrcamentoModelConverter previsaoOrcamentoModelConverter;
	private AbstractTableModel tableModelPrevisaoOrcamento;
	
	private boolean editingOrcamento = false;
	private Orcamento orcamentoEdited;
	
	private JComboBox<Previsao> previsaoCb;
	private JTextField valorPrevisaoTf;
	private JButton incluirPrevisaoBtn;

	public OrcamentoPage() {
		super(600, 1000);
		
		orcamentoController = new OrcamentoService();
		pessoaController = new PessoaService();
		terrenoController = new TerrenoService();
		custoUnitarioBasicoController = new CustoUnitarioBasicoService();
		
		generateTable();
		getContentPane().add(scrollPaneTableOrcamento);
		getContentPane().add(scrollPaneTablePrevisaoOrcamento);
		
		int yPosition = 160;
		nomeOrcamentoTf = new JTextField();
		nomeOrcamentoTf.setBounds(175, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(nomeOrcamentoTf);
		
		JLabel nomeLb = new JLabel("Nome");
		nomeLb.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeLb.setBounds(10, yPosition+5, 145, 15);
		getContentPane().add(nomeLb);
		
		yPosition += getDistanceTf();
		descricaoOrcamentoTa = new JTextArea();
		descricaoOrcamentoTa.setLineWrap(true);
		descricaoOrcamentoTa.setWrapStyleWord(true);
		descricaoOrcamentoSp = new JScrollPane(descricaoOrcamentoTa);
		descricaoOrcamentoSp.setViewportView(descricaoOrcamentoTa);
		descricaoOrcamentoSp.setBounds(175, yPosition, getWidthTf(), getHeightTf()*3);
		descricaoOrcamentoSp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		descricaoOrcamentoSp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		descricaoOrcamentoSp.setBorder(null);
		getContentPane().add(descricaoOrcamentoSp);
		
		JLabel descricaoLb = new JLabel("Descri��o");
		descricaoLb.setHorizontalAlignment(SwingConstants.RIGHT);
		descricaoLb.setBounds(10, yPosition+5, 145, 15);
		getContentPane().add(descricaoLb);
		
		yPosition += (getDistanceTf()*3)+4;
		clienteCb = new JComboBox<AbstractPessoa>();
		clienteCb.setBounds(175, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(clienteCb);
		
		JLabel clienteLb = new JLabel("Cliente");
		clienteLb.setHorizontalAlignment(SwingConstants.RIGHT);
		clienteLb.setBounds(10, yPosition+5, 145, 15);
		getContentPane().add(clienteLb);
		
		yPosition += getDistanceTf();
		terrenoCb = new JComboBox<Terreno>();
		terrenoCb.setBounds(175, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(terrenoCb);
		
		JLabel terrenoLb = new JLabel("Terreno");
		terrenoLb.setHorizontalAlignment(SwingConstants.RIGHT);
		terrenoLb.setBounds(10, yPosition+5, 145, 15);
		getContentPane().add(terrenoLb);
		
		yPosition += getDistanceTf();
		cubCb = new JComboBox<CustoUnitarioBasico>();
		cubCb.setBounds(175, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(cubCb);
		
		JLabel cubLb = new JLabel("C.U.B.");
		cubLb.setHorizontalAlignment(SwingConstants.RIGHT);
		cubLb.setBounds(10, yPosition+5, 145, 15);
		getContentPane().add(cubLb);
		
		yPosition += getDistanceTf();
		metragemTf = new JTextField();
		metragemTf.setBounds(175, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(metragemTf);
		
		JLabel metragemLb = new JLabel("Metragem");
		metragemLb.setHorizontalAlignment(SwingConstants.RIGHT);
		metragemLb.setBounds(10, yPosition+5, 145, 15);
		getContentPane().add(metragemLb);
		
		yPosition += getDistanceTf();
		percentualLucroTf = new JTextField();
		percentualLucroTf.setBounds(175, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(percentualLucroTf);
		
		JLabel percentualLucroLb = new JLabel("Lucro (%)");
		percentualLucroLb.setHorizontalAlignment(SwingConstants.RIGHT);
		percentualLucroLb.setBounds(10, yPosition+5, 145, 15);
		getContentPane().add(percentualLucroLb);
		
		yPosition += getDistanceTf() + 25;
		valorVendaCubTf = new JTextField();
		valorVendaCubTf.setBounds(175, yPosition, getWidthTf(), getHeightTf());
		valorVendaCubTf.setEditable(false);
		getContentPane().add(valorVendaCubTf);
		
		JLabel valorVendaCubLb = new JLabel("Valor venda C.U.B");
		valorVendaCubLb.setHorizontalAlignment(SwingConstants.RIGHT);
		valorVendaCubLb.setBounds(10, yPosition+5, 145, 15);
		getContentPane().add(valorVendaCubLb);
		
		yPosition += getDistanceTf();
		valorVendaPrevisaoTf = new JTextField();
		valorVendaPrevisaoTf.setBounds(175, yPosition, getWidthTf(), getHeightTf());
		valorVendaPrevisaoTf.setEditable(false);
		getContentPane().add(valorVendaPrevisaoTf);
		
		JLabel valorVendaPrevisaoLb = new JLabel("Valor venda previs�es");
		valorVendaPrevisaoLb.setHorizontalAlignment(SwingConstants.RIGHT);
		valorVendaPrevisaoLb.setBounds(10, yPosition+5, 145, 15);
		getContentPane().add(valorVendaPrevisaoLb);
		
		JLabel previsoesLb = new JLabel("Previs�es:");
		previsoesLb.setBounds(503, 160, 480, 15);
		getContentPane().add(previsoesLb);
		
		JLabel previsaoLb = new JLabel("Previs�o:");
		previsaoLb.setBounds(500, 300, getWidthTf()-50, getHeightTf());
		getContentPane().add(previsaoLb);
		
		previsaoCb = new JComboBox<Previsao>();
		previsaoCb.setBounds(500, 320, getWidthTf()-50, getHeightTf());
		getContentPane().add(previsaoCb);

		JLabel valorPrevisaoLb = new JLabel("Valor:");
		valorPrevisaoLb.setBounds(500 + getWidthTf()-35, 300, getWidthTf()-50, getHeightTf());
		getContentPane().add(valorPrevisaoLb);
		
		valorPrevisaoTf = new JTextField();
		valorPrevisaoTf.setBounds(500 + getWidthTf()-35, 320, getWidthTf()-50, getHeightTf());
		getContentPane().add(valorPrevisaoTf);
		
		incluirPrevisaoBtn = new JButton("Incluir Previs�o");
		incluirPrevisaoBtn.setBounds(840, 350, 135, 25);
		getContentPane().add(incluirPrevisaoBtn);
	
		setEnablePrevisaoInclude(false);
		
		loadItensForCb();
		addActions();
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	private void setEnablePrevisaoInclude(boolean enabled) {
		incluirPrevisaoBtn.setEnabled(enabled);
		valorPrevisaoTf.setEnabled(enabled);
		previsaoCb.setEnabled(enabled);
	}
	
	private void loadItensForCb() {
		clienteCb.addItem(null);
		for (AbstractPessoa item : pessoaController.getPessoas()) {
			clienteCb.addItem(item);
		}
		terrenoCb.addItem(null);
		for (Terreno item : terrenoController.getTerrenos()) {
			terrenoCb.addItem(item);
		}
		cubCb.addItem(null);
		for (CustoUnitarioBasico cub : custoUnitarioBasicoController.getCustos()) {
			cubCb.addItem(cub);
		}
		previsaoCb.addItem(null);
		for (Previsao previsao : orcamentoController.getAllPrevisoes()) {
			previsaoCb.addItem(previsao);
		}
	}
	
	private void generateTable() {
		/*
		 * OR�AMENTO 
		 */
		orcamentoModelConverter = new OrcamentoModelConverter();
		
		tableModelOrcamento = new TableModelImpl(orcamentoModelConverter);
		
		tableOrcamento = new CustomTable();
		tableOrcamento.setModel(tableModelOrcamento);
		tableOrcamento.getColumn("Orcamento").setPreferredWidth(490);
		tableOrcamento.getColumn("Terreno").setPreferredWidth(450);
		
		scrollPaneTableOrcamento.setViewportView(tableOrcamento);
		scrollPaneTableOrcamento.setBounds(20, 40, 960, 100);
		scrollPaneTableOrcamento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneTableOrcamento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		generateSecondsTables();
		
		addActionToTable();
		
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	private void generateSecondsTables() {
		/*
		 * PREVISAO ORCAMENTO 
		 */
		previsaoOrcamentoModelConverter = new PrevisaoOrcamentoModelConverter(orcamentoEdited);
		
		tableModelPrevisaoOrcamento = new TableModelImpl(previsaoOrcamentoModelConverter);
		
		tablePrevisaoOrcamento = new CustomTable();
		tablePrevisaoOrcamento.setModel(tableModelPrevisaoOrcamento);
		tablePrevisaoOrcamento.getColumn("Previs�o").setPreferredWidth(300);
		tablePrevisaoOrcamento.getColumn("Valor").setPreferredWidth(160);
		tablePrevisaoOrcamento.setEnabled(false);
		
		scrollPaneTablePrevisaoOrcamento.setViewportView(tablePrevisaoOrcamento);
		scrollPaneTablePrevisaoOrcamento.setBounds(500, 180, 480, 120);
		scrollPaneTablePrevisaoOrcamento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneTablePrevisaoOrcamento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
	private void loadCamposByObject(Orcamento orcamento) {
		nomeOrcamentoTf.setText(orcamento.getNome());
		descricaoOrcamentoTa.setText(orcamento.getDescricao());
		clienteCb.setSelectedItem(orcamento.getCliente());
		terrenoCb.setSelectedItem(orcamento.getTerreno());
		cubCb.setSelectedItem(orcamento.getCub());
		metragemTf.setText(orcamento.getMetragemConstrucao().toString());
		percentualLucroTf.setText(orcamento.getPercentualLucro().toString());
		loadCalculatedValuesByObject(orcamento);
		
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	private void loadCalculatedValuesByObject(Orcamento orcamento) {
		String vendaCub = String.valueOf(orcamento.getValorVendaCub());
		String vendaPrevisao = String.valueOf(orcamento.getValorVendaPrevisao().doubleValue());
		
		valorVendaCubTf.setText(vendaCub);
		valorVendaPrevisaoTf.setText(vendaPrevisao);
	}
	
	private void limparCampos() {
		nomeOrcamentoTf.setText("");
		descricaoOrcamentoTa.setText("");
		clienteCb.setSelectedItem(null);
		terrenoCb.setSelectedItem(null);
		cubCb.setSelectedItem(null);
		metragemTf.setText("");
		percentualLucroTf.setText("");
		valorVendaCubTf.setText("");
		valorVendaPrevisaoTf.setText("");
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	@Override
	protected void addActions() {
		
		incluirPrevisaoBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				
				Previsao previsao = previsaoCb.getItemAt(previsaoCb.getSelectedIndex());
				if (previsao == null) {
					JOptionPane.showMessageDialog(null, "Selecione uma previs�o");
					return;
				}
				
				String valorPrevisao = valorPrevisaoTf.getText();
				if (valorPrevisao == null || valorPrevisao.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe o valor da previs�o");
					return;
				}
				
				BigDecimal valorConverted;
				try {
					valorConverted = new BigDecimal(valorPrevisao);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor da previs�o � inv�lido");
					return;
				}
				try {
					orcamentoController.cadastrarPrevisaoOrcamento(new PrevisaoOrcamento(valorConverted, previsao, orcamentoEdited));
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "N�o foi poss�vel incluir a previs�o ao or�amento");
					return;
				}
				generateSecondsTables();
				orcamentoEdited = orcamentoModelConverter.getObjectByRowIndex(tableOrcamento.getSelectedRow());
				loadCalculatedValuesByObject(orcamentoEdited);
				
				previsaoCb.setSelectedItem(null);
				valorPrevisaoTf.setText("");
				JOptionPane.showMessageDialog(null, "Previs�o incluida com sucesso");
			}
		});
		
		getNovoBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableOrcamento.clearSelection();
				limparCampos();
				orcamentoEdited = null;
				editingOrcamento = false;
				generateSecondsTables();
				setEnablePrevisaoInclude(false);
			}
		});
		
		getSalvarBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String nome = nomeOrcamentoTf.getText();
				if (nome == null || nome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informa o nome do or�amento");
					return;
				}
				
				String descricao = descricaoOrcamentoTa.getText();
				if (descricao == null || descricao.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informa a descri��o do or�amento");
					return;
				}
				
				AbstractPessoa cliente = clienteCb.getItemAt(clienteCb.getSelectedIndex());
				if (cliente == null) {
					JOptionPane.showMessageDialog(null, "Selecione um cliente");
					return;
				}
				
				Terreno terreno = terrenoCb.getItemAt(terrenoCb.getSelectedIndex());
				if (terreno == null) {
					JOptionPane.showMessageDialog(null, "Selecione um terreno");
					return;
				}
				
				CustoUnitarioBasico cub = cubCb.getItemAt(cubCb.getSelectedIndex());
				if (cub == null) {
					JOptionPane.showMessageDialog(null, "Selecione um custo unitário básico (C.U.B.)");
					return;
				}
				Double metragemConstrucao = new Double(metragemTf.getText());
				Double percentualLucro = new Double(percentualLucroTf.getText());
				
				Orcamento orcamento = null;
				try {
					orcamento = new Orcamento(nome, descricao, cub, terreno, metragemConstrucao);
				} catch (MetragemConstrucaoMaiorTerrenoException e) {
					JOptionPane.showMessageDialog(null, "A metragem da construção não pode ser maior que a do terreno.");
					return;
				} catch (TerrenoNullException e) {
					e.printStackTrace();
				}
				orcamento.setPercentualLucro(percentualLucro);
				orcamento.setCliente(cliente);
				try {
					if (editingOrcamento) {
						orcamento.setId(orcamentoEdited.getId());
						orcamentoController.atualizarOrcamento(orcamento);
					} else {
						orcamentoController.cadastrarOrcamento(orcamento);
					}
					// quando o orcamentoEdited (contexto) n�o � nulo
					// o mesmo deve repassar a lista da previsoes (que nao � informado em tela)
					// antes de ser substituido pelo orcamento de edi��o
					if (orcamentoEdited != null) {
						orcamento.setPrevisaoList(orcamentoEdited.getPrevisaoList());
					}
					orcamentoEdited = orcamento;
					loadCalculatedValuesByObject(orcamentoEdited);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar or�amento");
					return;
				}
				generateTable();
				editingOrcamento = true;
				JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
			}
		});
		
		getExcluirBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					orcamentoController.removerOrcamento(orcamentoEdited);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "N�o foi poss�vel remover o registro");
					return;
				}
				generateTable();
				JOptionPane.showMessageDialog(null, "Registro removido com sucesso");
			}
		});
	}
	
	/**
	 * M�todo separado porque a tabela � recriada quando algum registro � criado/ removido
	 */
	private void addActionToTable() {
		tableOrcamento.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tableOrcamento.getSelectedRow() > -1) {
					editingOrcamento = true;
					orcamentoEdited = orcamentoModelConverter.getObjectByRowIndex(tableOrcamento.getSelectedRow());
					loadCamposByObject(orcamentoEdited);
					generateSecondsTables();
					setEnablePrevisaoInclude(true);
				}
			}
		});
	}
}
