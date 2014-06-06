package edu.asselvi.orcamentoobras.view.pages;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.Usuario;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.factory.IDaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IUsuarioDao;
import edu.asselvi.orcamentoobras.view.templates.TemplateCadastroPages;

import javax.swing.JList;
import javax.swing.SwingUtilities;

public class CadastroUsuarioPage extends TemplateCadastroPages {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JList<Usuario> usuariosList;
	private IDaoFactory daoFactory;
	private IUsuarioDao usuarioDao;
	
	public CadastroUsuarioPage() {
		super(500, 500);
		
		daoFactory = DaoFactory.getInstance();
		usuarioDao = daoFactory.getUsuarioDao();
		
		generateList();
	}

	private void generateList() {
		
		Usuario[] usuarioArray = new Usuario[10];
		try {
			int i = 0;
			for (Usuario usuario : usuarioDao.getTodos()) {
				usuarioArray[i] = usuario;
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		
		usuariosList = new JList<Usuario>(usuarioArray);
		usuariosList.setBounds(10, 60, 475, 95);
		getContentPane().add(usuariosList);
		
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	@Override
	protected void addActions() {
		
	}
}
