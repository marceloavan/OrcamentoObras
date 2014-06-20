package edu.asselvi.orcamentoobras.context;

import edu.asselvi.orcamentoobras.model.beans.Usuario;

public class SystemInfo {
	
	private static Usuario usuarioLogado;
	
	public static Usuario getUSuarioLogado() {
		return usuarioLogado;
	}
	
	public static void setUSuarioLogado(Usuario usuario) {
		usuarioLogado = usuario;
	}
}
