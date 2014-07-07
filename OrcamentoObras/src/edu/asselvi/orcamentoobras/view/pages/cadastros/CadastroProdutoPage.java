package edu.asselvi.orcamentoobras.view.pages.cadastros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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

import edu.asselvi.orcamentoobras.controller.ProdutoController;
import edu.asselvi.orcamentoobras.model.beans.Produto;
import edu.asselvi.orcamentoobras.view.components.CustomTable;
import edu.asselvi.orcamentoobras.view.components.table.model.ProdutoModelConverter;
import edu.asselvi.orcamentoobras.view.components.table.model.TableModelImpl;
import edu.asselvi.orcamentoobras.view.templates.TemplateCadastroPages;

public class CadastroProdutoPage extends TemplateCadastroPages{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane = new JScrollPane();
	private CustomTable table;
	private ProdutoModelConverter produtoModelConverter;
	private AbstractTableModel tableModel;
	
	private JTextField codigoTf;
	private JTextField descricaoTf;
	
	private boolean editingUser = false;
	
	private ProdutoController produtoController;
	
	public CadastroProdutoPage() {
		super(500,500);
		
		produtoController = new ProdutoController();
		produtoModelConverter =  new ProdutoModelConverter();
		
		generateTable();
		
		getContentPane().add(scrollPane);
		
		JLabel codigoLb = new JLabel("Código:");
		codigoLb.setHorizontalAlignment(SwingConstants.RIGHT);
		codigoLb.setBounds(10, 250, 90, 15);
		getContentPane().add(codigoLb);
		
		JLabel descricaoLb = new JLabel("Descrição:");
		descricaoLb.setHorizontalAlignment(SwingConstants.RIGHT);
		descricaoLb.setBounds(10, 275, 90, 15);
		getContentPane().add(descricaoLb);
		
		int yPosition = 245;
		codigoTf = new JTextField();
		codigoTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		codigoTf.setColumns(10);
		getContentPane().add(codigoTf);
		
		
		yPosition += getDistanceTf();
		descricaoTf = new JTextField();
		descricaoTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		descricaoTf.setColumns(10);
		getContentPane().add(descricaoTf);
		
		
		addActions();
		SwingUtilities.updateComponentTreeUI(this);
		
	}
	
	private void limparCampos(){
		codigoTf.setText("");
		descricaoTf.setText("");
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	private void loadCamposByObject(Produto produto) {
		codigoTf.setText(produto.getCodigo().toString());
		descricaoTf.setText(produto.getDescricao());
	}
	
	private void generateTable() {
		tableModel = new TableModelImpl(produtoModelConverter);
		
		table = new CustomTable();
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumn("Código").setPreferredWidth(200);
		table.getColumn("Descrição").setPreferredWidth(250);
		
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
			public void actionPerformed(ActionEvent e) {
				String descricao = descricaoTf.getText();
				Integer codigo = Integer.parseInt(codigoTf.getText());
								
				if (descricao.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe a descrição do produto");
					return;
				}
				try {
					produtoController.cadastrarProduto(new Produto(codigo, descricao));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o produto");
					return;
				}
				limparCampos();
				generateTable();
				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
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
			public void actionPerformed(ActionEvent e) {
				try {
					Integer codigo = Integer.parseInt(codigoTf.getText());
					produtoController.removerProduto(codigo);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					return;
				}
				limparCampos();
				generateTable();
			}
		});
		
	}
	
	private void addActionToTable(){
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() > -1) {
					Produto produto = produtoModelConverter.getObjectByRowIndex(table.getSelectedRow());
					loadCamposByObject(produto);
					editingUser = true;
				}
				
			}
		});
	}

}
