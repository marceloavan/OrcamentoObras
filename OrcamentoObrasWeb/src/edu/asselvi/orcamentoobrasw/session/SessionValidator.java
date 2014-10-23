package edu.asselvi.orcamentoobrasw.session;

import java.util.Date;

import edu.asselvi.orcamentoobras.model.beans.Usuario;

public class SessionValidator {
	
	private Usuario usuarioLogado;
	private String nomeSistema;
	private Date ultimaMovimentacao;
	private long tempoLimite;
	private String message;

	private static SessionValidator INSTANCE;
	
	public static SessionValidator getCurrentInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SessionValidator(100000l);
		}
		return INSTANCE;
	}
	
	private SessionValidator(long tempoLimite) {
		this.tempoLimite = tempoLimite;
		setMessage("Favor efetuar o login"); 
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
	
	private void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Retorna a última mesagem válida gravada no {@link SessionValidator}
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
		setMessage("Sessão expirada. Favor efetuar o login novamente");
		setUsuarioLogado(null);
		setUltimaMovimentacao(null);
		return false;
	}
}
