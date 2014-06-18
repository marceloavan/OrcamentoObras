package edu.asselvi.orcamentoobras.view.tablemodel;

import java.sql.SQLException;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Usuario;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;

public class UsuarioModelConverter implements IModel<Usuario> {
	
	private int qtdColumns = 2;
	private List<Usuario> usuariosList;
	
	@Override
	public String[] getColumnNames() {
		return new String[] {"Login", "Nome"};
	}
	
	@Override
	public Object[][] getData() {
		Object[][] objects;
		
		try {
			usuariosList = DaoFactory.getInstance().getUsuarioDao().getTodos();
		} catch (SQLException e) {
		}

		objects = new Object[usuariosList.size()][qtdColumns];
		
		int row = 0;
		for (Usuario usuario : usuariosList) {
			objects[row][0] = (Object) usuario.getUserName();
			objects[row][1] = (Object) usuario.getNomeCompleto();
			row++;
		}
		
		return objects;
	}

	@Override
	public Usuario getObjectByRowIndex(int index) {
		return usuariosList.get(index);
	}
}
