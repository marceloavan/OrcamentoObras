package edu.asselvi.orcamentoobras.model.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;

/**
 * Implementa��o padr�o inicial de or�amentos
 * <br><br>
 * Objetivo: Todo or�amento dever� "or�ar" os custos da obra de modo gerencial, ou seja,
 * armazenar os gastos e gerar valores de venda de acordo com regras definidas pela intf
 * principal.
 *
 * @author Marcelo Avancini
 *
 */
public class Orcamento {

	private Integer id;
	private String nome;
	private String descricao;
	
	private CustoUnitarioBasico cub;
	private Terreno terreno;
	private AbstractPessoa cliente;

	private Double metragemConstrucao;
	private List<PrevisaoOrcamento> previsaoList;
	private Double percetualLucro;
	
	public Orcamento(String nome, String descricao, CustoUnitarioBasico cub, Terreno terreno, Double metragemConstrucao) throws Exception {
		setNome(nome);
		setDescricao(descricao);
		setCub(cub);
		setTerreno(terreno);
		setMetragemConstrucao(metragemConstrucao);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCliente(AbstractPessoa cliente) {
		this.cliente = cliente;
	}

	public CustoUnitarioBasico getCub() {
		return cub;
	}

	public void setCub(CustoUnitarioBasico cub) {
		this.cub = cub;
	}

	public Terreno getTerreno() {
		return terreno;
	}

	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}

	public Double getMetragemConstrucao() {
		return metragemConstrucao;
	}

	public void setMetragemConstrucao(Double metragemConstrucao) throws Exception {
		if (metragemConstrucao > getTerreno().getMetragem()) {
			// TODO criar exception especifica...
			throw new Exception();
		}
		this.metragemConstrucao = metragemConstrucao;
	}
	
	public List<PrevisaoOrcamento> getPrevisaoList() {
		return previsaoList;
	}

	public void setPrevisaoList(List<PrevisaoOrcamento> previsaoList) {
		this.previsaoList = previsaoList;
	}
	
	/**
	 * Insere previs�o a lista j� existente de previs�es
	 * 
	 * @param previsao
	 */
	public void addPrevisao(PrevisaoOrcamento previsao) {
		if (this.previsaoList == null) {
			this.previsaoList = new ArrayList<PrevisaoOrcamento>();
		}
		this.previsaoList.add(previsao);
	}
	
	public Double getPercetualLucro() {
		return percetualLucro;
	}

	public void setPercetualLucro(Double percetualLucro) {
		this.percetualLucro = percetualLucro;
	}

	/**
	 * Retorna o valor total que representam as previs�es de gasto
	 * 
	 * @return totalPrevisao - somat�rio do valor das previs�es
	 */
	public BigDecimal getTotalPrevisao() {
		BigDecimal totalPrevisao = new BigDecimal(0);
		for (PrevisaoOrcamento previsao : getPrevisaoList()) {
			totalPrevisao = totalPrevisao.add(previsao.getValor());
		}
		return totalPrevisao;
	}
	
	public BigDecimal getValorVendaCub() {
		return getCub().getValorMetroQuadrado().multiply(new BigDecimal(getMetragemConstrucao()));
	}

	public BigDecimal getValorVendaPrevisao() {
		return getTotalPrevisao().multiply(new BigDecimal(getPercetualLucro() / 100));
	}

	public AbstractPessoa getCliente() {
		return cliente;
	}
}