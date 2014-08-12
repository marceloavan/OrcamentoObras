package edu.asselvi.orcamentoobras.view.pages.cadastros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import edu.asselvi.orcamentoobras.controller.MunicipioController;
import edu.asselvi.orcamentoobras.controller.UnidadeFederativaController;
import edu.asselvi.orcamentoobras.model.beans.Endereco;
import edu.asselvi.orcamentoobras.model.beans.Municipio;
import edu.asselvi.orcamentoobras.model.beans.UnidadeFederativa;
import edu.asselvi.orcamentoobras.view.components.CustomTable;
import edu.asselvi.orcamentoobras.view.components.table.model.EnderecoModelConverter;
import edu.asselvi.orcamentoobras.view.components.table.model.TableModelImpl;
import edu.asselvi.orcamentoobras.view.templates.TemplateCadastroPages;

public class CadastroEnderecoPage extends TemplateCadastroPages{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane = new JScrollPane();
	private CustomTable table;
	private AbstractTableModel tableModel;
	private EnderecoModelConverter enderecoModelConverter;
	
	private JTextField codigoTf;
	private JTextField logradouroTf;
	private JTextField numeroTf;
	private JTextField bairroTf;
	private JTextField cepTf;
	private JComboBox<UnidadeFederativa> unidadeFederativaCb;
	private JComboBox<Municipio> municipioCb;
	
	
	private EnderecoController enderecoController;
	private MunicipioController municipioController;
	private UnidadeFederativaController unidadeFederativaController;
	
	public CadastroEnderecoPage() {
		super (500,500);
		
		enderecoController = new EnderecoController();
		municipioController = new MunicipioController();
		enderecoModelConverter = new EnderecoModelConverter();
		unidadeFederativaController = new UnidadeFederativaController();
		
		generateTable();
		
		getContentPane().add(scrollPane);
		
		JLabel unidadeFederativaLb = new JLabel("Estado");
		unidadeFederativaLb.setHorizontalAlignment(SwingConstants.RIGHT);
		unidadeFederativaLb.setBounds(10, 225, 90, 15);
		getContentPane().add(unidadeFederativaLb);
		
		JLabel municipioLb = new JLabel("Município");
		municipioLb.setHorizontalAlignment(SwingConstants.RIGHT);
		municipioLb.setBounds(10, 250, 90, 15);
		getContentPane().add(municipioLb);
		
		JLabel logradouroLb = new JLabel("Logradouro");
		logradouroLb.setHorizontalAlignment(SwingConstants.RIGHT);
		logradouroLb.setBounds(10, 275, 90, 15);
		getContentPane().add(logradouroLb);
		
		JLabel numeroLb = new JLabel("Número");
		numeroLb.setHorizontalAlignment(SwingConstants.RIGHT);
		numeroLb.setBounds(10, 300, 90, 15);
		getContentPane().add(numeroLb);
		
		JLabel bairroLb = new JLabel("Bairro");
		bairroLb.setHorizontalAlignment(SwingConstants.RIGHT);
		bairroLb.setBounds(10, 325, 90, 15);
		getContentPane().add(bairroLb);
		
		JLabel cepLb = new JLabel("CEP");
		cepLb.setHorizontalAlignment(SwingConstants.RIGHT);
		cepLb.setBounds(10, 350, 90, 15);
		getContentPane().add(cepLb);
		
		int yPosition = 220;
		
		unidadeFederativaCb = new JComboBox<UnidadeFederativa>();
		unidadeFederativaCb.setBounds(110, 215, getWidthTf(), getHeightTf());
		getContentPane().add(unidadeFederativaCb);
		
		yPosition += getDistanceTf();
		municipioCb = new JComboBox<Municipio>();
		municipioCb.setBounds(110, 242, getWidthTf(), getHeightTf());
		getContentPane().add(municipioCb);
		
		yPosition += getDistanceTf();
		logradouroTf = new JTextField();
		logradouroTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		logradouroTf.setColumns(10);
		getContentPane().add(logradouroTf);
		
		yPosition += getDistanceTf();
		numeroTf = new JTextField();
		numeroTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		numeroTf.setColumns(10);
		getContentPane().add(numeroTf);
		
		yPosition += getDistanceTf();
		bairroTf = new JTextField();
		bairroTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		bairroTf.setColumns(10);
		getContentPane().add(bairroTf);
		
		yPosition += getDistanceTf();
		cepTf = new JTextField();
		cepTf.setBounds(110, yPosition, getWidthTf(), getHeightTf());
		cepTf.setColumns(10);
		getContentPane().add(cepTf);
		
		yPosition += getDistanceTf();
		codigoTf = new JTextField();
		codigoTf.setVisible(false);
		getContentPane().add(codigoTf);
		
		addActions();
		SwingUtilities.updateComponentTreeUI(this);
		loadItensForCb();
	
	}
	
	private void loadItensForCb() {
		unidadeFederativaCb.addItem(null);
		for (UnidadeFederativa uf : unidadeFederativaController.getTodos()) {
			unidadeFederativaCb.addItem(uf);
		}
	}
	
	
	private void limparCampos(){
		codigoTf.setText("");
		logradouroTf.setText("");
		bairroTf.setText("");
		numeroTf.setText("");
		cepTf.setText("");
		
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	private void loadCamposByObject(Endereco endereco) {
		codigoTf.setText(endereco.getId().toString());
		logradouroTf.setText(endereco.getLogradouro());
		bairroTf.setText(endereco.getBairro());
		numeroTf.setText(endereco.getNumero().toString());
		cepTf.setText(endereco.getCep().toString());
		municipioCb.setSelectedItem(endereco.getMunicipio());
	}
	
	private void generateTable() {
		tableModel = new TableModelImpl(enderecoModelConverter);
		
		table = new CustomTable();
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumn("Logradouro").setPreferredWidth(200);
		table.getColumn("Bairro").setPreferredWidth(250);
		
		scrollPane.setViewportView(table);
		scrollPane.setBounds(10, 40, 470, 125);
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
					Endereco endereco = enderecoModelConverter.getObjectByRowIndex(table.getSelectedRow());
					loadCamposByObject(endereco);
				}
				
			}
		});
	}
	
	@Override
	protected void addActions() {
		getSalvarBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String logradouro = logradouroTf.getText();
				String bairro = bairroTf.getText();
				Integer numero = new Integer(numeroTf.getText());
				Long cep = new Long(cepTf.getText());
				Municipio municipio = municipioCb.getItemAt(municipioCb.getSelectedIndex());
				
				try {
					Endereco endereco = new Endereco(logradouro, numero, bairro, municipio, cep);
					enderecoController.inserirEndereco(endereco);
				} catch (Exception e1){
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o endereço");
					return;
				}
				JOptionPane.showMessageDialog(null, "Endereço cadastro com sucesso");
				limparCampos();
				generateTable();
			}
		});
		
		getNovoBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCampos();
				
			}
		});
		
		getExcluirBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Integer codigo =  new Integer(codigoTf.getText());
					enderecoController.excluirEndereco(codigo);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					return;
				}
				limparCampos();
				generateTable();
			}
		});
		
		unidadeFederativaCb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}

}
