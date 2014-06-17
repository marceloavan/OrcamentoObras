package edu.asselvi.orcamentoobras.view.manager;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.cripto.Cripto;
import edu.asselvi.orcamentoobras.model.Usuario;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IUsuarioDao;
import edu.asselvi.orcamentoobras.view.exception.PasswdInvalidException;
import edu.asselvi.orcamentoobras.view.exception.UsuarioNotFoundException;

public class LoginManager {
	
	private IUsuarioDao usuarioDao;
	
	public LoginManager() {
		usuarioDao = DaoFactory.getInstance().getUsuarioDao();
	}
	
	public void validarLogin(String userName, String passwd) throws UsuarioNotFoundException, PasswdInvalidException {
		Usuario usuario = null;
		try {
			usuario = usuarioDao.getPeloUserName(userName);
		} catch (SQLException e) {
			throw new UsuarioNotFoundException("Problema ao consultar usuário, consulte o suporte técnico");
		}
		if (usuario == null) {
			throw new UsuarioNotFoundException("Usuário informado não existe");
		}
		
		String passwdCripted = Cripto.criptToMd5(passwd);
		if (!passwdCripted.equals(usuario.getPasswd())) {
			throw new PasswdInvalidException("Senha incorreta");
		}
	}
}