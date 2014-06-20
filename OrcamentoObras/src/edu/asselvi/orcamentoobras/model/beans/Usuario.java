package edu.asselvi.orcamentoobras.model.beans;

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
	
	@Override
	public String toString() {
		return getUserName() + " - " + getNomeCompleto();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
}
