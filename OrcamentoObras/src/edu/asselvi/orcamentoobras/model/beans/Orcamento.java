package edu.asselvi.orcamentoobras.model.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;
import edu.asselvi.orcamentoobras.model.exception.MetragemConstrucaoMaiorTerrenoException;
import edu.asselvi.orcamentoobras.model.exception.TerrenoNullException;

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
	private Double percentualLucro;
	
	public Orcamento(String nome, String descricao, CustoUnitarioBasico cub, Terreno terreno, Double metragemConstrucao) throws MetragemConstrucaoMaiorTerrenoException, TerrenoNullException {
		setNome(nome);
		setDescricao(descricao);
		setCub(cub);
		if (terreno == null) {
			throw new TerrenoNullException("É obrigatório informar o terreno para um orçamento.");
		}
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

	public void setMetragemConstrucao(Double metragemConstrucao) throws MetragemConstrucaoMaiorTerrenoException {
		if (getTerreno() == null || metragemConstrucao > getTerreno().getMetragem()) {
			throw new MetragemConstrucaoMaiorTerrenoException("A metragem da construção deve respetar o tamanho do terreno");
		}
		this.metragemConstrucao = metragemConstrucao;
	}
	
	public List<PrevisaoOrcamento> getPrevisaoList() {
		if (previsaoList == null) {
			return Collections.emptyList();
		}
		return previsaoList;
	}

	public void setPrevisaoList(List<PrevisaoOrcamento> previsaoList) {
		this.previsaoList = previsaoList;
	}
	
	/**
	 * Insere previsão a lista já existente de previsões
	 * 
	 * @param previsao
	 */
	public void addPrevisao(PrevisaoOrcamento previsao) {
		if (this.previsaoList == null) {
			this.previsaoList = new ArrayList<PrevisaoOrcamento>();
		}
		this.previsaoList.add(previsao);
	}
	
	public Double getPercentualLucro() {
		return percentualLucro;
	}

	public void setPercentualLucro(Double percentualLucro) {
		this.percentualLucro = percentualLucro;
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
	
	/**
	 * Valor de venda considerando o calculo do CUB
	 * 
	 * @return
	 */
	public BigDecimal getValorVendaCub() {
		return getCub().getValorMetroQuadrado().multiply(new BigDecimal(getMetragemConstrucao()));
	}

	/**
	 * Valor de venda considerando o total de previs�es multiplicado
	 * pelo percentual de lucro esperado
	 * 
	 * @return
	 */
	public BigDecimal getValorVendaPrevisao() {
		if (getTotalPrevisao().equals(BigDecimal.ZERO)) {
			return BigDecimal.ZERO;
		}
		return getTotalPrevisao().multiply(new BigDecimal(getPercentualLucro() / 100));
	}

	public AbstractPessoa getCliente() {
		return cliente;
	}
}