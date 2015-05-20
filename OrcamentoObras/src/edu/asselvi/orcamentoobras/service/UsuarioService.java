package edu.asselvi.orcamentoobras.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import edu.asselvi.orcamentoobras.cripto.Cripto;
import edu.asselvi.orcamentoobras.model.beans.Usuario;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IUsuarioDao;
import edu.asselvi.orcamentoobras.service.exception.PasswdInvalidException;
import edu.asselvi.orcamentoobras.service.exception.UsuarioNotFoundException;

public class UsuarioService {
	
	private IUsuarioDao usuarioDao;
	
	public UsuarioService() {
		usuarioDao = DaoFactory.getInstance().getUsuarioDao();
	}
	
	public Usuario validarLogin(String userName, String passwd) throws UsuarioNotFoundException, PasswdInvalidException {
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
			throw new PasswdInvalidException("Login inválido");
		}
		return usuario;
	}
	
	public void cadastrarUsuario(Usuario usuario) throws SQLException {
		usuario.setPasswd(Cripto.criptToMd5(usuario.getPasswd()));
		usuarioDao.inserir(usuario);
	}
	
	public void atualizarUsuario(Usuario usuario) throws SQLException {
		usuario.setPasswd(Cripto.criptToMd5(usuario.getPasswd()));
		usuarioDao.atualizar(usuario);
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
	
	public Usuario getUsuarioPeloUserName(String userName) {
		try {
			return usuarioDao.getPeloUserName(userName);
		} catch (SQLException e) {
		}
		return null;
	}
	
	public List<Usuario> getTodosUsuarios() {
		try {
			return usuarioDao.getTodos();
		} catch (SQLException e) {
			return Collections.emptyList();
		}
	}
}