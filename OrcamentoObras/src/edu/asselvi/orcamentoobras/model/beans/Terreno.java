package edu.asselvi.orcamentoobras.model;

import java.math.BigDecimal;

import edu.asselvi.orcamentoobras.model.intf.ICalculaImpostos;

/**
 * Definições de um terreno e métodos auxiliares para calculo
 * de informações referentes ao mesmo
 * 
 * @author Marcelo Avancini
 *
 */
public class Terreno implements ICalculaImpostos {
	
	private Integer codigo;
	private String descricao;
	private BigDecimal valorVenda;
	private Endereco endereco;
	private Double metragem;
	
	//Impostos
	private BigDecimal valorITBI;
	private BigDecimal valorFRJ;
	private BigDecimal valorEscritura;
	private BigDecimal valorRegistro;
	
	public Terreno(String descricao, BigDecimal valorVenda,	Endereco endereco, Double metragem) {
		setDescricao(descricao);
		setValorVenda(valorVenda);
		setEndereco(endereco);
		setMetragem(metragem);
	}

	public BigDecimal getValorImpostos() {
		BigDecimal valorImpostos = new BigDecimal(0);
		valorImpostos = valorImpostos.add(valorITBI);
		valorImpostos = valorImpostos.add(valorFRJ);
		valorImpostos = valorImpostos.add(valorEscritura);
		valorImpostos = valorImpostos.add(valorRegistro);
		return valorImpostos;
	}

	public BigDecimal getValorTotalComImpostos() {
		return getValorVenda().add(getValorImpostos());
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
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