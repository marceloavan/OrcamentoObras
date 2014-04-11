package edu.asselvi.model;

import java.math.BigDecimal;

import edu.asselvi.model.intf.IImposto;

/**
 * Imposto padr�o sem regra especifica definida
 * 
 * @author Marcelo
 *
 */
public class Imposto implements IImposto {

	private String sigla;
	private BigDecimal percentual;
	private String descricao;
	
	public Imposto(String sigla, BigDecimal percentual, String descricao) {
		this.sigla = sigla;
		this.percentual = percentual;
		this.descricao = descricao;
	}

	@Override
	public String getSigla() {
		return sigla;
	}

	@Override
	public BigDecimal getPercentual() {
		return percentual;
	}

	@Override
	public String getDescricao() {
		return descricao;
	}
}