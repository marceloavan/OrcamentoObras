package edu.asselvi.orcamentoobras.model;

/**
 * Representa cada usuário do sistema
 * 
 * @author Marcelo Avancini
 *
 */
public class Usuario {

	private String userName;
	private String passwd;
	private String nomeCompleto;
	
	public Usuario(String userName, String passwd, String nomeCompleto) {
		setUserName(userName);
		setPasswd(passwd);
		setNomeCompleto(nomeCompleto);
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
}
