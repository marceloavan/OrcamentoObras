package edu.asselvi.orcamentoobras.controller;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.context.SystemInfo;
import edu.asselvi.orcamentoobras.controller.exception.PasswdInvalidException;
import edu.asselvi.orcamentoobras.controller.exception.UsuarioNotFoundException;
import edu.asselvi.orcamentoobras.cripto.Cripto;
import edu.asselvi.orcamentoobras.model.beans.Usuario;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IUsuarioDao;

public class UsuarioController {
	
	private IUsuarioDao usuarioDao;
	
	public UsuarioController() {
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
	
	public void cadastrarUsuario(String userName, String passwd, String nomeCompleto) throws SQLException {
		usuarioDao.inserir(new Usuario(userName, Cripto.criptToMd5(passwd), nomeCompleto));
	}
	
	public void atualizarUsuario(String userName, String passwd, String nomeCompleto) throws SQLException {
		usuarioDao.atualizar(new Usuario(userName, Cripto.criptToMd5(passwd), nomeCompleto));
	}
	
	public void excluirUsuario(String userName) throws UsuarioNotFoundException {
		try {
			Usuario usuario = usuarioDao.getPeloUserName(userName);
			if (usuario == null) {
				throw new UsuarioNotFoundException("Usuario não existe");
			}
			usuarioDao.remover(usuario);
		} catch (SQLException e) {
		}
	}
	
	public boolean isUsuarioExistente(String userName) {
		Usuario usuario = null;
		try {
			usuario = usuarioDao.getPeloUserName(userName);
		} catch (SQLException e) {
		}
		return usuario != null;
	}
	
	public boolean isUsuarioLogado(String userName) {
		try {
			Usuario usuario = usuarioDao.getPeloUserName(userName);
			return usuario.equals(SystemInfo.getUSuarioLogado());
		} catch (SQLException e) {
		}
		return false;
	}
	
	public Usuario getUsuarioPeloUserName(String userName) {
		try {
			return usuarioDao.getPeloUserName(userName);
		} catch (SQLException e) {
		}
		return null;
	}
}