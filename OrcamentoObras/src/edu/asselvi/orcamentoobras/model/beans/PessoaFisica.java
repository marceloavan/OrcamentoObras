package edu.asselvi.orcamentoobras.model.beans;

import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;
import edu.asselvi.orcamentoobras.model.enumerator.ETipoPessoa;

/**
 * Possui fun��es especificas para Pessoa Fisica
 * 
 * @author Marcelo Avancini
 *
 */
public final class PessoaFisica extends AbstractPessoa {

	private String nome;
	private String sobreNome;
	
	public PessoaFisica(String documento, Endereco endereco, String nome, String sobreNome) throws Exception {
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
		return getNome() + " " + getSobreNome();
	}
}