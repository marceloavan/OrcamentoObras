package edu.asselvi.model;

import java.math.BigDecimal;

import edu.asselvi.model.intf.ICalculaImpostos;

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
	private Double metragem;
	
	//Impostos
	private BigDecimal valorITBI;
	private BigDecimal valorFRJ;
	private BigDecimal valorEscritura;
	private BigDecimal valorRegistro;
	
	public Terreno(Integer id, String descricao, BigDecimal valorVenda,	Endereco endereco, Double metragem) {
		this.id = id;
		this.descricao = descricao;
		this.valorVenda = valorVenda;
		this.endereco = endereco;
		this.metragem = metragem;
	}


	public BigDecimal getValorImpostos() {
		BigDecimal valorImpostos = new BigDecimal(0);
		valorImpostos.add(valorITBI);
		valorImpostos.add(valorFRJ);
		valorImpostos.add(valorEscritura);
		valorImpostos.add(valorRegistro);
		return valorImpostos;
	}

	public BigDecimal getValorTotalComImpostos() {
		return getValorVenda().add(getValorImpostos());
	}

	public Integer getId() {
		return id;
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

	public Double getMetragem() {
		return metragem;
	}

	public void setMetragem(Double metragem) {
		this.metragem = metragem;
	}

	public BigDecimal getValorITBI() {
		return valorITBI;
	}

	public void setValorITBI(BigDecimal valorITBI) {
		this.valorITBI = valorITBI;
	}

	public BigDecimal getValorFRJ() {
		return valorFRJ;
	}

	public void setValorFRJ(BigDecimal valorFRJ) {
		this.valorFRJ = valorFRJ;
	}

	public BigDecimal getValorEscritura() {
		return valorEscritura;
	}

	public void setValorEscritura(BigDecimal escritura) {
		this.valorEscritura = escritura;
	}

	public BigDecimal getValorRegistro() {
		return valorRegistro;
	}

	public void setValorRegistro(BigDecimal registro) {
		this.valorRegistro = registro;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}
}