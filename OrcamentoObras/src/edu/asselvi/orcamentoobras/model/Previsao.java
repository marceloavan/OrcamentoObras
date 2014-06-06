package edu.asselvi.orcamentoobras.model;

/**
 * 
 * @author Marcelo Avancini
 *
 */
public class Previsao {
	
	private Integer codigo;
	private String descricao;
	
	/**
	 * 
	 * @param descricao
	 */
	public Previsao(String descricao) {
		setDescricao(descricao);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return getCodigo() + " - " + getDescricao();
	}
}
