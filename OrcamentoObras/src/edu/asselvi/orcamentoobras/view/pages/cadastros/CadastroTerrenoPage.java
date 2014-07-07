package edu.asselvi.orcamentoobras.view.pages.cadastros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import edu.asselvi.orcamentoobras.controller.EnderecoController;
import edu.asselvi.orcamentoobras.controller.TerrenoController;
import edu.asselvi.orcamentoobras.model.beans.Endereco;
import edu.asselvi.orcamentoobras.model.beans.Terreno;
import edu.asselvi.orcamentoobras.view.components.CustomTable;
import edu.asselvi.orcamentoobras.view.components.table.model.TableModelImpl;
import edu.asselvi.orcamentoobras.view.components.table.model.TerrenoModelConverter;
import edu.asselvi.orcamentoobras.view.templates.TemplateCadastroPages;

public class CadastroTerrenoPage extends TemplateCadastroPages{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane = new JScrollPane();
	private CustomTable table;
	private TerrenoModelConverter terrenoModelConverter;
	private AbstractTableModel tableModel;
	
	private JTextField codigoTf;
	private JTextField valorVendaTf;
	private JTextField metragemTf;
	private JTextField itbiTf;
	private JTextField frjTf;
	private JTextField escrituraTf;
	private JTextField registroTf;
	private JTextField descricaoTf;
	private JComboBox<Endereco> enderecoCb;
	
	
	private TerrenoController terrenoController;
	private EnderecoController enderecoController;
	
	public CadastroTerrenoPage(){
		super(580,500);
		
		terrenoController = new TerrenoController();
		enderecoController = new EnderecoController();
		
		terrenoModelConverter = new TerrenoModelConverter();
		
		generateTable();
		
		getContentPane().add(scrollPane);
		
		JLabel descricaoLb = new JLabel("Descrição");
		descricaoLb.setBounds(10, 250, 90, 15);
		descricaoLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(descricaoLb);
		
		JLabel enderecoLb = new JLabel("Endereço");
		enderecoLb.setBounds(10, 275, 90, 15);
		enderecoLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(enderecoLb);
		
		JLabel metragemLb = new JLabel("Metragem");
		metragemLb.setBounds(10, 300, 90, 15);
		metragemLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(metragemLb);
		
		JLabel valorVendaLb = new JLabel("Vlr. Venda");
		valorVendaLb.setBounds(10, 325, 90, 15);
		valorVendaLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(valorVendaLb);
		
		JLabel itbiLb = new JLabel("Vlr. ITBI");
		itbiLb.setBounds(10, 350, 90, 15);
		itbiLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(itbiLb);
		
		JLabel frjLb = new JLabel("Vlr. FRJ");
		frjLb.setBounds(10, 375, 90, 15);
		frjLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(frjLb);
		
		JLabel escrituraLb = new JLabel("Vlr. Escritura");
		escrituraLb.setBounds(10, 400, 90, 15);
		escrituraLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(escrituraLb);
		
		JLabel registroLb = new JLabel("Vlr Registro");
		registroLb.setBounds(10, 425, 90, 15);
		registroLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(registroLb);
		
		int yPosition = 245;
		
		descricaoTf = new JTextField();
		descricaoTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		descricaoTf.setColumns(10);
		getContentPane().add(descricaoTf);
		
		yPosition += getDistanceTf();
		enderecoCb = new JComboBox<Endereco>();
		enderecoCb.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(enderecoCb);
		
		yPosition += getDistanceTf();
		metragemTf = new JTextField();
		metragemTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		metragemTf.setColumns(10);
		getContentPane().add(metragemTf);
		
		yPosition += getDistanceTf();
		valorVendaTf = new JTextField();
		valorVendaTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		valorVendaTf.setColumns(10);
		getContentPane().add(valorVendaTf);
		
		yPosition += getDistanceTf();
		itbiTf = new JTextField();
		itbiTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		itbiTf.setColumns(10);
		getContentPane().add(itbiTf);
		
		yPosition += getDistanceTf();
		frjTf = new JTextField();
		frjTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		frjTf.setColumns(10);
		getContentPane().add(frjTf);
		
		yPosition += getDistanceTf();
		escrituraTf = new JTextField();
		escrituraTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		escrituraTf.setColumns(10);
		getContentPane().add(escrituraTf);
		
		yPosition += getDistanceTf();
		registroTf = new JTextField();
		registroTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		registroTf.setColumns(10);
		getContentPane().add(registroTf);
		
		addActions();
		SwingUtilities.updateComponentTreeUI(this);
		loadItensForCb();
		
		yPosition += getDistanceTf();
		codigoTf = new JTextField();
		codigoTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		getContentPane().add(codigoTf);
		codigoTf.setVisible(false);
	}
	
	private void loadItensForCb() {
		enderecoCb.addItem(null);
		for (Endereco endereco : enderecoController.getTodos()) {
			enderecoCb.addItem(endereco);
		}
	}
	
	private void limparCampos() {
		descricaoTf.setText("");
		valorVendaTf.setText("");
		itbiTf.setText("");
		frjTf.setText("");
		escrituraTf.setText("");
		registroTf.setText("");
		metragemTf.setText("");
		
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	private void loadCamposByObject (Terreno terreno) {
		descricaoTf.setText(terreno.getDescricao());
		valorVendaTf.setText(terreno.getValorVenda().toString());
		itbiTf.setText(terreno.getValorITBI().toString());
		frjTf.setText(terreno.getValorFRJ().toString());
		escrituraTf.setText(terreno.getValorEscritura().toString());
		registroTf.setText(terreno.getValorRegistro().toString());
		metragemTf.setText(terreno.getMetragem().toString());
	}
	
	private void generateTable() {
		tableModel = new TableModelImpl(terrenoModelConverter);
		
		table = new CustomTable();
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumn("Descrição").setPreferredWidth(200);
		table.getColumn("Metragem").setPreferredWidth(250);
		
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
					Terreno terreno = terrenoModelConverter.getObjectByRowIndex(table.getSelectedRow());
					loadCamposByObject(terreno);
				}
				
			}
		});
	}
	
	@Override
	protected void addActions() {
		getSalvarBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String descricao = descricaoTf.getText();
				if (descricao.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe a descrição");
					return;
				}
				
				BigDecimal valorVenda = new BigDecimal(valorVendaTf.getText());
				BigDecimal valorItbi = new BigDecimal(itbiTf.getText());
				BigDecimal valorFrj = new BigDecimal(frjTf.getText());
				BigDecimal escritura = new BigDecimal(escrituraTf.getText());
				BigDecimal registro = new BigDecimal(escrituraTf.getText());
				Double metragem = new Double (metragemTf.getText());
				Endereco endereco = enderecoCb.getItemAt(enderecoCb.getSelectedIndex());
				
				
				try {
					Terreno terreno = new Terreno(descricao, valorVenda, endereco, metragem);
					terreno.setValorEscritura(escritura);
					terreno.setValorFRJ(valorFrj);
					terreno.setValorITBI(valorItbi);
					terreno.setValorRegistro(registro);
					
					terrenoController.cadastrarTerreno(terreno);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o terreno");
					return;
				}
				limparCampos();
				generateTable();
				JOptionPane.showMessageDialog(null, "Terreno cadastrado com sucesso");
				
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
				try {
					Integer codigo = Integer.parseInt(codigoTf.getText());
					terrenoController.removerTerreno(codigo);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				limparCampos();
				generateTable();
			}
		});
		
	}

}
