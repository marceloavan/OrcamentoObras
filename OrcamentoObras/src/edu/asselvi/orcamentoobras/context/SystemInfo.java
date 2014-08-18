package edu.asselvi.orcamentoobras.context;

import edu.asselvi.orcamentoobras.model.beans.Usuario;

public class SystemInfo {
	
	private static Usuario usuarioLogado;
	private static String nomeSistema;
	
	public static Usuario getUSuarioLogado() {
		return usuarioLogado;
	}
	
	public static void setUSuarioLogado(Usuario usuario) {
		usuarioLogado = usuario;
	}
	
	public static String getNomeSistema() {
		return nomeSistema = "Orçamento Obras";
	}
}
