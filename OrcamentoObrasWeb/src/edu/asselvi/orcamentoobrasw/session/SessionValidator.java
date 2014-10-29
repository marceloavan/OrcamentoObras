package edu.asselvi.orcamentoobrasw.session;

import java.util.Date;

import edu.asselvi.orcamentoobras.model.beans.Usuario;

public class SessionValidator {
	
	private Usuario usuarioLogado;
	private String nomeSistema;
	private Date ultimaMovimentacao;
	private long tempoLimite;
	private String message;

	public static final String MESSAGE_SESSION_EXPIRED = "Sessão expirada. Favor efetuar o login novamente"; 
	public static final String MESSAGE_NEW_SESSION = "Favor efetuar o login";
	
	public static SessionValidator newInstance() {
		return new SessionValidator(1000000);
	}
	
	private SessionValidator(long tempoLimite) {
		this.tempoLimite = tempoLimite;
		setMessage(MESSAGE_NEW_SESSION); 
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public String getNomeUsuarioLogado() {
		if (getUsuarioLogado() == null) {
			return "";
		}
		return getUsuarioLogado().getNomeCompleto();
	}
	
	public void setUsuarioLogado(Usuario usuario) {
		usuarioLogado = usuario;
	}
	
	public String getNomeSistema() {
		nomeSistema = "Orçamento Obras";
		return nomeSistema;
	}
	
	public void setUltimaMovimentacao(Date acesso) {
		ultimaMovimentacao = acesso;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Retorna a última mensagem válida gravada no {@link SessionValidator}
	 * 
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	
	public boolean validaSessao() {
		if (usuarioLogado == null || ultimaMovimentacao == null) {
			return false;
		}
		
		long milliAcesso = ultimaMovimentacao.getTime();
		if ((System.currentTimeMillis() - milliAcesso) <= tempoLimite) {
			setUltimaMovimentacao(new Date());
			return true;
		}
		setMessage(MESSAGE_SESSION_EXPIRED);
		setUsuarioLogado(null);
		setUltimaMovimentacao(null);
		return false;
	}
}
