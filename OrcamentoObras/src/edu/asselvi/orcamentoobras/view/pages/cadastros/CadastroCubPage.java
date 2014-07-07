package edu.asselvi.orcamentoobras.view.pages.cadastros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
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

import edu.asselvi.orcamentoobras.controller.CustoUnitarioBasicoController;
import edu.asselvi.orcamentoobras.model.beans.CustoUnitarioBasico;
import edu.asselvi.orcamentoobras.view.components.CustomTable;
import edu.asselvi.orcamentoobras.view.components.table.model.CubModelConverter;
import edu.asselvi.orcamentoobras.view.components.table.model.TableModelImpl;
import edu.asselvi.orcamentoobras.view.templates.TemplateCadastroPages;

public class CadastroCubPage extends TemplateCadastroPages{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane = new JScrollPane();
	private CustomTable table;
	private CubModelConverter cubModelConverter;
	private AbstractTableModel tableModel;
	
	private JTextField codigoTf;
	private JTextField mesTf;
	private JTextField anoTf;
	private JTextField valorTf;
	
	private CustoUnitarioBasicoController cubController;
	
	public CadastroCubPage() {
		
		super(500,500);
		
		cubController = new CustoUnitarioBasicoController();
		cubModelConverter = new CubModelConverter();
		
		generateTable();
		
		getContentPane().add(scrollPane);
		
		JLabel mesLb = new JLabel("Mês");
		mesLb.setBounds(10, 250, 90, 15);
		mesLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(mesLb);
		
		JLabel anoLb = new JLabel("Ano");
		anoLb.setBounds(10, 275, 90, 15);
		anoLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(anoLb);
		
		JLabel valorLb = new JLabel("Vlr M2");
		valorLb.setBounds(10, 300, 90, 15);
		valorLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(valorLb);
		
		int yPosition = 245;
		mesTf = new JTextField();
		mesTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		mesTf.setColumns(10);
		getContentPane().add(mesTf);
		
		yPosition += getDistanceTf();
		anoTf = new JTextField();
		anoTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		anoTf.setColumns(10);
		getContentPane().add(anoTf);
		
		yPosition += getDistanceTf();
		valorTf = new JTextField();
		valorTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		valorTf.setColumns(10);
		getContentPane().add(valorTf);
		
		yPosition += getDistanceTf();
		codigoTf = new JTextField();
		codigoTf.setVisible(false);
		
		addActions();
		SwingUtilities.updateComponentTreeUI(this);
		
	}
	
	private void limparCampos() {
		mesTf.setText("");
		anoTf.setText("");
		valorTf.setText("");
		codigoTf.setText("");
		
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	private void loadCamposByObject(CustoUnitarioBasico cub) {
		mesTf.setText(cub.getMes().toString());
		anoTf.setText(cub.getAno().toString());
		valorTf.setText(cub.getValorMetroQuadrado().toString());
	}
	
	private void generateTable() {
		tableModel = new TableModelImpl(cubModelConverter);
		
		table = new CustomTable();
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumn("Mês").setPreferredWidth(200);
		table.getColumn("Ano").setPreferredWidth(250);
		table.getColumn("Vlr M2").setPreferredWidth(300);
		
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
				Integer mes = new Integer(mesTf.getText());
				Integer ano = new Integer(anoTf.getText());
				BigDecimal valorMetroQuadrado = new BigDecimal (valorTf.getText());
				
				try {
					CustoUnitarioBasico cub = new CustoUnitarioBasico(valorMetroQuadrado, mes, ano);
					cubController.inserirCub(cub);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o custo unitário básico");
					return;
				}
				limparCampos();
				generateTable();
				JOptionPane.showMessageDialog(null, "Custo unitário básico cadastrado com sucesso");
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
					Integer codigo = new Integer(codigoTf.getText());
					cubController.excluirCub(codigo);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				limparCampos();
				generateTable();
				
			}
		});
		
	}
	
	public void addActionToTable() {
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() > -1) {
					CustoUnitarioBasico cub  = cubModelConverter.getObjectByRowIndex(table.getSelectedRow());
					loadCamposByObject(cub);
				}
				
			}
		});
	}

}
