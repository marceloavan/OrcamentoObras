package edu.asselvi.orcamentoobras.view.pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import edu.asselvi.orcamentoobras.controller.CustoUnitarioBasicoController;
import edu.asselvi.orcamentoobras.controller.OrcamentoController;
import edu.asselvi.orcamentoobras.controller.PessoaController;
import edu.asselvi.orcamentoobras.controller.TerrenoController;
import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;
import edu.asselvi.orcamentoobras.model.beans.CustoUnitarioBasico;
import edu.asselvi.orcamentoobras.model.beans.Orcamento;
import edu.asselvi.orcamentoobras.model.beans.Terreno;
import edu.asselvi.orcamentoobras.model.exception.MetragemConstrucaoMaiorTerrenoException;
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
	private JTextField percuntalLucroTf;
	
	private OrcamentoController orcamentoController;
	private PessoaController pessoaController;
	private TerrenoController terrenoController;
	private CustoUnitarioBasicoController custoUnitarioBasicoController;

	public OrcamentoPage() {
		super(700, 1000);
		
		orcamentoController = new OrcamentoController();
		pessoaController = new PessoaController();
		terrenoController = new TerrenoController();
		custoUnitarioBasicoController = new CustoUnitarioBasicoController();
		
		int yPosition = 160;
		nomeOrcamentoTf = new JTextField();
		nomeOrcamentoTf.setBounds(125, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(nomeOrcamentoTf);
		
		JLabel nomeLb = new JLabel("Nome");
		nomeLb.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeLb.setBounds(10, yPosition+5, 90, 15);
		getContentPane().add(nomeLb);
		
		yPosition += getDistanceTf();
		descricaoOrcamentoTa = new JTextArea();
		descricaoOrcamentoTa.setLineWrap(true);
		descricaoOrcamentoTa.setWrapStyleWord(true);
		descricaoOrcamentoSp = new JScrollPane(descricaoOrcamentoTa);
		descricaoOrcamentoSp.setViewportView(descricaoOrcamentoTa);
		descricaoOrcamentoSp.setBounds(125, yPosition, getWidthTf(), getHeightTf()*3);
		descricaoOrcamentoSp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		descricaoOrcamentoSp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		descricaoOrcamentoSp.setBorder(null);
		getContentPane().add(descricaoOrcamentoSp);
		
		JLabel descricaoLb = new JLabel("Descrição");
		descricaoLb.setHorizontalAlignment(SwingConstants.RIGHT);
		descricaoLb.setBounds(10, yPosition+5, 90, 15);
		getContentPane().add(descricaoLb);
		
		yPosition += (getDistanceTf()*3)+4;
		clienteCb = new JComboBox<AbstractPessoa>();
		clienteCb.setBounds(125, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(clienteCb);
		
		JLabel clienteLb = new JLabel("Cliente");
		clienteLb.setHorizontalAlignment(SwingConstants.RIGHT);
		clienteLb.setBounds(10, yPosition+5, 90, 15);
		getContentPane().add(clienteLb);
		
		yPosition += getDistanceTf();
		terrenoCb = new JComboBox<Terreno>();
		terrenoCb.setBounds(125, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(terrenoCb);
		
		JLabel terrenoLb = new JLabel("Terreno");
		terrenoLb.setHorizontalAlignment(SwingConstants.RIGHT);
		terrenoLb.setBounds(10, yPosition+5, 90, 15);
		getContentPane().add(terrenoLb);
		
		yPosition += getDistanceTf();
		cubCb = new JComboBox<CustoUnitarioBasico>();
		cubCb.setBounds(125, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(cubCb);
		
		JLabel cubLb = new JLabel("C.U.B.");
		cubLb.setHorizontalAlignment(SwingConstants.RIGHT);
		cubLb.setBounds(10, yPosition+5, 90, 15);
		getContentPane().add(cubLb);
		
		yPosition += getDistanceTf();
		metragemTf = new JTextField();
		metragemTf.setBounds(125, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(metragemTf);
		
		JLabel metragemLb = new JLabel("Metragem");
		metragemLb.setHorizontalAlignment(SwingConstants.RIGHT);
		metragemLb.setBounds(10, yPosition+5, 90, 15);
		getContentPane().add(metragemLb);
		
		yPosition += getDistanceTf();
		percuntalLucroTf = new JTextField();
		percuntalLucroTf.setBounds(125, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(percuntalLucroTf);
		
		JLabel percentualLucroLb = new JLabel("Lucro (%)");
		percentualLucroLb.setHorizontalAlignment(SwingConstants.RIGHT);
		percentualLucroLb.setBounds(10, yPosition+5, 90, 15);
		getContentPane().add(percentualLucroLb);
		
		loadItensForCb();
		addActions();
		SwingUtilities.updateComponentTreeUI(this);
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
	}
	
	@Override
	protected void addActions() {
		
		getSalvarBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String nome = nomeOrcamentoTf.getText();
				if (nome == null || nome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informa o nome do orçamento");
					return;
				}
				
				String descricao = descricaoOrcamentoTa.getText();
				if (descricao == null || descricao.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informa a descrição do orçamento");
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
				Double percentualLucro = new Double(percuntalLucroTf.getText());
				
				Orcamento orcamento = null;
				try {
					orcamento = new Orcamento(nome, descricao, cub, terreno, metragemConstrucao);
				} catch (MetragemConstrucaoMaiorTerrenoException e) {
					JOptionPane.showMessageDialog(null, "A metragem da construção não pode ser maior que a do terreno.");
					return;
				}
				orcamento.setPercentualLucro(percentualLucro);
				orcamento.setCliente(cliente);
				try {
					orcamentoController.cadastrarOrcamento(orcamento);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar orçamento");
					return;
				}
			}
		});
		
	}
}
