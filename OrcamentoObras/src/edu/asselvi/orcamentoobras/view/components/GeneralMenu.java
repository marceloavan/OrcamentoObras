package edu.asselvi.orcamentoobras.view.components;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GeneralMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Itens do menu Cadastro
	private JMenuItem itemCadastroProdutos;
	private JMenuItem itemCadastroTerrenos;
	private JMenuItem itemCadastroPessoa;
	
	// Itens do menu Adminitracao
	private JMenuItem itemAdministracaoUsuarios;
	private JMenuItem itemAdministracaoTrocarSenha;
	
	// Itens do menu Orcamento
	private JMenuItem itemOrcamentoCub;
	private JMenuItem itemOrcamentoGestaoOrcamento;
	
	// Itens do menu Sair
	private JMenuItem itemSairLogout;
	private JMenuItem itemSairFechar;
	
	public GeneralMenu(Integer width) {
		setBounds(0, 0, width, 25);
		generateMenu();
	}

	private void generateMenu() {

		/* MENU ADMISTRACAO */
		JMenu menuAdministracao = new JMenu("Administração");
		add(menuAdministracao);
		
		itemAdministracaoUsuarios = new JMenuItem("Usu\u00E1rios");
		menuAdministracao.add(itemAdministracaoUsuarios);
		
		itemAdministracaoTrocarSenha = new JMenuItem("Trocar senha");
		menuAdministracao.add(itemAdministracaoTrocarSenha);

		/* MENU CADASTRO */
		JMenu menuCadastro = new JMenu("Cadastro");
		add(menuCadastro);
		
		itemCadastroProdutos = new JMenuItem("Produtos");
		menuCadastro.add(itemCadastroProdutos);
		
		itemCadastroTerrenos = new JMenuItem("Terrenos");
		menuCadastro.add(itemCadastroTerrenos);
		
		itemCadastroPessoa = new JMenuItem("Clientes");
		menuCadastro.add(itemCadastroPessoa);
		
		/* MENU ORCAMENTO */
		JMenu menuOrcamento = new JMenu("Orçamento");
		add(menuOrcamento);
		
		itemOrcamentoCub = new JMenuItem("Custo Unitário Básico");
		menuOrcamento.add(itemOrcamentoCub);
		
		itemOrcamentoGestaoOrcamento = new JMenuItem("Gestão de orçamentos");
		menuOrcamento.add(itemOrcamentoGestaoOrcamento);
		
		/* MENU SAIR */
		JMenu menuSair = new JMenu("Sair");
		add(menuSair);

		itemSairLogout = new JMenuItem("Logout");
		menuSair.add(itemSairLogout);
		
		itemSairFechar = new JMenuItem("Fechar");
		menuSair.add(itemSairFechar);
		
	}

	public JMenuItem getItemAdministracaoUsuarios() {
		return itemAdministracaoUsuarios;
	}

	public JMenuItem getItemAdministracaoTrocarSenha() {
		return itemAdministracaoTrocarSenha;
	}

	public JMenuItem getItemSairLogout() {
		return itemSairLogout;
	}

	public JMenuItem getItemSairFechar() {
		return itemSairFechar;
	}
	
	public JMenuItem getItemOrcamentoCub() {
		return itemOrcamentoCub;
	}
	
	public JMenuItem getItemOrcamentoGestaoOrcamento() {
		return itemOrcamentoGestaoOrcamento;
	}
	
	public JMenuItem getItemCadastroProduto() {
		return itemCadastroProdutos;
	}
	
	public JMenuItem getItemCadastroTerreno() {
		return itemCadastroTerrenos;
	}
	
	public JMenuItem getItemCadastroPessoa() {
		return itemCadastroPessoa;
	}
}