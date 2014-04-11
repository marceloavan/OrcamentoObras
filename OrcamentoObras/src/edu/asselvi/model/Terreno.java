package edu.asselvi.model;

import java.math.BigDecimal;
import java.util.List;

import edu.asselvi.model.intf.ICalculaImpostos;
import edu.asselvi.model.intf.IImposto;

/**
 * Definições de um terreno e métodos auxiliares para calculo
 * de informações referentes ao mesmo
 * 
 * @author Marcelo
 *
 */
public class Terreno implements ICalculaImpostos {
	
	private Integer id;
	private String descricao;
	private BigDecimal valorVenda;
	private Endereco endereco;
	private List<IImposto> impostos;
	
	public BigDecimal getValorImpostos() {
		
		BigDecimal valorImpostos = new BigDecimal(0);
		for (IImposto imposto : impostos) {
			BigDecimal decimalPercent = imposto.getPercentual().divide(new BigDecimal(100));
			valorImpostos.add(getValorVenda().multiply(decimalPercent));
		}
		return valorImpostos;
	}

	public BigDecimal getValorTotalComImpostos() {
		return getValorVenda().add(getValorImpostos());
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	public void setNovoImposto(IImposto imposto) {
		impostos.add(imposto);
	}
}
