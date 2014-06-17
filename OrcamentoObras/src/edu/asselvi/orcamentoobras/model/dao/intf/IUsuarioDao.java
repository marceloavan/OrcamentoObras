package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.beans.Usuario;

public interface IUsuarioDao extends IDao<Usuario> {
	
	public Usuario getPeloUserName(String userName) throws SQLException;
	
}
