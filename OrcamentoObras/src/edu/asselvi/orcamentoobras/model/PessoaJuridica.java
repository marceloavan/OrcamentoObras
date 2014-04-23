package edu.asselvi.orcamentoobras.model;

import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;
import edu.asselvi.orcamentoobras.model.enumerator.ETipoPessoa;

/**
 * Possui funções especificas para Pessoa Juridica
 * 
 * @author Marcelo Avancini
 *
 */
public final class PessoaJuridica extends AbstractPessoa {

	private String razaoSocial;
	private String nomeFantasia;
	
	public PessoaJuridica(Long documento, Endereco endereco, String razaoSocial, String nomeFantasia) throws Exception {
		super(documento, ETipoPessoa.JURIDICA, endereco);
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	@Override
	public String toString() {
		return getRazaoSocial();
	}
}