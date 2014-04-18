package edu.asselvi.model;

import edu.asselvi.model.abst.AbstractPessoa;
import edu.asselvi.model.enumerator.ETipoPessoa;

/**
 * Possui funções especificas para Pessoa Fisica
 * 
 * @author Marcelo
 *
 */
public final class PessoaFisica extends AbstractPessoa {

	private String nome;
	private String sobreNome;
	
	public PessoaFisica(Long documento, Endereco endereco, String nome, String sobreNome) throws Exception {
		super(documento, ETipoPessoa.FISICA, endereco);
		this.nome = nome;
		this.sobreNome = sobreNome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	@Override
	public String toString() {
		return getNome() + getSobreNome();
	}
}